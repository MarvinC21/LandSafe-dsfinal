package LandSafe.GUI;


    import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import LandSafe.Person;

public class LandSearchGUI extends JFrame {
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
           @Override
           public void actionPerformed(ActionEvent e) {
               int landID = Integer.parseInt(landNameField.getText());
            //    searchLand(landID);
           }
       });
   }


//    private void searchLand(int landID, ) {

       
//            resultArea.setText("Owner " +  + " found.");
//    }
}
