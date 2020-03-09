package dk.cphbusiness.stubsAndDummies;
import dk.cphbusiness.bankingInterfaces.ICustomer;

public class CustomerDummy implements ICustomer {

  @Override
  public String getNumber() {
    return "2222222";
  }

  @Override
  public String getName() {
    return "dummy customer";
  }
  }
