// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package abele.samples.newactivity.client.managed.activity;

import abele.samples.newactivity.client.managed.activity.OwnerEditActivityWrapper.View;
import abele.samples.newactivity.client.managed.request.ApplicationRequestFactory;
import abele.samples.newactivity.client.managed.request.OwnerProxy;
import abele.samples.newactivity.client.scaffold.activity.IsScaffoldMobileActivity;
import abele.samples.newactivity.client.scaffold.place.ProxyEditView;
import abele.samples.newactivity.client.scaffold.place.ProxyListPlace;
import abele.samples.newactivity.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class OwnerEditActivityWrapper_Roo_Gwt implements Activity, IsScaffoldMobileActivity {

    protected Activity wrapped;

    protected View<?> view;

    protected ApplicationRequestFactory requests;

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        wrapped.start(display, eventBus);
    }

    public interface View_Roo_Gwt<V extends abele.samples.newactivity.client.scaffold.place.ProxyEditView<abele.samples.newactivity.client.managed.request.OwnerProxy, V>> extends ProxyEditView<OwnerProxy, V> {
    }
}
