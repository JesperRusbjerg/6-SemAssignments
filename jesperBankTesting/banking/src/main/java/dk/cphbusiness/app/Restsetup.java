package dk.cphbusiness.app;

import dk.cphbusiness.rest.Banking;
import dk.cphbusiness.rest.Greetings;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


public class Restsetup extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    public Restsetup() {
        // Register our hello service
        singletons.add(new Greetings());
        singletons.add(new Banking());
    }
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}