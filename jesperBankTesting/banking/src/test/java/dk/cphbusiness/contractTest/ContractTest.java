package dk.cphbusiness.contractTest;

import dk.cphbusiness.facade.AccountFacadeDummy;
import dk.cphbusiness.facade.BankFacadeDummy;
import dk.cphbusiness.facade.CustomerFacadeDummy;
import facadeTest.AccountFacadeTest;
import facadeTest.ContractHolder;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountFacadeTest.class
//        BankFacadeDummy.class,
//        CustomerFacadeDummy.class
})
public class ContractTest {

    @BeforeClass
    public static void before(){
        ContractHolder.accountContract = new AccountFacadeDummy();
    }

}
