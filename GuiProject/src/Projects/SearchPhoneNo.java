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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author hp
 */
public class SearchPhoneNo extends  JFrame implements ActionListener{
     JPanel p,p1,p2;
    JLabel lblevents, lbltitle,lblname;
    JTextField txtname;
    JButton btnsearch,btnback; 
    public SearchPhoneNo(){
           p = new JPanel();
           p1 = new JPanel();
           p2 = new JPanel();
               setLayout(new BorderLayout());
          add(p,BorderLayout.PAGE_START);
        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);
        
//          p.setLayout(new GridLayout(2,0));
    p1.setLayout(new GridLayout(1,1));
    p2.setLayout(new GridLayout(1,2));
    
    p.setLayout(new GridBagLayout());
               GridBagConstraints c= new GridBagConstraints();
           
       lblevents = new JLabel("Events Inc");
       lbltitle = new JLabel("Phone  Details From");
       lblname = new JLabel("Name");
       txtname = new JTextField(20);
       btnsearch = new JButton("Search");
       btnsearch.addActionListener(this);
       btnback = new JButton("Back");
       btnback.addActionListener(this);
       
       c.gridx=0;
       c.gridy=0;
       c.anchor= c.CENTER;
        p.add(lblevents,c);
        c.gridx=0;
       c.gridy=1;
       c.anchor= c.CENTER;
       p.add(lbltitle,c);
       p1.add(lblname);
       p1.add(txtname);
       p2.add(btnsearch);
       p2.add(btnback);
       
//       this.add(p);
        setTitle("Search Phone.No. From");
        setVisible(true);
        setSize(100,200);
        pack();
    }
    public static void main(String[] args) {
        SearchPhoneNo p = new SearchPhoneNo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==btnsearch){
       String name = txtname.getText();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                    
                } else {
                    Searchcontact(name);
                }
      
      }else if(e.getSource()==btnback){
       SearchFrom s = new SearchFrom();
            this.dispose();
      
      }
    }
    
    private void Searchcontact( String name){
    DisplayPhoneRecord dp = new DisplayPhoneRecord(name);
    dp.setVisible(true);
    }
}
