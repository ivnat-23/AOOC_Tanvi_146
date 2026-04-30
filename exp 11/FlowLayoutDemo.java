import javax.swing.*;
import java.awt.*;

public class FlowLayoutDemo extends JFrame {

    public FlowLayoutDemo() {

        setTitle("FlowLayout Example");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // FlowLayout: LEFT alignment, hgap = 10, vgap = 20
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

        // Create Checkboxes
        JCheckBox java = new JCheckBox("Java");
        JCheckBox python = new JCheckBox("Python");
        JCheckBox cpp = new JCheckBox("C++");

        // Add to frame
        add(java);
        add(python);
        add(cpp);

        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutDemo();
    }
}