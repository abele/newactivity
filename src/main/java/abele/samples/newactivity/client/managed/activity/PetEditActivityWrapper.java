package abele.samples.newactivity.client.managed.activity;

import abele.samples.newactivity.client.managed.activity.PetEditActivityWrapper.View;
import abele.samples.newactivity.client.managed.request.ApplicationRequestFactory;
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

public class PetEditActivityWrapper extends PetEditActivityWrapper_Roo_Gwt {

    private final EntityProxyId<PetProxy> proxyId;

    public PetEditActivityWrapper(ApplicationRequestFactory requests, View<?> view, Activity activity, EntityProxyId<abele.samples.newactivity.client.managed.request.PetProxy> proxyId) {
        this.requests = requests;
        this.view = view;
        this.wrapped = activity;
        this.proxyId = proxyId;
    }

    public Place getBackButtonPlace() {
        return (proxyId == null) ? new ProxyListPlace(PetProxy.class) : new ProxyPlace(proxyId, ProxyPlace.Operation.DETAILS);
    }

    public String getBackButtonText() {
        return "Cancel";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return (proxyId == null) ? "New Pet" : "Edit Pet";
    }

    public boolean hasEditButton() {
        return false;
    }

    @Override
    public String mayStop() {
        return wrapped.mayStop();
    }

    @Override
    public void onCancel() {
        wrapped.onCancel();
    }

    @Override
    public void onStop() {
        wrapped.onStop();
    }

    public interface View<V extends abele.samples.newactivity.client.scaffold.place.ProxyEditView<abele.samples.newactivity.client.managed.request.PetProxy, V>> extends View_Roo_Gwt<V> {
    }
}
