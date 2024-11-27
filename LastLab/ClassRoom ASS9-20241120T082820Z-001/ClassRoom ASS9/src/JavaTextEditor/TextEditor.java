package JavaTextEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextEditor extends JFrame {
    private JTextArea textArea;
    private JLabel statusBar;
    private JMenu fileMenu;
    private JMenuBar menuBar;

    public TextEditor() {
        // Set up the main frame
        setTitle("Text Editor");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Set up the text area for writing and editing text
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Add a scroll pane to the text area
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Set up the status bar at the bottom to show character count and line count
        statusBar = new JLabel("Characters: 0 | Lines: 0");
        statusBar.setFont(new Font("Arial", Font.PLAIN, 12));
        add(statusBar, BorderLayout.SOUTH);

        // Set up the menu bar
        menuBar = new JMenuBar();

        // Create File menu
        fileMenu = new JMenu("File");

        // Create menu items for File operations
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Add action listeners for the menu items
        openItem.addActionListener(new FileMenuListener());
        saveItem.addActionListener(new FileMenuListener());
        clearItem.addActionListener(new FileMenuListener());
        exitItem.addActionListener(new FileMenuListener());

        // Add menu items to the File menu
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(clearItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        // Add File menu to the menu bar
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        // Add focus listener to update the status bar
        textArea.addCaretListener(e -> updateStatusBar());

        // Display the frame
        setVisible(true);
    }

    // Update the status bar to show character count and line count
    private void updateStatusBar() {
        int characterCount = textArea.getText().length();
        int lineCount = textArea.getLineCount();
        statusBar.setText("Characters: " + characterCount + " | Lines: " + lineCount);
    }

    // Inner class to handle file operations
    private class FileMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "Open":
                    openFile();
                    break;
                case "Save":
                    saveFile();
                    break;
                case "Clear":
                    clearText();
                    break;
                case "Exit":
                    System.exit(0);
                    break;
            }
        }

        // Open file using JFileChooser
        private void openFile() {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(TextEditor.this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    textArea.setText("");  // Clear the text area before loading the new file
                    String line;
                    while ((line = reader.readLine()) != null) {
                        textArea.append(line + "\n");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(TextEditor.this, "Error opening file", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Save file using JFileChooser
        private void saveFile() {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(TextEditor.this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(textArea.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(TextEditor.this, "Error saving file", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Clear the text area
        private void clearText() {
            textArea.setText("");
        }
    }

    public static void main(String[] args) {
        // Launch the Text Editor application
        SwingUtilities.invokeLater(() -> new TextEditor());
    }
}

