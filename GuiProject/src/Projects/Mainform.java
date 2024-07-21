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
public class Mainform extends JFrame implements ActionListener{
JPanel p,p1;
JLabel lbltitle;
JButton btnContact, btnUpdate, btnSearch,btnBack;

public Mainform(){
    p = new JPanel();
     p1= new JPanel();
     
    setLayout(new BorderLayout());
    add(p,BorderLayout.NORTH);
    add(p1,BorderLayout.CENTER);
    p1.setLayout(new GridLayout(4,0));
    p.setLayout(new GridBagLayout());
               GridBagConstraints c= new GridBagConstraints();
    
    
    lbltitle = new JLabel("Events Inc.");
    
    
    btnContact = new JButton("Add Contacts ");
    btnContact.addActionListener(this);
    btnUpdate = new JButton("Update/Delete Contact");
    btnUpdate.addActionListener(this);
    btnSearch = new JButton("Search Contact");
    btnSearch.addActionListener(this);
    btnBack = new JButton("Back");
    btnBack.addActionListener(this);
    
                 c.gridx =0;
             c.gridy=0;
             c.anchor =c.CENTER;
    p.add(lbltitle,c);
    p1.add(btnContact);
    p1.add(btnUpdate);
    p1.add(btnSearch);
    p1.add(btnBack);
    
    
    
     
             setTitle("Main Form");
        setVisible(true);
        setSize(300,200);
        
        
}

    public static void main(String[] args) {
        
        Mainform mobj = new Mainform();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==btnContact){
 AddForm aobj = new AddForm();
 this.dispose();

}else if(e.getSource()==btnUpdate){
UpdateDeleteForm u = new UpdateDeleteForm();
 this.dispose();
}else if(e.getSource()==btnSearch){
SearchFrom s = new SearchFrom();
this.dispose();
}
else if(e.getSource()==btnBack){
 Login lobj = new Login();
 this.dispose();

}

    }
   
    
    
    
}

