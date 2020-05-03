package dk.cphbusiness.bankingInterfaces;

public interface IAccount {

    public IBank getBank();
    
    public ICustomer getCustomer();

    public String getNumber();
    
    public long getBalance();
    
    public void transfer(long amount, IAccount target) throws Exception;

    public void setBank(IBank bank);
    public void setCustomer(ICustomer customer);
    public void setBalance(long balance);
    public void setNumber(String number);



}