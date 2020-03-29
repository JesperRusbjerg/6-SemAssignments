package dk.cphbusiness.contract;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.dto.AccountDTO;

import java.util.List;

public interface AccountContract {

    List<AccountDTO> getAllAccounts();

    AccountDTO getAccount(String number);

    AccountDTO editAccount(AccountDTO a);

    AccountDTO editBalance(long balance, String AccountNumber);


}
