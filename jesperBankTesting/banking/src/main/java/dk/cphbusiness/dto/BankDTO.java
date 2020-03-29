package dk.cphbusiness.dto;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;

import java.util.ArrayList;
import java.util.List;

public class BankDTO {

    private List<IAccount> accounts = new ArrayList();
    private List<ICustomer> customers = new ArrayList();

    public BankDTO(IBank bank) {
        for (IAccount a : bank.getAccounts()) {
            accounts.add(a);
        }
        for (ICustomer c: bank.getCustomers()) {
            customers.add(c);
        }
    }

    public List<IAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<IAccount> accounts) {
        this.accounts = accounts;
    }

    public List<ICustomer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<ICustomer> customers) {
        this.customers = customers;
    }
}
