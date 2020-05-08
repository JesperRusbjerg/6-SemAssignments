package dk.cphbusiness.facade;

import contract.BankContract;
import dk.cphbusiness.facade.AccountStub;
import dk.cphbusiness.facade.CustomerStub;
import dto.AccountDTO;
import dto.BankDTO;
import dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public class BankFacadeDummy implements BankContract {


    @Override
    public List<AccountDTO> getAccounts(BankDTO bankDTO) {
        List<AccountDTO> res = new ArrayList<>();
        AccountStub a = new AccountStub();
        res.add(new AccountDTO(a));
        res.add(new AccountDTO(a));
        res.add(new AccountDTO(a));
        return res;
    }

    @Override
    public List<CustomerDTO> getCustomers(BankDTO bankDTO) {
        List<CustomerDTO> customers = new ArrayList<>();
        CustomerStub c = new CustomerStub();
        customers.add(new CustomerDTO(c));
        customers.add(new CustomerDTO(c));
        customers.add(new CustomerDTO(c));
        return customers;
    }

    @Override
    public AccountDTO getAccount(String s, BankDTO bankDTO) {
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
    public void registerCustomer(CustomerDTO customerDTO, BankDTO bankDTO) {

    }


    @Override
    public void setAccount(AccountDTO accountDTO) {

    }
}
