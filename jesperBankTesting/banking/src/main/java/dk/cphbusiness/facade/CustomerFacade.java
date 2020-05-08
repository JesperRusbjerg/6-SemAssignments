package dk.cphbusiness.facade;

import contract.CustomerContract;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.datalayer.IDataLayer;
import dto.CustomerDTO;

public class CustomerFacade implements CustomerContract {

    IDataLayer data;

    public CustomerFacade(IDataLayer data) {
        this.data = data;
    }

    @Override
    public CustomerDTO getCusomter(String s) {
        ICustomer c = data.fetchCustmer(s);

        return new CustomerDTO(c);
    }
}
