package facadeTest;

import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.dto.AccountDTO;
import dk.cphbusiness.dto.CustomerDTO;
import facade.AccountFacade;
import facade.BankFacade;
import facade.CustomerFacade;
import org.junit.BeforeClass;
import org.junit.Test;
import stubsAndDummies.AccountStub;

import java.util.List;

import static org.junit.Assert.*;


public class CustomerFacadeTest {

    @Test
    public void CustomerFacade_Test_get_Customer(){
        CustomerFacade cf = new CustomerFacade();
        CustomerDTO cd = cf.getCusomter("test");
        assertNotNull(cd);
    }
}
