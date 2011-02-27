package nextACT.server.domain.relationships;

import nextACT.server.domain.Activity;
import nextACT.server.domain.User;

public interface Participation {
	User getUser();
	Activity getActivity();
}
