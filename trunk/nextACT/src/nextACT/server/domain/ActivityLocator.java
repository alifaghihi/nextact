package nextACT.server.domain;

import com.google.gwt.requestfactory.shared.Locator;
import nextACT.domain.Activity;


public class ActivityLocator extends Locator<Activity, Long>  {

	@Override
	public Activity create(Class<? extends Activity> clazz) {
		// create some dummy data...
		long facebookId = -1;
		boolean isNative = false;
		String name = "No name defined yet";
		String description = "No description defined yet.";
		String locationName = "";
		String locationCity = "";
		long startDate = -1;
		long endDate = -1;
		double longitude = -1;
		long latitude = -1;
		int participantLimit = 0;
		
		return NextActServiceImpl.getInstance().createActivity(facebookId, isNative, name, description, locationName, locationCity, startDate, endDate, longitude, latitude, participantLimit);
	}

	@Override
	public Activity find(Class<? extends Activity> clazz, Long id) {
		return NextActServiceImpl.getInstance().getActivity(id);
	}

	@Override
	public Class<Activity> getDomainType() {
		return Activity.class;
	}

	@Override
	public Long getId(Activity domainObject) {
		return domainObject.getId();
	}

	@Override
	public Class<Long> getIdType() {
		return Long.class;
	}

	@Override
	public Object getVersion(Activity domainObject) {
		return domainObject.getVersion();
	}

}
