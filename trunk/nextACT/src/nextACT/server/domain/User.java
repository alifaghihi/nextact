package nextACT.server.domain;

public interface User {
	// own attributes
	long getId();
	void setId(long id);
	
	long getFacebookId();
	void setFacebookId(long id);
	
	String getFirstName();
	void setFirstName(String firstName);
	String getLastName();
	void setLastName(String lastName);
	String getFullName();
	void setFullName(String fullName);
	String getEMail();
	void setEMail(String email);
	String getPictureURL();
	void setPictureURL(String pictureURL);
	long getBirthday();
	void setBirthday(long birthday);
	String getCity();
	void setCity(String city);
	double getLongitude();
	void setLongitude(double longitude);
	double getLatitude();
	void setLatitude(double latitude);
	
	// get related Activites
	Iterable<Activity> getOwnedActivites();
	Iterable<Activity> getParticipatingActivies();
	Iterable<Activity> getInvitedActivies();
	
	// get related users
	Iterable<User> getFriends();
	Iterable<User> getFriendsOfFriends();
}
