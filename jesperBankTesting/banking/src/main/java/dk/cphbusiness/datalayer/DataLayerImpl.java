package dk.cphbusiness.datalayer;

import dk.cphbusiness.banking.Account;
import dk.cphbusiness.banking.Customer;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataLayerImpl implements IDataLayer{

    DBConnect dbc = new DBConnect();
    Connection con = dbc.getCon();




    @Override
    public List<IAccount> getAccounts() {
        try {
            Statement state = con.createStatement();
            String sql = "select * from account";
            ResultSet rs = state.executeQuery(sql);

            List<IAccount> accs = new ArrayList<>();
            while(rs.next()){
                Account a = new Account();
                a.setBalance(rs.getLong("balance"));
                a.setNumber(rs.getString("number"));
                accs.add(a);
            }
            return accs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return null;
    }

    @Override
    public IAccount getAccount(int id) {
        try {
            Statement state = con.createStatement();
            String sql = "select * from account where id =" + id;
            ResultSet rs = state.executeQuery(sql);

            if(rs.next()){
                Account a = new Account();
                a.setBalance(rs.getLong("balance"));
                a.setNumber(rs.getString("number"));
                return a;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IAccount editAccount(IAccount a) {
        try {
            Statement state = con.createStatement();
            String sql = "UPDATE account set balance ='"+a.getBalance()+"', number ='"+a.getNumber()+"' where "+a.getBalance()+"="+a.getBalance();
            state.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<IAccount> getAccountsBank(int bankId) {
        try {
            Statement state = con.createStatement();
            String sql = "select * from account where bank ="+bankId;
            ResultSet rs = state.executeQuery(sql);

            List<IAccount> accs = new ArrayList<>();
            while(rs.next()){
                Account a = new Account();
                a.setBalance(rs.getLong("balance"));
                a.setNumber(rs.getString("number"));
                accs.add(a);
            }
            return accs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ICustomer> getCustomers(String number) {
        try {
            Statement state = con.createStatement();
            String sql = "select * from customer where number='"+number+"'";
            ResultSet rs = state.executeQuery(sql);

            List<ICustomer> customers = new ArrayList<>();
            while(rs.next()){
                Customer c = new Customer();
                c.setName(rs.getString("name"));
                c.setNumber(rs.getString("number"));
                customers.add(c);
            }
            return customers;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IBank editBank(IBank b, String name) {
        try {
            Statement state = con.createStatement();
            String sql = "UPDATE bank set name ='"+b.getName()+"' where name ='"+name+"'";
            state.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ICustomer fetchCustmer(String number) {
        try {
            Statement state = con.createStatement();
            String sql = "select * from customer where number ='" + number+"'";
            ResultSet rs = state.executeQuery(sql);

            if(rs.next()){
                Customer c = new Customer();
                c.setName(rs.getString("name"));
                c.setNumber(rs.getString("number"));
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ICustomer editCustomer(ICustomer c) {
        try {
            Statement state = con.createStatement();
            String sql = "UPDATE customer set name ='"+c.getName()+"' where number ='"+c.getNumber()+"'";
            state.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
