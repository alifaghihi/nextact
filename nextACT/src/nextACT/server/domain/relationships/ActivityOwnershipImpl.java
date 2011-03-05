package nextACT.server.domain.relationships;

import org.neo4j.graphdb.Relationship;

import nextACT.domain.Activity;
import nextACT.domain.User;
import nextACT.server.domain.nodes.ActivityImpl;
import nextACT.server.domain.nodes.UserImpl;

public class ActivityOwnershipImpl implements ActivityOwnership {

	private static final String ACTIVITYOWNERSHIP_PROPERTY = "ownership";
    private final Relationship underlyingRel;
	
	public ActivityOwnershipImpl(final Relationship rel) {
		this.underlyingRel = rel;
	}
	
	Relationship getUnderlyingRelationship()
    {
        return this.underlyingRel;
    }
	
	@Override
	public User getUser() {
		return new UserImpl(underlyingRel.getEndNode());
	}

	@Override
	public Activity getActivity() {
		return new ActivityImpl(underlyingRel.getStartNode());
	}
	
}
