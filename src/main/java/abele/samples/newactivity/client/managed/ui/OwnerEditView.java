package abele.samples.newactivity.client.managed.ui;

import abele.samples.newactivity.client.managed.activity.OwnerEditActivityWrapper;
import abele.samples.newactivity.client.managed.request.OwnerProxy;
import abele.samples.newactivity.client.managed.ui.OwnerEditView.Binder;
import abele.samples.newactivity.client.scaffold.place.ProxyEditView;
import abele.samples.newactivity.client.scaffold.ui.*;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.editor.client.EditorError;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.requestfactory.client.RequestFactoryEditorDriver;
import com.google.gwt.requestfactory.shared.RequestFactory;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DoubleBox;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.datepicker.client.DateBox;
import java.util.Collection;
import java.util.List;

public class OwnerEditView extends OwnerEditView_Roo_Gwt {

    private static final Binder BINDER = GWT.create(Binder.class);

    private static abele.samples.newactivity.client.managed.ui.OwnerEditView instance;

    @UiField
    Button cancel;

    @UiField
    Button save;

    @UiField
    DivElement errors;

    @UiField
    Element editTitle;

    @UiField
    Element createTitle;

    private Delegate delegate;

    public OwnerEditView() {
        initWidget(BINDER.createAndBindUi(this));
    }

    public static abele.samples.newactivity.client.managed.ui.OwnerEditView instance() {
        if (instance == null) {
            instance = new OwnerEditView();
        }
        return instance;
    }

    @Override
    public RequestFactoryEditorDriver<abele.samples.newactivity.client.managed.request.OwnerProxy, abele.samples.newactivity.client.managed.ui.OwnerEditView> createEditorDriver() {
        RequestFactoryEditorDriver<OwnerProxy, OwnerEditView> driver = GWT.create(Driver.class);
        driver.initialize(this);
        return driver;
    }

    public void setCreating(boolean creating) {
        if (creating) {
            editTitle.getStyle().setDisplay(Display.NONE);
            createTitle.getStyle().clearDisplay();
        } else {
            editTitle.getStyle().clearDisplay();
            createTitle.getStyle().setDisplay(Display.NONE);
        }
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    public void setEnabled(boolean enabled) {
        save.setEnabled(enabled);
    }

    public void showErrors(List<EditorError> errors) {
        SafeHtmlBuilder b = new SafeHtmlBuilder();
        for (EditorError error : errors) {
            b.appendEscaped(error.getPath()).appendEscaped(": ");
            b.appendEscaped(error.getMessage()).appendHtmlConstant("<br>");
        }
        this.errors.setInnerHTML(b.toSafeHtml().asString());
    }

    @UiHandler("cancel")
    void onCancel(ClickEvent event) {
        delegate.cancelClicked();
    }

    @UiHandler("save")
    void onSave(ClickEvent event) {
        delegate.saveClicked();
    }

    interface Binder extends UiBinder<HTMLPanel, OwnerEditView> {
    }

    interface Driver extends RequestFactoryEditorDriver<OwnerProxy, OwnerEditView> {
    }
}
