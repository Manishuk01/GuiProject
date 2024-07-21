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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author hp
 */
public class AddEmail extends JFrame implements ActionListener,ItemListener{
    JPanel p,p1,p2;
    JLabel lblevent,lbltitle,lblselect, lblname,lblemail;
    JTextField txtname,txtemail;
   JButton btnnew, btnadd, btnback;
    JComboBox<String> cmbselect;
   
   
   public AddEmail(){
       p = new JPanel();
       p1 = new JPanel();
       p2= new JPanel();
        setLayout(new BorderLayout());
        add(p, BorderLayout.NORTH);
  add(p1, BorderLayout.CENTER);  
        add(p2, BorderLayout.SOUTH);
        p.setLayout(new GridLayout(2,1));
        p1.setLayout(new GridLayout(3,2));
        p2.setLayout(new GridLayout(1,3));
        
       p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

       lblevent = new JLabel("Events Inc.");
       lbltitle= new JLabel("EMAIL ENTRY FROM");
       lblselect= new JLabel("Selected ID");
       lblname = new JLabel("Name");
       lblemail = new JLabel("Email ID:");
       
       
       txtname = new JTextField(20);
       txtemail = new JTextField(20);
       
       cmbselect= new JComboBox<>();
       getId();
       cmbselect.addItemListener(this);
       btnnew = new JButton("New Record");
       btnnew.addActionListener(this);
       btnadd = new JButton("Add Record");
       btnadd.addActionListener(this);
       btnback = new JButton("Back");
       btnback.addActionListener(this);
       
       
       c.gridx=0;
       c.gridy=0;
       c.anchor= c.CENTER;
       p.add(lblevent,c);
        c.gridx=0;
       c.gridy=1;
       c.anchor= c.CENTER;
       p.add(lbltitle,c);
       p1.add(lblselect);
       p1.add(cmbselect);
       p1.add(lblname);
       p1.add(txtname);
       p1.add(lblemail);
       p1.add(txtemail);
       
       p2.add(btnnew);
       p2.add(btnadd);
       p2.add(btnback);
       
//       this.add(p);
       setTitle("Email Entry From");
       setSize(300,300);
       setVisible(true);
      
       
       
   }
   
   
    public static void main(String[] args) {
     AddEmail eobj = new AddEmail();
     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==btnadd){

     String selectedId, username ,emailId;

    selectedId =cmbselect.getSelectedItem().toString();
        username= txtname.getText();
        emailId=txtemail.getText();
      
        if(username.isEmpty()||emailId.isEmpty()){
        JOptionPane.showConfirmDialog(null, "please fill in all fields");
        
        }
       String updateQuery= "UPDATE Registration SET name=?, email=? WHERE Id=?";
      try{
            String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
            String dbusername = "sa";
            String password = "root";
//            if(Id==txtid.getText()){
       Connection con = DriverManager.getConnection(dbURL, dbusername, password);
      //preparing db ro query^
     PreparedStatement st = con.prepareStatement(updateQuery);

     st.setString(1, username);
      st.setString(2, emailId);
      st.setString(3, selectedId);
       
      int rs = st.executeUpdate();
      if(rs>0){
      JOptionPane.showConfirmDialog(null, "Record updated sucessfully");
      
      }else {
      JOptionPane.showConfirmDialog(null, "Error updating record");
      
      }
      con.close();
     
          
      }catch(SQLException se){
      
      System.out.println("Error :"+se.getLocalizedMessage());
      }
}else if(e.getActionCommand().equals("New Record")){
 this.remove(this);
     
      txtname.setText("");
      txtemail.setText("");
}else if(e.getSource()==btnback){
 AddForm aobj = new AddForm();
 this.dispose();
}    }

    @Override
    public void itemStateChanged(ItemEvent e) {
 String selectedId = cmbselect.getSelectedItem().toString();
        String selQ = "SELECT name FROM Registration WHERE Id=?";
        
        try {
            String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
            String dbusername = "sa";
            String password = "root";
            Connection con = DriverManager.getConnection(dbURL, dbusername, password);
            PreparedStatement st = con.prepareStatement(selQ);
            st.setString(1, selectedId);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                txtname.setText(rs.getString("name"));
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    private void getId() {
String selQ="Select id from Registration";
try{
String dbURL="jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
String dbusername="sa";
String password ="root";
Connection con = DriverManager.getConnection(dbURL,dbusername,password);
PreparedStatement st = con.prepareStatement(selQ);
ResultSet rs = st.executeQuery();
while(rs.next()){
cmbselect.addItem(rs.getString("id"));


}
con.close();

}catch(SQLException se){
System.out.println("Error :"+se.getLocalizedMessage());
}

    }
}
