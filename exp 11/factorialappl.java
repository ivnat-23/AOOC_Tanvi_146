import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class factorialappl extends JFrame implements ActionListener {

    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1;

    public factorialappl() {
        setTitle("Factorial Application");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        l1 = new JLabel("Enter Number:");
        l2 = new JLabel("Factorial:");

        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t2.setEditable(false);

        b1 = new JButton("Find Factorial");

        add(l1);
        add(t1);
        add(b1);
        add(l2);
        add(t2);

        b1.addActionListener(this);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int num = Integer.parseInt(t1.getText());
            
            if (num < 0) {
                t2.setText("Must be >= 0");
                return;
            }
            
            long fact = 1;

            for (int i = 1; i <= num; i++) {
                fact *= i;
            }

            t2.setText(String.valueOf(fact));

        } catch (NumberFormatException ex) {
            t2.setText("Invalid Input");
        }
    }

    public static void main(String[] args) {
        new factorialappl();
    }
}