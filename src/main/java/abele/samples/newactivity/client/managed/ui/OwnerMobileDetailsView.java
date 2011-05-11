package abele.samples.newactivity.client.managed.ui;

import abele.samples.newactivity.client.managed.request.OwnerProxy;
import abele.samples.newactivity.client.managed.ui.OwnerMobileDetailsView.Binder;
import abele.samples.newactivity.client.scaffold.place.ProxyDetailsView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class OwnerMobileDetailsView extends OwnerMobileDetailsView_Roo_Gwt {

    private static final Binder BINDER = GWT.create(Binder.class);

    private static abele.samples.newactivity.client.managed.ui.OwnerMobileDetailsView instance;

    @UiField
    HasClickHandlers delete;

    private Delegate delegate;

    public OwnerMobileDetailsView() {
        initWidget(BINDER.createAndBindUi(this));
    }

    public static abele.samples.newactivity.client.managed.ui.OwnerMobileDetailsView instance() {
        if (instance == null) {
            instance = new OwnerMobileDetailsView();
        }
        return instance;
    }

    public Widget asWidget() {
        return this;
    }

    public boolean confirm(String msg) {
        return Window.confirm(msg);
    }

    public OwnerProxy getValue() {
        return proxy;
    }

    @UiHandler("delete")
    public void onDeleteClicked(ClickEvent e) {
        delegate.deleteClicked();
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    interface Binder extends UiBinder<HTMLPanel, OwnerMobileDetailsView> {
    }
}
