package dk.cphbusiness.banking.datalayerTest;

import dk.cphbusiness.banking.Account;
import dk.cphbusiness.banking.Bank;
import dk.cphbusiness.banking.Customer;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.datalayer.DBConnect;
import dk.cphbusiness.datalayer.DataLayerImpl;
import dto.BankDTO;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.sql.*;
import java.util.List;

public class DatalayerTest {

    private static DataLayerImpl dli;
    private static DBSetup dbs;

    @BeforeClass
    public static void before() throws SQLException, IOException {
        DBConnect.REAL_DB = false;
        dli = new DataLayerImpl();
        dbs = new DBSetup(dli.getCon());
        dbs.tearDownAndRebuildEverything();
    }

    @AfterClass
    public static void after() throws SQLException {
        dli.getCon().close();

        DBConnect.REAL_DB = true;
    }


    @Test
    public void Test_Tables_Setup() throws SQLException {
        Connection con = dli.getCon();
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

        List<IAccount> accs = dli.getAccounts();
        Assert.assertNotNull(accs);
    }

    @Test
    public void Test_Edit_account_And_Get_Account_DataLayer(){
        Account a = new Account();
        a.setNumber("333");
        a.setBalance(9999);
        dli.editAccount(a);

        Account a1 = (Account) dli.getAccount(1);
        Assert.assertEquals(a1.getBalance(), 9999);

        //Now i have edited in my account table, therefor i must reset it to standard

        dbs.resetAccountTable();
    }

    @Test
    public void Test_Account_Accounts_For_Bank_DataLayer(){

        List<IAccount> accs = dli.getAccountsBank(1);
        Assert.assertNotNull(accs);

    }

    @Test
    public void Test_Get_Customer_from_number_DataLayer(){

        List<ICustomer> customers = dli.getCustomersFromBank(2);
        Assert.assertNotNull(customers);
    }

    @Test
    public void Test_Edit_And_Fetch_Customer(){
        Customer c = new Customer();
        c.setName("Per hansenxxx");
        c.setNumber("3dax");
        dli.editCustomer(c);

        Customer cus = (Customer) dli.fetchCustmer("3dax");

        Assert.assertEquals(cus.getName(), "Per hansenxxx");
    }


    @Test
    public void Test_Transaction_Account_To_Account() throws Exception {
        long amountToTransfer = 200;

        Account from = (Account) dli.getAccount(1);
        Account to = (Account) dli.getAccount(2);

        from.transfer(amountToTransfer, to);

        dli.transaction(from, to);

        IAccount fromEdited = dli.getAccount(1);
        IAccount toEdited = dli.getAccount(2);

        Assert.assertEquals(from.getBalance(), fromEdited.getBalance());
        Assert.assertEquals(to.getBalance(), toEdited.getBalance());


    }



}


