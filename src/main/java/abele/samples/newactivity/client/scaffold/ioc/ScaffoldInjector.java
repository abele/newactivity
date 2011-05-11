package abele.samples.newactivity.client.scaffold.ioc;

import abele.samples.newactivity.client.scaffold.ScaffoldApp;
import com.google.gwt.inject.client.Ginjector;

public interface ScaffoldInjector extends Ginjector {

	ScaffoldApp getScaffoldApp();
}
