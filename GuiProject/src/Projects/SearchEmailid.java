/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;

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
public class SearchEmailid  extends  JFrame implements ActionListener{
    JPanel p;
    JLabel lblevents, lbltitle,lblname;
    JTextField txtname;
    JButton btnsearch,btnback;  
    public SearchEmailid(){
          p = new JPanel();
       lblevents = new JLabel("Events Inc");
       lbltitle = new JLabel("Email Details From");
       lblname = new JLabel("Name");
       txtname = new JTextField(20);
       
       btnsearch = new JButton("Search");
       btnsearch.addActionListener(this);
       btnback = new JButton("Back");
       btnback.addActionListener(this);
       
       
        p.add(lblevents);
       p.add(lbltitle);
       p.add(lblname);
       p.add(txtname);
       p.add(btnsearch);
       p.add(btnback);
       
       this.add(p);
        setTitle("Search Email From");
        setVisible(true);
        setSize(300,400);
    }
    public static void main(String[] args) {
        SearchEmailid s = new SearchEmailid();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==btnsearch){
 String name = txtname.getText();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                    
                } else {
                    searchContact(name);
                }
}
else if(e.getSource()==btnback){
 SearchFrom s = new SearchFrom();
            this.dispose();

}


    }
    private void searchContact(String name){
    
    DisplayEmailRecord de=new DisplayEmailRecord(name);
    de.setVisible(true);
   
    
    }
}
