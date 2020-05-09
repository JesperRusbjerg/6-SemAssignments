package dk.cphbusiness.datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    static Connection con=null;
    public static boolean REAL_DB = true;
    public DBConnect()  {
    }

    public static Connection getConnection() {

        System.out.println("Connecting database...");
        Connection conn = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank","root","toonage15");

        } catch (SQLException | ClassNotFoundException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
        }
        return conn;
    }

    public static Connection getTestConnection() {

        System.out.println("Connecting Test database...");
        Connection conn = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/banktest","root","toonage15");

        } catch (SQLException | ClassNotFoundException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
        }
        return conn;
    }

    public Connection getCon() {
        if (con != null) return con;
        if(REAL_DB) getConnection();
        return getTestConnection();

        // get db, user, pass from settings file
    }

    public static void main(String[] args){



        DBConnect d = new DBConnect();



        d.getCon();

    }




}


