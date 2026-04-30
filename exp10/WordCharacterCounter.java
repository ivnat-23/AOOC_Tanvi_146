import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class WordCharacterCounter extends JFrame implements KeyListener {

    private JTextArea textArea;
    private JLabel countLabel;

    public WordCharacterCounter() {
        setTitle("Real-Time Word & Character Counter");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Initialize JTextArea
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));

        // Add the KeyListener to the text area
        textArea.addKeyListener(this);

        // Initialize JLabel for counts
        countLabel = new JLabel("Characters: 0  |  Words: 0");
        countLabel.setFont(new Font("Arial", Font.BOLD, 14));
        countLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Add components to the frame
        // A JScrollPane is highly recommended for text areas to allow scrolling
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(countLabel, BorderLayout.SOUTH);

        setLocationRelativeTo(null); // Center the window on the screen
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used, but required by KeyListener interface
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Not used, but required by KeyListener interface
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // keyReleased is ideal because the text component has already updated its
        // content
        String text = textArea.getText();

        int charCount = text.length();
        // Trim the text and split by whitespace to get the word count
        int wordCount = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;

        countLabel.setText("Characters: " + charCount + "  |  Words: " + wordCount);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WordCharacterCounter().setVisible(true));
    }
}