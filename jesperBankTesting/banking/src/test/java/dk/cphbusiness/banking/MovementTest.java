package dk.cphbusiness.banking;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.stubsAndDummies.AccountDummy;

public class MovementTest {

  @Test
  public void testMovementHistory() throws Exception {

    IAccount ac = new AccountDummy("number");
    IAccount ac1 = new AccountDummy("number1");
    IAccount ac2 = new AccountDummy("number2");
    IAccount ac3 = new AccountDummy("number3");

    long amount = 1;
    Date date = new Date();
    long time = date.getTime();
    MovementHistory m = new MovementHistory();
    m.addMovement(ac2, ac3, amount, time);
    m.addMovement(ac, ac1, amount, time);

    assertEquals(m.returnList().size(), 2);
    }

  }
