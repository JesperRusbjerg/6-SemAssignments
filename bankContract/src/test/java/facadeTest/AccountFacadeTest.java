package facadeTest;

import contract.AccountContract;
import dto.AccountDTO;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class AccountFacadeTest {

    @BeforeClass
    public static void setupBeforeClass(){

    }

    @Test
    public void AccountFacade_Get_All_Accounts_Test(){
        AccountContract manager = ContractHolder.accountContract;

        List<AccountDTO> acc = manager.getAllAccounts();
        assertNotNull(acc);
        assertEquals(3, acc.size());
    }

    @Test
    public void AccountFacade_Get_Account_Test(){
        AccountContract manager = ContractHolder.accountContract;

        AccountDTO a = manager.getAccount("xx");
        assertNotNull(a);
    }

    @Test
    public void AccountFacade_edit_Balance(){
        AccountContract manager = ContractHolder.accountContract;

        long testbalance = 3333;
        AccountDTO a = manager.editBalance(testbalance, "xx");

        assertEquals(a.getBalance(), testbalance);

    }


}
