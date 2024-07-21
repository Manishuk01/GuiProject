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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class UpdateEmail extends JFrame implements ActionListener, ItemListener {

    JPanel p, p1, p2, p3;
        private Connection conection;
    private Statement statement;
    private ResultSet resultSet;

    String[] select = {"Select"};
    JLabel lblevents, lbltitle, lbnentry, lblid, lblname, lblemail;
    JButton btnback, btnupdate, btndelete;
    TextField txtid, txtname, txtemail;
    JComboBox cmbselect;

    public UpdateEmail() {
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
        p1.setLayout(new GridLayout(1, 3));
        p2.setLayout(new GridLayout(3, 2));
        p3.setLayout(new GridLayout(1, 0));
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        lblevents = new JLabel("Events Inc.");
        cmbselect = new JComboBox(select);
        getId();
        cmbselect.addItemListener(this);
        
        lbltitle = new JLabel("Email Updation/Deletion From");
        lblid = new JLabel("Entry ID :");
        lblname = new JLabel("Name");
        lblemail = new JLabel("Email Id");

        btnback = new JButton("Back");
        btnback.addActionListener(this);
        btnupdate = new JButton("Update");
        btnupdate.addActionListener(this);
        btndelete = new JButton("Delete");
        btndelete.addActionListener(this);

        txtid = new TextField(20);
        txtname = new TextField(20);
        txtemail = new TextField(20);

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = c.CENTER;
        p.add(lblevents, c);
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = c.CENTER;
        p.add(lbltitle, c);
        p1.add(cmbselect);
        p1.add(btnupdate);
        p1.add(btndelete);
        p2.add(lblid);
        p2.add(txtid);
        p2.add(lblname);
        p2.add(txtname);
        p2.add(lblemail);
        p2.add(txtemail);
        p3.add(btnback);


        setVisible(true);
        setSize(300, 300);
        pack();
        setTitle("Email Update/Delete From");

    }

    public static void main(String[] args) {
        UpdateEmail em = new UpdateEmail();
    }

  private void delete(){
    String Id = txtid.getText();
    String updateQuery = "DELETE FROM Registration WHERE Id = ?";
    try {
        String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
        String dbusername = "sa";
        String password = "root";
        Connection con = DriverManager.getConnection(dbURL, dbusername, password);
        PreparedStatement st = con.prepareStatement(updateQuery);
        st.setString(1, Id);
        int rs = st.executeUpdate();
        if (rs > 0) {
            JOptionPane.showMessageDialog(null, "Record Deleted ");
            txtid.setText("");
            txtname.setText("");
            txtemail.setText("");
            cmbselect.removeItem(cmbselect.getSelectedItem());
                           System.out.println("Romoving data..");
        } else {
            JOptionPane.showMessageDialog(null, "Error");
        }
        
   } catch (SQLException se){
        System.err.println("Error :" + se.getLocalizedMessage());
    }
}

private void update() {
    String Id = txtid.getText();
    String email = txtemail.getText();
    if (Id.isEmpty() || email.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please fill in all fields");
        return;
    }
    String upadateQuery = "UPDATE Registration SET email = ? WHERE Id = ?";
    try {
        String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
        String dbusername = "sa";
        String password = "root";
        Connection con = DriverManager.getConnection(dbURL, dbusername, password);
        PreparedStatement st = con.prepareStatement(upadateQuery);
        st.setString(1, email);
        st.setString(2, Id);
        int rs = st.executeUpdate();
        if (rs > 0) {
            JOptionPane.showMessageDialog(null, "Record Updated successfully.");
        } else {
            JOptionPane.showMessageDialog(null, "Error updating record.");
        }
    } catch (SQLException se) {
        System.out.println("Error :" + se.getLocalizedMessage());
    }
}


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

    @Override
    public void itemStateChanged(ItemEvent e) {
        String uid = cmbselect.getSelectedItem().toString();
        System.out.println("Selected " + uid);
        String userId, username, emailid;
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
                txtemail.setText(rs.getString("email"));
            }
    } catch (SQLException ex) {
            System.out.println("Error :" + ex.getLocalizedMessage());
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

            ResultSet rs = st.executeQuery(selQ);
            while (rs.next()) {
                System.out.println("Adding "+rs.getString("Id"));
                cmbselect.addItem(rs.getString("Id"));
            }

        } catch (SQLException se) {
            System.err.println("Error :" + se.getLocalizedMessage());

        }

    }

}
