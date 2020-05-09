package dk.cphbusiness.banking;

import java.util.ArrayList;
import java.util.List;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;

public class Bank implements IBank {

    private int id;
    private List<IAccount> accounts;
    private List<ICustomer> customers;
    private String name;

    public Bank(String name) {
        accounts = new ArrayList<IAccount>();
        customers = new ArrayList<ICustomer>();
        this.name = name;
    }

    public Bank(int id, String name) {
        this.id = id;
        accounts = new ArrayList<IAccount>();
        customers = new ArrayList<ICustomer>();
        this.name = name;
    }

    public Bank(List<IAccount> accounts, List<ICustomer> customers, String name) {
        this.accounts = accounts;
        this.customers = customers;
        this.name = name;
    }

    @Override
    public IAccount getAccount(String number) {
        for (IAccount acc : accounts) {
            if (acc.getNumber().equals(number)) {
                return acc;
            }
        }
        return null;
    }

    @Override
    public void registerAccount(IAccount account) {
        accounts.add(account);
    }

    @Override
    public ICustomer getCustomer(String number) {
        for (ICustomer cust : customers) {
            if (cust.getNumber().equals(number)) {
                return cust;
            }
        }
        return null;
    }

    @Override
    public void registerCustomer(ICustomer customer) {
        customers.add(customer);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setAccount(IAccount account) {
        for (IAccount ac : accounts) {
            if (account.getNumber().equals(ac.getNumber())) {
                ac = account;
            }
        }
    }
    @Override
    public List<IAccount> getAccounts(){
        return accounts;
    }
    @Override
    public List<ICustomer> getCustomers(){
        return customers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}