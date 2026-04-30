import java.sql.*;
import java.util.Scanner;
public class StudentCRUD {
    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASS = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         try {
            // ✅ For MySQL 5.x driver
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            while (true) {
                System.out.println("\n===== STUDENT MENU =====");
                System.out.println("1. Insert");
                System.out.println("2. Select");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1: // INSERT
                        System.out.print("Enter Name: ");
                        String name = sc.next();
                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        System.out.print("Enter Course: ");
                        String course = sc.next();
                        String insertQuery = "INSERT INTO student(name, age, course) VALUES (?, ?, ?)";
                        PreparedStatement psInsert = con.prepareStatement(insertQuery);
                        psInsert.setString(1, name);
                        psInsert.setInt(2, age);
                        psInsert.setString(3, course);
                        psInsert.executeUpdate();
                        System.out.println("✅ Record Inserted!");
                        break;
                        case 2: // SELECT
                        String selectQuery = "SELECT * FROM student";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(selectQuery);
                        System.out.println("\nID\tName\tAge\tCourse");
                        while (rs.next()) {
                            System.out.println(
                                    rs.getInt("id") + "\t" +
                                            rs.getString("name") + "\t" +
                                            rs.getInt("age") + "\t" +
                                            rs.getString("course"));
                        }
                        break;
                        case 3: // UPDATE
                        System.out.print("Enter ID to update: ");
                        int uid = sc.nextInt();
                        System.out.print("Enter new Name: ");
                        String newName = sc.next();
                        String updateQuery = "UPDATE student SET name=? WHERE id=?";
                        PreparedStatement psUpdate = con.prepareStatement(updateQuery);
                        psUpdate.setString(1, newName);
                        psUpdate.setInt(2, uid);
                        int rowsUpdated = psUpdate.executeUpdate();
                        if (rowsUpdated > 0)
                            System.out.println("✅ Record Updated!");
                        else
                            System.out.println("❌ Record not found!");
                        break;
                        case 4: // DELETE
                        System.out.print("Enter ID to delete: ");
                        int did = sc.nextInt();
                        String deleteQuery = "DELETE FROM student WHERE id=?";
                        PreparedStatement psDelete = con.prepareStatement(deleteQuery);
                        psDelete.setInt(1, did);
                        int rowsDeleted = psDelete.executeUpdate();
                        if (rowsDeleted > 0)
                            System.out.println("✅ Record Deleted!");
                        else
                            System.out.println("❌ Record not found!");
                        break;
                        case 5:
                        con.close();
                        System.out.println("👋 Exiting...");
                        System.exit(0);
                        default:
                        System.out.println("❌ Invalid Choice!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}