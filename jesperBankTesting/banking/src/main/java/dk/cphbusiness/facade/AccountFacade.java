package dk.cphbusiness.facade;

import contract.AccountContract;
import dk.cphbusiness.Utils;
import dk.cphbusiness.banking.Account;
import dk.cphbusiness.banking.Bank;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.datalayer.DataLayerImpl;
import dk.cphbusiness.datalayer.IDataLayer;
import dto.AccountDTO;
import dto.BankDTO;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountFacade implements AccountContract{

    private IDataLayer data;

    public AccountFacade(IDataLayer data) {
    this.data = data;
    }

    @Override
    public List<AccountDTO> getAllAccounts() {

    List<IAccount> accounts = data.getAccounts();
    List<AccountDTO> accountDTOs = new ArrayList<>();

    for(IAccount a: accounts){
        accountDTOs.add(new AccountDTO(a));
    }

    return accountDTOs;
    }
    @Override
    public AccountDTO getAccount(String s) throws Exception{

    IAccount a = data.getAccountAndHistroyOnNumber(s);

        AccountDTO ac = new AccountDTO(a);


    return ac;
    }
    @Override
    public AccountDTO editAccount(AccountDTO accountDTO) throws Exception{

        IAccount acc = data.getAccountAndHistroyOnNumber(accountDTO.getNumber());
        acc.setBalance(accountDTO.getBalance());

        IAccount editedAccount = data.editAccount(acc);

        return new AccountDTO(editedAccount);
    }
    @Override
    public void editBalance(long l, String s) {

        data.editBalance(l, s);

    }

    @Override
    public List<AccountDTO> transaction(String accNum1, String accNum2, long amount) throws Exception{

    IAccount source = data.getAccountAndHistroyOnNumber(accNum1);
    IAccount dest = data.getAccountAndHistroyOnNumber(accNum2);

    source.transfer(amount, dest);

   List<IAccount> accs = data.transaction(source, dest, amount, Utils.getEpochTime());

   List<AccountDTO> accDtos = new ArrayList<>();
   for(IAccount a: accs){

        accDtos.add(new AccountDTO(a));
    }
   return accDtos;
    }


    public static void main(String[] args) throws Exception {
        AccountFacade f = new AccountFacade(new DataLayerImpl());

        List<AccountDTO> accs = f.transaction("332", "33", 4);

    }
}
