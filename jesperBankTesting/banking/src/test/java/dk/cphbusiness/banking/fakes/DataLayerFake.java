package dk.cphbusiness.banking.fakes;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.datalayer.IDataLayer;

import java.sql.SQLException;
import java.util.List;

// This class would be used in any scenario where you would need a fake data layer
// E.G if you had to call your data layer in your facade class, you would use this implementation
// So you faked having a connection to a real DB :)

public class DataLayerFake implements IDataLayer {

    @Override
    public List<IAccount> getAccounts() {
        return null;
    }

    @Override
    public IAccount getAccount(int id) {
        return null;
    }

    @Override
    public IAccount editAccount(IAccount a) {
        return null;
    }

    @Override
    public IAccount getAccountONNumber(String number) {
        return null;
    }

    @Override
    public IAccount editBalance(long amount, String accNumber) {
        return null;
    }

    @Override
    public List<IAccount> getAccountsBank(int bankId) {
        return null;
    }

    @Override
    public List<ICustomer> getCustomersFromBank(int bankId) {
        return null;
    }

    @Override
    public IBank getBank(String name) {
        return null;
    }

    @Override
    public IAccount getAccountFromBank(String accNumber, int bankid) {
        return null;
    }

    @Override
    public ICustomer fetchCustmer(String number) {
        return null;
    }

    @Override
    public ICustomer editCustomer(ICustomer c) {
        return null;
    }

    @Override
    public void transaction(IAccount a, IAccount b) throws SQLException {

    }
}
