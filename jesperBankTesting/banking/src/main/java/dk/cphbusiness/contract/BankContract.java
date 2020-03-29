package dk.cphbusiness.contract;

import dk.cphbusiness.dto.AccountDTO;
import dk.cphbusiness.dto.CustomerDTO;

import java.util.List;

public interface BankContract {

    List<AccountDTO> getAccounts();

    List<CustomerDTO> getCustomers();

    AccountDTO getAccount(String number);

    void registerAccount(AccountDTO a);

    void registerCustomer(CustomerDTO c);

    void setAccount(AccountDTO a);

}


