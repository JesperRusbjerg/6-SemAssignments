package dk.cphbusiness.stubsAndDummies;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;

import java.util.List;

public class BankStub implements IBank {
  private IAccount account;

  @Override
  public IAccount getAccount(String number) {
    // TODO Auto-generated method stub
    return account;
  }

  @Override
  public void registerAccount(IAccount account) {
    // TODO Auto-generated method stub

  }

  @Override
  public void setAccount(IAccount account) {
    this.account = account;

  }

  @Override
  public ICustomer getCustomer(String number) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void registerCustomer(ICustomer customer) {
    // TODO Auto-generated method stub

  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<IAccount> getAccounts() {
    return null;
  }

  @Override
  public List<ICustomer> getCustomers() {
    return null;
  }

  @Override
  public int getId() {
    return 0;
  }


}
