//package dk.cphbusiness.banking;
//
//import org.junit.Test;
//import static org.junit.Assert.*;
//import dk.cphbusiness.bankingInterfaces.IBank;
//import dk.cphbusiness.bankingInterfaces.ICustomer;
//import dk.cphbusiness.stubsAndDummies.BankDummy;
//import dk.cphbusiness.facade.BankStub;
//import dk.cphbusiness.stubsAndDummies.CustomerDummy;
//
//public class AccountTest {
//
//  @Test
//  public void testCreateAccount() throws Exception {
//    IBank bank = new BankDummy();
//    ICustomer customer = new CustomerDummy();
//    String number = null;
//    Account account = new Account(bank, customer, number);
//    assertNotNull(account);
//    }
//
//  @Test
//  public void testCreateAccountWithBank() {
//    IBank bank = new BankDummy();
//    ICustomer customer = new CustomerDummy();
//    String number = null;
//    Account account = new Account(bank, customer, number);
//    assertEquals(bank, account.getBank());
//    assertNotNull(account.getBank());
//    }
//
//  @Test
//  public void testCreateAccountWithNumber() {
//    IBank bank = new BankDummy();
//    ICustomer customer = new CustomerDummy();
//    String number = "ABC12345";
//    Account account = new Account(bank, customer, number);
//    assertEquals(number, account.getNumber());
//    assertNotNull(account.getNumber());
//    }
//
//  @Test
//  public void testCreateAccountWithZeroBalance() {
//    IBank bank = new BankDummy();
//    ICustomer customer = new CustomerDummy();
//    String number = "ABC12345";
//    Account account = new Account(bank, customer, number);
//    assertEquals(0L, account.getBalance());
//    }
//
//  @Test
//  public void testTransferPositiveAmount() {
//    IBank bank = new BankDummy();
//    ICustomer customer = new CustomerDummy();
//    String number = "ABC12345";
//    Account source = new Account(bank, customer, "SRC12345");
//    Account target = new Account(bank, customer, "TGT12345");
//    source.transfer(10000, target);
//    assertEquals(-10000, source.getBalance());
//    assertEquals(10000, target.getBalance());
//    }
//
//  @Test
//  public void testTransferPositiveAmountUsingNumber() {
//    BankStub bank = new BankStub();
//    ICustomer customer = new CustomerDummy();
//    String targetNumber = "TGT12345";
//    Account target = new Account(bank, customer, targetNumber);
//    Account source = new Account(bank, customer, "SRC12345");
//    bank.setAccount(target);
//
//    source.transfer(10000, targetNumber);
//    assertEquals(-10000, source.getBalance());
//    assertEquals(10000, target.getBalance());
//    }
//
//
//  }
