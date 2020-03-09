package dk.cphbusiness.bankingInterfaces;

import dk.cphbusiness.banking.Account;

public interface IAccount {
    
    int balance = 0;

    public IBank getBank();
    
    public ICustomer getCustomer();

    public String getNumber();
    
    public long getBalance();
    
    public void transfer(long amount, IAccount target);
    
    public void transfer(long amount, String targetNumber);
}