package dk.cphbusiness.banking.datalayerTest;

import dk.cphbusiness.datalayer.DBConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBSetup {

    public DBSetup() {
    }

    public void tearDownAndRebuildEverything() {

        resetAccountTable();
        resetBanksTable();
        resetCustomerTable();

    }

    public void resetBanksTable() {

        DBConnect dbc = new DBConnect();
        Connection con = dbc.getCon();
        try {
            Statement state = con.createStatement();

            List<String> commands = new ArrayList();
            commands.add("SET FOREIGN_KEY_CHECKS = 0;");
            commands.add("DROP TABLE IF EXISTS bank;");
            commands.add("CREATE TABLE bank (" +
                    "    id        INT PRIMARY KEY AUTO_INCREMENT," +
                    "    name varchar(255)" +
                    "  );");
            //Inserts into bank
            commands.add("insert into bank (name) values (\"Danske bank\");");
            commands.add("insert into bank (name) values (\"AL\");");
            commands.add(" SET FOREIGN_KEY_CHECKS = 1;");


            for (String s : commands) {
                state.execute(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void resetAccountTable() {

        DBConnect dbc = new DBConnect();
        Connection con = dbc.getCon();
        try {
            Statement state = con.createStatement();

            List<String> commands = new ArrayList();
            commands.add("SET FOREIGN_KEY_CHECKS = 0;");

            commands.add("drop table if exists account;");

            commands.add("CREATE TABLE account (\n" +
                    "    id        INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    bank int,\n" +
                    "    customer int,\n" +
                    "    number varchar(255),\n" +
                    "    balance bigint,\n" +
                    "    \n" +
                    "    FOREIGN KEY (customer) REFERENCES customer(id),\n" +
                    "    FOREIGN KEY (bank) REFERENCES bank(id)\n" +
                    "   \n" +
                    "  );\n");

            //Inserts into account
            commands.add("insert into account (bank, customer, `number` , balance ) values (1, 1, \"333\", \"22222\");");
            commands.add("insert into account (bank, customer, `number` , balance ) values (2, 2, \"333\", \"2222\");");



            commands.add(" SET FOREIGN_KEY_CHECKS = 1;");


            for (String s : commands) {
                state.execute(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void resetCustomerTable() {

        DBConnect dbc = new DBConnect();
        Connection con = dbc.getCon();
        try {
            Statement state = con.createStatement();
            List<String> commands = new ArrayList();
            commands.add("SET FOREIGN_KEY_CHECKS = 0;");
            commands.add("drop table if exists customer;");

            commands.add(" CREATE TABLE customer (\n" +
                    "    id        INT PRIMARY KEY AUTO_INCREMENT,\n" +
                    "    number varchar(255),\n" +
                    "    name varchar(255),\n" +
                    "    account int,\n" +
                    "    bank int,\n" +
                    "    FOREIGN KEY (bank) REFERENCES bank(id),\n" +
                    "    FOREIGN KEY (account) REFERENCES account(id)\n" +
                    "   \n" +
                    "  );\n");
            //Inserts into customer
            commands.add("insert into customer(account, bank, name , `number` ) values(1, 1, \"Peter jensen\", \"3dax\");");
            commands.add("insert into customer(account, bank, name , `number` ) values(2, 2, \"Mogens jensen\", \"3xxxxdax\");");

            commands.add(" SET FOREIGN_KEY_CHECKS = 1;");

            for (String s : commands) {
                state.execute(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}