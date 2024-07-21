/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author hp
 */
public class SearchBirthday extends JFrame implements ActionListener {
        private final String[] months = {"Jan", "Feb", "March", "April", "May","June","July", "August","September","Oct", "Nov", "Dec"};
        private final String [] days ={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","29","30","31"};
    JPanel p,p1;
    JComboBox cmbday,cmbmonth;
//    JLabel lblyear;
//    JTextField txtyear;
    JButton btnsearch, btnback;
    public SearchBirthday(){
         p = new JPanel();
         p1 = new JPanel();
         setLayout(new BorderLayout());
          add(p,BorderLayout.NORTH);
        add(p1,BorderLayout.SOUTH);
        
          p.setLayout(new GridLayout(1,0));
    p1.setLayout(new GridLayout(1,2));
    
//    p.setLayout(new GridBagLayout());
          
    GridBagConstraints c= new GridBagConstraints();
//        cmbday= new JComboBox(days);
       cmbmonth = new JComboBox(months);
//       lblyear = new JLabel("Year ");
//        txtyear = new JTextField(20);
        
        btnsearch = new JButton("Search");
        btnsearch.addActionListener(this);
        btnback = new JButton("Back");
        btnback.addActionListener(this);
        
//        c.gridx=0;
//        c.gridy=0;
//        c.anchor= c.CENTER;
//        p.add(cmbday);
        p.add(cmbmonth);
//        p.add(lblyear);
//        p.add(txtyear);
        
        p1.add(btnsearch);
        p1.add(btnback);
//        this.add(p);
        setSize(300,400);
        setVisible(true);
        setTitle("Search BirthDay ");
        pack();
    }
    public static void main(String[] args) {
        SearchBirthday s = new SearchBirthday();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  if(e.getSource()==btnsearch){
     String month=cmbmonth.getSelectedItem().toString();
      SearchContact(month);
  
  }else if(e.getSource()==btnback){
      
      SearchFrom  s= new SearchFrom();
     this.dispose();
  
  }

    }
    private void SearchContact(String month){
    
    DisplayBirthDayRecord dbd= new DisplayBirthDayRecord(month);
    dbd.setVisible(true);
    
    }
}
