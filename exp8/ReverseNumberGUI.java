import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReverseNumberGUI extends JFrame implements ActionListener {

    JTextField inputField, resultField;
    JButton reverseBtn;

    public ReverseNumberGUI() {
        setTitle("Reverse Number");
        setSize(350, 150);
        setLayout(new GridLayout(3, 2, 5, 5));

        JLabel inputLabel = new JLabel("Enter Number:");
        JLabel resultLabel = new JLabel("Reversed Number:");

        inputField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        reverseBtn = new JButton("Reverse");

        add(inputLabel);
        add(inputField);
        add(resultLabel);
        add(resultField);
        add(new JLabel()); // empty space
        add(reverseBtn);

        reverseBtn.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num = Integer.parseInt(inputField.getText());
            int reversed = 0;

            while (num != 0) {
                int digit = num % 10;
                reversed = reversed * 10 + digit;
                num = num / 10;
            }

            resultField.setText(String.valueOf(reversed));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!");
        }
    }

    public static void main(String[] args) {
        new ReverseNumberGUI();
    }
}