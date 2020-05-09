package dk.cphbusiness.bankingInterfaces;

import java.util.List;

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

    public void setId(int id);
    public int getId();

    public List<IMovement> movementHistory();

    public void setMovementHistory(List<IMovement> movements);

    public void addToMovementHistory(IMovement movement);



}