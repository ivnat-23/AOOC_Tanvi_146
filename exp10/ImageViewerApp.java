import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

public class ImageViewerApp extends JFrame {

    private JComboBox<String> imageComboBox;
    private JLabel imageLabel;
    private Map<String, String> imagePaths;

    public ImageViewerApp() {
        // Set up the main frame
        setTitle("ComboBox Image Viewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // 1. Initialize our image data mapping (Name -> File Path)
        imagePaths = new HashMap<>();
        imagePaths.put("Select an image...", "");
        imagePaths.put("Puppy", "puppy.jpg");
        imagePaths.put("Kitten", "kitten.jpg");
        imagePaths.put("Parrot", "parrot.jpg");

        // 2. Create the JComboBox with the image names
        String[] imageNames = { "Select an image...", "Puppy", "Kitten", "Parrot" };
        imageComboBox = new JComboBox<>(imageNames);

        // 3. Create the JLabel to hold the image
        imageLabel = new JLabel("Please select an image above.", SwingConstants.CENTER);
        imageLabel.setPreferredSize(new Dimension(400, 300));

        // Optional: add a border for better visual presentation
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // 4. Add the ItemListener to the JComboBox
        imageComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                // Ensure we only react to the new item being selected,
                // ignoring the deselection of the previous item.
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedName = (String) e.getItem();
                    updateImage(selectedName);
                }
            }
        });

        // 5. Add components to the frame
        // Pad the layout a bit for aesthetics
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Choose Image: "));
        topPanel.add(imageComboBox);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(imageLabel), BorderLayout.CENTER);

        // Pack and center the window on screen
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Helper method to update the JLabel's icon based on the dropdown selection.
     */
    private void updateImage(String imageName) {
        String filePath = imagePaths.get(imageName);

        if (filePath != null && !filePath.isEmpty()) {
            ImageIcon icon = new ImageIcon(filePath);

            // Check if the image was successfully loaded
            if (icon.getIconWidth() == -1) {
                imageLabel.setIcon(null);
                imageLabel.setText("Image not found: " + filePath);
            } else {
                imageLabel.setIcon(icon);
                imageLabel.setText(""); // Clear the text when an image is shown
            }
        } else {
            // Revert to default text if "Select an image..." is chosen
            imageLabel.setIcon(null);
            imageLabel.setText("Please select an image above.");
        }
    }

    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread (EDT) for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ImageViewerApp().setVisible(true);
            }
        });
    }
}
