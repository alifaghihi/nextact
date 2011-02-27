package nextACT.server.domain.relationships;

import nextACT.server.domain.Activity;
import nextACT.server.domain.User;

public interface ActivityOwnership {
	User getUser();
	Activity getActivity();
}
