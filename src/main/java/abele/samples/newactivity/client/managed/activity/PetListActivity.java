package abele.samples.newactivity.client.managed.activity;

import abele.samples.newactivity.client.managed.request.ApplicationRequestFactory;
import abele.samples.newactivity.client.managed.request.PetProxy;
import abele.samples.newactivity.client.scaffold.ScaffoldMobileApp;
import abele.samples.newactivity.client.scaffold.activity.IsScaffoldMobileActivity;
import abele.samples.newactivity.client.scaffold.place.AbstractProxyListActivity;
import abele.samples.newactivity.client.scaffold.place.ProxyListView;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.requestfactory.shared.Receiver;
import com.google.gwt.requestfactory.shared.Request;
import com.google.gwt.view.client.Range;
import java.util.List;

public class PetListActivity extends AbstractProxyListActivity<PetProxy> implements IsScaffoldMobileActivity {

    private final ApplicationRequestFactory requests;

    public PetListActivity(ApplicationRequestFactory requests, ProxyListView<abele.samples.newactivity.client.managed.request.PetProxy> view, PlaceController placeController) {
        super(placeController, view, PetProxy.class);
        this.requests = requests;
    }

    public Place getBackButtonPlace() {
        return ScaffoldMobileApp.ROOT_PLACE;
    }

    public String getBackButtonText() {
        return "Entities";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return "Pets";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<abele.samples.newactivity.client.managed.request.PetProxy>> createRangeRequest(Range range) {
        return requests.petRequest().findPetEntries(range.getStart(), range.getLength());
    }

    protected void fireCountRequest(Receiver<Long> callback) {
        requests.petRequest().countPets().fire(callback);
    }
}
