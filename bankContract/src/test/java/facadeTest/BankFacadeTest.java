package facadeTest;
import contract.BankContract;
import dto.AccountDTO;
import dto.CustomerDTO;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class BankFacadeTest {

    @Test
    public void BankFacade_Get_Customers_Test(){
        BankContract b = ContractHolder.bankContract;
        List<CustomerDTO> c = b.getCustomers();
        assertNotNull(c);
        assertEquals(3, c.size());
    }
    @Test
    public void BankFacade_Get_Accounts_Test(){
        BankContract b = ContractHolder.bankContract;
        List<AccountDTO> c = b.getAccounts();
        assertNotNull(c);
        assertEquals(3, c.size());
    }


}
