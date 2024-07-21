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
public class AddForm extends JFrame implements ActionListener{
    JPanel p,p1,p2;
    JLabel lbltitle, lblmenu;
    JButton btnaddress, btnphone, btnemail, btnbirthday, btnanniversity, btnreminder, btnback;


public AddForm(){
    p= new JPanel();
    p1= new JPanel();
    p2 = new JPanel();
    setLayout(new BorderLayout());
    add(p,BorderLayout.NORTH);
    add(p1,BorderLayout.CENTER);
    add(p2, BorderLayout.SOUTH);
    p.setLayout(new GridLayout(2,0));
    p1.setLayout(new GridLayout(3,2));
    p2.setLayout(new GridLayout(1,0));
    
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      p.setLayout(new GridBagLayout());
               GridBagConstraints c= new GridBagConstraints();
    lbltitle = new JLabel("Events Inc");
    lblmenu= new JLabel("Menu For Adding Corresponding Detaill ");
    
    btnaddress = new JButton("Add Address");
    btnaddress.addActionListener(this);
    btnphone = new JButton("Add Phone");
    btnphone.addActionListener(this);
    btnemail = new JButton("Add Email Address");
    btnemail.addActionListener(this);
    btnbirthday = new JButton("Add Birthday ");
    btnbirthday.addActionListener(this);
    btnanniversity = new JButton("Add Anniversary");
    btnanniversity.addActionListener(this);
    btnreminder = new JButton("Add Reminder");
    btnreminder.addActionListener(this);
    
    
    btnback =  new JButton("Back ");
    btnback.addActionListener(this);
    
    
//     this.add(p);
//    this.add(p1);
//    this.add(p2); 
c.gridx=1;
c.gridy=0;

   p.add(lbltitle,c);
   c.gridx=1;
c.gridy=1;
   p.add(lblmenu,c);
   p1.add(btnaddress);
   p1.add(btnphone);
   p1.add(btnemail);
   p1.add(btnbirthday);
   p1.add(btnanniversity);
   p1.add(btnreminder);
    p2.add(btnback);
    
  
//     this.add(p);
     
//          c.gridx =0;
//             c.gridy=0;
//             c.anchor =c.CENTER;
//             p.add(lbltitle,c);
//             c.gridx =0;//col
//             c.gridy=1;//row
//              c.anchor =c.CENTER;
//             p.add(lblmenu ,c);
//              c.gridx=0;//col
//             c.gridy=2;//ro
//             p.add(btnaddress,c);
//             c.gridx=1;//col
//             c.gridy=2;//row
//             p.add(btnphone, c);
//            c.gridx=0;//col
//            c.gridy=3;//row
//            p.add( btnemail,c);
//            c.gridx=1;//col
//            c.gridy=3;//row
//              p.add(btnbirthday,c);
//              c.gridx=0;//col
//            c.gridy=4;//row
//              p.add(btnanniversity,c);
//             c.gridx=1;//col
//            c.gridy=4;//row
//              p.add(btnreminder,c);
//              c.gridx=0;//col
//              c.gridy=5;//row
//               c.anchor =c.CENTER;
//              p.add(btnback,c);
              
               setTitle("Login Form");
               
        setVisible(true);
//        setSize(300,200);
            setSize(200,200);
             pack();
}
    public static void main(String[] args) {
        AddForm aobj = new AddForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==btnaddress){
  AddAddress A = new AddAddress();
  this.dispose();
}else if(e.getSource()==btnphone){
 AddPhone  A = new AddPhone();
 this.dispose();

}else if (e.getSource()==btnemail){
  AddEmail eobj = new AddEmail();
  this.dispose();

}else if(e.getSource()==btnbirthday){
  AddBirthdayForm b = new AddBirthdayForm();
  this.dispose();

}else if(e.getSource()==btnanniversity){
        AddAnnivForm an = new AddAnnivForm();
        this.dispose();
}else if(e.getSource()==btnreminder){
        RemindForm r = new RemindForm();
this.dispose();

}else if(e.getSource()==btnback){
Mainform mobj = new Mainform();
this.dispose();

}
    }
    
}
