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

  public void transfer(long amount, IAccount target) throws Exception {
    if(balance - amount < 0) throw new Exception("Not enough money on the account!!");

    balance -= amount;
    Account ac = (Account) target;
    ac.balance += amount;

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


}
