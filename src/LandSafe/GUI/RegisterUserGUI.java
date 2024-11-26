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
import javax.swing.JTextField;

import LandSafe.Person;

public class RegisterUserGUI extends JFrame {
    private JTextField nameField;
    private JTextField idField;
    private JTextField ageField;
    private JButton registerButton;
    private HashMap<String, Person> personMap;
    private int idNum = 0; 

    public RegisterUserGUI() {
        setTitle("Register User");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("ID:"));
        idField = new JTextField();
        idField.setText((Integer.toString(idNum)));
        panel.add(idField);

        panel.add(new JLabel("Age:"));
        ageField = new JTextField();
        panel.add(ageField);

        registerButton = new JButton("Register");
        panel.add(registerButton);

        add(panel);

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String ageText = ageField.getText();

                 if (name.isEmpty() || ageText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        int age = Integer.parseInt(ageText);
                        if (age < 18) {
                            JOptionPane.showMessageDialog(null, "User must be 18 or older.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        } else {
                            // Handle registration logic here
                            JOptionPane.showMessageDialog(null, "User Registered: " + name);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid age.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
    }

}
