package nextACT.server.domain.relationships;

import nextACT.domain.Activity;
import nextACT.domain.User;

public interface ActivityOwnership {
	User getUser();
	Activity getActivity();
}
