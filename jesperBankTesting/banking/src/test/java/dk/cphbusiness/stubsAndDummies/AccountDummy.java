package dk.cphbusiness.stubsAndDummies;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;

public class AccountDummy implements IAccount {

    private String number; 
    public AccountDummy(String number){
        this.number = number;
    }

    @Override
    public IBank getBank() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ICustomer getCustomer() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public long getBalance() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void transfer(long amount, IAccount target) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBank(IBank bank) {

    }

    @Override
    public void setCustomer(ICustomer customer) {

    }

    @Override
    public void setBalance(long balance) {

    }

    @Override
    public void setNumber(String number) {

    }

    @Override
    public void setId(int id) {

    }

    @Override
    public int getId() {
        return 0;
    }


}