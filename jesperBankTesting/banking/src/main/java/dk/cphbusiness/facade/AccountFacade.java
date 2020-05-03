package dk.cphbusiness.facade;

import contract.AccountContract;
import dk.cphbusiness.banking.Account;
import dk.cphbusiness.banking.Bank;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.datalayer.IDataLayer;
import dto.AccountDTO;
import dto.BankDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountFacade  {

    private IDataLayer data;

    public AccountFacade(IDataLayer data) {
    this.data = data;
    }


    public List<AccountDTO> getAllAccounts() {

    List<IAccount> accounts = data.getAccounts();
    List<AccountDTO> accountDTOs = new ArrayList<>();

    for(IAccount a: accounts){
        accountDTOs.add(new AccountDTO(a));
    }

    return accountDTOs;
    }

    public AccountDTO getAccount(String s) {

    IAccount a = data.getAccountONNumber(s);


        AccountDTO ac = new AccountDTO(a);


    return ac;
    }

    public AccountDTO editAccount(AccountDTO accountDTO) {

        IAccount acc = data.getAccountONNumber(accountDTO.getNumber());
        acc.setBalance(accountDTO.getBalance());
        acc.setNumber(accountDTO.getNumber());

        IAccount editedAccount = data.editAccount(acc);

        return new AccountDTO(editedAccount);
    }

    public AccountDTO editBalance(long l, String s) {

        IAccount a = data.editBalance(l, s);

        return new AccountDTO(a);

    }
}
