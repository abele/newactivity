package abele.samples.newactivity.client.managed.activity;

import abele.samples.newactivity.client.managed.request.ApplicationRequestFactory;
import abele.samples.newactivity.client.managed.request.OwnerProxy;
import abele.samples.newactivity.client.managed.request.OwnerRequest;
import abele.samples.newactivity.client.managed.ui.OwnerDetailsView;
import abele.samples.newactivity.client.managed.ui.OwnerEditView;
import abele.samples.newactivity.client.managed.ui.OwnerListView;
import abele.samples.newactivity.client.managed.ui.OwnerMobileDetailsView;
import abele.samples.newactivity.client.managed.ui.OwnerMobileEditView;
import abele.samples.newactivity.client.scaffold.ScaffoldApp;
import abele.samples.newactivity.client.scaffold.place.CreateAndEditProxy;
import abele.samples.newactivity.client.scaffold.place.FindAndEditProxy;
import abele.samples.newactivity.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.RequestContext;

public class OwnerActivitiesMapper {

    private final ApplicationRequestFactory requests;

    private final PlaceController placeController;

    public OwnerActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new OwnerDetailsActivity((EntityProxyId<OwnerProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? OwnerMobileDetailsView.instance() : OwnerDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }

    @SuppressWarnings("unchecked")
    private EntityProxyId<abele.samples.newactivity.client.managed.request.OwnerProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<OwnerProxy>) place.getProxyId();
    }

    private Activity makeCreateActivity() {
        OwnerEditView.instance().setCreating(true);
        final OwnerRequest request = requests.ownerRequest();
        Activity activity = new CreateAndEditProxy<OwnerProxy>(OwnerProxy.class, request, ScaffoldApp.isMobile() ? OwnerMobileEditView.instance() : OwnerEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(OwnerProxy proxy) {
                request.persist().using(proxy);
                return request;
            }
        };
        return new OwnerEditActivityWrapper(requests, ScaffoldApp.isMobile() ? OwnerMobileEditView.instance() : OwnerEditView.instance(), activity, null);
    }

    private Activity makeEditActivity(ProxyPlace place) {
        OwnerEditView.instance().setCreating(false);
        EntityProxyId<OwnerProxy> proxyId = coerceId(place);
        Activity activity = new FindAndEditProxy<OwnerProxy>(proxyId, requests, ScaffoldApp.isMobile() ? OwnerMobileEditView.instance() : OwnerEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(OwnerProxy proxy) {
                OwnerRequest request = requests.ownerRequest();
                request.persist().using(proxy);
                return request;
            }
        };
        return new OwnerEditActivityWrapper(requests, ScaffoldApp.isMobile() ? OwnerMobileEditView.instance() : OwnerEditView.instance(), activity, proxyId);
    }
}
