import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackgroundColorChanger extends JFrame {

    private JComboBox<String> colorDropdown;
    private JPanel mainPanel;

    public BackgroundColorChanger() {
        setTitle("Background Color Changer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create main panel
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Array of color names for the dropdown
        String[] colorNames = { "White", "Red", "Green", "Blue", "Yellow", "Orange", "Pink", "Black" };
        colorDropdown = new JComboBox<>(colorNames);

        // Add an ActionListener to detect when a new color is selected
        colorDropdown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorDropdown.getSelectedItem();
                changeBackgroundColor(selectedColor);
            }
        });

        // Add components to the panel
        mainPanel.add(new JLabel("Select Background Color: "));
        mainPanel.add(colorDropdown);

        // Add the main panel to the frame
        add(mainPanel);

        // Center the window on the screen
        setLocationRelativeTo(null);
    }

    // Helper method to convert String selection to an actual java.awt.Color
    private void changeBackgroundColor(String colorName) {
        switch (colorName) {
            case "Red":
                mainPanel.setBackground(Color.RED);
                break;
            case "Green":
                mainPanel.setBackground(Color.GREEN);
                break;
            case "Blue":
                mainPanel.setBackground(Color.BLUE);
                break;
            case "Yellow":
                mainPanel.setBackground(Color.YELLOW);
                break;
            case "Orange":
                mainPanel.setBackground(Color.ORANGE);
                break;
            case "Pink":
                mainPanel.setBackground(Color.PINK);
                break;
            case "Black":
                mainPanel.setBackground(Color.BLACK);
                break;
            default:
                mainPanel.setBackground(Color.WHITE);
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BackgroundColorChanger().setVisible(true));
    }
}