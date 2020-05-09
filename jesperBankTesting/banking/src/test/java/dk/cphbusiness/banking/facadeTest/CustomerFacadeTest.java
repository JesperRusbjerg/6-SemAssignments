package dk.cphbusiness.banking.facadeTest;

import dk.cphbusiness.banking.fakes.DataLayerFake;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.datalayer.IDataLayer;
import dk.cphbusiness.facade.BankFacade;
import dk.cphbusiness.facade.CustomerFacade;
import dto.CustomerDTO;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class CustomerFacadeTest {

    private static IDataLayer dli;
    private static CustomerFacade cf;

    @BeforeClass
    public static void before() throws SQLException, IOException {
        dli = new DataLayerFake();
        cf = new CustomerFacade(dli);
    }

    @AfterClass
    public static void after() throws SQLException {
    }


    @Test
    public void Test_FetchCustomer_CustomerFacade(){

    CustomerDTO c = cf.getCusomter("custNumber");

        Assert.assertEquals(c.getName(), "Peter Martinsen");
    }

}
