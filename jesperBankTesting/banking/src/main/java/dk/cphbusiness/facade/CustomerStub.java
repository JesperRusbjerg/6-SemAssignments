package dk.cphbusiness.facade;

import dk.cphbusiness.bankingInterfaces.ICustomer;

public class CustomerStub implements ICustomer{
    @Override
    public String getNumber() {
        return "xxxx";
    }

    @Override
    public String getName() {
        return "peter";
    }
}
