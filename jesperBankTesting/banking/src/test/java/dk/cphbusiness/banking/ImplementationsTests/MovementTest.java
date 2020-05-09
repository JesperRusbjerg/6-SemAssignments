package dk.cphbusiness.banking.ImplementationsTests;

import dk.cphbusiness.banking.Movement;
import dk.cphbusiness.bankingInterfaces.IMovement;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.stubsAndDummies.AccountDummy;

public class MovementTest {

  @Test
  public void Test_MovementHistory_Account() throws Exception {

    IAccount ac = new AccountDummy("number");
    IAccount ac1 = new AccountDummy("number1");

    long amount = 1;

    Date date = new Date();
    long time = date.getTime();

    IMovement movement = new Movement(ac.getNumber(), ac1.getNumber(), amount, time);
    IMovement movement2 = new Movement(ac1.getNumber(), ac.getNumber(), amount, time);
    ac.addToMovementHistory(movement);
    ac.addToMovementHistory(movement2);

    Assert.assertEquals(ac.movementHistory().size(), 2);

  }

  }
