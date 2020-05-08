package dk.cphbusiness.app; // {{ groupId}}.app
// import the rest service you created!

import dk.cphbusiness.rest.Banking;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class HelloApplication extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    public HelloApplication() {
        // Register our hello service
        singletons.add(new Banking());
    }
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}