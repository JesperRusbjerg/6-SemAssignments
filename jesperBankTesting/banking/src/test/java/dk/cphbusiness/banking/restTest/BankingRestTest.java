package dk.cphbusiness.banking.restTest;



import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dk.cphbusiness.banking.datalayerTest.DBSetup;
import dk.cphbusiness.datalayer.DBConnect;
import dk.cphbusiness.datalayer.DataLayerImpl;
import dk.cphbusiness.rest.Banking;
import dto.AccountDTO;
import dto.CustomerDTO;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;


public final class BankingRestTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(Banking.class);
    }

    @BeforeClass
    public static void before() throws SQLException, IOException {
        DBConnect.REAL_DB = false;
    }

    @AfterClass
    public static void after() throws SQLException {
        DBConnect.REAL_DB = true;
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
        final String number  = "333";
        Response res = target("/banking/account/" + number).request()
                .get();

        ObjectMapper mapper = new ObjectMapper();
        String content = res.readEntity(String.class);

        AccountDTO dto = mapper.readValue(content, AccountDTO.class);

        assertEquals(22222, dto.getBalance());
        assertEquals("333", dto.getNumber());
    }

    @Test
    public void testAllAccounts() throws IOException {
        Response res = target("/banking/account/all").request()
                .get();

        ObjectMapper mapper = new ObjectMapper();
        String content = res.readEntity(String.class);

        List<AccountDTO> dto =  mapper.readValue(content, new TypeReference<List<AccountDTO>>(){});

        assertEquals(dto.size(), 2);

    }









}
