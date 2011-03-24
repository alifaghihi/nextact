package nextACT.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.IntegerBox;

public class TestPage extends Composite {

	private static TestPageUiBinder uiBinder = GWT
			.create(TestPageUiBinder.class);
	@UiField Button createButton;
	@UiField Button saveButton;
	@UiField TextBox loadID;
	@UiField LongBox id;
	@UiField LongBox facebookID;
	@UiField LongBox version;
	@UiField SimpleCheckBox isNative;
	@UiField TextBox name;
	@UiField TextBox description;
	@UiField TextBox locationName;
	@UiField TextBox locationCity;
	@UiField DateBox startDate;
	@UiField DateBox endDate;
	@UiField DoubleBox longitude;
	@UiField DoubleBox latitude;
	@UiField IntegerBox participantLimit;

	interface TestPageUiBinder extends UiBinder<Widget, TestPage> {
	}

	public TestPage() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public TestPage(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("createButton")
	void onCreateButtonClick(ClickEvent event) {
	}
}
