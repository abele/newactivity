package abele.samples.newactivity.client.managed.ui;

import abele.samples.newactivity.client.scaffold.place.ProxyListPlace;
import abele.samples.newactivity.client.scaffold.place.SomeEntityProxy;

public class ApplicationListPlaceRenderer extends ApplicationListPlaceRenderer_Roo_Gwt {
	
	@Override
	public String render(ProxyListPlace object) {
		String label = super.render(object);
		if(label == null) {
			if (SomeEntityProxy.class.equals(object.getProxyClass())) {
				label = "Some activity";
			}
		}
		return label;
	}
}
