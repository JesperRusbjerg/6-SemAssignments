package dk.cphbusiness.banking.ImplementationsTests;

import dk.cphbusiness.banking.Account;
import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;

import static org.junit.Assert.assertEquals;

public class AccountMockingTest {
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();

  @Test
  public void testAccountTransfer() {
    final ICustomer customer = context.mock(ICustomer.class);
    final IBank bank = context.mock(IBank.class);
    final String targetNumber = "TGT54321";
    Account source = new Account(bank, customer, "SRC54321");
    Account target = new Account(bank, customer, targetNumber);
    context.checking(new Expectations(){{
      oneOf(bank).getAccount(targetNumber);
      will(returnValue(target));
      //oneOf(bank).getName();
      }});

    source.transfer(10000, "TGT54321");
    assertEquals(-10000, source.getBalance());
    assertEquals(10000, target.getBalance());

    //context.assertIsSatisfied();
    }

  }
