package dk.cphbusiness.banking.facadeTest;

import dk.cphbusiness.banking.datalayerTest.DBSetup;
import dk.cphbusiness.banking.fakes.DataLayerFake;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.datalayer.DBConnect;
import dk.cphbusiness.datalayer.DataLayerImpl;
import dk.cphbusiness.datalayer.IDataLayer;
import dk.cphbusiness.facade.AccountFacade;
import dto.AccountDTO;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AccountFacadeTest {

    //Point of this test is to unit test the Accountfacade while mocking all surrounding dependencies
    //In this case that is the data layer
    // This then allows us to unit test our methods, without being dependant on the real datalayer
    // But at the same time it allows us to make sure our integration is correct, so long as the datalayer handles our calls correctly
    // Meaning that we can put any datalayer in our real app, as long as that passes its own tests

    private static IDataLayer dli;
    private static AccountFacade af;

    @BeforeClass
    public static void before() throws SQLException, IOException {
        dli = new DataLayerFake();
        af = new AccountFacade(dli);
    }

    @AfterClass
    public static void after() throws SQLException {
    }

    @Test
    public void Test_getAllAccounts_AccountFacade(){
        List<AccountDTO> accs = af.getAllAccounts();

        Assert.assertEquals(accs.size(), 2);
    }

    @Test
    public void Test_getAccount_AccountFacade(){

        AccountDTO a = af.getAccount("xxxAccNum");
        Assert.assertEquals(a.getBalance(), 350);
    }
    @Test
    public void Test_editedAccount_AccountFacade(){

        long amountToEdit = 400;
        AccountDTO a = af.getAccount("xxxAccNum");
        a.setBalance(amountToEdit);

        af.editAccount(a);

        AccountDTO aEdited = af.getAccount("xxxAccNum");

        Assert.assertEquals(aEdited.getBalance(), amountToEdit);

    }

    @Test
    public void Test_editBalance_AccountFacade(){
        af.editBalance(300, "xxxAccNum");
        AccountDTO a = af.getAccount("xxxAccNum");

        Assert.assertEquals(a.getBalance(), 300);

    }






}
