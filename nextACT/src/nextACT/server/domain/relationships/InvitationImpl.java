package nextACT.server.domain.relationships;

import org.neo4j.graphdb.Relationship;

import nextACT.domain.Activity;
import nextACT.domain.User;
import nextACT.server.domain.nodes.ActivityImpl;
import nextACT.server.domain.nodes.UserImpl;

public class InvitationImpl implements Invitation {

	private static final String INVITATION_PROPERTY = "invitation";
    private final Relationship underlyingRel;
	
    public InvitationImpl(final Relationship rel) {
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
