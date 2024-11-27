package JavaStudent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class StudentManagementSystem extends JFrame {
    private JTextField idField, nameField, ageField, genderField, departmentField;
    private JButton addButton, updateButton, deleteButton, viewButton;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private Connection connection;

    public StudentManagementSystem() {
        // Set up the frame
        setTitle("Student Management System");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Student ID:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        panel.add(new JLabel("Gender:"));
        genderField = new JTextField();
        panel.add(genderField);

        panel.add(new JLabel("Department:"));
        departmentField = new JTextField();
        panel.add(departmentField);

        // Add buttons
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        viewButton = new JButton("View");

        // Add ActionListeners for buttons
        addButton.addActionListener(new ButtonListener());
        updateButton.addActionListener(new ButtonListener());
        deleteButton.addActionListener(new ButtonListener());
        viewButton.addActionListener(new ButtonListener());

        // Set up the table to display students
        tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Gender", "Department"}, 0);
        studentTable = new JTable(tableModel);
        JScrollPane tableScroll = new JScrollPane(studentTable);

        // Layout components
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(viewButton);

        add(panel, BorderLayout.NORTH);
        add(tableScroll, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Set up the database connection
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserDB", "root", "new_password");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database connection failed: " + e.getMessage());
        }

        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Add")) {
                addStudent();
            } else if (command.equals("Update")) {
                updateStudent();
            } else if (command.equals("Delete")) {
                deleteStudent();
            } else if (command.equals("View")) {
                viewStudents();
            }
        }

        private void addStudent() {
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText();
            String department = departmentField.getText();

            try {
                String query = "INSERT INTO students (name, age, gender, department) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.setString(3, gender);
                stmt.setString(4, department);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(StudentManagementSystem.this, "Student Added Successfully!");
                clearFields();
                viewStudents();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(StudentManagementSystem.this, "Error adding student: " + ex.getMessage());
            }
        }

        private void updateStudent() {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText();
            String department = departmentField.getText();

            try {
                String query = "UPDATE students SET name = ?, age = ?, gender = ?, department = ? WHERE id = ?";
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setString(1, name);
                stmt.setInt(2, age);
                stmt.setString(3, gender);
                stmt.setString(4, department);
                stmt.setInt(5, id);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(StudentManagementSystem.this, "Student Updated Successfully!");
                clearFields();
                viewStudents();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(StudentManagementSystem.this, "Error updating student: " + ex.getMessage());
            }
        }

        private void deleteStudent() {
            int id = Integer.parseInt(idField.getText());

            try {
                String query = "DELETE FROM students WHERE id = ?";
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, id);
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(StudentManagementSystem.this, "Student Deleted Successfully!");
                clearFields();
                viewStudents();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(StudentManagementSystem.this, "Error deleting student: " + ex.getMessage());
            }
        }

        private void viewStudents() {
            try {
                String query = "SELECT * FROM students";
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                tableModel.setRowCount(0); // Clear existing rows

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String gender = rs.getString("gender");
                    String department = rs.getString("department");
                    tableModel.addRow(new Object[]{id, name, age, gender, department});
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(StudentManagementSystem.this, "Error viewing students: " + ex.getMessage());
            }
        }

        private void clearFields() {
            idField.setText("");
            nameField.setText("");
            ageField.setText("");
            genderField.setText("");
            departmentField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementSystem());
    }
}

