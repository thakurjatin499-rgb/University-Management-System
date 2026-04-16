package UMS;

import java.sql.*;
public class Conn{
    Connection con;
    Statement st;
    Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql:///universitymanagement","root","2024@bethebest");
            if (con != null) {
                System.out.println("Connection established successfully!");
            } else {
                System.out.println("Failed to establish connection!");
            }
            st = con.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Conn();
    }

}
