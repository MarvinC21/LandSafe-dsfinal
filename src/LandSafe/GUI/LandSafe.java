package LandSafe.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
    * LandSafe is a simple application that allows the transfer of land ownership between two persons.
    * The application has a GUI that contains input fields for person details, a transfer button, an owner label,
    * and a transfer list.
 */
public class LandSafe {
    // GUI components
    private JFrame frame;

    

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
     * Constructor for LandSafe. Initializes the person map and transfer list model
     * and the set the GUI.
     */
    public LandSafe() {
        initialize();
    }

    /**
     * Initializes the contents of the frame and sets up the GUI components.
     * The frame contains input fields for person details, a transfer button, an
     * owner label, and a transfer list.
     * The transfer button triggers the transfer of land ownership between two
     * persons.
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
        frame.getContentPane().add(inputPanel, BorderLayout.CENTER);

        // Add transfer button
        JButton transferButton = new JButton("Transfer Land");
        frame.getContentPane().add(transferButton, BorderLayout.EAST);
        // Add Owner Lookup button
        JButton ownerLookup = new JButton("Owner Lookup");
        frame.getContentPane().add(ownerLookup, BorderLayout.EAST);
        // Add transfer button
        JButton landLookup = new JButton("Land Lookup");
        frame.getContentPane().add(landLookup, BorderLayout.EAST);
        // Add transfer button
        JButton ownerRegister = new JButton("Register User");
        frame.getContentPane().add(ownerRegister, BorderLayout.EAST);


         // Create a panel for the buttons
         JPanel buttonPanel = new JPanel();
         buttonPanel.setLayout(new GridLayout(4, 1));
         frame.getContentPane().add(buttonPanel, BorderLayout.EAST);
          // Add transfer button to the button panel
         buttonPanel.add(transferButton);
          // Add owner lookup button to the button panel
         buttonPanel.add(ownerLookup);
          // Add land lookup button to the button panel
         buttonPanel.add(landLookup);
          // Add owner register button to the button panel
         buttonPanel.add(ownerRegister);




       // Add action listener to ownerRegister button
       ownerRegister.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
           RegisterUserGUI registerUserGUI = new RegisterUserGUI();
           registerUserGUI.setVisible(true);
           }
       });
  
       // Add action listener to ownerLookup button
       ownerLookup.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
           OwnerSearchGUI ownerSearchGUI = new OwnerSearchGUI();
           ownerSearchGUI.setVisible(true);
           }
       });
       transferButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               TransferGUI transferGUI = new TransferGUI();
               transferGUI.setVisible(true);
           }
       });
   }


  








   //we do need the code below for now!!!!
    
    //      * Add action listener to transfer button
    //      * When the button is clicked, the transfer method is called to transfer the
    //      * land ownership
    //      * The owner label is updated with the current owner of the land
    //      * A new transfer record is added to the transfer list model
    //      * 
    //      */

    //     transferButton.addActionListener(new ActionListener() {
    //         public void actionPerformed(ActionEvent e) {
    //             if (validateInputs()) {
    //                 currentTime = Calendar.getInstance();
    //                 Person person1 = new Person(nameField1.getText(), idField1.getText(),
    //                         Integer.parseInt(ageField1.getText()), true);
    //                 Person person2 = new Person(nameField2.getText(), idField2.getText(),
    //                         Integer.parseInt(ageField2.getText()), true);

    //                 personMap.put(person1.getId(), person1);
    //                 personMap.put(person2.getId(), person2);

    //                 Land land = new Land("LAND001", person1);
    //                 if (validateOwnership(land, person1)) {
    //                     if (person1.getName().equals(nameField1.getText())) {
    //                         transfer(land, person1.getId(), person2.getId(), currentTime.get(Calendar.HOUR_OF_DAY)
    //                                 + ":" + currentTime.get(Calendar.MINUTE));
    //                         // transfer(land, person1.getId(), person2.getId(),
    //                         // currentTime.get(Calendar.HOUR_OF_DAY)
    //                         // + ":"+ currentTime.get(Calendar.MINUTE));

    //                         ownerLabel.setText("Current owner of the land: " + land.getOwner().getName());
    //                         transferListModel.addElement("Transferred from " + person1.getName() + " to "
    //                                 + person2.getName() + " on " + currentTime.getTime());
    //                         updateOwnerData(person2);
    //                     } else {
    //                         JOptionPane.showMessageDialog(frame,
    //                                 "The seller's name does not match the registered owner.", "Transfer Error",
    //                                 JOptionPane.ERROR_MESSAGE);
    //                     }
    //                 } else {
    //                     JOptionPane.showMessageDialog(frame, "Only the current owner can initiate the transfer.",
    //                             "Transfer Error", JOptionPane.ERROR_MESSAGE);
    //                 }
    //             }
    //         }
    //         /*
    //             * Validates the ownership of the land by checking if the current owner is the
    //             * same as the person initiating the transfer.
    //          */
    //         private boolean validateOwnership(Land land, Person person1) {
    //             return land.getOwner().getId().equals(person1.getId());
    //         }
    //     });
    // }

    // /**
    //  * Validates the input fields to ensure all fields are filled and ages are valid
    //  * numbers.
    //  * @return true if inputs are valid, false otherwise
    //  *         Also, it returns a boolean value
    //  *         It checks if the name, ID, and age fields are filled out
    //  *         It also checks if the age fields contain valid numbers
    //  *         It also checks if the owners are of legal age
    //  *         It returns true if all fields are valid, and false otherwise
    //  */
    // private boolean validateInputs() {
    //     if (nameField1.getText().isEmpty() || idField1.getText().isEmpty() || ageField1.getText().isEmpty() ||
    //             nameField2.getText().isEmpty() || idField2.getText().isEmpty() || ageField2.getText().isEmpty()) {
    //         JOptionPane.showMessageDialog(frame, "All fields must be filled out.", "Input Error",
    //                 JOptionPane.ERROR_MESSAGE);
    //         return false;
    //     }

    //     try {
    //         Integer.parseInt(ageField1.getText());
    //         Integer.parseInt(ageField2.getText());
    //     } catch (NumberFormatException e) {
    //         JOptionPane.showMessageDialog(frame, "Age must be a valid number.", "Input Error",
    //                 JOptionPane.ERROR_MESSAGE);
    //         return false;
    //     }
    //     if (Integer.parseInt(ageField1.getText()) < 18 ||  Integer.parseInt(ageField2.getText()) < 18 ) {
    //         JOptionPane.showMessageDialog(frame, "Owner must be of legal age.", "Input Error",
    //         JOptionPane.ERROR_MESSAGE);
    //         return false;
    //     }

    //     return true;
    // }

    // /**
    //  * Transfers the ownership of the land from the current owner to the new owner.
    //  * 
    //  * @param land           the land to be transferred
    //  * @param currentOwnerId the ID of the current owner
    //  * @param newOwnerId     the ID of the new owner
    //  * @param date           the date of the transfer
    //  */
    // public void transfer(Land land, String currentOwnerId, String newOwnerId, String date) {
    //     Person currentOwner = personMap.get(currentOwnerId);
    //     Person newOwner = personMap.get(newOwnerId);

    //     if (currentOwner != null && newOwner != null) {
    //         Transfer transfer = new Transfer(currentOwner, newOwner, currentTime.getTime());
    //         land.addTransfer(transfer);
    //         currentOwner.removeProperty(land);
    //         newOwner.addProperty(land);
    //     } else {
    //         JOptionPane.showMessageDialog(frame, "Transfer cannot be completed. Invalid owner IDs.", "Transfer Error",
    //                 JOptionPane.ERROR_MESSAGE);
    //     }
    // }
    // /**
    //  * Updates the fields for the new owner and clears the fields for the previous
    //  * owner.
    //  * @param newOwner the new owner of the land
    //  */
    // private void updateOwnerData(Person newOwner) {
    //     nameField1.setText(newOwner.getName());
    //     idField1.setText(newOwner.getId());
    //     ageField1.setText(String.valueOf(newOwner.getAge()));
    //     // Clear the fields for the new owner and enable editing
    //     nameField2.setText("");
    //     idField2.setText("");
    //     ageField2.setText("");

    //     // Disable editing for the fields of the current owner to prevent changes
    //     nameField1.setEditable(false);
    //     idField1.setEditable(false);
    //     ageField1.setEditable(false);
    // }
}