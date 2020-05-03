package dk.cphbusiness.datalayer;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;

import java.sql.SQLException;
import java.util.List;

public interface IDataLayer {

    //Fetching accounts
    List<IAccount> getAccounts();
    IAccount getAccount(int id);
    IAccount editAccount(IAccount a);
    IAccount getAccountONNumber(String number);
    IAccount editBalance(long amount, String accNumber);

    //Fetching for bank
    //Fetches all accounts from a given bank
    List<IAccount> getAccountsBank(int bankId);
    //Fetches all customers from a given bank
    List<ICustomer> getCustomersFromBank(String customerNumber);

    //Fetch customer
    //Fetch a certain customer - number is unique
    ICustomer fetchCustmer(String number);
    // edit a customer
    ICustomer editCustomer (ICustomer c);

    //Movement
    void transaction(IAccount a, IAccount b) throws SQLException;
}
