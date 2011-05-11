package abele.samples.newactivity.client.managed.activity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class SomeActivity extends Composite implements Activity{

	private static SomeActivityUiBinder uiBinder = GWT
			.create(SomeActivityUiBinder.class);

	interface SomeActivityUiBinder extends UiBinder<Widget, SomeActivity> {
	}

	private AcceptsOneWidget display;

	public SomeActivity() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public String mayStop() {
		return null;
	}

	@Override
	public void onCancel() {
		onStop();
		
	}

	@Override
	public void onStop() {
		this.display.setWidget(null);
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.display = panel;
		this.display.setWidget(this);
	}

}
