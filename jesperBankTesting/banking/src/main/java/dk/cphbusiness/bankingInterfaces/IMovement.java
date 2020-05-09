package dk.cphbusiness.bankingInterfaces;

public interface IMovement {

    public String sourceAcc();
    public String destinationAcc();

    public String timestamp();
    public long amount();

}
