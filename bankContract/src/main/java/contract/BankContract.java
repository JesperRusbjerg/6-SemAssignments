package contract;

import dto.AccountDTO;
import dto.CustomerDTO;

import java.util.List;

public interface BankContract {

    List<AccountDTO> getAccounts();

    List<CustomerDTO> getCustomers();

    AccountDTO getAccount(String number);

    void registerAccount(AccountDTO a);

    void registerCustomer(CustomerDTO c);

    void setAccount(AccountDTO a);

}


