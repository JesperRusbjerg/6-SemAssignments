package dk.cphbusiness.bankingInterfaces;


public interface IBank {
  IAccount getAccount(String number);
  void registerAccount(IAccount account);
  void setAccount(IAccount account);
  ICustomer getCustomer(String number);
  void registerCustomer(ICustomer customer);
  String getName();
  }
