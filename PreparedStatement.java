package com.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; // Correct import

public class PreparedStatement {
    public static void main(String args[]) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/session", "root", "amazon");
            System.out.println("Connection Successful");
   
          
            
            
            java.sql.PreparedStatement pstmt=con.prepareStatement("insert into student values(?,?,?,?)");
           pstmt.setInt(1,201);
           pstmt.setString(2,"gayatri");
           pstmt.setString(3,"1999-08-14");
           pstmt.setString(4,"Bangalore");
           
           pstmt.setInt(1,202);
           pstmt.setString(2,"Tushar");
           pstmt.setString(3,"2002-06-21");
         pstmt.setString(4,"jarkhand");
           
            
            int a2=pstmt.executeUpdate();
            String sql = "Select * from student";
            ResultSet rs=pstmt.executeQuery(sql);
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


/* String sql = "SELECT * FROM employee";
try (java.sql.Statement stmt = con.createStatement();
     java.sql.ResultSet rs = stmt.executeQuery(sql)) {
    while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String department = rs.getString("department");
        String company = rs.getString("company");
        double salary = rs.getDouble("salary");
        String phoneNumber = rs.getString("phoneNumber");
        System.out.printf("ID: %d, Name: %s, Department: %s, Company: %s, Salary: %.2f, PhoneNumber: %s%n",
                          id, name, department, company, salary, phoneNumber);
    }
}*/
