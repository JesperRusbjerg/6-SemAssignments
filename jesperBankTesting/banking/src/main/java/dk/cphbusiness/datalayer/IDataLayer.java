package dk.cphbusiness.datalayer;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;

import java.util.List;

public interface IDataLayer {

    //Fetching accounts
    List<IAccount> getAccounts();
    IAccount getAccount(int id);
    IAccount editAccount(IAccount a);

    //Fetching for bank
    List<IAccount> getAccountsBank(int accId);
    List<ICustomer> getCustomers(String number);
    IBank editBank(IBank b, String name);

    //Fetch customer
    ICustomer fetchCustmer(String number);
    ICustomer editCustomer (ICustomer c);

}
