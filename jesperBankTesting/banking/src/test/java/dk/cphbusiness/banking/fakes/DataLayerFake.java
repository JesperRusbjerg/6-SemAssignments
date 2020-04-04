package dk.cphbusiness.banking.fakes;

import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.datalayer.IDataLayer;

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
    public List<IAccount> getAccountsBank(int accId) {
        return null;
    }

    @Override
    public List<ICustomer> getCustomers(String number) {
        return null;
    }

    @Override
    public IBank editBank(IBank b, String name) {
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
}
