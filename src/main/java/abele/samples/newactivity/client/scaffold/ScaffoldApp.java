package abele.samples.newactivity.client.scaffold;

import abele.samples.newactivity.client.managed.request.ApplicationEntityTypesProcessor;
import abele.samples.newactivity.client.scaffold.place.ProxyListPlace;
import abele.samples.newactivity.client.scaffold.place.SomeEntityProxy;

import com.google.gwt.requestfactory.shared.EntityProxy;

import java.util.HashSet;
import java.util.Set;

public class ScaffoldApp {

	static boolean isMobile = false;

	public static boolean isMobile() {
		return isMobile;
	}

	public void run() {
	}

	protected HashSet<ProxyListPlace> getTopPlaces() {
		Set<Class<? extends EntityProxy>> types = ApplicationEntityTypesProcessor.getAll();
		HashSet<ProxyListPlace> rtn = new HashSet<ProxyListPlace>(types.size());

		for (Class<? extends EntityProxy> type : types) {
			rtn.add(new ProxyListPlace(type));
		}
		
		rtn.add(new ProxyListPlace(SomeEntityProxy.class));

		return rtn;
	}
}