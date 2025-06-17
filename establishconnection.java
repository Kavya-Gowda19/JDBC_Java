package com.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement; // Correct import

public class establishconnection {
    public static void main(String args[]) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/session", "root", "amazon");
            System.out.println("Connection Successful");
   
          
            // Create the statement
            Statement stmt = con.createStatement();
           
            //String sql="create database session";
            //String sql="create table Student(id int , name varchar(10),dob date)";
            //String sql = "alter table student add address varchar(10)"; 
            //String sql="alter table student modify name varchar(20) ";
            //String sql = "INSERT INTO student (id, name, dob, address) VALUES " +
            //             "(102, 'anu', '2002-02-12', 'mysore'), " +
            //             "(103, 'bhavya', '2003-07-16', 'bangalore')";
            String sql = "UPDATE student SET address='Mangalore' WHERE id=103";

            
           //boolean a = stmt.execute(sql); it is true and false
            int a=stmt.executeUpdate(sql); 
            System.out.println("Numberof rows get affected "+a);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
