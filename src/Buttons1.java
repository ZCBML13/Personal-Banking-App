import javax.swing.*;
import java.awt.event.*;

public class Buttons1 {
    public static void main(String[] args) {
        // Create a new JFrame (window) with the title "Circle Area Calculator"
        JFrame frame = new JFrame("Circle Area Calculator");
        // Set the default close operation to exit the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the initial size of the window to 300 pixels wide and 150 pixels tall
        frame.setSize(300, 150);

        // Create a JPanel to hold components
        JPanel panel = new JPanel();
        // Add the panel to the JFrame
        frame.add(panel);

        // Create labels and text fields for user input and result display
        JLabel radiusLabel = new JLabel("Radius: ");
        JTextField radiusField = new JTextField(10);
        JLabel resultLabel = new JLabel("Result: ");
        JTextField resultField = new JTextField(10);

        resultField.setEditable(false);  // Make the results text field uneditable

        // Create buttons for calculations, clearing, and exiting
        JButton calculateButton = new JButton("Calculate");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        // Add components to the panel
        panel.add(radiusLabel);
        panel.add(radiusField);
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
                    // Parse the radius as a double from the text field
                    double radius = Double.parseDouble(radiusField.getText());
                    // Calculate the area of a circle
                    double area = Math.PI * radius * radius;
                    // Display the result with two decimal places
                    resultField.setText(String.format("%.2f", area));
                } catch (NumberFormatException ex) {
                    // Display an error message if the input is not a valid number
                    JOptionPane.showMessageDialog(null, "Please enter a valid number for the radius.");
                }
            }
        });

        // Define an action listener for the "Clear" button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear both the radius and result text fields
                radiusField.setText("");
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
