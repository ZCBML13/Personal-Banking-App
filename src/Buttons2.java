import javax.swing.*;
import java.awt.event.*;

public class Buttons2 {
    public static void main(String[] args) {
        // Create a JFrame (window) with the title "Rectangle Area Calculator"
        JFrame frame = new JFrame("Rectangle Area Calculator");
        // Set the default close operation to exit the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the initial size of the window to 300 pixels wide and 150 pixels tall
        frame.setSize(300, 150);

        // Create a JPanel to hold components
        JPanel panel = new JPanel();
        // Add the panel to the JFrame
        frame.add(panel);

        // Create labels and text fields for length, width, and result display
        JLabel lengthLabel = new JLabel("Length: ");
        JTextField lengthField = new JTextField(10);
        JLabel widthLabel = new JLabel("Width: ");
        JTextField widthField = new JTextField(10);
        JLabel resultLabel = new JLabel("Result: ");
        JTextField resultField = new JTextField(10);

        resultField.setEditable(false);  // Make the results text field uneditable

        // Create buttons for calculations, clearing, and exiting
        JButton calculateButton = new JButton("Calculate");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        // Add components to the panel
        panel.add(lengthLabel);
        panel.add(lengthField);
        panel.add(widthLabel);
        panel.add(widthField);
        panel.add(resultLabel);
        panel.add(resultField);
        panel.add(calculateButton);
        panel.add(clearButton);
        panel.add(exitButton);

        // Define an action listener for the "Calculate" button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse the length and width as doubles from the respective text fields
                    double length = Double.parseDouble(lengthField.getText());
                    double width = Double.parseDouble(widthField.getText());
                    // Calculate the area of a rectangle
                    double area = length * width;
                    // Display the result with two decimal places
                    resultField.setText(String.format("%.2f", area));
                } catch (NumberFormatException ex) {
                    // Display an error message if the input is not valid numbers
                    JOptionPane.showMessageDialog(null, "Please enter valid numbers for length and width.");
                }
            }
        });

        // Define an action listener for the "Clear" button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the length, width, and result text fields
                lengthField.setText("");
                widthField.setText("");
                resultField.setText("");
            }
        });

        // Define an action listener for the "Exit" button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the application
                System.exit(0);
            }
        });

        // Make the JFrame visible
        frame.setVisible(true);
    }
}
