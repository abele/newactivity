// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package abele.samples.newactivity.domain;

import java.lang.String;

privileged aspect Pet_Roo_ToString {
    
    public String Pet.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("PetOwner: ").append(getPetOwner());
        return sb.toString();
    }
    
}
