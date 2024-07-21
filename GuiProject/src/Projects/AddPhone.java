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

public class AddPhone extends JFrame implements ActionListener, ItemListener {
    JPanel p, p1, p2;
    JLabel lblselect, lblevent, lblphentery, lblname, lblphone;
    JTextField txtname, txtphone;
    JButton btnadd, btnback;
    JComboBox<String> cmbselect;

    public AddPhone() {
        p = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();

        setLayout(new BorderLayout());
        add(p, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);

        p.setLayout(new GridLayout(2, 0));
        p1.setLayout(new GridLayout(3, 2));
        p2.setLayout(new GridLayout(1, 3));

        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        lblevent = new JLabel("Events Inc.");
        lblphentery = new JLabel("PHONE NO ENTRY FROM");
        lblselect = new JLabel("Select ID:");

        cmbselect = new JComboBox<>();
        getId();
        cmbselect.addItemListener(this);

        lblname = new JLabel("Name:");
        lblphone = new JLabel("Phone No.");

        txtname = new JTextField(20);
        txtphone = new JTextField(12);

        btnadd = new JButton("Add Record");
        btnadd.addActionListener(this);
        btnback = new JButton("Back");
        btnback.addActionListener(this);

        p.add(lblevent);
        p.add(lblphentery);
        p1.add(lblselect);
        p1.add(cmbselect);
        p1.add(lblname);
        p1.add(txtname);
        p1.add(lblphone);
        p1.add(txtphone);

        p2.add(btnadd);
        p2.add(btnback);

        this.pack();
        setTitle("Phone Entry From");
        setVisible(true);
        setSize(600, 300);
    }

    public static void main(String[] args) {
        new AddPhone();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnadd) {
            String selectedId = cmbselect.getSelectedItem().toString();
            String name = txtname.getText();
            String phone = txtphone.getText();

            if (name.isEmpty() || phone.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            } else {
                try {
                    String updateQuery = "UPDATE Registration SET name=?, phone=? WHERE Id=?";
                    String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
                    String dbusername = "sa";
                    String password = "root";

                    Connection con = DriverManager.getConnection(dbURL, dbusername, password);
                    PreparedStatement st = con.prepareStatement(updateQuery);
                    st.setString(1, name);
                    st.setString(2, phone);
                    st.setString(3, selectedId);

                    int rowsAffected = st.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Record updated successfully.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error updating record.");
                    }

                    con.close();
                } catch (SQLException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        } else if (e.getSource() == btnback) {
             AddForm aobj = new AddForm();
            this.dispose();
        }else if (e.getActionCommand().equals("New Record")) {
            txtname.setText("");
 this.remove(this);
        } 
    }

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

