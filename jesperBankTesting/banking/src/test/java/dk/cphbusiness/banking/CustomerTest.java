package dk.cphbusiness.banking;

import org.junit.Test;
import static org.junit.Assert.*;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.stubsAndDummies.BankDummy;
import dk.cphbusiness.stubsAndDummies.CustomerDummy;

public class CustomerTest {

  @Test
  public void testCreateAccount() throws Exception {
    ICustomer ic = new Customer("11111", "bente madsen");


    assertEquals("11111", ic.getNumber());
    assertEquals("bente madsen", ic.getName());
    
    
  }

  


  }
