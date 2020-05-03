package dk.cphbusiness.datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    static Connection con=null;
    public static boolean TEST_ENVIROMENT = false;
    public DBConnect()  {
    }

    public  void setConnnectionToTestDB(){
        TEST_ENVIROMENT = false;
    }
    public void setConnnectionToRealDB(){
        TEST_ENVIROMENT = true;
    }

    public static Connection getConnection() {

        System.out.println("Connecting database...");
        Connection conn = null;

        String connectToThisDB = "banktest";

        if(TEST_ENVIROMENT){
            connectToThisDB = "bank";

        }

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost/"+connectToThisDB+"?" +
                            "user=root&password=toonage15&serverTimezone=UTC");

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


