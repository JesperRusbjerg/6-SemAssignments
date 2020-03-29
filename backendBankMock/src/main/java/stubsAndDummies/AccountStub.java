package stubsAndDummies;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;

public class AccountStub implements IAccount {

    IBank b = new BankStub();
    public long balance = 0;

    @Override
    public IBank getBank() {
        return b;
    }

    @Override
    public ICustomer getCustomer() {
        return new CustomerStub();
    }

    @Override
    public String getNumber() {
        return "xx";
    }

    @Override
    public long getBalance() {
        return balance;
    }

    @Override
    public void transfer(long l, IAccount iAccount) {

    }

    @Override
    public void transfer(long l, String s) {

    }
}
