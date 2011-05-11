package abele.samples.newactivity.client.managed.ui;

import abele.samples.newactivity.client.managed.request.PetProxy;
import com.google.gwt.requestfactory.ui.client.ProxyRenderer;

public class PetProxyRenderer extends ProxyRenderer<PetProxy> {

    private static abele.samples.newactivity.client.managed.ui.PetProxyRenderer INSTANCE;

    protected PetProxyRenderer() {
        super(new String[] { "name" });
    }

    public static abele.samples.newactivity.client.managed.ui.PetProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new PetProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(PetProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getId() + ")";
    }
}
