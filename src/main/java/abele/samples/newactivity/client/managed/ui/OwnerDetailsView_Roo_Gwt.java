// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package abele.samples.newactivity.client.managed.ui;

import abele.samples.newactivity.client.managed.request.OwnerProxy;
import abele.samples.newactivity.client.scaffold.place.ProxyDetailsView;
import abele.samples.newactivity.client.scaffold.place.ProxyListView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
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

public abstract class OwnerDetailsView_Roo_Gwt extends Composite implements ProxyDetailsView<OwnerProxy> {

    @UiField
    SpanElement id;

    @UiField
    SpanElement version;

    @UiField
    SpanElement name;

    OwnerProxy proxy;

    @UiField
    SpanElement displayRenderer;

    public void setValue(OwnerProxy proxy) {
        this.proxy = proxy;
        id.setInnerText(proxy.getId() == null ? "" : String.valueOf(proxy.getId()));
        version.setInnerText(proxy.getVersion() == null ? "" : String.valueOf(proxy.getVersion()));
        name.setInnerText(proxy.getName() == null ? "" : String.valueOf(proxy.getName()));
        displayRenderer.setInnerText(abele.samples.newactivity.client.managed.ui.OwnerProxyRenderer.instance().render(proxy));
    }
}
