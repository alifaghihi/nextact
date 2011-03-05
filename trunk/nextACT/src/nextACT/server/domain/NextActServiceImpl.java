package nextACT.server.domain;

import nextACT.domain.Activity;
import nextACT.domain.User;
import nextACT.server.domain.nodes.ActivityImpl;
import nextACT.server.domain.nodes.UserImpl;
import nextACT.server.domain.relationships.ActivityOwnership;
import nextACT.server.domain.relationships.ActivityOwnershipImpl;
import nextACT.server.domain.relationships.Invitation;
import nextACT.server.domain.relationships.InvitationImpl;
import nextACT.server.domain.relationships.Participation;
import nextACT.server.domain.relationships.ParticipationImpl;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.NotFoundException;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexHits;

public class NextActServiceImpl implements NextActService {

	private static final NextActServiceImpl INSTANCE = new NextActServiceImpl();
	
    private GraphDatabaseService graphDbService = null;
    private Index<Node> userIndex = null;
    private Index<Node> activityIndex = null;
    
    private static enum BasicRelationshipTypes implements RelationshipType {
		INCOMING,
		OUTGOING
	}
    
    // in neo4j node ids are not unique over time - so we have generate custom, sequencial ones..
    private static final String KEY_COUNTER = "counter";
    private synchronized long getNextId()
    {
    	Long counter = null;
	    try {
	    	counter = ( Long ) graphDbService.getReferenceNode().getProperty(KEY_COUNTER);
	    }
	    catch (NotFoundException e) {
	        // create a new counter
	        counter = 0L;
	    }
	     
	    graphDbService.getReferenceNode().setProperty(KEY_COUNTER, new Long(counter + 1));
	    return counter;
    }
    
    public static void initService(GraphDatabaseService graphDbService) {
    	INSTANCE.graphDbService = graphDbService;
    	INSTANCE.userIndex = graphDbService.index().forNodes("users");
    	//TODO: create a more sophisticated user index
    	INSTANCE.activityIndex = graphDbService.index().forNodes("activities");
    	//TODO: create a more sophisticated activities index
    }
    
    public static NextActService getInstance() {
    	return INSTANCE;
    }
  
    
	@Override
	public Activity createActivity(long facebookId, boolean isNative,
			String name, String description, String locationName,
			String locationCity, long startDate, long endDate,
			double longitude, long latitude, int participantLimit) {
		
		Activity newActivity = null;
		
		// basic sanity checks
		// TODO: check for illegal arguments
		
		// create the node in the database
		Transaction tx = graphDbService.beginTx();
        try
        {
        	final Node activityNode = graphDbService.createNode();
        	final Activity activity = new ActivityImpl(activityNode);
        	
        	// add all the properties
        	// use a newly created id...
        	long id = this.getNextId();
        	activity.setId(id);
        	activity.setVersion(1);
        	activity.setFacebookId(facebookId);
        	activity.setIsNative(isNative);
        	activity.setName(name);
        	activity.setDescription(description);
        	activity.setLocationName(locationName);
        	activity.setLocationCity(locationCity);
        	activity.setStartDate(startDate);
        	activity.setEndDate(endDate);
        	activity.setLongitude(longitude);
        	activity.setLatitude(latitude);
        	activity.setParticipantLimit(participantLimit);
        	
        	// TODO: add tags
        	// TODO: add albums
        	// TODO: add owner
        	
        	// add it to the index
        	activityIndex.add(activityNode, "id", id);
        	
        	//TODO: add index for start/enddate
        	
        	// actually write it into the db...
        	tx.success();
        	
        	newActivity = activity;
        }
        finally {
                tx.finish();
        }
        
        return newActivity;
	}

	@Override
	public Activity getActivity(long id) {
		Activity activity = null;
		IndexHits<Node> matchingActivities = activityIndex.get("id", id);
		Node activityNode = matchingActivities.getSingle();
		
		if(activityNode != null) {
			activity = new ActivityImpl(activityNode);
		}
		
		return activity;
	}
	
	

	@Override
	public User createUser(long id, long facebookID, String lastName,
			String firstName, String eMail, String pictureURL, long birthday,
			String city, double longitude, double latitude) {
		
		User newUser = null;
		
		// basic sanity checks
		// TODO: check for illegal arguments
		
		// create the node in the database
		Transaction tx = graphDbService.beginTx();
        try
        {
        	final Node userNode = graphDbService.createNode();
        	final User user = new UserImpl(userNode);
		
        	// add all the properties
        	user.setId(id);
        	user.setFacebookId(facebookID);
        	user.setLastName(lastName);
        	user.setFirstName(firstName);
        	user.setLastName(lastName);
        	user.setFullName(firstName + " " + lastName);
        	user.setEMail(eMail);
        	user.setPictureURL(pictureURL);
        	user.setBirthday(birthday);
        	user.setCity(city);
        	user.setLongitude(longitude);
        	user.setLatitude(latitude);
        	
        	// TODO: set friendships
        	
        	// add id/user to index
        	userIndex.add(userNode, "id", id);
        	
        	// actually write it into the db...
        	tx.success();
        	
        	newUser = user;
        }
        finally {
                tx.finish();
        }
        
		return newUser;
	}

	@Override
	public User getUser(long id) {
		
		User user = null;
		IndexHits<Node> matchingUsers = userIndex.get("id", id);
		Node userNode = matchingUsers.getSingle();
		
		if(userNode != null) {
			user = new UserImpl(userNode);
		}
		
		return user;
	}

	@Override
	public ActivityOwnership createActivityOwnership(Activity activity,
			User user) {
		//TODO: add basic sanity checks!
		final Node userNode = ((UserImpl) user).getUnderlyingNode();
		final Node activityNode = ((ActivityImpl) activity).getUnderlyingNode();
		final Relationship rel = activityNode.createRelationshipTo(userNode, BasicRelationshipTypes.OUTGOING);
		
		final ActivityOwnership activityOwnership = new ActivityOwnershipImpl(rel);
		
		return activityOwnership;
	}

	@Override
	public Invitation createInvitation(Activity activity, User user) {
		//TODO: add basic sanity checks!
		final Node userNode = ((UserImpl) user).getUnderlyingNode();
		final Node activityNode = ((ActivityImpl) activity).getUnderlyingNode();
		final Relationship rel = activityNode.createRelationshipTo(userNode, BasicRelationshipTypes.OUTGOING);
		
		final Invitation invitation = new InvitationImpl(rel);
		
		return invitation;
	}

	@Override
	public Participation createParticipation(Activity activity, User user) {
		//TODO: add basic sanity checks!
		final Node userNode = ((UserImpl) user).getUnderlyingNode();
		final Node activityNode = ((ActivityImpl) activity).getUnderlyingNode();
		final Relationship rel = activityNode.createRelationshipTo(userNode, BasicRelationshipTypes.OUTGOING);
		
		final Participation participation = new ParticipationImpl(rel);
		
		return participation;
	}

}
