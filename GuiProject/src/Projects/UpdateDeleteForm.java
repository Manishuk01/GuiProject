/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class UpdateDeleteForm extends JFrame implements ActionListener{
    JPanel p;
    JLabel lblevents, lbltitle;
    JButton btnaddress, btnphone, btnemail, btnbirthday, btnanni,btnreminder,btnback;
    public UpdateDeleteForm(){
        p = new JPanel();
//         p.setLayout(new GridLayout(9,0));
        lblevents =new JLabel("Events Inc");
        lbltitle = new JLabel("Menu For Updating Deleting Corresponding Details");
        
        btnaddress = new JButton("Update/Delete Address");
        btnaddress.addActionListener(this);
        btnphone = new JButton("Update/Delete Phone");
        btnphone.addActionListener(this);
        btnemail = new JButton("Update/Delete Email");
        btnemail.addActionListener(this);
        btnbirthday = new JButton("Update/Delete Birthday");
        btnbirthday.addActionListener(this);
        btnanni = new JButton("Update/Delete Anniversary");
        btnanni.addActionListener(this);
        btnreminder = new JButton("Update/Delete Reminder");
        btnreminder.addActionListener(this);
        btnback = new JButton("Back");
        btnback.addActionListener(this);
        
        
        
          setVisible(true);
        setSize(300,250);
        setTitle("Update Delete Form ");
        this.add(p);
          p.setLayout(new GridLayout(9,0));
         p.add(lblevents);
         p.add(lbltitle);
       p.add(btnaddress);
       p.add(btnphone);
       p.add(btnemail);
        p.add(btnbirthday);
        p.add(btnanni);
       p.add(btnreminder);
       p.add(btnreminder);
       p.add(btnback);
    }
    
    public static void main(String[] args) {
        UpdateDeleteForm u = new UpdateDeleteForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==btnaddress){
  UpdationFrom  u= new UpdationFrom(); 
  this.dispose();

}else if(e.getSource()==btnemail){
  UpdateEmail em = new UpdateEmail();
this.dispose();
}else if(e.getSource()==btnphone){
  UpdatePhone up=  new UpdatePhone(); 
  this.dispose();
}else if(e.getSource()==btnbirthday){
      UpdDelBirthday b = new UpdDelBirthday();
      this.dispose();

}else if(e.getSource()==btnanni){
 UpdDelAnnivForm  u = new UpdDelAnnivForm(); 
 this.dispose();

}else if(e.getSource()==btnreminder){
  UpDelRemFrom u = new UpDelRemFrom(); 
   this.dispose();
}else if(e.getSource()==btnback){
       Mainform mobj = new Mainform();
        this.dispose();
}

    }

 
}
