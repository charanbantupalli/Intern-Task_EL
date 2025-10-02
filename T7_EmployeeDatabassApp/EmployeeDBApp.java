package T7_EmployeeDatabassApp;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDBApp {

    // Change these details as per your MySQL setup
    private static final String URL = "jdbc:mysql://localhost:3306/companyDB";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    private Connection conn;

    public EmployeeDBApp() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database Connected Successfully!");
        } catch (Exception e) {
            System.out.println("❌ Connection Failed: " + e.getMessage());
        }
    }

    // Add Employee
    public void addEmployee(String name, String role, double salary) {
        String query = "INSERT INTO employee (name, role, salary) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, role);
            stmt.setDouble(3, salary);
            stmt.executeUpdate();
            System.out.println("✅ Employee Added Successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // View Employees
    public void viewEmployees() {
        String query = "SELECT * FROM employee";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\n--- Employee Records ---");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                                   rs.getString("name") + " | " +
                                   rs.getString("role") + " | " +
                                   rs.getDouble("salary"));
            }
            System.out.println("------------------------\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update Employee
    public void updateEmployee(int id, String newRole, double newSalary) {
        String query = "UPDATE employee SET role = ?, salary = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newRole);
            stmt.setDouble(2, newSalary);
            stmt.setInt(3, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Employee Updated Successfully!");
            } else {
                System.out.println("⚠️ Employee Not Found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete Employee
    public void deleteEmployee(int id) {
        String query = "DELETE FROM employee WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Employee Deleted Successfully!");
            } else {
                System.out.println("⚠️ Employee Not Found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close Connection
    public void close() {
        try {
            if (conn != null) conn.close();
            System.out.println("🔒 Connection Closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main Method
    public static void main(String[] args) {
        EmployeeDBApp app = new EmployeeDBApp();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Employee Database Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Role: ");
                    String role = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    app.addEmployee(name, role, salary);
                    break;

                case 2:
                    app.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Update: ");
                    int idUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Role: ");
                    String newRole = sc.nextLine();
                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();
                    app.updateEmployee(idUpdate, newRole, newSalary);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Delete: ");
                    int idDelete = sc.nextInt();
                    app.deleteEmployee(idDelete);
                    break;

                case 5:
                    app.close();
                    sc.close();
                    System.out.println("👋 Exiting App...");
                    return;

                default:
                    System.out.println("⚠️ Invalid Choice! Try Again.");
            }
        }
    }
}
