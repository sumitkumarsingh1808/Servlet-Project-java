import java.sql.*;
import java.util.Scanner;

public class ProductCRUD {
    // Database credentials
    static final String DB_URL = "jdbc:mysql://localhost:3306/ProductDB";
    static final String USER = "root"; // replace with your MySQL username
    static final String PASS = "tiger"; // replace with your MySQL password

    public static void main(String[] args) {
        Connection conn = null;
        Scanner sc = new Scanner(System.in);

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false); // enable transaction handling

            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> addProduct(conn, sc);
                    case 2 -> viewProducts(conn);
                    case 3 -> updateProduct(conn, sc);
                    case 4 -> deleteProduct(conn, sc);
                    case 5 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid choice!");
                }
            } while (choice != 5);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
                sc.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    // CREATE
    public static void addProduct(Connection conn, Scanner sc) {
        try {
            System.out.print("Enter ProductID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            String sql = "INSERT INTO Product (ProductID, ProductName, Price, Quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setDouble(3, price);
            pstmt.setInt(4, qty);

            int rows = pstmt.executeUpdate();
            conn.commit();
            System.out.println(rows + " Product added successfully!");
            pstmt.close();
        } catch (SQLException e) {
            try {
                conn.rollback();
                System.out.println("Transaction rolled back: " + e.getMessage());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // READ
    public static void viewProducts(Connection conn) {
        try {
            String sql = "SELECT * FROM Product";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\nProduct List:");
            System.out.printf("%-10s %-20s %-10s %-10s%n", "ProductID", "ProductName", "Price", "Quantity");
            while (rs.next()) {
                System.out.printf("%-10d %-20s %-10.2f %-10d%n",
                        rs.getInt("ProductID"),
                        rs.getString("ProductName"),
                        rs.getDouble("Price"),
                        rs.getInt("Quantity"));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateProduct(Connection conn, Scanner sc) {
        try {
            System.out.print("Enter ProductID to update: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter new Product Name: ");
            String name = sc.nextLine();
            System.out.print("Enter new Price: ");
            double price = sc.nextDouble();
            System.out.print("Enter new Quantity: ");
            int qty = sc.nextInt();

            String sql = "UPDATE Product SET ProductName=?, Price=?, Quantity=? WHERE ProductID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, qty);
            pstmt.setInt(4, id);

            int rows = pstmt.executeUpdate();
            conn.commit();
            System.out.println(rows + " Product updated successfully!");
            pstmt.close();
        } catch (SQLException e) {
            try {
                conn.rollback();
                System.out.println("Transaction rolled back: " + e.getMessage());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    // DELETE
    public static void deleteProduct(Connection conn, Scanner sc) {
        try {
            System.out.print("Enter ProductID to delete: ");
            int id = sc.nextInt();

            String sql = "DELETE FROM Product WHERE ProductID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            conn.commit();
            System.out.println(rows + " Product deleted successfully!");
            pstmt.close();
        } catch (SQLException e) {
            try {
                conn.rollback();
                System.out.println("Transaction rolled back: " + e.getMessage());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
