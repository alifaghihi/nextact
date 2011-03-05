	package nextACT.server.domain.nodes;


import nextACT.domain.Activity;
import nextACT.domain.User;

import org.neo4j.graphdb.Node;

public class ActivityImpl implements Activity {

    private static final String ID_PROPERTY = "id";
    private static final String FACEBOOKID_PROPERTY = "facebookID";
    private static final String VERSION_PROPERTY = "version";
    private static final String ISNATIVE_PROPERTY = "isNative";
    private static final String NAME_PROPERTY = "name";
    private static final String DESCRIPTION_PROPERTY = "description";
    private static final String LOCATIONNAME_PROPERTY = "locationName";
    private static final String LOCATIONCITY_PROPERTY = "locationCity";
    private static final String STARTDATE_PROPERTY = "startDate";
    private static final String ENDDATE_PROPERTY = "endDate";
    private static final String LONGITUDE_PROPERTY = "longitude";
    private static final String LATITUDE_PROPERTY = "latitude";
    private static final String PARTICIPATIONLIMIT_PROPERTY = "participationLimit";

	
	
	private final Node underlyingNode;
	
	public ActivityImpl(final Node node) {
		this.underlyingNode = node;
	}
	
	public Node getUnderlyingNode() {
		return this.underlyingNode;
	}

	@Override
	public long getId() {
		return (Long) underlyingNode.getProperty(ID_PROPERTY);
	}

	@Override
	public void setId(long id) {
		underlyingNode.setProperty(ID_PROPERTY, id);
	}
	
	@Override
	public long getVersion() {
		return (Long) underlyingNode.getProperty(VERSION_PROPERTY);
	}
	
	@Override
	public
	void setVersion(long version) {
		underlyingNode.setProperty(VERSION_PROPERTY, version);
	}

	@Override
	public long getFacebookId() {
		return (Long) underlyingNode.getProperty(FACEBOOKID_PROPERTY);
	}

	@Override
	public void setFacebookId(long facebookId) {
		underlyingNode.setProperty(FACEBOOKID_PROPERTY, facebookId);
	}

	@Override
	public boolean isNative() {
		return (Boolean) underlyingNode.getProperty(ISNATIVE_PROPERTY);
	}

	@Override
	public void setIsNative(boolean isNative) {
		underlyingNode.setProperty(ISNATIVE_PROPERTY, isNative);
	}

	@Override
	public String getName() {
		return (String) underlyingNode.getProperty(NAME_PROPERTY);
	}

	@Override
	public void setName(String name) {
		underlyingNode.setProperty(NAME_PROPERTY, name);
	}

	@Override
	public String getDescription() {
		return (String) underlyingNode.getProperty(DESCRIPTION_PROPERTY);
	}

	@Override
	public void setDescription(String description) {
		underlyingNode.setProperty(DESCRIPTION_PROPERTY, description);
	}

	@Override
	public String getLocationName() {
		return (String) underlyingNode.getProperty(LOCATIONNAME_PROPERTY);
	}

	@Override
	public void setLocationName(String locationName) {
		underlyingNode.setProperty(LOCATIONNAME_PROPERTY, locationName);
	}

	@Override
	public String getLocationCity() {
		return (String) underlyingNode.getProperty(LOCATIONCITY_PROPERTY);
	}

	@Override
	public void setLocationCity(String locationCity) {
		underlyingNode.setProperty(LOCATIONCITY_PROPERTY, locationCity);
	}

	@Override
	public long getStartDate() {
		return (Long) underlyingNode.getProperty(STARTDATE_PROPERTY);
	}

	@Override
	public void setStartDate(long startDate) {
		underlyingNode.setProperty(STARTDATE_PROPERTY, startDate);
	}

	@Override
	public long getEndDate() {
		return (Long) underlyingNode.getProperty(ENDDATE_PROPERTY);
	}

	@Override
	public void setEndDate(long endDate) {
		underlyingNode.setProperty(ENDDATE_PROPERTY, endDate);
	}

	@Override
	public double getLongitude() {
		return (Double) underlyingNode.getProperty(LONGITUDE_PROPERTY);
	}

	@Override
	public void setLongitude(double longitude) {
		underlyingNode.setProperty(LONGITUDE_PROPERTY, longitude);
	}

	@Override
	public double getLatitude() {
		return (Double) underlyingNode.getProperty(LATITUDE_PROPERTY);
	}

	@Override
	public void setLatitude(double latitude) {
		underlyingNode.setProperty(LATITUDE_PROPERTY, latitude);
	}

	@Override
	public int getParticipantLimit() {
		return (Integer) underlyingNode.getProperty(PARTICIPATIONLIMIT_PROPERTY);
	}

	@Override
	public void setParticipantLimit(int participantLimit) {
		underlyingNode.setProperty(PARTICIPATIONLIMIT_PROPERTY, participantLimit);
	}

	@Override
	public Iterable<User> getOwners() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> getParticipants() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> getInvitedUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
