/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;

import com.microsoft.sqlserver.jdbc.SQLServerException;
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
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class AddAddress extends JFrame implements ActionListener{

    JPanel p ,p1,p2;
    JLabel  lblEvent, lbltitle, lblId, lblname, lbladdress, lblcity, lblstate, lblcountry, lblpincode;
    JTextField txtId, txtname, txtaddress, txtcity, txtstate, txtcountry, txtpincode;
    JButton btnrecord, btnaddrecord, btnback;
 
// private int[] id={};

    public AddAddress() {

   p= new JPanel();
    p1= new JPanel();
    p2 = new JPanel();
    setLayout(new BorderLayout());
    add(p,BorderLayout.NORTH);
    add(p1,BorderLayout.CENTER);
    add(p2, BorderLayout.SOUTH);
    p.setLayout(new GridLayout(2,0));
    p1.setLayout(new GridLayout(7,2));
    p2.setLayout(new GridLayout(1,3));
//             p.setLayout(new GridLayout(9,1));
                            p.setLayout(new GridBagLayout());
               GridBagConstraints c= new GridBagConstraints();
        lblEvent = new JLabel("Events Inc.:");
        lbltitle = new JLabel("Address Entry Form:");
      
        
      

        lblId = new JLabel("Entry ID");
        txtId = new JTextField(12);

        lblname = new JLabel("Name:");
        txtname = new JTextField(15);

        lbladdress = new JLabel("Address:");
        txtaddress = new JTextField(25);

        lblcity = new JLabel("City:");
        txtcity = new JTextField(15);

        lblstate = new JLabel("State:");
        txtstate = new JTextField(15);

        lblcountry = new JLabel("Country:");
        txtcountry = new JTextField(15);

        lblpincode = new JLabel("Pincode:");
        txtpincode = new JTextField(10);

        btnrecord = new JButton("New Record");
        btnrecord.addActionListener(this);
        btnaddrecord = new JButton("Add Record");
        btnaddrecord.addActionListener(this);
        btnback = new JButton("Back");
        btnback.addActionListener(this);
        
        c.gridx=0;
        c.gridy=0;
        c.anchor=c.CENTER;
        p.add(lblEvent,c);
         c.gridx=0;
        c.gridy=1;
        c.anchor=c.CENTER;
        p.add(lbltitle,c);
        
        
     
        p1.add(lblId);
        p1.add(txtId);

        p1.add(lblname);
        p1.add(txtname);

        p1.add(lbladdress);
        p1.add(txtaddress);

        p1.add(lblcity);
        p1.add(txtcity);

        p1.add(lblstate);
        p1.add(txtstate);

        p1.add(lblcountry);
        p1.add(txtcountry);

        p1.add(lblpincode);
        p1.add(txtpincode);

        p2.add(btnrecord);

        p2.add(btnaddrecord);
        p2.add(btnback);

//      ^
        setTitle("Address Entry Form");
        setVisible(true);
        setSize(400, 200);
    }

    public static void main(String[] args) {
        AddAddress a = new AddAddress();
    }

    
    private void addrecord(){
    String Id, username ,addrs,city,state,country,pincode;

     Id= txtId.getText();
        username= txtname.getText();
        addrs=txtaddress.getText();
        city= txtcity.getText();
        state = txtstate.getText();
        country = txtcountry.getText();
        pincode= txtpincode.getText();
        if(Id.isEmpty()||username.isEmpty()||addrs.isEmpty()||city.isEmpty()||state.isEmpty()||country.isEmpty()||pincode.isEmpty()){
        JOptionPane.showConfirmDialog(null, "please fill in all fields");
        
        }
       String updateQuery= "INSERT INTO Registration (Id, name,address,city,state,country,pincode)VALUES(?,?,?,?,?,?,?)";
      try{
            String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
            String dbusername = "sa";
            String password = "root";
//            if(Id==txtId.getText()){
       Connection con = DriverManager.getConnection(dbURL, dbusername, password);
      //preparing db ro query^
     PreparedStatement st = con.prepareStatement(updateQuery);
     st.setString(1, Id);
     st.setString(2, username);
      st.setString(3, addrs);
       st.setString(4, city);
       st.setString(5, state);
        st.setString(6, country);
        st.setString(7, pincode);
      int rs = st.executeUpdate();
      
     
                 JOptionPane.showMessageDialog(null, "Record added successfully.");
//     }else{
//            System.out.println("Error ! Log in id is wrong");
//                                 JOptionPane.showMessageDialog(null, "Please enter a valid Log in Id");
//
//            }
      }catch(SQLException se){
      
      System.out.println("Error :"+se.getLocalizedMessage());
      }
    
    
    
    }
    private void addNewReord(){
    
     String Id, username ,addrs,city,state,country,pincode;

//     Id= txtId.getText();
//        username= txtname.getText();
//        addrs=txtaddress.getText();
//        city= txtcity.getText();
//        state = txtstate.getText();
//        country = txtcountry.getText();
//        pincode= txtpincode.getText();



    }
    @Override
    public void actionPerformed(ActionEvent e) {
            
       
        if (e.getSource() == btnaddrecord) {
    addrecord();
          
        } else if (e.getActionCommand().equals("New Record")) {
             txtId.setText("");
 txtaddress.setText("");
 txtcity.setText("");
 txtcountry.setText("");
 txtname.setText("");
 txtstate.setText("");
 txtpincode.setText("");
 this.remove(this);
        } else if (e.getSource() == btnback) {
            AddForm aobj = new AddForm();
            this.dispose();

        }
    }
    }
