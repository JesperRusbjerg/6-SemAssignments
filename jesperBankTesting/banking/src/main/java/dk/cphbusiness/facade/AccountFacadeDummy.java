package dk.cphbusiness.facade;

import contract.AccountContract;
import dto.AccountDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountFacadeDummy implements AccountContract{

    //Simulate a DB with accs
    public static List<AccountStub> accs = new ArrayList<>();

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<AccountDTO> res = new ArrayList<>();
        AccountStub a = new AccountStub();
        res.add(new AccountDTO(a));
        res.add(new AccountDTO(a));
        res.add(new AccountDTO(a));
        return res;
    }

    @Override
    public AccountDTO getAccount(String s) {
        AccountStub a = new AccountStub();
        accs.add(a);
        accs.add(a);
        accs.add(a);
        for (AccountStub acc : accs) {
            if (acc.getNumber().equals(s)) {
                return new AccountDTO(acc);
            }
        }
        return null;
    }

    @Override
    public AccountDTO editAccount(AccountDTO accountDTO) {
        //Simulate that it has been edited in the DB
         //- Find the account based on number, update fields
        return accountDTO;
    }

    @Override
    public AccountDTO editBalance(long l, String s) {
        AccountStub a = new AccountStub();
        accs.add(a);
        accs.add(a);
        accs.add(a);
        for (AccountStub acc : accs) {
            if (acc.getNumber().equals(s)) {
                acc.balance = l;
                return new AccountDTO(acc);
            }
        }
        return null;
    }
}

