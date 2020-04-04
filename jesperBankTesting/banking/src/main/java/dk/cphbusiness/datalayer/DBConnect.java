package dk.cphbusiness.datalayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    static Connection con=null;

    public DBConnect()  {

    }

    private static Connection getConnection()
    {
        String url = "jdbc:mysql://localhost:3306/bank";
        String username = "jezper";
        String password = "Toonage1555#";

        System.out.println("Connecting database...");

        try  {
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return con;
    }

    public Connection getCon() {
        if (con != null) return con;
        // get db, user, pass from settings file
        return getConnection();
    }

    public static void main(String[] args){
        DBConnect d = new DBConnect();

    }
}


