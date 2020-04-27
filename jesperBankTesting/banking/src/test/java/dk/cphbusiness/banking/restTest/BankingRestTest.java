package dk.cphbusiness.banking.restTest;



import com.fasterxml.jackson.databind.ObjectMapper;
import dk.cphbusiness.rest.Banking;
import dto.AccountDTO;
import dto.CustomerDTO;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;


public final class BankingRestTest extends JerseyTest {

    @Override
    protected Application configure() {

        return new ResourceConfig(Banking.class);
    }


    @Test
    public void testGetCustomer() throws IOException  {
        Response res = target("/banking/customer/" + "test").request()
                .get();

        ObjectMapper mapper = new ObjectMapper();
        String content = res.readEntity(String.class);

        CustomerDTO dto = mapper.readValue(content, CustomerDTO.class);

        assertEquals("per", dto.getName());
        assertEquals("Xx21123dx", dto.getNumber());


    }

    @Test
    public void testGetAccountFromNumber() throws IOException {
        final String number  = "xx";
        Response res = target("/banking/account/" + number).request()
                .get();

        ObjectMapper mapper = new ObjectMapper();
        String content = res.readEntity(String.class);

        AccountDTO dto = mapper.readValue(content, AccountDTO.class);

        assertEquals(0, dto.getBalance());
        assertEquals("xx", dto.getNumber());
    }









}
