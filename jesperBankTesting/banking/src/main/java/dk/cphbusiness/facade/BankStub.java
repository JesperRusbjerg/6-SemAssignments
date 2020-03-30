package dk.cphbusiness.facade;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;

import java.util.ArrayList;
import java.util.List;

public class BankStub implements IBank {

    @Override
    public IAccount getAccount(String s) {
        return null;
    }

    @Override
    public void registerAccount(IAccount iAccount) {

    }

    @Override
    public void setAccount(IAccount iAccount) {

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
