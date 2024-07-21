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
public class AddAnnivForm extends JFrame implements ActionListener, ItemListener{

    private final String days[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "29", "30", "31"};
    private final String months[] = {"JANUARY", "FEBUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
    JPanel p, p1, p2, p4;
    JLabel lblevent, lbltitle, lblselect, lblname, lbldate, lblday, lblmonth, lblyear;
    JTextField  txtname, txtyear;
    JComboBox cmbday, cmbmonth;
    JComboBox<String> cmbselect;
    JButton btnnew, btnsave, btnback;

    public AddAnnivForm() {
        p = new JPanel();
//        p1 = new JPanel();
        p2 = new JPanel();
        p4 = new JPanel();
        setLayout(new BorderLayout());
        add(p, BorderLayout.NORTH);
//        add(p1, BorderLayout.WEST);
        add(p2, BorderLayout.SOUTH);
        add(p4, BorderLayout.CENTER);

        p.setLayout(new GridLayout(4, 2));
//        p1.setLayout(new GridLayout(2, 2));
        p4.setLayout(new GridLayout(1, 7));
        p2.setLayout(new GridLayout(1, 3));

        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        lblevent = new JLabel("Events Inc");
        lbltitle = new JLabel("Anniversary Entry From");
        lblselect = new JLabel("select Id :");
        lblname = new JLabel("Name");
        lbldate = new JLabel("Enter Date Of Ann :");
        lblday = new JLabel("Day");
        lblmonth = new JLabel("Month");
        lblyear = new JLabel("Year");

         
        txtname = new JTextField(20);
        txtyear = new JTextField(5);
        
        
          cmbselect= new JComboBox<>();
          getId();
          cmbselect.addItemListener(this);
          
        cmbday = new JComboBox(days);
        cmbmonth = new JComboBox(months);

        btnnew = new JButton("New");
        btnnew.addActionListener(this);
        btnsave = new JButton("Save");
        btnsave.addActionListener(this);
        btnback = new JButton("Back");
        btnback.addActionListener(this);

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = c.CENTER;
        p.add(lblevent, c);
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = c.CENTER;
        p.add(lbltitle, c);

        c.gridx = 0;
        c.gridy = 2;
        p.add(lblselect, c);
        c.gridx = 1;
        c.gridy = 2;
        p.add(cmbselect, c);

        c.gridx = 0;
        c.gridy = 3;
        p.add(lblname,c);
        c.gridx = 1;
        c.gridy = 3;
        p.add(txtname,c);
        p4.add(lbldate);
        p4.add(lblday);
        p4.add(cmbday);
        p4.add(lblmonth);
        p4.add(cmbmonth);
        p4.add(lblyear);
        p4.add(txtyear);
        p2.add(btnnew);
        p2.add(btnsave);
        p2.add(btnback);

//    this.add(p);
        setSize(300, 300);
        setTitle("Anniversary Entry From");
        setVisible(true);
        pack();

    }

    public static void main(String[] args) {
        AddAnnivForm an = new AddAnnivForm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==btnsave){

     String seletedId,username,day,month,year;
   
//     String doa=days+months;

 seletedId = cmbselect.getSelectedItem().toString();
        username= txtname.getText();
        day=cmbday.getSelectedItem().toString();
        month = cmbmonth.getSelectedItem().toString();
       year=txtyear.getText();
      
        if(username.isEmpty()||day.isEmpty()||month.isEmpty()||year.isEmpty()){
        JOptionPane.showConfirmDialog(null, "please fill in all fields");
        
        }
       String InsertQuery= "UPDATE Registration SET name=?, aDay=?,aMonth=?,aYear=? WHERE Id=?";
      try{
            String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
            String dbusername = "sa";
            String password = "root";
//            
       Connection con = DriverManager.getConnection(dbURL, dbusername, password);
      //preparing db ro query^
     PreparedStatement st = con.prepareStatement(InsertQuery);
    
     st.setString(1, username);
      st.setString(2, day);
      st.setString(3, month);
      st.setString(4,year);
      st.setString(5, seletedId);
       
                    int rowsAffected = st.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Record updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error updating record.");
                     }
                    con.close();
      }catch(SQLException se){
      
      System.out.println("Error :"+se.getLocalizedMessage());
      }
}else if(e.getActionCommand().equals("New")){
 this.remove(this);
     
      txtname.setText("");
      txtyear.setText("");
}else if(e.getSource()==btnback){
 AddForm aobj = new AddForm();
 this.dispose();
}     }
    
        private void getId() {
        String selQ = "SELECT id FROM Registration";
        try {
            String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
            String dbusername = "sa";
            String password = "root";
            Connection con = DriverManager.getConnection(dbURL, dbusername, password);
            PreparedStatement st = con.prepareStatement(selQ);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                cmbselect.addItem(rs.getString("id"));
            }
            con.close();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex.getMessage());
        }
    }

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

}
