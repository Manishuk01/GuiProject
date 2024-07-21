/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author hp
 */
public class SearchFrom extends JFrame implements ActionListener{
    JPanel p;
    JLabel lblevents, lblmenu;
    JButton btnadd,btnemail,btnphone,btnbirth,btnanni,btnremind,btnback;
    
    public SearchFrom(){
        p = new JPanel();
        lblevents = new JLabel("Events Inc");
        lblmenu = new JLabel("Menu For Searching Corresponding Details ");
        btnadd = new JButton("Search Address");
        btnadd.addActionListener(this);
        btnemail = new JButton("Search Email");
        btnemail.addActionListener(this);
        btnphone = new JButton("Search Phone No");
        btnphone.addActionListener(this);
        btnbirth = new JButton("Search Birthday");
        btnbirth.addActionListener(this);
        btnanni = new JButton("Search Anniversary");
        btnanni.addActionListener(this);
        btnremind = new JButton("Search Reminder");
        btnremind.addActionListener(this);
        btnback = new JButton("Back");
        btnback.addActionListener(this);
        
        
      p.add(lblevents);
      p.add(lblmenu);
      p.add(btnadd);
      p.add(btnemail);
      p.add(btnphone);
      p.add(btnbirth);
      p.add(btnanni);
      p.add(btnremind);
      p.add(btnback);
      
      this.add(p);
        setSize(400, 300);
        setTitle("Search Contact From");
        setVisible(true);
              
                
    }
    
    public static void main(String[] args) {
        SearchFrom  s= new SearchFrom();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==btnadd){
   SearchAddr s = new SearchAddr();
  this.dispose();
}else if(e.getSource()==btnemail){
     SearchEmailid s = new SearchEmailid();
       this.dispose();
}else if(e.getSource()==btnphone){
      SearchPhoneNo p = new SearchPhoneNo();
   this.dispose();
}else if(e.getSource()==btnbirth){
  SearchBirthday s = new SearchBirthday();
     this.dispose();
}else if(e.getSource()==btnanni){
 SearchAnniversary A = new SearchAnniversary ();
   this.dispose();

}else if(e.getSource()==btnremind){
 SearchReminder r = new SearchReminder();  
   this.dispose();
}else if(e.getSource()==btnback){
  Mainform mobj = new Mainform();
  this.dispose();
}
    }
}
