package dk.cphbusiness.contract;

import dk.cphbusiness.dto.CustomerDTO;

public interface CustomerContract {

    CustomerDTO getCusomter(String number);

    public static void main(String[] args) {

        System.out.println("hej");
    }
}
