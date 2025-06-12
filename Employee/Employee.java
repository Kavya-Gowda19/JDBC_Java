package Employee;
import java.sql.*;
import java.util.*;

public class Employee {
    private Connection con;

    public Employee() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeManagement", "root", "amazon");
    }

    public void insertEmployees(List<Map<String, Object>> employees) throws SQLException {
        String query = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = con.prepareStatement(query);

        for (Map<String, Object> emp : employees) {
            pstmt.setInt(1, (int) emp.get("empid"));
            pstmt.setString(2, (String) emp.get("empname"));
            pstmt.setString(3, (String) emp.get("empgender"));
            pstmt.setLong(4, (long) emp.get("empcontact"));
            pstmt.setString(5, (String) emp.get("empemail"));
            pstmt.setString(6, (String) emp.get("empdesignation"));
            pstmt.setLong(7, (long) emp.get("empSalary"));
            pstmt.setString(8, (String) emp.get("city"));
            pstmt.setString(9, (String) emp.get("state"));
            pstmt.setString(10, (String) emp.get("country"));
            pstmt.setInt(11, (int) emp.get("pincode"));
            pstmt.executeUpdate();
        }
        System.out.println("Employees inserted successfully.");
    }

    public void updateDesignationByEmpId(int empid, String newDesignation) throws SQLException {
        String query = "UPDATE employees SET empdesignation = ? WHERE empid = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, newDesignation);
        pstmt.setInt(2, empid);
        int rows = pstmt.executeUpdate();
        System.out.println(rows > 0 ? "Designation updated." : "No record found.");
    }

    public void updatePhoneByEmpId(int empid, long newPhone) throws SQLException {
        String query = "UPDATE employees SET empcontact = ? WHERE empid = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setLong(1, newPhone);
        pstmt.setInt(2, empid);
        int rows = pstmt.executeUpdate();
        System.out.println(rows > 0 ? "Phone number updated." : "No record found.");
    }

    public void fetchAllEmployees() throws SQLException {
        String query = "SELECT * FROM employees";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            printEmployee(rs);
        }
    }

    public void fetchEmployeeById(int empid) throws SQLException {
        String query = "SELECT * FROM employees WHERE empid = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, empid);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            printEmployee(rs);
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void fetchEmployeesByDesignation(String designation) throws SQLException {
        String query = "SELECT * FROM employees WHERE empdesignation = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, designation);
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            printEmployee(rs);
        }
    }

    public void deleteEmployeeById(int empid) throws SQLException {
        String query = "DELETE FROM employees WHERE empid = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, empid);
        int rows = pstmt.executeUpdate();
        System.out.println(rows > 0 ? "Employee deleted." : "Employee not found.");
    }

    private void printEmployee(ResultSet rs) throws SQLException {
        System.out.println(rs.getInt("empid") + " " + rs.getString("empname") + " " + rs.getString("empgender") + " " +
                           rs.getLong("empcontact") + " " + rs.getString("empemail") + " " + rs.getString("empdesignation") + " " +
                           rs.getLong("empSalary") + " " + rs.getString("city") + " " + rs.getString("state") + " " +
                           rs.getString("country") + " " + rs.getInt("pincode"));
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 6db5c79a0c62d0d569e589d500833e80ca1baea1
