package nextACT.client;

import nextACT.client.ui.TestPage;
import nextACT.shared.NextActRequestFactory;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class NextACT implements EntryPoint {
	private SimplePanel appWidget = new SimplePanel();
	
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	final EventBus eventBus = new SimpleEventBus();
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		final NextActRequestFactory requestFactory = GWT.create(NextActRequestFactory.class);
		requestFactory.initialize(eventBus);
		
		RootPanel.get().add(appWidget);
		TestPage testPage = new TestPage();
		appWidget.clear();
		appWidget.add(testPage);
		testPage.setVisible(true);
	}
}
