package abele.samples.newactivity.client.managed.ui;

import abele.samples.newactivity.client.managed.request.OwnerProxy;
import abele.samples.newactivity.client.managed.ui.OwnerListView.Binder;
import abele.samples.newactivity.client.scaffold.place.AbstractProxyListView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import java.util.HashSet;
import java.util.Set;

public class OwnerListView extends OwnerListView_Roo_Gwt {

    private static final Binder BINDER = GWT.create(Binder.class);

    private static abele.samples.newactivity.client.managed.ui.OwnerListView instance;

    @UiField
    Button newButton;

    public OwnerListView() {
        init(BINDER.createAndBindUi(this), table, newButton);
        table.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.DISABLED);
        init();
    }

    public static abele.samples.newactivity.client.managed.ui.OwnerListView instance() {
        if (instance == null) {
            instance = new OwnerListView();
        }
        return instance;
    }

    public String[] getPaths() {
        return paths.toArray(new String[paths.size()]);
    }

    interface Binder extends UiBinder<HTMLPanel, OwnerListView> {
    }
}
