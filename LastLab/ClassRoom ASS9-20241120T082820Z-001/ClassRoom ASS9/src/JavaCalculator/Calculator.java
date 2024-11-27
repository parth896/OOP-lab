package JavaCalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField display;
    private char[] input; // Using char array to store input
    private boolean operatorPressed; // Flag to track if operator is pressed

    public Calculator() {
        // Set up the frame
        setTitle("Basic Calculator App -Java Program");
        setSize(400, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        input = new char[50]; // Initialize input array with size 50

        // Set up the display area
        display = new JTextField();
        display.setFont(new Font("MV Boli", Font.BOLD, 30));
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        display.setEditable(false);
//        display.setSize(400,200);
        display.setBackground(Color.lightGray);

        // Set up the button panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Create and add buttons directly
        JButton button7 = new JButton("7");
        button7.setFont(new Font("MV Boli", Font.BOLD, 30));
        button7.setBackground(Color.lightGray);
        button7.addActionListener(new ButtonClickListener());
        panel.add(button7);

        JButton button8 = new JButton("8");
        button8.setBackground(Color.lightGray);
        button8.setFont(new Font("MV Boli", Font.BOLD, 30));
        button8.addActionListener(new ButtonClickListener());
        panel.add(button8);

        JButton button9 = new JButton("9");
        button9.setBackground(Color.lightGray);
        button9.setFont(new Font("MV Boli", Font.BOLD, 30));
        button9.addActionListener(new ButtonClickListener());
        panel.add(button9);

        JButton buttonDiv = new JButton("/");
        buttonDiv.setBackground(Color.lightGray);
        buttonDiv.setFont(new Font("MV Boli", Font.BOLD, 30));
        buttonDiv.addActionListener(new ButtonClickListener());
        panel.add(buttonDiv);

        JButton button4 = new JButton("4");
        button4.setBackground(Color.lightGray);
        button4.setFont(new Font("Arial", Font.BOLD, 30));
        button4.addActionListener(new ButtonClickListener());
        panel.add(button4);

        JButton button5 = new JButton("5");
        button5.setBackground(Color.lightGray);
        button5.setFont(new Font("MV Boli", Font.BOLD, 30));
        button5.addActionListener(new ButtonClickListener());
        panel.add(button5);

        JButton button6 = new JButton("6");
        button6.setBackground(Color.lightGray);
        button6.setFont(new Font("MV Boli", Font.BOLD, 30));
        button6.addActionListener(new ButtonClickListener());
        panel.add(button6);

        JButton buttonMul = new JButton("*");
        buttonMul.setBackground(Color.lightGray);
        buttonMul.setFont(new Font("MV Boli", Font.BOLD, 30));
        buttonMul.addActionListener(new ButtonClickListener());
        panel.add(buttonMul);

        JButton button1 = new JButton("1");
        button1.setBackground(Color.lightGray);
        button1.setFont(new Font("MV Boli", Font.BOLD, 30));
        button1.addActionListener(new ButtonClickListener());
        panel.add(button1);

        JButton button2 = new JButton("2");
        button2.setBackground(Color.lightGray);
        button2.setFont(new Font("MV Boli", Font.BOLD, 30));
        button2.addActionListener(new ButtonClickListener());
        panel.add(button2);

        JButton button3 = new JButton("3");
        button3.setBackground(Color.lightGray);
        button3.setFont(new Font("MV Boli", Font.BOLD, 30));
        button3.addActionListener(new ButtonClickListener());
        panel.add(button3);

        JButton buttonSub = new JButton("-");
        buttonSub.setBackground(Color.lightGray);
        buttonSub.setFont(new Font("MV Boli", Font.BOLD, 30));
        buttonSub.addActionListener(new ButtonClickListener());
        panel.add(buttonSub);

        JButton button0 = new JButton("0");
        button0.setBackground(Color.lightGray);
        button0.setFont(new Font("MV Boli", Font.BOLD, 30));
        button0.addActionListener(new ButtonClickListener());
        panel.add(button0);

        JButton buttonDot = new JButton(".");
        buttonDot.setBackground(Color.lightGray);
        buttonDot.setFont(new Font("MV Boli", Font.BOLD, 30));
        buttonDot.addActionListener(new ButtonClickListener());
        panel.add(buttonDot);

        JButton buttonEq = new JButton("=");
        buttonEq.setBackground(Color.lightGray);
        buttonEq.setFont(new Font("MV Boli", Font.BOLD, 30));
        buttonEq.addActionListener(new ButtonClickListener());
        panel.add(buttonEq);

        JButton buttonAdd = new JButton("+");
        buttonAdd.setBackground(Color.lightGray);
        buttonAdd.setFont(new Font("MV Boli", Font.BOLD, 30));
        buttonAdd.addActionListener(new ButtonClickListener());
        panel.add(buttonAdd);

        // Set layout for the frame and add components
        setLayout(new BorderLayout(10, 10));
        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Action Listener for button clicks
    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            // If equals button is clicked
            if (command.equals("=")) {
                try {
                    double result = evaluate(input);
                    display.setText(String.valueOf(result));
                    input = new char[50];
                    // Clear input after calculation
                } catch (Exception ex) {
                    display.setText("Error");
                    input = new char[50];  // Reset input on error
                }
            } else {
                addInput(command.charAt(0));  // Add clicked button to the input array
            }
        }
    }

    // Add character to the input array
    private void addInput(char c) {
        if (operatorPressed) {
            input = new char[50];  // Clear input if operator is pressed
            operatorPressed = false;
        }
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '\0') {  // Find the first empty position in the array
                input[i] = c;
                display.setText(new String(input).trim());
                break;
            }
        }
    }

    // Evaluate the arithmetic expression stored in char[]
    private double evaluate(char[] input) {
        double result = 0;
        double currentNum = 0;
        char operator = '+';

        for (char c : input) {
            if (c == '\0') break;

            if (Character.isDigit(c) || c == '.') {
                currentNum = currentNum * 10 + (c - '0'); // Handle current number
            } else {
                if (operator == '+') {
                    result += currentNum;
                } else if (operator == '-') {
                    result -= currentNum;
                } else if (operator == '*') {
                    result *= currentNum;
                } else if (operator == '/') {
                    if (currentNum == 0) throw new ArithmeticException("Division by Zero");
                    result /= currentNum;
                }
                currentNum = 0; // Reset the current number
                operator = c; // Set the current operator
            }
        }

        if (operator == '+') {
            result += currentNum;
        } else if (operator == '-') {
            result -= currentNum;
        } else if (operator == '*') {
            result *= currentNum;
        } else if (operator == '/') {
            if (currentNum == 0) throw new ArithmeticException("Division by Zero");
            result /= currentNum;
        }

        return result;
    }

    public static void main(String[] args) {
        // Launch the calculator application
        new Calculator();
    }
}
