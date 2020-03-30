package dto;

import dk.cphbusiness.bankingInterfaces.ICustomer;

public class CustomerDTO {

    private String name;
    private String number;

    public CustomerDTO(ICustomer customer) {
        this.name = customer.getName();
        this.number = customer.getNumber();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
