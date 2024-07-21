/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author hp
 */
public class UpdatePhone extends JFrame implements ActionListener,ItemListener{
    
      private String select[] ={"Select"};
     JPanel p,p1,p2,p3;
    JLabel lblevents, lbltitle, lbnentry,lblid, lblname, lblphone;
    JButton btnback, btnupdate, btndelete;
    TextField txtid, txtname, txtphone;
    JComboBox cmbselect;
    public UpdatePhone(){
 p= new JPanel();
            p1 = new JPanel();

        p2 = new JPanel();

        p3 = new JPanel();

         
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);

         this.setVisible(true);
         
         this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
          this.add(p);
         this.add(p1);
         this.add(p2);
         this.add(p3);
 p.setLayout(new GridLayout(2,0));
               p1.setLayout(new GridLayout(1,3));
               p2.setLayout(new GridLayout(3,2));
               p3.setLayout(new GridLayout(1,0));
               p.setLayout(new GridBagLayout());
                       GridBagConstraints c = new GridBagConstraints();
        lblevents = new JLabel("Events Inc.");
        
         cmbselect = new JComboBox(select);
           getId();
        cmbselect.addItemListener(this);
        
        lbltitle = new JLabel("Email Updation/Deletion From");
        lblid = new JLabel ("Entry ID :");
        lblname = new JLabel("Name");
        lblphone = new JLabel("Phone No");
       
        
        btnback = new JButton("Back");
        btnback.addActionListener(this);
        btnupdate = new JButton("Update");
        btnupdate.addActionListener(this);
        btndelete = new JButton("Delete");
        btndelete.addActionListener(this);
        
        txtid = new TextField(20);
        txtname = new TextField(20);
        txtphone = new TextField(20);

        c.gridx=0;
        c.gridy=0;
        c.anchor=c.CENTER;
        p.add(lblevents,c);
          c.gridx=0;
        c.gridy=1;
        c.anchor=c.CENTER;
        p.add(lbltitle,c);
       p1.add(cmbselect);
        p1.add(btnupdate);
        p1.add(btndelete);
        p2.add(lblid);
        p2.add(txtid);
        p2.add(lblname);
        p2.add(txtname);
        p2.add(lblphone);
        p2.add(txtphone);
         p3.add(btnback);
     
         setVisible(true);
        setSize(300,200);
        setTitle("Phone Update/Delete From");
        
    } 
    public static void main(String[] args) {
       UpdatePhone up=  new UpdatePhone(); 
    }
    

   @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnupdate) {
        update();
    } else if (e.getSource() == btndelete) {
        try {
            delete();
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePhone.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else if (e.getSource() == btnback) {
        UpdateDeleteForm u = new UpdateDeleteForm();
        this.dispose();
    }
}

       
    private void getId() {
         cmbselect.removeAllItems();
         String selQ = "Select Id from Registration";

        try {
                String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
                String dbusername = "sa";
                String password = "root";
                //loading connection 
                Connection con = DriverManager.getConnection(dbURL, dbusername, password);
//preparing db to query
                Statement st = con.createStatement();
//                int rs = st.executeUpdate(selQ);
          ResultSet rs = st.executeQuery(selQ);
          while (rs.next()) {
                              System.out.println("Adding "+rs.getString("Id"));

            cmbselect.addItem(rs.getString("Id"));
        
           
        }

         
            } catch (SQLException se) {
                System.err.println("Error :" + se.getLocalizedMessage());

            }
       
     
               
               
               
    }

    private void update() {
      String Id = txtid.getText();
      String name = txtname.getText();
    String phoneNo=txtphone.getText();
    if(Id.isEmpty()||phoneNo.isEmpty()){
    JOptionPane.showConfirmDialog(null, "Please fill in all fields ");
return;    
    }
    String updateQuery="UPDATE Registration SET phone=? WHERE Id=?";
    try{
      String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
                String dbusername = "sa";
                String password = "root";
                Connection con = DriverManager.getConnection(dbURL,dbusername,password);
    PreparedStatement st = con.prepareStatement(updateQuery);
   
     st.setString(1, phoneNo);
     st.setString(2,Id);
//    st.setString(2, name);
   
   
    int rs = st.executeUpdate();
    if(rs>0){
    JOptionPane.showConfirmDialog(null, "Record Updated Successfull");
    
    }else {
    
    JOptionPane.showConfirmDialog(null, "Error updating record");
    
    }
    }catch(SQLException se){
        System.out.println("Error :"+se.getLocalizedMessage());
    
    }
    
    
    }

    private void delete() throws SQLException {
String uid = txtid.getText();
String updateQuery="DELETE FROM Registration WHERE Id=?";
      try{  String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
 String dbusername= "sa";
 String password ="root";
 Connection con = DriverManager.getConnection(dbURL,dbusername,password);
PreparedStatement st =con.prepareStatement(updateQuery);
st.setString(1, uid);
int rs = st.executeUpdate();
if(rs>0){
JOptionPane.showConfirmDialog(null, "Phone Updated SuccessFully");}
else{
JOptionPane.showConfirmDialog(null, "Error");

txtid.setText("");
txtname.setText("");
txtphone.setText("");
cmbselect.removeItem(cmbselect.getSelectedItem());
                           System.out.println("Romoving data..");
}
   }catch(SQLException se){
   
   System.out.println("Error :"+se.getLocalizedMessage());
   
    
   } }

  
    @Override
    public void itemStateChanged(ItemEvent e) {
        String uid = cmbselect.getSelectedItem().toString();
        System.out.println("Selected " + uid);
        String userId, username, PhoneNo;
        String selQ = "select * from Registration where Id=?";
        String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
        String dbusername = "sa";
        String password = "root";
        try {
            Connection con = DriverManager.getConnection(dbURL, dbusername, password);
            PreparedStatement st = con.prepareStatement(selQ);
            st.setString(1, uid);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                txtid.setText(rs.getString("Id"));
                txtname.setText(rs.getString("name"));
                txtphone.setText(rs.getString("phone"));
            }

        } catch (SQLException ex) {
            System.out.println("Error :" + ex.getLocalizedMessage());

        }

    }
                
}
