package dk.cphbusiness.bankingInterfaces;

public interface IAccount {

    public IBank getBank();
    
    public ICustomer getCustomer();

    public String getNumber();
    
    public long getBalance();
    
    public void transfer(long amount, IAccount target);
    
    public void transfer(long amount, String targetNumber);
}