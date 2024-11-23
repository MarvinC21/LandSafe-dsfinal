package LandSafe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Calendar;

/**
 * LandSafe is a Java Swing application that simulates the transfer of land ownership between two persons.
 * It provides a graphical user interface to input person details and perform the transfer.
 */
public class LandSafe {
    // GUI components
    private JFrame frame;
    private JLabel ownerLabel;
    private JTextField nameField1, idField1, ageField1;
    private JTextField nameField2, idField2, ageField2; 
    private HashMap<String, Person> personMap; // Map of person ID to person object
    private DefaultListModel<String> transferListModel; // List model for transfer records
    Calendar currentTime;

    /**
     * The main method to launch the application.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                LandSafe window = new LandSafe();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Constructor for LandSafe. Initializes the person map and transfer list model and the set the GUI.
     */
    public LandSafe() {
        personMap = new HashMap<>();
        transferListModel = new DefaultListModel<>(); // List model for transfer records
        initialize();  // Set up the GUI components
    }

    /**
     * Initializes the contents of the frame and sets up the GUI components.
     * The frame contains input fields for person details, a transfer button, an owner label, and a transfer list.
     * The transfer button triggers the transfer of land ownership between two persons.
     * The owner label displays the current owner of the land.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setTitle("LandSafe");

        // Add title label
        JLabel titleLabel = new JLabel("LandSafe", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        frame.getContentPane().add(titleLabel, BorderLayout.NORTH);

        // Create input panel for person details
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

        inputPanel.add(new JLabel("Person 1 Name:"));
        nameField1 = new JTextField();
        inputPanel.add(nameField1);

        inputPanel.add(new JLabel("Person 1 ID:"));
        idField1 = new JTextField();
        inputPanel.add(idField1);

        inputPanel.add(new JLabel("Person 1 Age:"));
        ageField1 = new JTextField();
        inputPanel.add(ageField1);

        inputPanel.add(new JLabel("Person 2 Name:"));
        nameField2 = new JTextField();
        inputPanel.add(nameField2);

        inputPanel.add(new JLabel("Person 2 ID:"));
        idField2 = new JTextField();
        inputPanel.add(idField2);

        inputPanel.add(new JLabel("Person 2 Age:"));
        ageField2 = new JTextField();
        inputPanel.add(ageField2);

        frame.getContentPane().add(inputPanel, BorderLayout.CENTER);

        // Add transfer button
        JButton transferButton = new JButton("Transfer Land");
        frame.getContentPane().add(transferButton, BorderLayout.SOUTH);

        // Add owner label
        ownerLabel = new JLabel("Current owner of the land: ");
        frame.getContentPane().add(ownerLabel, BorderLayout.NORTH);

        // Add transfer list
        JList<String> transferList = new JList<>(transferListModel);
        frame.getContentPane().add(new JScrollPane(transferList), BorderLayout.EAST);

        /*  Add action listener to transfer button
        When the button is clicked, the transfer method is called to transfer the land ownership
        The owner label is updated with the current owner of the land
        A new transfer record is added to the transfer list model

        */

        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateInputs()) {
                    currentTime = Calendar.getInstance();
                    Person person1 = new Person(nameField1.getText(), idField1.getText(), Integer.parseInt(ageField1.getText()), true);
                    Person person2 = new Person(nameField2.getText(), idField2.getText(), Integer.parseInt(ageField2.getText()), true);

                    personMap.put(person1.getId(), person1);
                    personMap.put(person2.getId(), person2);

                    Land land = new Land("LAND001", person1);

                    transfer(land, person1.getId(), person2.getId(), currentTime.get(Calendar.HOUR_OF_DAY)
                    + ":"+ currentTime.get(Calendar.MINUTE));

                    ownerLabel.setText("Current owner of the land: " + land.getOwner().getName());
                    transferListModel.addElement("Transferred from " + person1.getName() + " to " + person2.getName() + " on "+ currentTime.getTime());
                }
            }
        });
    }

    /**
     * Validates the input fields to ensure all fields are filled and ages are valid numbers.
     * @return true if inputs are valid, false otherwise
     * Also, it returns a boolean value
     * It checks if the name, ID, and age fields are filled out
     * It also checks if the age fields contain valid numbers
     * It returns true if all fields are valid, and false otherwise
     */
    private boolean validateInputs() {
        if (nameField1.getText().isEmpty() || idField1.getText().isEmpty() || ageField1.getText().isEmpty() ||
            nameField2.getText().isEmpty() || idField2.getText().isEmpty() || ageField2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "All fields must be filled out.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Integer.parseInt(ageField1.getText());
            Integer.parseInt(ageField2.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Age must be a valid number.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    /**
     * Transfers the ownership of the land from the current owner to the new owner.
     * @param land the land to be transferred
     * @param currentOwnerId the ID of the current owner
     * @param newOwnerId the ID of the new owner
     * @param date the date of the transfer
     */
    public void transfer(Land land, String currentOwnerId, String newOwnerId, String date) {
        Person currentOwner = personMap.get(currentOwnerId);
        Person newOwner = personMap.get(newOwnerId);

        if (currentOwner != null && newOwner != null) {
            Transfer transfer = new Transfer(currentOwner, newOwner, currentTime.getTime());
            land.addTransfer(transfer);
            currentOwner.removeProperty(land);
            newOwner.addProperty(land);
        } else {
            JOptionPane.showMessageDialog(frame, "Transfer cannot be completed. Invalid owner IDs.", "Transfer Error", JOptionPane.ERROR_MESSAGE); 
        }
    }
}