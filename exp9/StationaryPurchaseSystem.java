import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StationaryPurchaseSystem extends JFrame implements ActionListener {

    JCheckBox notebook, pen, pencil;
    JButton orderBtn;

    int total = 0;

    public StationaryPurchaseSystem() {
        setTitle("Stationary Purchase System");
        setSize(350, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel("Stationary Purchase System");
        title.setBounds(70, 20, 200, 20);
        add(title);

        notebook = new JCheckBox("Notebook @ 50");
        notebook.setBounds(50, 60, 150, 20);

        pen = new JCheckBox("Pen @ 30");
        pen.setBounds(50, 90, 150, 20);

        pencil = new JCheckBox("Pencil @ 10");
        pencil.setBounds(50, 120, 150, 20);

        add(notebook);
        add(pen);
        add(pencil);

        orderBtn = new JButton("Order");
        orderBtn.setBounds(100, 170, 100, 30);
        orderBtn.addActionListener(this);
        add(orderBtn);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        total = 0;
        String message = "";

        if (notebook.isSelected()) {
            String qtyStr = JOptionPane.showInputDialog("Enter Quantity for Notebook:");
            if (qtyStr != null && !qtyStr.isEmpty()) {
                int qty = Integer.parseInt(qtyStr);
                int cost = qty * 50;
                total += cost;
                message += "Notebook Quantity: " + qty + " Total: " + cost + "\n";
            }
        }

        if (pen.isSelected()) {
            String qtyStr = JOptionPane.showInputDialog("Enter Quantity for Pen:");
            if (qtyStr != null && !qtyStr.isEmpty()) {
                int qty = Integer.parseInt(qtyStr);
                int cost = qty * 30;
                total += cost;
                message += "Pen Quantity: " + qty + " Total: " + cost + "\n";
            }
        }

        if (pencil.isSelected()) {
            String qtyStr = JOptionPane.showInputDialog("Enter Quantity for Pencil:");
            if (qtyStr != null && !qtyStr.isEmpty()) {
                int qty = Integer.parseInt(qtyStr);
                int cost = qty * 10;
                total += cost;
                message += "Pencil Quantity: " + qty + " Total: " + cost + "\n";
            }
        }

        message += "\nTotal: " + total;

        JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(this, "Successfully Ordered.", "Alert", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        new StationaryPurchaseSystem();
    }
}