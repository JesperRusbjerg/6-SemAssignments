package dk.cphbusiness.banking.facadeTest;


import dk.cphbusiness.banking.Account;
import dk.cphbusiness.banking.fakes.DataLayerFake;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.datalayer.IDataLayer;
import dk.cphbusiness.facade.AccountFacade;
import dto.AccountDTO;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.xml.crypto.Data;

import static org.mockito.Mockito.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AccountFacadeMockTest {


//
//    @BeforeClass
//    public void before() throws SQLException, IOException {
//
//    }


    @Test
    public void Test_getAllAccounts_AccountFacade(){ List<IAccount> accs = new ArrayList<>();
        IDataLayer dli = Mockito.mock(IDataLayer.class);


        AccountFacade af = new AccountFacade(dli);
        accs.add(new Account(null, null, "xx0"));
        accs.add(new Account(null, null, "xx2"));

        when(dli.getAccounts()).thenReturn(accs);

        List<AccountDTO> accsx = af.getAllAccounts();

        Assert.assertEquals(accsx.size(), 2);

        verify(dli, times(1)).getAccounts();
    }

    @Test
    public void Test_TransactionExceptionAndSpy_AccountFacade() throws Exception {

        IDataLayer dli = Mockito.mock(IDataLayer.class);

        when(dli.getAccountAndHistroyOnNumber("xx")).thenReturn(null);
        IAccount a = new Account(null, null, "JeppeNumber");
        when(dli.getAccountAndHistroyOnNumber("x2")).thenReturn(a);
        AccountFacade af = new AccountFacade(dli);


        Assertions.assertThrows(Exception.class,
                () -> {af.transaction("xx", "x2", 400);} );


        verify(dli, times(0)).transaction(null, null, 400, 292);

    }

}
