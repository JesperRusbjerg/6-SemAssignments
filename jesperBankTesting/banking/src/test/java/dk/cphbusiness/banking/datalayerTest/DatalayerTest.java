package dk.cphbusiness.banking.datalayerTest;

import dk.cphbusiness.banking.Account;
import dk.cphbusiness.banking.Bank;
import dk.cphbusiness.banking.Customer;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.datalayer.DBConnect;
import dk.cphbusiness.datalayer.DataLayerImpl;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.plaf.nimbus.State;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DatalayerTest {

    @BeforeClass
    public static void before() throws SQLException, IOException {
        DBSetup dbs = new DBSetup();
        dbs.tearDownAndRebuildEverything();

    }

    @AfterClass
    public static void after() throws SQLException {
        DBConnect dbc = new DBConnect();
        Connection con = dbc.getCon();
        con.close();
    }


    @Test
    public void Test_Tables_Setup() throws SQLException {
        DBConnect dbc = new DBConnect();
        Connection con = dbc.getCon();
        DatabaseMetaData meta = con.getMetaData();
        ResultSet res = meta.getTables(null, null, "account",
                new String[] {"TABLE"});
        DatabaseMetaData meta1 = con.getMetaData();
        ResultSet res2 = meta1.getTables(null, null, "bank",
                new String[] {"TABLE"});
        DatabaseMetaData meta2 = con.getMetaData();
        ResultSet res3 = meta2.getTables(null, null, "customer",
                new String[] {"TABLE"});

        Assert.assertNotNull(res);
        Assert.assertNotNull(res2);
        Assert.assertNotNull(res3);
    }

    @Test
    public void Test_Get_Accounts_DataLayer(){
        DataLayerImpl dli = new DataLayerImpl();

        List<IAccount> accs = dli.getAccounts();
        Assert.assertNotNull(accs);
    }

    @Test
    public void Test_Edit_account_And_Get_Account_DataLayer(){
        Account a = new Account();
        a.setNumber("333");
        a.setBalance(9999);
        DataLayerImpl dli = new DataLayerImpl();
        dli.editAccount(a);

        Account a1 = (Account) dli.getAccount(1);
        Assert.assertEquals(a1.getBalance(), 9999);

        //Now i have edited in my account table, therefor i must reset it to standard
        DBSetup dbs = new DBSetup();
        dbs.resetAccountTable();
    }

    @Test
    public void Test_Account_Accounts_For_Bank_DataLayer(){
        DataLayerImpl dli = new DataLayerImpl();

        List<IAccount> accs = dli.getAccountsBank(1);
        Assert.assertNotNull(accs);

       // ScriptRunner sr = new ScriptRunner(null, false, false);

    }

    @Test
    public void Test_Get_Customer_from_number_DataLayer(){
        DataLayerImpl dli = new DataLayerImpl();
        List<ICustomer> customers = dli.getCustomers("3dax");
        Assert.assertNotNull(customers);
    }

    @Test
    public void Test_Edit_Bank_DataLayer(){
        DataLayerImpl dli = new DataLayerImpl();
        Bank b = new Bank();
        b.setName("Kejserens bank");

        dli.editBank(b, "Danske bank");

        //Now i have edited in my bank table, therefor i must reset it to standard
        DBSetup dbs = new DBSetup();
        dbs.resetBanksTable();
    }

    @Test
    public void Test_Edit_And_Fetch_Customer(){
        DataLayerImpl dli = new DataLayerImpl();
        Customer c = new Customer();
        c.setName("Per hansenxxx");
        c.setNumber("3dax");
        dli.editCustomer(c);

        Customer cus = (Customer) dli.fetchCustmer("3dax");

        Assert.assertEquals(cus.getName(), "Per hansenxxx");

    }


}


