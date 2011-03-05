package nextACT.shared;

import com.google.gwt.requestfactory.shared.InstanceRequest;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.ServiceName;

@ServiceName("nextACT.server.domain.NextActServiceImpl")
public interface ActivityDetailsRequest extends RequestContext {
	Request<ActivityDetailsProxy> getActivity(Long id);
	Request<ActivityDetailsProxy> createActivity(Long facebookId, Boolean isNative, String name, String description, String locationName, String locationCity, Long startDate, Long endDate, Double longitude, Long latitude, Integer participantLimit);
	//TODO: find activities by other properties (e.g. time & location)

	//TODO: what about persistance?!
	//TODO: remove/delete activity
}
