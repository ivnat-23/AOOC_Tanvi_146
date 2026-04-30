import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CounterGUI extends JFrame implements ActionListener {

    JTextField textField;
    JButton btnUp, btnDown, btnReset;
    int count = 0;

    public CounterGUI() {
        setTitle("Counter");
        setSize(400, 120);
        setLayout(new FlowLayout());

        JLabel label = new JLabel("Counter");

        textField = new JTextField("0", 5);
        textField.setEditable(false);

        btnUp = new JButton("Count Up");
        btnDown = new JButton("Count Down");
        btnReset = new JButton("Reset");

        add(label);
        add(textField);
        add(btnUp);
        add(btnDown);
        add(btnReset);

        btnUp.addActionListener(this);
        btnDown.addActionListener(this);
        btnReset.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnUp) {
            count++;
        } else if (e.getSource() == btnDown) {
            count--;
        } else if (e.getSource() == btnReset) {
            count = 0;
        }

        textField.setText(String.valueOf(count));
    }

    public static void main(String[] args) {
        new CounterGUI();
    }
}