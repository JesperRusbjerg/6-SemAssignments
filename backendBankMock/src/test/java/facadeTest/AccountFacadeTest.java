package facadeTest;

import dk.cphbusiness.banking.Account;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.dto.AccountDTO;
import facade.AccountFacade;
import org.junit.BeforeClass;
import org.junit.Test;
import stubsAndDummies.AccountStub;

import java.util.List;

import static org.junit.Assert.*;

public class AccountFacadeTest {


    @BeforeClass
    public static void setupBeforeClass(){
        AccountFacade.accs.add(new AccountStub());
        AccountFacade.accs.add(new AccountStub());
        AccountFacade.accs.add(new AccountStub());
        AccountFacade.accs.add(new AccountStub());
    }

    @Test
    public void AccountFacade_Get_All_Accounts_Test(){
        AccountFacade af = new AccountFacade();
        List<AccountDTO> acc = af.getAllAccounts();
        assertNotNull(acc);
        assertEquals(3, acc.size());
    }

    @Test
    public void AccountFacade_Get_Account_Test(){
        AccountFacade af = new AccountFacade();
        AccountDTO a = af.getAccount("xx");
        assertNotNull(a);
    }

    @Test
    public void AccountFacade_edit_Balance(){
        long testbalance = 3333;
        AccountFacade af = new AccountFacade();
        AccountDTO a = af.editBalance(testbalance, "xx");

        assertEquals(a.getBalance(), testbalance);

    }


}
