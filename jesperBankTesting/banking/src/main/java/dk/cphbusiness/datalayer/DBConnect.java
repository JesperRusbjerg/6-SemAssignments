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

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+connectToThisDB+"","root","toonage15");

        } catch (SQLException | ClassNotFoundException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
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


