package abele.samples.newactivity.client.managed.activity;

import abele.samples.newactivity.client.managed.request.ApplicationRequestFactory;
import abele.samples.newactivity.client.managed.request.OwnerProxy;
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

public class OwnerListActivity extends AbstractProxyListActivity<OwnerProxy> implements IsScaffoldMobileActivity {

    private final ApplicationRequestFactory requests;

    public OwnerListActivity(ApplicationRequestFactory requests, ProxyListView<abele.samples.newactivity.client.managed.request.OwnerProxy> view, PlaceController placeController) {
        super(placeController, view, OwnerProxy.class);
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
        return "Owners";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<java.util.List<abele.samples.newactivity.client.managed.request.OwnerProxy>> createRangeRequest(Range range) {
        return requests.ownerRequest().findOwnerEntries(range.getStart(), range.getLength());
    }

    protected void fireCountRequest(Receiver<Long> callback) {
        requests.ownerRequest().countOwners().fire(callback);
    }
}
