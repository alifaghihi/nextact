package nextACT.server.domain.relationships;

import org.neo4j.graphdb.Relationship;

import nextACT.server.domain.Activity;
import nextACT.server.domain.ActivityImpl;
import nextACT.server.domain.User;
import nextACT.server.domain.UserImpl;

public class ParticipationImpl implements Participation {

	private static final String PARTICIPATION_PROPERTY = "participation";
    private final Relationship underlyingRel;
	
    public ParticipationImpl(final Relationship rel) {
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
