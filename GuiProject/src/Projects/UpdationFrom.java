/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author hp
 */
public class UpdationFrom extends JFrame implements ActionListener,ItemListener {

    private String[] name = {"Matela@123", "Lalit", "Manoj", "Yogesh", "Pawan"};
    String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
    String dbusername = "sa";
    String password = "root";
    
    JPanel p, p1, p2, p3;
    JLabel lblevents, lbltitle, lblid, lblname, lbladdress, lblcity, lblstate, lblcountry, lblpin, lblcontact;
    JButton btnupdate, btndelete, btnback;
    JComboBox cmbselect;
    JTextField txtid, txtname, txtadd, txtcity, txtstate, txtcountry, txtpin;

    public UpdationFrom() {
        p = new JPanel();
        p1 = new JPanel();

        p2 = new JPanel();
        p3 = new JPanel();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.add(p);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        p.setLayout(new GridLayout(2, 0));
        p1.setLayout(new GridLayout(1, 4));
        p2.setLayout(new GridLayout(7, 2));
        p3.setLayout(new GridLayout(1, 0));
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        lblevents = new JLabel("Event Inc.");
        lbltitle = new JLabel("Address Updation/Deletion From");
        lblcontact = new JLabel("Select Contact");
        lblid = new JLabel("Entry ID:");
        lblname = new JLabel("Name");
        lbladdress = new JLabel("Address");
        lblcity = new JLabel("City");
        lblstate = new JLabel("State");
        lblcountry = new JLabel("Country");
        lblpin = new JLabel("PinCode");

        btnupdate = new JButton("Update");
        btnupdate.addActionListener(this);
        btndelete = new JButton("Delete");
        btndelete.addActionListener(this);
        btnback = new JButton("Back");
        btnback.addActionListener(this);

        cmbselect = new JComboBox();
        getId();
        cmbselect.addItemListener(this);
        
        txtid = new JTextField(20);
        txtname = new JTextField(20);
        txtadd = new JTextField(20);
        txtcity = new JTextField(20);
        txtstate = new JTextField(20);
        txtcountry = new JTextField(20);
        txtpin = new JTextField(20);
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = c.CENTER;
        p.add(lblevents, c);
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = c.CENTER;
        p.add(lbltitle, c);
        p1.add(lblcontact);
        p1.add(cmbselect);
        p1.add(btnupdate);
        p1.add(btndelete);
        p2.add(lblid);
        p2.add(txtid);
        p2.add(lblname);
        p2.add(txtname);
        p2.add(lbladdress);
        p2.add(txtadd);
        p2.add(lblcity);
        p2.add(txtcity);
        p2.add(lblstate);
        p2.add(txtstate);
        p2.add(lblcountry);
        p2.add(txtcountry);
        p2.add(lblpin);
        p2.add(txtpin);
        p3.add(btnback);

//this.add(p);
        setVisible(true);
        setTitle("Address Update/Delete From");
        setSize(400, 400);

    }

    public static void main(String[] args) {
        UpdationFrom u = new UpdationFrom();
    }

    private void delete() {
     String uid =txtid.getText();
     String updateQuery="DELETE FROM Registration WHERE Id=?";
     try{
     String dbURL="jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
     String dbusername="sa";
     String password="root";
     Connection con = DriverManager.getConnection(dbURL,dbusername,password);
     PreparedStatement st =con.prepareStatement(updateQuery);
     st.setString(1, uid);
   
     int rs = st.executeUpdate();
      
     if(rs>0){
     JOptionPane.showConfirmDialog(null, "Address Deleted successfully");
     txtid.setText("");
    txtname.setText("");
    txtadd.setText("");
    txtcity.setText("");
    txtstate.setText("");
    txtcountry.setText("");
    txtpin.setText("");
   cmbselect.removeItem(cmbselect.getSelectedItem());
                           System.out.println("Romoving data..");
     }else{
     JOptionPane.showConfirmDialog(null, "Error");
     }
     }catch(SQLException se){
     System.out.println("Error :"+se.getLocalizedMessage());
     }
    }
    
    
    

    private void update(){
//        String Id, username, addrs, city, state, country, pincode;
//        select = cmbselect.getSelectedItem().toString();
System.out.println("Updating");
      String  Id = txtid.getText();
      String   username = txtname.getText();
        String addrs = txtadd.getText();
      String   city = txtcity.getText();
       String  state = txtstate.getText();
       String  country = txtcountry.getText();
       String  pincode = txtpin.getText();
       System.out.println("Updating process");
        if (Id.isEmpty() || username.isEmpty() || addrs.isEmpty() || city.isEmpty() || state.isEmpty() || country.isEmpty() || pincode.isEmpty()) {
            JOptionPane.showConfirmDialog(null, "please fill in all fields");}
        else{
            String upadateQuery = "UPDATE Registration  SET address=?,city=?,state=?,country=?,pincode=? WHERE Id = ?";
            System.out.println("Updating Query");
            try {
                String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
                String dbusername = "sa";
                String password = "root";
                //loading connection 
                Connection con = DriverManager.getConnection(dbURL, dbusername, password);
//preparing db to query
              PreparedStatement st = con.prepareStatement(upadateQuery);
              
              st.setString(1, addrs);
              st.setString(2, city);
              st.setString(3, state);
              st.setString(4, country);
              st.setString(5, pincode);
              st.setString(6, Id);
              
              
              int rs =st.executeUpdate();
              System.out.println("Updated");
               if (rs > 0) {
                   JOptionPane.showConfirmDialog(null, "Successfully Upadated");

                } else {
                   JOptionPane.showConfirmDialog(null, "Error Upadating record");
                }
            } catch (SQLException se) {
                System.err.println("Error :" + se.getLocalizedMessage());

            }
        }
    }


    
    
    
    
    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnupdate) {
            update();

        } else if (e.getSource() == btndelete) {
            delete();

        } else if (e.getSource() == btnback) {
            UpdateDeleteForm u = new UpdateDeleteForm();
            this.dispose();
        }
    }

    private String[] getId() {
        cmbselect.removeAll();
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
              System.out.println("Adding Id"+rs.getString("Id"));
            cmbselect.addItem(rs.getString("Id"));
        
           
        }

         
            } catch (SQLException se) {
                System.err.println("Error :" + se.getLocalizedMessage());

            }
        return null;
       

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String uid =cmbselect.getSelectedItem().toString();
        System.out.println("Selected "+uid);
    String selQ="select * from Registration WHERE Id=?";
     String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
        String dbusername = "sa";
        String password = "root";
        try{
        Connection con = DriverManager.getConnection(dbURL,dbusername,password);
        PreparedStatement st=con.prepareStatement(selQ);
        st.setString(1, uid);
        
        ResultSet rs = st.executeQuery();
        if(rs.next()){
        txtid.setText(rs.getString("Id"));
        txtname.setText(rs.getString("name"));
        txtadd.setText(rs.getString("address"));
        txtcity.setText(rs.getString("city"));
        txtstate.setText(rs.getString("state"));
        txtcountry.setText(rs.getString("country"));
        txtpin.setText(rs.getString("pincode"));
        }
        }catch(SQLException se){
        System.out.println("Error :"+se.getLocalizedMessage());
        }
    }
}
