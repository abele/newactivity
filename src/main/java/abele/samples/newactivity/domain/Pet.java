package abele.samples.newactivity.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import abele.samples.newactivity.domain.Owner;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooEntity
public class Pet {

    private String name;

    @ManyToOne
    private Owner petOwner;
}
