package soen387.a2;

import java.sql.*;
import java.sql.DriverManager;



public class DB_Connection {

    static final String DB_URL = "jdbc:mysql://localhost:3306/Assignment1";
    // Database credentials
    static final String USER = "root";
    static final String PASS = "ray.macbook";

    private static Connection conn= null;
    private static Statement stmt = null;



    public static Connection connectDB() {
        //Connection conn = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            if (conn != null) {
                System.out.println("connected to database successfully");

            }
        } catch (SQLException err) {
            err.printStackTrace();
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }
        return conn;

    }


    public static void disconnectDB() {

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public static void main(String[] args){
       // connectDB();

    }
}
