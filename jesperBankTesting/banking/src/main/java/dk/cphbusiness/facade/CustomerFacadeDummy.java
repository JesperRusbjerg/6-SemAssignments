package dk.cphbusiness.facade;

import dk.cphbusiness.banking.Customer;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import contract.CustomerContract;
import dto.CustomerDTO;

public class CustomerFacadeDummy implements CustomerContract {
    @Override
    public CustomerDTO getCusomter(String s) {
        ICustomer c = new Customer("Xx21123dx", "per");
        return new CustomerDTO(c);
    }
}

