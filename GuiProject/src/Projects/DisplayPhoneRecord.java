/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author hp
 */
public class DisplayPhoneRecord extends JFrame {
  private DefaultTableModel tableModel;
private JTable table;
private JButton btnback;
private JPanel p;
public DisplayPhoneRecord(String name){
    setTitle("Records");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(600,400);
    
    //create table model with no data no data initially
   tableModel = new DefaultTableModel();
   
   table = new JTable(tableModel);
   JScrollPane scrollPane= new JScrollPane(table);
   
   getContentPane().add(scrollPane);
btnback = new JButton("Back");
        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
                dispose();
            }
        });

        p = new JPanel();
        p.add(btnback);
        getContentPane().add(p, BorderLayout.SOUTH);

        displayRecords(name);


}
private void displayRecords(String name){
    Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
    String query="Select * from Registration where name=?";
String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
String dbusername="sa";
String password ="root";
try{
con = DriverManager.getConnection(dbURL,dbusername,password);
 st = con.prepareStatement(query);
st.setString(1, name);
        rs = st.executeQuery();

//get MetaData
            ResultSetMetaData metaData = rs.getMetaData();
            int ColumnCount = metaData.getColumnCount();
              tableModel.setColumnCount(0);

              
              
              for (int i = 1; i <= ColumnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));

            }
            //clear existing rows
            tableModel.setRowCount(0);
            
            //Add Rows from result set 
            while (rs.next()) {
                Object[] rowData = new Object[ColumnCount];
                for (int i = 1; i <= ColumnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);

                }
                tableModel.addRow(rowData);
                System.out.println("Ended...");
            }


}catch(SQLException se){
 se.printStackTrace();

}finally {
            try {
                if (rs!= null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException se) {
                se.printStackTrace();
            }

        }


}}


