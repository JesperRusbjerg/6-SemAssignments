package dk.cphbusiness.banking.facadeTest;

import dk.cphbusiness.banking.fakes.DataLayerFake;
import dk.cphbusiness.datalayer.IDataLayer;
import dk.cphbusiness.facade.AccountFacade;
import dk.cphbusiness.facade.BankFacade;
import dto.AccountDTO;
import dto.BankDTO;
import dto.CustomerDTO;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BankFacadeTest {

    private static IDataLayer dli;
    private static BankFacade bf;

    @BeforeClass
    public static void before() throws SQLException, IOException {
        dli = new DataLayerFake();
        bf = new BankFacade(dli);
    }

    @AfterClass
    public static void after() throws SQLException {
    }


    @Test
    public void Test_GetAccountsBank_BankFacade(){
        BankDTO b = new BankDTO();
        b.setName("Danske bank");

        List<AccountDTO> accDtos = bf.getAccounts(b);

        Assert.assertEquals(accDtos.size(), 2);


    }

    @Test
    public void Test_GetCustomersBank_BankFacade(){
        BankDTO b = new BankDTO();
        b.setName("Danske bank");

        List<CustomerDTO> accDtos = bf.getCustomers(b);

        Assert.assertEquals(accDtos.size(), 2);
    }

    @Test
    public void Test_GetAccountFromBank(){
        BankDTO b = new BankDTO();
        b.setName("Danske bank");

        AccountDTO a = bf.getAccount("xxxAccNum", b);

        Assert.assertNotNull(a);
    }

}
