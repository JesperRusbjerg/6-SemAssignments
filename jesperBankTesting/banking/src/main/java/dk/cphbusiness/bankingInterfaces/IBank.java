package dk.cphbusiness.bankingInterfaces;


import java.util.List;

public interface IBank {
  IAccount getAccount(String number);
  void registerAccount(IAccount account);
  void setAccount(IAccount account);
  ICustomer getCustomer(String number);
  void registerCustomer(ICustomer customer);
  String getName();
  List<IAccount> getAccounts();
  List<ICustomer> getCustomers();
  }
