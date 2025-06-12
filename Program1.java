//to make connection with the database
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Program1 {
    public static void main(String[] args) {
        try {
            // Step-1: Loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver is loaded");

            // Step-2: Establishing Connection
            String url = "jdbc:mysql://localhost:3306/May_Dest_Jdbc";
            // jdbc:api, mysql:DB, localhost: NW, 3306: Port, May_Dest_Jdbc: database name

           
            String user = "root";
            String pwd = "amazon";

            Connection con = DriverManager.getConnection(url, user, pwd);
            // Connection is a build in interface inside sql package used for handling
            // DB Connections

            if (con == null) {
                System.out.println("Connection is not established");
            } else {
                System.out.println("Connection Established");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception is generated and handled");
        }
    }
}