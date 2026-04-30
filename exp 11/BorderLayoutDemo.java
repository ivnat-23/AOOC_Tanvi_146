import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderLayoutDemo extends JFrame implements ActionListener {

    JTextField inputField, resultField;
    JButton binaryBtn, octalBtn, hexBtn;

    public BorderLayoutDemo() {

        setTitle("BorderLayout Example");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        // Top Panel (NORTH)
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter the number: "));
        inputField = new JTextField(10);
        topPanel.add(inputField);
        add(topPanel, BorderLayout.NORTH);

        // Center Panel (CENTER)
        JPanel centerPanel = new JPanel(new GridLayout(1, 3, 10, 10));

        binaryBtn = new JButton("Binary");
        octalBtn = new JButton("Octal");
        hexBtn = new JButton("Hex");

        centerPanel.add(binaryBtn);
        centerPanel.add(octalBtn);
        centerPanel.add(hexBtn);

        add(centerPanel, BorderLayout.CENTER);

        // Bottom Panel (SOUTH)
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("Result: "));
        resultField = new JTextField(10);
        resultField.setEditable(false);
        bottomPanel.add(resultField);

        add(bottomPanel, BorderLayout.SOUTH);

        // Add action listeners
        binaryBtn.addActionListener(this);
        octalBtn.addActionListener(this);
        hexBtn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int num = Integer.parseInt(inputField.getText());

            if (e.getSource() == binaryBtn) {
                resultField.setText(Integer.toBinaryString(num));
            } else if (e.getSource() == octalBtn) {
                resultField.setText(Integer.toOctalString(num));
            } else if (e.getSource() == hexBtn) {
                resultField.setText(Integer.toHexString(num).toUpperCase());
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number!");
        }
    }

    public static void main(String[] args) {
        new BorderLayoutDemo();
    }
}