// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package abele.samples.newactivity.client.managed.ui;

import abele.samples.newactivity.client.managed.request.OwnerProxy;
import abele.samples.newactivity.client.managed.request.PetProxy;
import abele.samples.newactivity.client.scaffold.ScaffoldMobileApp;
import abele.samples.newactivity.client.scaffold.ui.MobileProxyListView;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import java.util.HashSet;
import java.util.Set;

public abstract class PetMobileListView_Roo_Gwt extends MobileProxyListView<PetProxy> {

    protected Set<String> paths = new HashSet<String>();

    public PetMobileListView_Roo_Gwt(String buttonText, SafeHtmlRenderer<abele.samples.newactivity.client.managed.request.PetProxy> renderer) {
        super(buttonText, renderer);
    }

    public void init() {
        paths.add("name");
        paths.add("id");
    }
}
