package nextACT.shared;

import nextACT.domain.Activity;

import com.google.gwt.requestfactory.shared.RequestContext;
import com.google.gwt.requestfactory.shared.RequestFactory;
import com.google.gwt.requestfactory.shared.Service;

public interface nextActRequestFactory extends RequestFactory {
	ActivityDetailsRequest activityDetailsRequest();
}
