package Employee;

import java.util.*;

public class EmployeeManagement {
    public static void main(String[] args) {
        try {
            Employee empObj = new Employee();
            Scanner sc = new Scanner(System.in);
            List<Map<String, Object>> empList = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                Map<String, Object> emp = new HashMap<>();
                System.out.println("Enter details for employee " + (i + 1));

                System.out.print("ID: "); emp.put("empid", sc.nextInt());
                System.out.print("Name: "); emp.put("empname", sc.next());
                System.out.print("Gender: "); emp.put("empgender", sc.next());
                System.out.print("Phone: "); emp.put("empcontact", sc.nextLong());
                System.out.print("Email: "); emp.put("empemail", sc.next());
                System.out.print("Designation: "); emp.put("empdesignation", sc.next());
                System.out.print("Salary: "); emp.put("empSalary", sc.nextLong());
                System.out.print("City: "); emp.put("city", sc.next());
                System.out.print("State: "); emp.put("state", sc.next());
                System.out.print("Country: "); emp.put("country", sc.next());
                System.out.print("Pincode: "); emp.put("pincode", sc.nextInt());

                empList.add(emp);
            }
            empObj.insertEmployees(empList);

            System.out.print("\nEnter empid to update designation: ");
            int eid = sc.nextInt();
            System.out.print("New Designation: ");
            String newDesig = sc.next();
            empObj.updateDesignationByEmpId(eid, newDesig);

            System.out.print("\nEnter empid to update contact number: ");
            eid = sc.nextInt();
            System.out.print("New Phone: ");
            long phone = sc.nextLong();
            empObj.updatePhoneByEmpId(eid, phone);

            System.out.println("\nFetching all employees:");
            empObj.fetchAllEmployees();

            System.out.print("\nEnter empid to fetch details: ");
            eid = sc.nextInt();
            empObj.fetchEmployeeById(eid);

            System.out.print("\nEnter designation to fetch employees: ");
            String designation = sc.next();
            empObj.fetchEmployeesByDesignation(designation);

            System.out.print("\nEnter empid to delete: ");
            eid = sc.nextInt();
            empObj.deleteEmployeeById(eid);

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
