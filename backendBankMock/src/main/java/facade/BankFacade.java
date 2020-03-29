package facade;

import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.contract.BankContract;
import dk.cphbusiness.dto.AccountDTO;
import dk.cphbusiness.dto.CustomerDTO;
import stubsAndDummies.AccountStub;
import stubsAndDummies.CustomerStub;

import java.util.ArrayList;
import java.util.List;

public class BankFacade implements BankContract {
    @Override
    public List<AccountDTO> getAccounts() {
        List<AccountDTO> res = new ArrayList<>();
        AccountStub a = new AccountStub();
        res.add(new AccountDTO(a));
        res.add(new AccountDTO(a));
        res.add(new AccountDTO(a));
        return res;
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        List<CustomerDTO> customers = new ArrayList<>();
        CustomerStub c = new CustomerStub();
        customers.add(new CustomerDTO(c));
        customers.add(new CustomerDTO(c));
        customers.add(new CustomerDTO(c));
        return customers;
    }

    @Override
    public AccountDTO getAccount(String s) {
        AccountStub a = new AccountStub();
        return new AccountDTO(a);
    }

    @Override
    public void registerAccount(AccountDTO accountDTO) {
        //Simulates a save to a DB
        List<AccountDTO> res = new ArrayList<>();
        res.add(accountDTO);
    }

    @Override
    public void registerCustomer(CustomerDTO customerDTO) {
        //Simulates a save to a DB
        List<CustomerDTO> res = new ArrayList<>();
        res.add(customerDTO);
    }

    @Override
    public void setAccount(AccountDTO accountDTO) {

    }
}
