package Clock;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainJava extends JFrame {
    private JLabel timeLabel;
    private Timer timer;

    public MainJava() {
        // Set up the JFrame
        setTitle("Digital Clock");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
//        setResizable(false);

        //JLabel To display Time Date else things
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("MV Boli", Font.BOLD, 24));
        timeLabel.setForeground(Color.PINK);
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(timeLabel, BorderLayout.CENTER);

        // Start the clock
        startClock();
    }

    private void startClock() {
        timer = new Timer(1000, e -> updateTime());
        timer.start();
        updateTime();
    }

    private void updateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("E -> yyyy-MM-dd -> HH:mm:ss");
        String currentTime = dateFormat.format(new Date());
        timeLabel.setText(currentTime);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainJava clock = new MainJava();
            clock.setVisible(true);
        });
    }
}
