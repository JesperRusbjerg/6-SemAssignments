package dk.cphbusiness.facade;

import dk.cphbusiness.banking.Account;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;

import java.util.ArrayList;
import java.util.List;

public class BankStub implements IBank {
    Account a = null;

    @Override
    public IAccount getAccount(String s) {
        return a;
    }

    @Override
    public void registerAccount(IAccount iAccount) {
    a = (Account) iAccount;
    }

    @Override
    public void setAccount(IAccount iAccount) {
        a = (Account) iAccount;
    }

    @Override
    public ICustomer getCustomer(String s) {
        return null;
    }

    @Override
    public void registerCustomer(ICustomer iCustomer) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<IAccount> getAccounts() {
        List<IAccount> res = new ArrayList<>();
        res.add(new AccountStub());
        return res;
    }

    @Override
    public List<ICustomer> getCustomers() {
        List<ICustomer> res = new ArrayList<>();
        res.add(new CustomerStub());
        return res;
    }
}
