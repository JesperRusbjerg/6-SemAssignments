package dk.cphbusiness.banking.ImplementationsTests;

import dk.cphbusiness.banking.Bank;
import org.junit.Test;
import static org.junit.Assert.*;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.stubsAndDummies.AccountDummy;
import dk.cphbusiness.stubsAndDummies.CustomerDummy;

public class BankTest {

  @Test
  public void Test_GetAndRegisterAccount_Account() throws Exception {
    IAccount acc = new AccountDummy("123");
    Bank bank = new Bank("Danske bank");
    bank.registerAccount(acc);

    IAccount iac = bank.getAccount(acc.getNumber());

    assertNotNull(iac);
  }

  @Test
  public void Test_GetAndRegisterCustomer_Account() throws Exception {
    ICustomer customer = new CustomerDummy();
    Bank bank = new Bank("Dansk benk");
    bank.registerCustomer(customer);
    ICustomer cust = bank.getCustomer(customer.getNumber());

    assertNotNull(cust);
  }

  @Test
  public void Test_SetCustomer_Account() throws Exception {
    IAccount acc = new AccountDummy("22222");
    Bank bank = new Bank("Danske bank");
    bank.registerAccount(acc);
    
    IAccount acc2 = new AccountDummy("22222");
    bank.setAccount(acc2);

    IAccount assertx = bank.getAccount("22222");

    assertNotNull(assertx);
  }

}
