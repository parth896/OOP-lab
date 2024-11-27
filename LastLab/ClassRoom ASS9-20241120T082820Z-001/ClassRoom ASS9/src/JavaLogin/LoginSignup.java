package JavaLogin;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginSignup extends JFrame {
    private JTextField usernameField, emailField, loginUsernameField;
    private JPasswordField passwordField, loginPasswordField;
    private JButton registerButton, loginButton;

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/UserDB";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "new_password"; // Replace with your MySQL password

    public LoginSignup() {
        setTitle("Login and Registration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Background Panel
        JPanel backgroundPanel = new JPanel(new BorderLayout());
        backgroundPanel.setBackground(new Color(44, 62, 80));
        add(backgroundPanel);

        // Header
        JLabel headerLabel = new JLabel("Welcome to MyApp", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Verdana", Font.BOLD, 30));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        backgroundPanel.add(headerLabel, BorderLayout.NORTH);

        // Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 16));
        tabbedPane.setBackground(new Color(52, 73, 94));
        tabbedPane.setForeground(Color.WHITE);

        // Registration Panel
        JPanel registrationPanel = createRegistrationPanel();
        tabbedPane.addTab("Register", registrationPanel);

        // Login Panel
        JPanel loginPanel = createLoginPanel();
        tabbedPane.addTab("Login", loginPanel);

        backgroundPanel.add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createRegistrationPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBackground(new Color(52, 73, 94));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel usernameLabel = new JLabel("Username:");
        styleLabel(usernameLabel);
        usernameField = new JTextField();
        styleTextField(usernameField);

        JLabel emailLabel = new JLabel("Email:");
        styleLabel(emailLabel);
        emailField = new JTextField();
        styleTextField(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        styleLabel(passwordLabel);
        passwordField = new JPasswordField();
        styleTextField(passwordField);

        registerButton = new JButton("Register");
        styleButton(registerButton);
        registerButton.addActionListener(new RegisterAction());

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(emailLabel);
        panel.add(emailField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(registerButton);

        return panel;
    }

    private JPanel createLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBackground(new Color(52, 73, 94));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel usernameLabel = new JLabel("Username:");
        styleLabel(usernameLabel);
        loginUsernameField = new JTextField();
        styleTextField(loginUsernameField);

        JLabel passwordLabel = new JLabel("Password:");
        styleLabel(passwordLabel);
        loginPasswordField = new JPasswordField();
        styleTextField(loginPasswordField);

        loginButton = new JButton("Login");
        styleButton(loginButton);
        loginButton.addActionListener(new LoginAction());

        panel.add(usernameLabel);
        panel.add(loginUsernameField);
        panel.add(passwordLabel);
        panel.add(loginPasswordField);
        panel.add(loginButton);

        return panel;
    }

    private void styleLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.WHITE);
    }

    private void styleTextField(JTextField textField) {
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        textField.setBackground(new Color(236, 240, 241));
        textField.setForeground(Color.BLACK);
        textField.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(new Color(39, 174, 96));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // Action for registration
    private class RegisterAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = String.valueOf(passwordField.getPassword());

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String query = "INSERT INTO Users (username, email, password) VALUES (?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.setString(2, email);
                pstmt.setString(3, password);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Registration Successful!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }

    // Action for login
    private class LoginAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginUsernameField.getText();
            String password = String.valueOf(loginPasswordField.getPassword());

            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.setString(2, password);

                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials!");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginSignup app = new LoginSignup();
            app.setVisible(true);
        });
    }
}

