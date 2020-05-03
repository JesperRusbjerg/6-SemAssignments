package dk.cphbusiness.banking.ImplementationsTests;

import dk.cphbusiness.banking.Account;
import org.junit.Test;
import static org.junit.Assert.*;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.stubsAndDummies.BankDummy;
import dk.cphbusiness.facade.BankStub;
import dk.cphbusiness.stubsAndDummies.CustomerDummy;

public class AccountTest {

  @Test
  public void testCreateAccount() throws Exception {
    IBank bank = new BankDummy();
    ICustomer customer = new CustomerDummy();
    String number = null;
    Account account = new Account(bank, customer, number);
    assertNotNull(account);
    }

  @Test
  public void testCreateAccountWithBank() {
    IBank bank = new BankDummy();
    ICustomer customer = new CustomerDummy();
    String number = null;
    Account account = new Account(bank, customer, number);
    assertEquals(bank, account.getBank());
    assertNotNull(account.getBank());
    }

  @Test
  public void testCreateAccountWithNumber() {
    IBank bank = new BankDummy();
    ICustomer customer = new CustomerDummy();
    String number = "ABC12345";
    Account account = new Account(bank, customer, number);
    assertEquals(number, account.getNumber());
    assertNotNull(account.getNumber());
    }

  @Test
  public void testCreateAccountWithZeroBalance() {
    IBank bank = new BankDummy();
    ICustomer customer = new CustomerDummy();
    String number = "ABC12345";
    Account account = new Account(bank, customer, number);
    assertEquals(0L, account.getBalance());
    }




  }
