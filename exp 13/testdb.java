import java.sql.*;

class testdb {
    public static void main(String args[]) {
        try {
            // Load driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection (XAMPP settings)
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/stud?useSSL=false&serverTimezone=UTC",
                "root",
                ""
            );

            // Create statement
            Statement stmt = con.createStatement();

            // Execute query
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            // Display data
            while (rs.next()) {
                int roll = rs.getInt("rollno");
                String name = rs.getString("name");

                System.out.println("Roll No: " + roll + " Name: " + name);
            }

            // Close connection
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}