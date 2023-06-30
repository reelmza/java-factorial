import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class FactorialCalculator extends JFrame implements ActionListener {
    private JLabel inputLabel;
    private JTextField inputTextField;
    private JButton calculateButton;

    public FactorialCalculator() {
        setTitle("Factorial Calculator");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        inputLabel = new JLabel("Enter a number:");
        inputTextField = new JTextField(10);
        calculateButton = new JButton("Calculate");

        // Set layout
        setLayout(new FlowLayout());

        // Add components to the frame
        add(inputLabel);
        add(inputTextField);
        add(calculateButton);

        // Register action listener for the button
        calculateButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            String inputText = inputTextField.getText();
            int number = Integer.parseInt(inputText);

            long factorial = calculateFactorial(number);

            // Write the result to a file
            try {
                FileWriter writer = new FileWriter("factorial_result.txt");
                writer.write("Factorial of " + number + " is " + factorial);
                writer.close();
                JOptionPane.showMessageDialog(this, "Factorial calculated and written to file.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error writing to file: " + ex.getMessage());
            }
        }
    }

    private long calculateFactorial(int number) {
        if (number == 0)
            return 1;
        else
            return number * calculateFactorial(number - 1);
    }

}
