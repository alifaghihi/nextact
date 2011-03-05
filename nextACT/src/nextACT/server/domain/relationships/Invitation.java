package nextACT.server.domain.relationships;

import nextACT.domain.Activity;
import nextACT.domain.User;

public interface Invitation {
	User getUser();
	Activity getActivity();
	//TODO: add who invited one...
}
