package dk.cphbusiness.miscellaneous;

import dk.cphbusiness.bankingInterfaces.ICustomer;

public class BaseCustomer implements ICustomer {
  private String number;
  private String name;

  public BaseCustomer(String number, String name) {

    this.number = number;
    this.name = name;
  }

  @Override
  public String getNumber() {
    return number;
  }

  @Override
  public String getName() {
    return name;
  }
}
