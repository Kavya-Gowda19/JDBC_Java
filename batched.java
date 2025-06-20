package com.pack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; // Correct import

public class batched {
    public static void main(String args[]) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/session", "root", "amazon");
            System.out.println("Connection Successful");
   
          
            // Create the statement
            Statement stmt = con.createStatement();
            String insertquery ="insert into student values(301,'manju','1990-07-15','mangalore')" ;
            stmt.addBatch(insertquery);
            
            String updatequery ="update student set name= 'danu' where id=301" ;
            stmt.addBatch(updatequery);
            
            
            int[] arr=stmt.executeBatch();
            	System.out.println("the number of rows affected "+ arr.length);
            
            
            String sql = "Select * from student";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()) {
            	System.out.println(rs.getInt(1));
            	System.out.println(rs.getString(2));
            	System.out.println(rs.getDate(3));
            	System.out.println(rs.getString(4));
            }
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
