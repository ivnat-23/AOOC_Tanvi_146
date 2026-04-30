import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridLayoutSwapDemo extends JFrame implements ActionListener {

    JButton[] buttons = new JButton[6];
    int firstIndex = -1; // to store first clicked button

    public GridLayoutSwapDemo() {

        setTitle("GridLayout Swap Demo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 2 rows, 3 columns
        setLayout(new GridLayout(2, 3, 5, 5));

        // Numbers to display
        for (int i = 0; i < 6; i++) {
            buttons[i] = new JButton(String.valueOf(i + 1));
            buttons[i].setFont(new Font("Arial", Font.BOLD, 20));
            buttons[i].addActionListener(this);
            add(buttons[i]);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Find which button was clicked
        for (int i = 0; i < 6; i++) {
            if (e.getSource() == buttons[i]) {

                if (firstIndex == -1) {
                    // First click
                    firstIndex = i;
                    buttons[i].setBackground(Color.LIGHT_GRAY); // highlight
                } else {
                    // Second click → swap
                    String temp = buttons[firstIndex].getText();
                    buttons[firstIndex].setText(buttons[i].getText());
                    buttons[i].setText(temp);

                    // Reset color
                    buttons[firstIndex].setBackground(null);
                    firstIndex = -1;
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        new GridLayoutSwapDemo();
    }
}