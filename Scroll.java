
//to fetch data of only selected or specified student
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Scroll {

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
	                String sql = "Select * from student ";
	                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	                System.out.println("Enter sid : ");
	                Scanner sc=new Scanner(System.in);
	                	                
	                ResultSet res = stmt.executeQuery(sql);
	                res.afterLast();
	                while(res.previous()==true) {
	                	System.out.println(res.getInt("sid"));
	                	System.out.println(res.getString("sname"));
	                	System.out.println(res.getString("school"));
	                	System.out.println(res.getString("class"));
	                	System.out.println(res.getLong("phone"));
	                	System.out.println("==============");
	                }
	                }
	            

	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println("Exception Generated and handled");
	        }


	}

}