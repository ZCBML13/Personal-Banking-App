import javax.swing.*;
import java.awt.event.*;

public class Buttons3 {
    public static void main(String[] args) {
        // Create a JFrame (window) with the title "Personalized Message Generator"
        JFrame frame = new JFrame("Personalized Message Generator");
        // Set the default close operation to exit the application when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set the initial size of the window to 400 pixels wide and 200 pixels tall
        frame.setSize(400, 200);

        // Create a JPanel to hold components
        JPanel panel = new JPanel();
        // Add the panel to the JFrame
        frame.add(panel);

        // Create labels and text fields for name, age, and message display
        JLabel nameLabel = new JLabel("Name: ");
        JTextField nameField = new JTextField(20);
        JLabel ageLabel = new JLabel("Age: ");
        JTextField ageField = new JTextField(10);
        JLabel messageLabel = new JLabel("Message: ");
        JTextField messageField = new JTextField(30);

        messageField.setEditable(false);  // Make the message text field uneditable

        // Create buttons for generating a personalized message, clearing, and exiting
        JButton outputButton = new JButton("Output Message");
        JButton clearButton = new JButton("Clear");
        JButton exitButton = new JButton("Exit");

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(ageLabel);
        panel.add(ageField);
        panel.add(messageLabel);
        panel.add(messageField);
        panel.add(outputButton);
        panel.add(clearButton);
        panel.add(exitButton);

        // Define an action listener for the "Output Message" button
        outputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the name and age input from the respective text fields
                String name = nameField.getText();
                String ageText = ageField.getText();

                try {
                    // Parse the age as an integer
                    int age = Integer.parseInt(ageText);
                    // Create a personalized message based on name and age
                    String message = "Hello Mr. " + name + "! You do not look a day older than " + age + ".";
                    // Display the message in the message field
                    messageField.setText(message);
                } catch (NumberFormatException ex) {
                    // Display an error message if the input is not a valid age
                    JOptionPane.showMessageDialog(null, "Please enter a valid age.");
                }
            }
        });

        // Define an action listener for the "Clear" button
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the name, age, and message text fields
                nameField.setText("");
                ageField.setText("");
                messageField.setText("");
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
