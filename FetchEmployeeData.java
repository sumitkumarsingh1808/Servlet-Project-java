import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class FetchEmployeeData {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/jdbc_project"; 
        String user = "root"; 
        String password = "sumit";  

        try {
            // Step 1: Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC Driver Loaded Successfully.");

            // Step 2: Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected Successfully.");

            // Step 3: Create Statement
            Statement stmt = con.createStatement();

            // Step 4: Execute SQL Query
            String query = "SELECT EmpID, Name, Salary FROM Employee";
            ResultSet rs = stmt.executeQuery(query);

            // Step 5: Process ResultSet
            System.out.println("\nEmployee Details:");
            while (rs.next()) {
                int id = rs.getInt("EmpID");
                String name = rs.getString("Name");
                double salary = rs.getDouble("Salary");
                System.out.println("EmpID: " + id + ", Name: " + name + ", Salary: " + salary);
            }

            // Step 6: Close connection
            rs.close();
            stmt.close();
            con.close();
            System.out.println("\nConnection Closed Successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Error: " + e.getMessage());
        }
    }
}


