package dk.cphbusiness.banking;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.bankingInterfaces.IMovement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account implements IAccount {

  private int id;
  private IBank bank;
  private ICustomer customer;
  private String number;
  private long balance = 0;
  private List<IMovement> movements = new ArrayList<>();


  public Account(IBank bank, ICustomer customer, String number) {
    this.bank = bank;
    this.customer = customer;
    this.number = number;
    this.movements = new ArrayList<>();
  }
  public Account(IBank bank, ICustomer customer, String number, int id) {
    this.bank = bank;
    this.customer = customer;
    this.number = number;
    this.id = id;
    this.movements = new ArrayList<>();
  }

    public Account() {

    }

    public IBank getBank() {
    return bank;
    }

  public ICustomer getCustomer() {
    return customer;
    }

  public String getNumber() {
    return number;
    }

  public long getBalance() {
    return balance;
    }

  public void transfer(long amount, IAccount target) throws Exception {
    if(balance - amount < 0) throw new Exception("Not enough money on the account!!");

    balance -= amount;
    Account ac = (Account) target;
    ac.balance += amount;

    //Movements being added to both accounts if a transaction is valid
    movements.add(new Movement(this.number, target.getNumber(), amount, new Date().getTime()));
    target.movementHistory().add(new Movement(this.number, target.getNumber(), amount, new Date().getTime()));

    }

  @Override
  public void setBank(IBank bank) {
    this.bank = bank;
  }

  @Override
  public void setCustomer(ICustomer customer) {
    this.customer = customer;
  }

  @Override
  public void setBalance(long balance) {
    this.balance = balance;
  }

  @Override
  public void setNumber(String number) {
    this.number = number;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public List<IMovement> movementHistory() {
    return movements;
  }

  @Override
  public void setMovementHistory(List<IMovement> movements) {
    this.movements = movements;
  }

  @Override
  public void addToMovementHistory(IMovement movement) {
    this.movements.add(movement);
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }
}
