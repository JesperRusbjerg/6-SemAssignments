package dk.cphbusiness.facade;

import contract.BankContract;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.datalayer.DataLayerImpl;
import dk.cphbusiness.datalayer.IDataLayer;
import dto.AccountDTO;
import dto.BankDTO;
import dto.CustomerDTO;

import java.util.ArrayList;
import java.util.List;

public class BankFacade implements BankContract {

    IDataLayer data;

    public BankFacade(IDataLayer data) {
        this.data = data;
    }

    @Override
    public List<AccountDTO> getAccounts(BankDTO bankDTO) {

    IBank b = data.getBank(bankDTO.getName());

    List<IAccount> accs = data.getAccountsBank(b.getId());
    List<AccountDTO> dtoList = new ArrayList<>();
    for(IAccount a: accs){
        a.setBank(b);
        dtoList.add(new AccountDTO(a));
    }
    return dtoList;
    }

    @Override
    public List<CustomerDTO> getCustomers(BankDTO bankDTO) {

        IBank b = data.getBank(bankDTO.getName());

        List<ICustomer> customers = data.getCustomersFromBank(b.getId());
        List<CustomerDTO> dto = new ArrayList<>();
        for(ICustomer c: customers){
            dto.add(new CustomerDTO(c));
        }
     return dto;
    }

    @Override
    public AccountDTO getAccount(String s, BankDTO bankDTO) {
        IBank b = data.getBank(bankDTO.getName());

        IAccount a = data.getAccountFromBank(s, b.getId());
        a.setBank(b);

        AccountDTO dto = new AccountDTO(a);

        return dto;

    }



    public static void main(String[] args) {
        DataLayerImpl data = new DataLayerImpl();
        BankFacade f = new BankFacade(data);
        BankDTO dto = new BankDTO();
        dto.setName("Danske bank");

     AccountDTO a = f.getAccount("33", dto);


    }
}
