package dk.cphbusiness.datalayer;

import dk.cphbusiness.Utils;
import dk.cphbusiness.banking.Account;
import dk.cphbusiness.banking.Bank;
import dk.cphbusiness.banking.Customer;
import dk.cphbusiness.banking.Movement;
import dk.cphbusiness.bankingInterfaces.IAccount;
import dk.cphbusiness.bankingInterfaces.IBank;
import dk.cphbusiness.bankingInterfaces.ICustomer;
import dk.cphbusiness.bankingInterfaces.IMovement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataLayerImpl implements IDataLayer{

    Connection con;


    public DataLayerImpl() {

        DBConnect dbc = new DBConnect();

        if(DBConnect.REAL_DB){
        con = dbc.getCon();
        }else{
            con = dbc.getTestConnection();
        }

    }

    @Override
    public List<IAccount> getAccounts() {
        try {
            Statement state = con.createStatement();
            String sql = "select * from account";
            ResultSet rs = state.executeQuery(sql);

            List<IAccount> accs = new ArrayList<>();
            while(rs.next()){
                Account a = new Account();
                int bankId = rs.getInt("bank");

                IBank b = getBank(bankId);

                a.setBank(b);
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
            //Uses number to edit, as this value is unique
            Statement state = con.createStatement();
            String sql = "UPDATE account set balance ='"+a.getBalance()+"', number ='"+a.getNumber()+"' where number ="+a.getNumber();
            state.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IAccount getAccountAndHistroyOnNumber(String number) {
        try {
            Statement state = con.createStatement();
            String sql = "select * from account where number =" + number;
            ResultSet rs = state.executeQuery(sql);

            if(rs.next()){
                Account a = new Account();

                int bankId = rs.getInt("bank");
                IBank b = getBank(bankId);
                int accId = rs.getInt("id");

                List<IMovement> movements = movementsFromAccount(accId, number);

                a.setMovementHistory(movements);



                a.setBank(b);
                a.setId(accId);
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
    public List<IMovement> movementsFromAccount(int id, String accNumber) {

        try {
            Statement state = con.createStatement();
            String sql = "select * from movement where source =" + id + " or dest = " + id;
            ResultSet rs = state.executeQuery(sql);

            List<IMovement> movements = new ArrayList<>();
            while(rs.next()){

                String sourceNumber = accNumber;
                String destNumber;

                //If our account wasnt the one who made the transfer, but recived it
                int source = rs.getInt("source");
                int dest = rs.getInt("dest");
                long amount = rs.getLong("amount");
                long date = rs.getLong("date");


                if(source != id){
                    IAccount sourceAcc = getAccount(source);
                    sourceNumber = sourceAcc.getNumber();
                    destNumber = accNumber;
                }else{
                    IAccount destAcc = getAccount(dest);
                    destNumber = destAcc.getNumber();
                }
                movements.add(new Movement(sourceNumber, destNumber, amount, date));
            }
            return movements;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public IBank getBank(int id){
        try {
            Statement state = con.createStatement();
            String sql = "select * from bank where id =" + id;
            ResultSet rs = state.executeQuery(sql);

            if(rs.next()){

                int idx = rs.getInt("id");
                String bankName = rs.getString("name");
                Bank b = new Bank(idx, bankName);

                return b;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IAccount editBalance(long amount, String accNumber) {
        try {
            //Uses number to edit, as this value is unique
            Statement state = con.createStatement();
            String sql = "UPDATE account set balance ='"+amount+"' where number ="+accNumber;
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
    public List<ICustomer> getCustomersFromBank(int id) {
        try {
            Statement state = con.createStatement();
            String sql = "select * from customer where bank= "+id ;
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
    public IBank getBank(String name) {
        try {
            Statement state = con.createStatement();
            String sql = "select * from bank where name = '"+name+"'";
            ResultSet rs = state.executeQuery(sql);

            if(rs.next()){
                int id = rs.getInt("id");
                String bankName = rs.getString("name");
                Bank b = new Bank(id, bankName);

                return b;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public IAccount getAccountFromBank(String accNumber, int bankid) {
        try {
            Statement state = con.createStatement();
            String sql = "select * from account where bank = "+bankid+" and number = '"+accNumber+"';";
            ResultSet rs = state.executeQuery(sql);

            IAccount acc = null;
            while(rs.next()){
                Account a = new Account();
                a.setBalance(rs.getLong("balance"));
                a.setNumber(rs.getString("number"));
                acc = a;
            }
            return acc;

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

    @Override
    public List<IAccount> transaction(IAccount from, IAccount to, long amount, long date) throws SQLException {

            try
            {
                con.setAutoCommit(false);

                Statement state = con.createStatement();

                String sql = "UPDATE account set balance ='"+(from.getBalance())+"' where number ='"+from.getNumber()+"'";
                state.executeUpdate(sql);

                sql = "UPDATE account set balance ='"+(to.getBalance())+"' where number ='"+to.getNumber()+"'";
                state.executeUpdate(sql);

                sql = "INSERT INTO movement (source, dest, amount, date) VALUES ("+from.getId()+","+to.getId()+","+amount+","+date+");";
                state.executeUpdate(sql);

                con.commit();
                con.setAutoCommit(true);

                Movement m = new Movement(from.getNumber(), to.getNumber(), amount, date);
                from.addToMovementHistory(m);
                to.addToMovementHistory(m);
                List<IAccount> res = new ArrayList<>();
                res.add(from);
                res.add(to);
                    return res;
            }
            catch(Exception e)
            {
                con.rollback();
            }

return null;
        }



    public Connection getCon() {
        return con;
    }


}
