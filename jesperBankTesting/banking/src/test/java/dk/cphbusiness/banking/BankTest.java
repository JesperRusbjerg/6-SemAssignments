package dk.cphbusiness.banking;

import org.junit.Test;
import static org.junit.Assert.*;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.stubsAndDummies.AccountDummy;
import dk.cphbusiness.stubsAndDummies.CustomerDummy;

public class BankTest {

  @Test
  public void testGetAndRegisterAccount() throws Exception {
    IAccount acc = new AccountDummy("123");
    Bank bank = new Bank();
    bank.registerAccount(acc);

    IAccount iac = bank.getAccount(acc.getNumber());

    assertNotNull(iac);
  }

  @Test
  public void testGetAndRegisterCustomer() throws Exception {
    ICustomer customer = new CustomerDummy();
    Bank bank = new Bank();
    bank.registerCustomer(customer);
    ICustomer cust = bank.getCustomer(customer.getNumber());

    assertNotNull(cust);
  }

  @Test
  public void testSetCustomer() throws Exception {
    IAccount acc = new AccountDummy("22222");
    Bank bank = new Bank();
    bank.registerAccount(acc);
    
    IAccount acc2 = new AccountDummy("22222");
    bank.setAccount(acc2);

    IAccount assertx = bank.getAccount("22222");

    assertNotNull(assertx);
  }

}
