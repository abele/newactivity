// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package abele.samples.newactivity.client.managed.request;

import com.google.gwt.requestfactory.shared.EntityProxy;
import com.google.gwt.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtMirroredFrom;

@RooGwtMirroredFrom("abele.samples.newactivity.domain.Owner")
@ProxyForName("abele.samples.newactivity.domain.Owner")
public interface OwnerProxy extends EntityProxy {

    abstract Long getId();

    abstract Integer getVersion();

    abstract String getName();

    abstract void setId(Long id);

    abstract void setVersion(Integer version);

    abstract void setName(String name);
}
