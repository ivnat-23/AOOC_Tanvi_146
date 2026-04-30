import javax.swing.*;
import java.awt.event.*;

public class MouseCoordinates extends JFrame implements MouseMotionListener {

    JLabel label;

    public MouseCoordinates() {
        setTitle("Mouse Coordinates Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        label = new JLabel("Move mouse inside window...");
        label.setBounds(100, 120, 250, 30);
        add(label);

        addMouseMotionListener(this);

        setVisible(true);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        label.setText("X: " + x + " , Y: " + y);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Optional: handle drag if needed
    }

    public static void main(String[] args) {
        new MouseCoordinates();
    }
}