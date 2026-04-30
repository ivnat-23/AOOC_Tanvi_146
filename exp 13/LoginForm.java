import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class LoginForm extends JFrame {
    JTextField userField;
    JPasswordField passField;
    static final String URL = "jdbc:mysql://localhost:3306/logindb";
    static final String USER = "root";
    static final String PASS = "";
    public LoginForm() {
        setTitle("Login System");
        setSize(350, 200);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new JLabel("Username:"));
        userField = new JTextField();
        add(userField);
        add(new JLabel("Password:"));
        passField = new JPasswordField();
        add(passField);
        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");
        add(loginBtn);
        add(registerBtn);

        // LOGIN
        loginBtn.addActionListener(e -> loginUser());

        // REGISTER
        registerBtn.addActionListener(e -> registerUser());

        setLocationRelativeTo(null);
        setVisible(true);
    }
    void loginUser() {
        String user = userField.getText();
        String pass = new String(passField.getPassword());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
            String query = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "✅ Login Successful!");
            } else {
                JOptionPane.showMessageDialog(this, "❌ Invalid Credentials!");
            }
            con.close();
         } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    void registerUser() {
        String user = userField.getText();
        String pass = new String(passField.getPassword());
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);
             String query = "INSERT INTO users(username, password) VALUES(?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
             ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "✅ Registered Successfully!");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}