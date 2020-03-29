package facade;

import dk.cphbusiness.banking.Customer;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.contract.CustomerContract;
import dk.cphbusiness.dto.CustomerDTO;

public class CustomerFacade implements CustomerContract {
    @Override
    public CustomerDTO getCusomter(String s) {
        ICustomer c = new Customer("Xx21123dx", "per");
        return new CustomerDTO(c);
    }
}

