//to delete data using prepared statement
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Program7 {

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

                // SQL query to delete student by sid
                String sql = "DELETE FROM student WHERE sid = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                Scanner sc = new Scanner(System.in);

                System.out.print("Enter the student ID to delete: ");
                int sid = sc.nextInt();

                pstmt.setInt(1, sid);

                int x = pstmt.executeUpdate();
                if (x > 0) {
                    System.out.println("Student deleted successfully.");
                } else {
                    System.out.println("No student found with the given ID.");
                }


            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Exception Generated and handled: " + e.getMessage());
        }
    }
}
