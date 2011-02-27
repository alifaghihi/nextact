package nextACT.server.domain.relationships;

import nextACT.server.domain.Activity;
import nextACT.server.domain.User;

public interface Invitation {
	User getUser();
	Activity getActivity();
	//TODO: add who invited one...
}
