package dk.cphbusiness.datalayer;

import dk.cphbusiness.banking.Movement;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.bankingInterfaces.IMovement;

import java.sql.SQLException;
import java.util.List;

public interface IDataLayer {

    //Fetching accounts
    List<IAccount> getAccounts();
    IAccount getAccount(int id);
    IAccount editAccount(IAccount a);
    IAccount getAccountAndHistroyOnNumber(String number);
    IAccount editBalance(long amount, String accNumber);

    //Fetching for bank
    //Fetches all accounts from a given bank
    List<IAccount> getAccountsBank(int bankId);
    //Fetches all customers from a given bank
    List<ICustomer> getCustomersFromBank(int bankId);
    //Fetches bank with given name
    IBank getBank(String name);
    //Getting single account from bank
    IAccount getAccountFromBank(String accNumber, int bankid);

    //Fetch customer
    //Fetch a certain customer - number is unique
    ICustomer fetchCustmer(String number);
    // edit a customer
    ICustomer editCustomer (ICustomer c);

    //Movement
    List<IAccount> transaction(IAccount a, IAccount b, long amount,  long date) throws SQLException;
    List<IMovement> movementsFromAccount(int id, String Number);
}
