/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class DisplayReminderRecord extends JFrame implements ActionListener{
     private DefaultTableModel tableModel;
  private JTable table;
   private JButton btnback;
    private JPanel p;
  
 
  public DisplayReminderRecord(String month){
      setTitle("Anniversary Record");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(600,400);
       setLocationRelativeTo(null);
     
      tableModel = new DefaultTableModel();
      
      table = new JTable(tableModel);
      JScrollPane scrollPane = new JScrollPane(table);
      getContentPane().add(scrollPane,BorderLayout.CENTER);
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

        displayRecords(month);
  }

    private void displayRecords(String month) {
        System.out.println("Started");
Connection con =null;
PreparedStatement pst =null;
Statement st = null;
ResultSet rs = null;
String query="select * from Registration where rMonth=?";
String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";

String dbusername="sa";
String password ="root";
try{
con = DriverManager.getConnection(dbURL,dbusername,password);
pst = con.prepareStatement(query);
pst.setString(1, month);
rs= pst.executeQuery();


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
}finally{
try{
if(rs!=null){
rs.close();
}if(pst!=null){
pst.close();
}
if(con !=null){
con.close();


}}catch(SQLException se){
se.printStackTrace();

}



}
    } 

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
