package nextACT.server.domain;

import org.neo4j.graphdb.Node;

public class UserImpl implements User {
	
    private static final String ID_PROPERTY = "id";
    private static final String FACEBOOKID_PROPERTY = "facebookID";
    private static final String FIRSTNAME_PROPERTY = "firstName";
    private static final String LASTNAME_PROPERTY = "lastName";
    private static final String FULLNAME_PROPERTY = "fullName";
    private static final String EMAIL_PROPERTY = "email";
    private static final String PICTUREURL_PROPERTY = "pictureURL";
    private static final String BIRTHDAY_PROPERTY = "birthday";
    private static final String CITY_PROPERTY = "city";
    private static final String LONGITUDE_PROPERTY = "longitude";
    private static final String LATITUDE_PROPERTY = "latitude";
	
	private final Node underlyingNode;
	
	public UserImpl(final Node node) {
		this.underlyingNode = node;
	}
	
	Node getUnderlyingNode() {
		return this.underlyingNode;
	}
	
	@Override
	public long getId() {
		 return (Long) underlyingNode.getProperty(ID_PROPERTY);
	}
	
	@Override
	public void setId(long id) {
		underlyingNode.setProperty(ID_PROPERTY, id);
	}

	@Override
	public long getFacebookId() {
		return (Long) underlyingNode.getProperty(FACEBOOKID_PROPERTY);
	}
	
	@Override
	public void setFacebookId(long id) {
		underlyingNode.setProperty(FACEBOOKID_PROPERTY, id);
	}

	@Override
	public String getFirstName() {
		return (String) underlyingNode.getProperty(FIRSTNAME_PROPERTY);
	}
	
	@Override
	public void setFirstName(String firstName) {
		underlyingNode.setProperty(FIRSTNAME_PROPERTY, firstName);
	}

	@Override
	public String getLastName() {
		return (String) underlyingNode.getProperty(LASTNAME_PROPERTY);
	}
	
	@Override
	public void setLastName(String lastName) {
		underlyingNode.setProperty(LASTNAME_PROPERTY, lastName);
	}

	@Override
	public String getFullName() {
		return (String) underlyingNode.getProperty(FULLNAME_PROPERTY);
	}
	
	@Override
	public void setFullName(String fullName) {
		underlyingNode.setProperty(FULLNAME_PROPERTY, fullName);
	}
	
	@Override
	public String getEMail() {
		return (String) underlyingNode.getProperty(EMAIL_PROPERTY);
	}
	
	@Override
	public void setEMail(String email) {
		underlyingNode.setProperty(EMAIL_PROPERTY, email);
	}

	@Override
	public String getPictureURL() {
		return (String) underlyingNode.getProperty(PICTUREURL_PROPERTY);
	}
	
	@Override
	public void setPictureURL(String pictureURL) {
		underlyingNode.setProperty(PICTUREURL_PROPERTY, pictureURL);
	}

	@Override
	public long getBirthday() {
		return (Long) underlyingNode.getProperty(BIRTHDAY_PROPERTY);
	}
	
	@Override
	public void setBirthday(long birthday) {
		underlyingNode.setProperty(BIRTHDAY_PROPERTY, birthday);
	}

	@Override
	public String getCity() {
		return (String) underlyingNode.getProperty(CITY_PROPERTY);
	}

	@Override
	public void setCity(String city) {
		underlyingNode.setProperty(CITY_PROPERTY, city);
	}
	
	@Override
	public double getLongitude() {
		return (Double) underlyingNode.getProperty(LONGITUDE_PROPERTY);
	}

	@Override
	public void setLongitude(double longitude) {
		underlyingNode.setProperty(LONGITUDE_PROPERTY, longitude);
	}

	@Override
	public double getLatitude() {
		return (Long) underlyingNode.getProperty(LATITUDE_PROPERTY);
	}
	

	@Override
	public void setLatitude(double latitude) {
		underlyingNode.setProperty(LATITUDE_PROPERTY, latitude);
	}
	
	@Override
	public Iterable<Activity> getOwnedActivites() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Activity> getParticipatingActivies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Activity> getInvitedActivies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> getFriends() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> getFriendsOfFriends() {
		// TODO Auto-generated method stub
		return null;
	}
}
