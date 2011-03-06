package nextACT.domain;

import java.util.Date;




public interface Activity {
	// own attributes
	long getId();
	void setId(long id);
	
	long getFacebookId();
	void setFacebookId(long facebookId);
	
	long getVersion();
	void setVersion(long version);
	
	boolean getIsNative();
	void setIsNative(boolean isNative);
	
	String getName();
	void setName(String name);
	String getDescription();
	void setDescription(String description);
	String getLocationName();
	void setLocationName(String locationName);
	String getLocationCity();
	void setLocationCity(String locationCity);
	
	long getStartDate();
	void setStartDate(long startDate);
	long getEndDate();
	void setEndDate(long endDate);
	
	
	double getLongitude();
	void setLongitude(double longitude);
	double getLatitude();
	void setLatitude(double latitude);
	
	int getParticipantLimit();
	void setParticipantLimit(int participantLimit);
	
	// get related users
	Iterable<User> getOwners();
	Iterable<User> getParticipants();
	Iterable<User> getInvitedUsers();
}
