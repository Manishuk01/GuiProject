/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class SearchReminder extends JFrame implements ActionListener {
      String[] months = {"Jan", "Feb", "March", "April", "May","June","July", "August","September","Oct", "Nov", "Dec"};

    JPanel p,p1,p2;
    JComboBox cmbmonth;
    JButton btnsearch, btnback;   
   public SearchReminder(){
       p = new JPanel();
       p1 = new JPanel();
       p2= new JPanel();
       setLayout(new BorderLayout());
       add(p,BorderLayout.NORTH);
       add(p1,BorderLayout.CENTER);
       add(p2,BorderLayout.SOUTH);
       
       p1.setLayout(new GridLayout(1,2));
       
        cmbmonth = new JComboBox(months);
        btnsearch = new JButton("Search");
        btnsearch.addActionListener(this);
        btnback = new JButton("Back");
        btnback.addActionListener(this);
        
        p.add(cmbmonth);
        p1.add(btnsearch);
        p1.add(btnback);
//        this.add(p);
        setSize(300,400);
        setVisible(true);
        setTitle("Search Reminder ");   
        pack();
    }
    public static void main(String[] args) {
      SearchReminder r = new SearchReminder();  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
   if(e.getSource()==btnsearch){
    String month=cmbmonth.getSelectedItem().toString();
    searchContact(month);
   }
   if(e.getSource()==btnback){
    SearchFrom s = new SearchFrom();
            this.dispose();
   
   }
    
    }

    private void searchContact(String month) {

     DisplayReminderRecord dr = new DisplayReminderRecord(month);
     dr.setVisible(true);
    }
}
