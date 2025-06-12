
//to insert data in the table
import java.sql.*;
import java.util.*;

public class Program3 {
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
                Scanner sc = new Scanner(System.in);

                System.out.println("Enter sid : ");
                int sid = sc.nextInt();
                
                System.out.println("Enter sname : ");
                String sname = sc.next();

                System.out.println("Enter school : ");
                String school = sc.next();

                System.out.println("Enter class : ");
                String clas = sc.next();

                System.out.println("Enter phone : ");
                long phn = sc.nextLong();

                // Step 3: Create SQL query
                String query = "insert into student values (?,?,?,?,?)"; // ? --> placeholder

                // Step 4: Create the PreparedStatement as we have placeholders
                PreparedStatement pstmt = con.prepareStatement(query); 
                // PreparedStatement now has the incomplete SQL query

                pstmt.setInt(1, sid);
                pstmt.setString(2, sname);
                pstmt.setString(3, school);
                pstmt.setString(4, clas);
                pstmt.setLong(5, phn);

                // Now PreparedStatement has the complete query

                // Step 5: Execute the statement and collect results
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
