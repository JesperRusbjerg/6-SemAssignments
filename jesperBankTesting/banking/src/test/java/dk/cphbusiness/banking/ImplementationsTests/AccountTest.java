package dk.cphbusiness.banking.ImplementationsTests;

import dk.cphbusiness.banking.Account;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.stubsAndDummies.BankDummy;
import dk.cphbusiness.stubsAndDummies.CustomerDummy;
import org.junit.jupiter.api.Assertions;

public class AccountTest {

  @Test
  public void Test_CreateAccount_Account() throws Exception {
    IBank bank = new BankDummy();
    ICustomer customer = new CustomerDummy();
    String number = null;
    Account account = new Account(bank, customer, number);
    assertNotNull(account);
    }

  @Test
  public void Test_CreateAccountWithBank_Account() {
    IBank bank = new BankDummy();
    ICustomer customer = new CustomerDummy();
    String number = null;
    Account account = new Account(bank, customer, number);
    assertEquals(bank, account.getBank());
    assertNotNull(account.getBank());
    }

  @Test
  public void Test_CreateAccountWithNumber_Account() {
    IBank bank = new BankDummy();
    ICustomer customer = new CustomerDummy();
    String number = "ABC12345";
    Account account = new Account(bank, customer, number);
    assertEquals(number, account.getNumber());
    assertNotNull(account.getNumber());
    }

  @Test
  public void Test_CreateAccountWithZeroBalance_Account() {
    IBank bank = new BankDummy();
    ICustomer customer = new CustomerDummy();
    String number = "ABC12345";
    Account account = new Account(bank, customer, number);
    assertEquals(0L, account.getBalance());
    }

    @Test
    public void Test_AccountTransfer_Account() throws Exception {
      IBank bank = new BankDummy();
      ICustomer customer = new CustomerDummy();
      String number = "ABC12345";
      String number2 = "XXX12345";
      Account account = new Account(bank, customer, number);
      account.setBalance(300);
      Account account2 = new Account(bank, customer, number2);
      account.transfer(250, account2);

      assertEquals(account2.getBalance(), 250);

    }

    @Test
    public void Test_Account_Transfer_Exception()  {
      IBank bank = new BankDummy();
      ICustomer customer = new CustomerDummy();
      String number = "ABC12345";
      String number2 = "XXX12345";
      Account account = new Account(bank, customer, number);
      Account account2 = new Account(bank, customer, number2);


      Assertions.assertThrows(Exception.class,
              () -> {account.transfer(250, account2);} );


    }




  }
