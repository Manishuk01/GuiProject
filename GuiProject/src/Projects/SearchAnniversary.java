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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class SearchAnniversary extends JFrame implements ActionListener{
      private final String[] months = {"Jan", "Feb", "March", "April", "May","June","July", "August","September","Oct", "Nov", "Dec"};

    JPanel p,p1;
    JComboBox cmbmonth;
    JButton btnsearch, btnback; 
   public SearchAnniversary(){
         p = new JPanel();
         p1 = new JPanel();
         setLayout(new BorderLayout());
          add(p,BorderLayout.PAGE_START);
        add(p1,BorderLayout.SOUTH);
        
          p.setLayout(new GridLayout(1,0));
    p1.setLayout(new GridLayout(1,2));
    
    p.setLayout(new GridBagLayout());
               GridBagConstraints c= new GridBagConstraints();
    
        cmbmonth = new JComboBox(months);
        
        btnsearch = new JButton("Search");
       btnsearch.addActionListener(this);
        btnback = new JButton("Back");
        btnback.addActionListener(this);
        c.gridx=0;
        c.gridy=0;
        c.anchor= c.CENTER;
        p.add(cmbmonth,c);
        
        p1.add(btnsearch);
        p1.add(btnback);
        this.add(p);
        setSize(300,400);
        setVisible(true);
        setTitle("Search Anniversary ");  
   }
    public static void main(String[] args) {
        SearchAnniversary A = new SearchAnniversary ();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==btnsearch){
 String month=cmbmonth.getSelectedItem().toString();
    SearchContact(month);
}else if(e.getSource()==btnback){

 SearchFrom s = new SearchFrom();
            this.dispose();
}
    }
    private void SearchContact(String month){
        System.out.print("searching.......");
    DisplayAnniversaryDate da = new DisplayAnniversaryDate(month);
    da.setVisible(true);
    }
}
