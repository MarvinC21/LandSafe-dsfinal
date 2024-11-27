package LandSafe.GUI;


    import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import LandSafe.Backend.Person;

public class LandSearchGUI extends JFrame {
    private JFrame frame;
    private JTextField landNameField;
    private JButton searchButton;
    private JTextArea resultArea;


   public LandSearchGUI() {
       setTitle("Land Search");
       setSize(400, 300);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setLayout(new BorderLayout());


       JPanel inputPanel = new JPanel();
       inputPanel.setLayout(new FlowLayout());


       JLabel landNameLabel = new JLabel("Land ID:");
       landNameField = new JTextField(20);
       searchButton = new JButton("Search");


       inputPanel.add(landNameLabel);
       inputPanel.add(landNameField);
       inputPanel.add(searchButton);


       resultArea = new JTextArea();
       resultArea.setEditable(false);
       JScrollPane scrollPane = new JScrollPane(resultArea);


       add(inputPanel, BorderLayout.NORTH);
       add(scrollPane, BorderLayout.CENTER);

       searchButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if (validateInputs()) {
                int landID = Integer.parseInt(landNameField.getText());

                    } else {
                        JOptionPane.showMessageDialog(frame,
                                "The land does not have a current owner.", "No Owner Found",
                                JOptionPane.ERROR_MESSAGE);
                    }
       
               
           }
       });
    }
        /**
     * Validates the input fields to ensure all fields are filled and ages are valid
     * numbers.
     * 
     * @return true if inputs are valid, false otherwise
     *         Also, it returns a boolean value
     *         It checks if the name, ID, and age fields are filled out
     *         It also checks if the age fields contain valid numbers
     *         It also checks if the owners are of legal age
     *         It returns true if all fields are valid, and false otherwise
     */
    private boolean validateInputs() {
        if (landNameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(frame, "All fields must be filled out.", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(landNameField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Age must be a valid number.", "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
   }


//    private void searchLand(int landID, ) {

       
//            resultArea.setText("Owner " +  + " found.");
//    }

