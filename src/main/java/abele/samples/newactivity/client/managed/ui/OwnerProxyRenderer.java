package abele.samples.newactivity.client.managed.ui;

import abele.samples.newactivity.client.managed.request.OwnerProxy;
import com.google.gwt.requestfactory.ui.client.ProxyRenderer;

public class OwnerProxyRenderer extends ProxyRenderer<OwnerProxy> {

    private static abele.samples.newactivity.client.managed.ui.OwnerProxyRenderer INSTANCE;

    protected OwnerProxyRenderer() {
        super(new String[] { "name" });
    }

    public static abele.samples.newactivity.client.managed.ui.OwnerProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new OwnerProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(OwnerProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getId() + ")";
    }
}
