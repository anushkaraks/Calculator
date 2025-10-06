import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
    // Components
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton addButton, subButton, mulButton, divButton, clearButton, equalButton;
    JButton[] functionButtons = new JButton[5];

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        // Frame setup
        this.setTitle("Calculator");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.BLACK);

        // Text Field
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.WHITE);
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        this.add(textField);

        // Function Buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalButton = new JButton("=");
        clearButton = new JButton("C");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equalButton;

        for (JButton button : functionButtons) {
            button.addActionListener(this);
            button.setBackground(new Color(0, 102, 204)); // Blue theme
            button.setForeground(Color.WHITE);
            button.setFont(new Font("Arial", Font.BOLD, 22));
            button.setFocusPainted(false);
        }

        clearButton.addActionListener(this);
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Arial", Font.BOLD, 22));
        clearButton.setFocusPainted(false);

        // Number Buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setBackground(Color.DARK_GRAY);
            numberButtons[i].setForeground(Color.WHITE);
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 22));
            numberButtons[i].setFocusPainted(false);
        }

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.BLACK);

        // Add buttons in order
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(clearButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);

        this.add(panel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        } else if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        } else if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        } else if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        } else if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/': result = num1 / num2; break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        } else if (e.getSource() == clearButton) {
            textField.setText("");
            num1 = num2 = result = 0;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
