package dk.cphbusiness.banking;

import java.util.ArrayList;
import java.util.List;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;

public class Bank implements IBank {

    private List<IAccount> accounts;
    private List<ICustomer> customers;

    public Bank(){
        accounts = new ArrayList<IAccount>();
        customers = new ArrayList<ICustomer>();
    }

    public Bank(List<IAccount> accounts, List<ICustomer> customers){
        this.accounts = accounts;
        this.customers = customers;
    }

    @Override
    public IAccount getAccount(String number) {
        for (IAccount acc : accounts) {
            if(acc.getNumber().equals(number)){
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
            if(cust.getNumber().equals(number)){
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
        return "Bank of awesomeSauce";
    }

    @Override
    public void setAccount(IAccount account) {
        for (IAccount ac : accounts) {
            if(account.getNumber().equals(ac.getNumber())){
                ac = account;
            }
        }
    }

    

    

    

}