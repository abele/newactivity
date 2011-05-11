package abele.samples.newactivity.client.managed.activity;

import abele.samples.newactivity.client.managed.request.ApplicationRequestFactory;
import abele.samples.newactivity.client.managed.request.PetProxy;
import abele.samples.newactivity.client.managed.request.PetRequest;
import abele.samples.newactivity.client.managed.ui.PetDetailsView;
import abele.samples.newactivity.client.managed.ui.PetEditView;
import abele.samples.newactivity.client.managed.ui.PetListView;
import abele.samples.newactivity.client.managed.ui.PetMobileDetailsView;
import abele.samples.newactivity.client.managed.ui.PetMobileEditView;
import abele.samples.newactivity.client.scaffold.ScaffoldApp;
import abele.samples.newactivity.client.scaffold.place.CreateAndEditProxy;
import abele.samples.newactivity.client.scaffold.place.FindAndEditProxy;
import abele.samples.newactivity.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.EntityProxyId;
import com.google.gwt.requestfactory.shared.RequestContext;

public class PetActivitiesMapper {

    private final ApplicationRequestFactory requests;

    private final PlaceController placeController;

    public PetActivitiesMapper(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(place.getOperation()) {
            case DETAILS:
                return new PetDetailsActivity((EntityProxyId<PetProxy>) place.getProxyId(), requests, placeController, ScaffoldApp.isMobile() ? PetMobileDetailsView.instance() : PetDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }

    @SuppressWarnings("unchecked")
    private EntityProxyId<abele.samples.newactivity.client.managed.request.PetProxy> coerceId(ProxyPlace place) {
        return (EntityProxyId<PetProxy>) place.getProxyId();
    }

    private Activity makeCreateActivity() {
        PetEditView.instance().setCreating(true);
        final PetRequest request = requests.petRequest();
        Activity activity = new CreateAndEditProxy<PetProxy>(PetProxy.class, request, ScaffoldApp.isMobile() ? PetMobileEditView.instance() : PetEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(PetProxy proxy) {
                request.persist().using(proxy);
                return request;
            }
        };
        return new PetEditActivityWrapper(requests, ScaffoldApp.isMobile() ? PetMobileEditView.instance() : PetEditView.instance(), activity, null);
    }

    private Activity makeEditActivity(ProxyPlace place) {
        PetEditView.instance().setCreating(false);
        EntityProxyId<PetProxy> proxyId = coerceId(place);
        Activity activity = new FindAndEditProxy<PetProxy>(proxyId, requests, ScaffoldApp.isMobile() ? PetMobileEditView.instance() : PetEditView.instance(), placeController) {

            @Override
            protected RequestContext createSaveRequest(PetProxy proxy) {
                PetRequest request = requests.petRequest();
                request.persist().using(proxy);
                return request;
            }
        };
        return new PetEditActivityWrapper(requests, ScaffoldApp.isMobile() ? PetMobileEditView.instance() : PetEditView.instance(), activity, proxyId);
    }
}
