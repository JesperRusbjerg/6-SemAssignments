package contract;

import dto.AccountDTO;

import java.util.List;


public interface AccountContract {

    List<AccountDTO> getAllAccounts();

    AccountDTO getAccount(String number);

    AccountDTO editAccount(AccountDTO a);

    AccountDTO editBalance(long balance, String AccountNumber);


}
