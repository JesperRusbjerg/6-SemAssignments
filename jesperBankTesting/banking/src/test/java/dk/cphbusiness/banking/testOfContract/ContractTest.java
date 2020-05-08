package dk.cphbusiness.banking.testOfContract;

import dk.cphbusiness.datalayer.DBConnect;
import dk.cphbusiness.datalayer.DataLayerImpl;
import dk.cphbusiness.facade.*;
import facadeTest.AccountFacadeTest;
import facadeTest.BankFacadeTest;
import facadeTest.ContractHolder;
import facadeTest.CustomerFacadeTest;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

    @RunWith(Suite.class)
    @Suite.SuiteClasses({
            AccountFacadeTest.class,
            BankFacadeTest.class,
            CustomerFacadeTest.class
    })

    public class ContractTest {
        @BeforeClass
        public static void before(){
            DBConnect.REAL_DB = false;
            ContractHolder.accountContract = new AccountFacade(new DataLayerImpl());
            ContractHolder.bankContract = new BankFacade(new DataLayerImpl());
            ContractHolder.customerContract = new CustomerFacade(new DataLayerImpl());
        }

    }




