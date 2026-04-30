import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GenderGUI extends JFrame implements ActionListener {

    JRadioButton male, female, other;
    JButton submit;

    public GenderGUI() {
        setTitle("Gender Selection");
        setSize(300, 200);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Select Gender:");

        // Create radio buttons
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        other = new JRadioButton("Other");

        // Group them
        ButtonGroup bg = new ButtonGroup();
        bg.add(male);
        bg.add(female);
        bg.add(other);

        // Button
        submit = new JButton("Submit");

        // Add components
        add(label);
        add(male);
        add(female);
        add(other);
        add(submit);

        // Action
        submit.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String gender;

        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        } else if (other.isSelected()) {
            gender = "Other";
        } else {
            gender = "Not Selected";
        }

        JOptionPane.showMessageDialog(this, "Selected Gender: " + gender);
    }

    public static void main(String[] args) {
        new GenderGUI();
    }
}