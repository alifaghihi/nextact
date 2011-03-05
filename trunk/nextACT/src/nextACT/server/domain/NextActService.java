package nextACT.server.domain;

import nextACT.domain.Activity;
import nextACT.domain.User;
import nextACT.server.domain.relationships.ActivityOwnership;
import nextACT.server.domain.relationships.Invitation;
import nextACT.server.domain.relationships.Participation;

public interface NextActService {
	
	Activity createActivity(long facebookId, boolean isNative, String name, String description, String locationName, String locationCity, long startDate, long endDate, double longitude, long latitude, int participantLimit);
	Activity getActivity(long id);
	
	
	User createUser(long id, long facebookID, String lastName, String firstName, String eMail, String pictureURL, long birthday, String city, double longitude, double latitude);
	User getUser(long id);
	
	ActivityOwnership createActivityOwnership(final Activity activity, final User user);
	Invitation createInvitation(final Activity activity, final User user);
	Participation createParticipation(final Activity activity, final User user);
}
