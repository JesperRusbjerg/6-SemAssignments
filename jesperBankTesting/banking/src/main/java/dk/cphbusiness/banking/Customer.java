package dk.cphbusiness.banking;

import dk.cphbusiness.bankingInterfaces.ICustomer;

public class Customer implements ICustomer{

    private String number;
    private String name;

    public Customer(String number, String name){
        this.number = number;
        this.name = name;
    }

    public Customer() {

    }

    @Override
    public String getNumber() {
        return number;
    }
    @Override
    public String getName() {
        return name;
    }


    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }
}