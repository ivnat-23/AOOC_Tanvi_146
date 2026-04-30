import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BouncingBall extends JPanel implements Runnable {
    private int x = 50, y = 50; // Ball position
    private int dx = 3, dy = 3; // Direction & speed
    private final int SIZE = 30; // Ball size
    private boolean running = false;
    private Thread animator;
    public BouncingBall() {
        setBackground(Color.WHITE);
        // Start animation on mouse press
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!running) {
                    running = true;
                    animator = new Thread(BouncingBall.this);
                    animator.start();
                }
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw blue ball
        g.setColor(Color.BLUE);
        g.fillOval(x, y, SIZE, SIZE);
    }
    @Override
    public void run() {
        while (running) {
            moveBall();
            repaint();
            try {
                Thread.sleep(10); // control speed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void moveBall() {
        x += dx;
        y += dy;
        // Bounce off left & right walls
        if (x <= 0 || x + SIZE >= getWidth()) {
            dx = -dx;
        }
        // Bounce off top & bottom walls
        if (y <= 0 || y + SIZE >= getHeight()) {
            dy = -dy;
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        BouncingBall panel = new BouncingBall();
        frame.add(panel);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}