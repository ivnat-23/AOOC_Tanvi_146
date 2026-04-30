import java.sql.*;
public class StudentDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/school?useSSL=false";
        String user = "root";
        String password = "";
        try {
            // Load driver (for your 5.x jar)
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");
            ResultSetMetaData rsmd = rs.getMetaData();
            int columns = rsmd.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                System.out.print(rsmd.getColumnName(i) + "\t");
            }
            System.out.println();
            // Print all rows dynamically
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
            con.close();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}