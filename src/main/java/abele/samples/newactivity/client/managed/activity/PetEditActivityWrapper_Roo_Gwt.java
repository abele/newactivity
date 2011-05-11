// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package abele.samples.newactivity.client.managed.activity;

import abele.samples.newactivity.client.managed.activity.PetEditActivityWrapper.View;
import abele.samples.newactivity.client.managed.request.ApplicationRequestFactory;
import abele.samples.newactivity.client.managed.request.OwnerProxy;
import abele.samples.newactivity.client.managed.request.PetProxy;
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

public abstract class PetEditActivityWrapper_Roo_Gwt implements Activity, IsScaffoldMobileActivity {

    protected Activity wrapped;

    protected View<?> view;

    protected ApplicationRequestFactory requests;

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        view.setPetOwnerPickerValues(Collections.<OwnerProxy>emptyList());
        requests.ownerRequest().findOwnerEntries(0, 50).with(abele.samples.newactivity.client.managed.ui.OwnerProxyRenderer.instance().getPaths()).fire(new Receiver<List<OwnerProxy>>() {

            public void onSuccess(List<OwnerProxy> response) {
                List<OwnerProxy> values = new ArrayList<OwnerProxy>();
                values.add(null);
                values.addAll(response);
                view.setPetOwnerPickerValues(values);
            }
        });
        wrapped.start(display, eventBus);
    }

    public interface View_Roo_Gwt<V extends abele.samples.newactivity.client.scaffold.place.ProxyEditView<abele.samples.newactivity.client.managed.request.PetProxy, V>> extends ProxyEditView<PetProxy, V> {

        void setPetOwnerPickerValues(Collection<OwnerProxy> values);
    }
}