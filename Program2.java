import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// WAP to create a database using JDBC programming
public class Program2 {
    public static void main(String[] args) {
        try {
            // Step1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is loaded");

            // Step2: Establish Connection
            String url = "jdbc:mysql://localhost:3306/May_Dest_Jdbc";
            String user = "root";
            String pwd = "amazon";
            Connection con = DriverManager.getConnection(url, user, pwd);
            if (con == null) {
                System.out.println("Connection is not established");
            } else {
                System.out.println("Connection is established");
            }

            // Step3: Create SQL query
            String query = "Create database Sample_may_dbb";

            // Step4: Create statement
            Statement stmt = con.createStatement();
            // statement is the root interface for Callable and Prepared Statements

            // Step5: Execute the statement and collect results
            int x = stmt.executeUpdate(query);

            // Whenever we make use of DDL or DML statements we must use executeUpdate function call
            // executeUpdate() will return the count of all the rows that is modified
            // Whenever we make use of DQL statements we must use executeQuery function
            // executeQuery() will return the result fetched from the DB

            if (x >= 0) {
                System.out.println("Database created");
            } else {
                System.out.println("Database is not created");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception Generated and handled");
        }
    }
}