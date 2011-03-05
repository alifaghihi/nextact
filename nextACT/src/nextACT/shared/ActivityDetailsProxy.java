package nextACT.shared;

import nextACT.domain.Activity;
import nextACT.server.domain.ActivityLocator;

import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyFor;

@ProxyFor(value = Activity.class, locator = ActivityLocator.class)
public interface ActivityDetailsProxy extends EntityProxy {
	// own attributes
	long getId();
	long getFacebookId();
	
	long getVersion();
	
	boolean isNative();
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
	
	// TODO: handle relationships!
}
