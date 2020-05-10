package dk.cphbusiness.banking.fakes;

import dk.cphbusiness.Utils;
import dk.cphbusiness.banking.Account;
import dk.cphbusiness.banking.Bank;
import dk.cphbusiness.banking.Customer;
import dk.cphbusiness.banking.Movement;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.bankingInterfaces.IMovement;
import dk.cphbusiness.datalayer.IDataLayer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DataLayerFake implements IDataLayer {

    List<IAccount> accs = new ArrayList<>();
    ICustomer customerToEditOrFetch;

    public DataLayerFake() {
        IBank b = new Bank(1, "Danske bank");
        customerToEditOrFetch = new Customer("xxxNum", "Peter Martinsen");

        ICustomer c = new Customer("xxxNum", "Peter Martinsen");
        ICustomer c1 = new Customer("xxxNum2", "Bjarne Martinsen");

        IAccount a = new Account(b, c, "xxxAccNum", 1);
        a.setBalance(350);
        IAccount a1 = new Account(b, c1, "xxxAccNumXxx",2 );
        a1.setBalance(700);

        accs.add(a);
        accs.add(a1);

    }

    @Override
    public List<IAccount> getAccounts() {
       return accs;
    }

    @Override
    public IAccount getAccount(int id) {
       for(IAccount a: accs){
           if(a.getId() == id){
               return a;
           }
       }
       return null;
    }

    @Override
    public IAccount editAccount(IAccount a) {
        for(IAccount acc: accs){
            if(a.getNumber().equals(acc.getNumber())){
                acc = a;
                return acc;
            }
        }
        return null;
    }

    @Override
    public IAccount getAccountAndHistroyOnNumber(String number) {
        for(IAccount acc: accs){
            if(acc.getNumber().equals(number)){
                return acc;
            }
        }
        return null;
    }

    @Override
    public IAccount editBalance(long amount, String accNumber) {
        for(IAccount acc: accs){
            if(acc.getNumber().equals(accNumber)){
                acc.setBalance(amount);
                return acc;
            }
        }
        return null;
    }

    @Override
    public List<IAccount> getAccountsBank(int bankId) {
        List<IAccount> res = new ArrayList();

        for(IAccount acc: accs){
            if(acc.getBank().getId() == bankId){
                res.add(acc);
            }
        }
        return res;
    }

    @Override
    public List<ICustomer> getCustomersFromBank(int bankId) {
       List<ICustomer> res = new ArrayList<>();
       res.add(new Customer("xxxNum", "Peter Martinsen"));
       res.add(new Customer("xxxNum2", "Bjørn Martinsen"));

        return res;
    }

    @Override
    public IBank getBank(String name) {
        return new Bank(1, "Danske bank");
    }

    @Override
    public IAccount getAccountFromBank(String accNumber, int bankid) {
        for(IAccount acc: accs){
            if(acc.getNumber().equals(accNumber) && acc.getBank().getId() == bankid){
                return acc;
            }
        }
        return null;
    }

    @Override
    public ICustomer fetchCustmer(String number) {
    return customerToEditOrFetch;
    }

    @Override
    public ICustomer editCustomer(ICustomer c) {
        customerToEditOrFetch = c;
        return customerToEditOrFetch;
    }

    @Override
    public List<IAccount> transaction(IAccount a, IAccount b, long amount, long date) throws SQLException {

        List<IAccount> accounts = new ArrayList<>();

        for(IAccount acc: accs){
            if(a.getNumber().equals(acc.getNumber())){
                //Would normally persist to DB here too, but no need when its saved locally only
                acc.addToMovementHistory(new Movement(a.getNumber(), b.getNumber(), amount, date));
                accounts.add(acc);
            }

            if(b.getNumber().equals(acc.getNumber())){
                //Would normally persist to DB here too, but no need when its saved locally only
                acc.addToMovementHistory(new Movement(a.getNumber(), b.getNumber(), amount, date));
                accounts.add(acc);
            }
        }
        return accs;
    }

    @Override
    public List<IMovement> movementsFromAccount(int id, String Number) {
        for(IAccount acc: accs){
            if(acc.getNumber() == Number){
                return acc.movementHistory();
            }
        }
        return null;
    }


}
