//update=coloumn value or to update the data in table using prepared statement
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program6 {

	public static void main(String[] args) {
		 try {
	            // Step 1: Load the driver
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Driver is loaded");

	            // Step 2: Establish Connection
	            String url = "jdbc:mysql://localhost:3306/May_Dest_Jdbc";
	            String user = "root";
	            String pwd = "amazon";
	            Connection con = DriverManager.getConnection(url, user, pwd);
	            
	            if (con == null) {
	                System.out.println("Connection is not established");
	            } else {
	                System.out.println("Connection is established");
	                String sql = "update student set sname = ? where sid= ?";
	                PreparedStatement pstmt = con.prepareStatement(sql);
	                Scanner sc=new Scanner(System.in);
	                
	                System.out.println("Enter new name : ");
	                pstmt.setString(1,sc.next());
	                
	                System.out.println("Enter the sid : ");	                
	                pstmt.setInt(2,sc.nextInt());
	                
	                
	                int x = pstmt.executeUpdate(); // no parameter needed as query is already prepared
	                if (x > 0) {
	                    System.out.println("Data added");
	                } else {
	                    System.out.println("Data is not added");
	                }
	            }

	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println("Exception Generated and handled");
	        }
	    }
	}