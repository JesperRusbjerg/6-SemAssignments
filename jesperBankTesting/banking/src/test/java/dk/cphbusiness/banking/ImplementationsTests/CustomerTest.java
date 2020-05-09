package dk.cphbusiness.banking.ImplementationsTests;

import dk.cphbusiness.banking.Customer;
import org.junit.Test;
import static org.junit.Assert.*;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.stubsAndDummies.BankDummy;
import dk.cphbusiness.stubsAndDummies.CustomerDummy;

public class CustomerTest {

  @Test
  public void Test_CreateAccount_Account() throws Exception {
    ICustomer ic = new Customer("11111", "bente madsen");


    assertEquals("11111", ic.getNumber());
    assertEquals("bente madsen", ic.getName());
    
    
  }

  


  }
