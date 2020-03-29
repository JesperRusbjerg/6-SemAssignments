package facadeTest;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.dto.AccountDTO;
import dk.cphbusiness.dto.CustomerDTO;
import facade.AccountFacade;
import facade.BankFacade;
import org.junit.BeforeClass;
import org.junit.Test;
import stubsAndDummies.AccountStub;

import java.util.List;

import static org.junit.Assert.*;


public class BankFacadeTest {

    @Test
    public void BankFacade_Get_Customers_Test(){
        BankFacade b = new BankFacade();
        List<CustomerDTO> c = b.getCustomers();
        assertNotNull(c);
        assertEquals(3, c.size());
    }
    @Test
    public void BankFacade_Get_Accounts_Test(){
        BankFacade b = new BankFacade();
        List<AccountDTO> c = b.getAccounts();
        assertNotNull(c);
        assertEquals(3, c.size());
    }


}
