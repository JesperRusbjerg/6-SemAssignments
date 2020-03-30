package dto;

import dk.cphbusiness.bankingInterfaces.IAccount;


public class AccountDTO {

    private BankDTO bank;
    private CustomerDTO customer;
    private String number;
    private long balance;

    public AccountDTO(IAccount a) {
        this.bank = new BankDTO(a.getBank());
        //this.customer = new CustomerDTO(a.getCustomer());
        this.number = a.getNumber();
        this.balance = a.getBalance();
    }

    public BankDTO getBank() {
        return bank;
    }

    public void setBank(BankDTO bank) {
        this.bank = bank;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

//    //public void setCustomer(CustomerDTO customer) {
//        this.customer = customer;
//    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
}
