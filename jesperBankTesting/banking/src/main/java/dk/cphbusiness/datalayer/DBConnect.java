package dk.cphbusiness.datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    static Connection con=null;

    public DBConnect()  {

    }

    private static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "jezper";
        String password = "Toonage1555#";

        System.out.println("Connecting database...");
        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/bank?" +
                            "user=jezper&password=Toonage1555#");

            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return conn;
    }

    public Connection getCon() {
        if (con != null) return con;
        // get db, user, pass from settings file
        return getConnection();
    }

    public static void main(String[] args){
        System.out.println("ho");
        DBConnect d = new DBConnect();
        d.getCon();

    }
}


