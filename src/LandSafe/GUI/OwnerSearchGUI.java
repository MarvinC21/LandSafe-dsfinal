package LandSafe.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OwnerSearchGUI extends JFrame {
    private JTextField ownerNameField;
    private JButton searchButton;
    private JTextArea resultArea;
    

   public OwnerSearchGUI() {
       setTitle("Owner Search");
       setSize(400, 300);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       setLayout(new BorderLayout());


       JPanel inputPanel = new JPanel();
       inputPanel.setLayout(new FlowLayout());


       JLabel ownerNameLabel = new JLabel("Owner Name:");
       ownerNameField = new JTextField(20);
       searchButton = new JButton("Search");


       inputPanel.add(ownerNameLabel);
       inputPanel.add(ownerNameField);
       inputPanel.add(searchButton);


       resultArea = new JTextArea();
       resultArea.setEditable(false);
       JScrollPane scrollPane = new JScrollPane(resultArea);


       add(inputPanel, BorderLayout.NORTH);
       add(scrollPane, BorderLayout.CENTER);


       searchButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               String ownerName = ownerNameField.getText();
               searchOwner(ownerName);
           }
       });
   }


   private void searchOwner(String ownerName) {
       // Placeholder for search logic
       if (ownerName.isEmpty()) {
           resultArea.setText("Please enter an owner name.");
       } else {
           // Simulate search result
           resultArea.setText("Owner " + ownerName + " found.");
       }
   }


//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new OwnerSearchGUI().setVisible(true);
//            }
//        });
//    }
}

    
