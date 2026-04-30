import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StopwatchApp extends JFrame implements Runnable {
    private JLabel timeLabel;
    private JButton startBtn, stopBtn, resetBtn;
    private int seconds = 0;
    private boolean running = false;
    private Thread timerThread;
   public StopwatchApp() {
        setTitle("Stopwatch");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // UI Setup
        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        startBtn = new JButton("Start");
        stopBtn = new JButton("Stop");
        resetBtn = new JButton("Reset");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startBtn);
        buttonPanel.add(stopBtn);
        buttonPanel.add(resetBtn);
        add(timeLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        // Button Actions
        startBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!running) {
                    running = true;
                    timerThread = new Thread(StopwatchApp.this);
                    timerThread.start();
                }
            }
        });
        stopBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running = false;
            }
        });
        resetBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                running = false;
                seconds = 0;
                updateLabel();
            }
        });
    }
    @Override
    public void run() {
        while (running) {
            seconds++;
            updateLabel();
            try {
                Thread.sleep(1000); // 1 second delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void updateLabel() {
        int hrs = seconds / 3600;
        int mins = (seconds % 3600) / 60;
        int secs = seconds % 60;

        String time = String.format("%02d:%02d:%02d", hrs, mins, secs);
        timeLabel.setText(time);
    }public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StopwatchApp().setVisible(true);
        });
    }
}