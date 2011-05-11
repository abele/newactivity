package abele.samples.newactivity.client.managed.activity;

import abele.samples.newactivity.client.managed.request.ApplicationEntityTypesProcessor;
import abele.samples.newactivity.client.managed.request.ApplicationRequestFactory;
import abele.samples.newactivity.client.managed.request.OwnerProxy;
import abele.samples.newactivity.client.managed.request.PetProxy;
import abele.samples.newactivity.client.managed.ui.OwnerListView;
import abele.samples.newactivity.client.managed.ui.OwnerMobileListView;
import abele.samples.newactivity.client.managed.ui.PetListView;
import abele.samples.newactivity.client.managed.ui.PetMobileListView;
import abele.samples.newactivity.client.scaffold.ScaffoldApp;
import abele.samples.newactivity.client.scaffold.place.ProxyListPlace;
import abele.samples.newactivity.client.scaffold.place.SomeEntityProxy;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

public final class ApplicationMasterActivities extends
		ApplicationMasterActivities_Roo_Gwt {

	@Inject
	public ApplicationMasterActivities(ApplicationRequestFactory requests,
			PlaceController placeController) {
		this.requests = requests;
		this.placeController = placeController;
	}

	@Override
	public Activity getActivity(Place place) {
		if (!(place instanceof ProxyListPlace)) {
			return null;
		}
		Activity activity = super.getActivity(place);
		if (activity == null) {
			ProxyListPlace listPlace = (ProxyListPlace) place;
			if (SomeEntityProxy.class.equals(listPlace.getProxyClass())) {
				activity = new SomeActivity();
			}
		}
		return activity;
	}
}
