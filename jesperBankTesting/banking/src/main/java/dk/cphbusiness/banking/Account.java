package dk.cphbusiness.banking;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;

public class Account implements IAccount {
  private IBank bank;
  private ICustomer customer;
  private String number;
  private long balance = 0;

  public Account(IBank bank, ICustomer customer, String number) {
    this.bank = bank;
    this.customer = customer;
    this.number = number;
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

  public void transfer(long amount, IAccount target) {
    balance -= amount;
    Account ac = (Account) target;
    ac.balance += amount;
    }

  public void transfer(long amount, String targetNumber) {
    IAccount target = bank.getAccount(targetNumber);
    transfer(amount, target);
    }

  public void setBank(IBank bank) {
    this.bank = bank;
  }

  public void setCustomer(ICustomer customer) {
    this.customer = customer;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public void setBalance(long balance) {
    this.balance = balance;
  }
}
