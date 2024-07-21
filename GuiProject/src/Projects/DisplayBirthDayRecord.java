/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
/**
 *
 * @author hp
 */
public class DisplayBirthDayRecord extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton btnback;
    private JPanel p;
    
    public DisplayBirthDayRecord(String month){
        setTitle("Birth Day record");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        tableModel = new DefaultTableModel();
   table= new JTable(tableModel);
   JScrollPane scrollPane = new JScrollPane(table);
   getContentPane().add(scrollPane);
  btnback = new JButton("Back");
        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 SearchBirthday s = new SearchBirthday();
                dispose();
            }
        });

        p = new JPanel();
        p.add(btnback);
        getContentPane().add(p, BorderLayout.SOUTH);

        displayRecords(month);
}

    private void displayRecords(String month) {
Connection con =null;
PreparedStatement pst =null;
ResultSet rs = null;
Statement st = null;

 
        
String query ="Select * from Registration where bMonth=?";
String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";

String dbusername="sa";
String password ="root";
try{
con=DriverManager.getConnection(dbURL,dbusername,password);
pst = con.prepareStatement(query);
pst.setString(1,month);
rs=pst.executeQuery();
ResultSetMetaData mtdt=rs.getMetaData();
int columnCount =mtdt.getColumnCount();
tableModel.setColumnCount(0);

for(int i=1; i<=columnCount;i++){
 tableModel.addColumn(mtdt.getCatalogName(i));
}

tableModel.setRowCount(0);
while(rs.next()){
Object[] rowData = new Object[columnCount];
for(int i=1; i<=columnCount; i++){
rowData[i-1]=rs.getObject(i);

}

tableModel.addRow(rowData);

}

}catch(SQLException se){
se.printStackTrace();
}finally{
try{
if(rs!=null){
rs.close();
}if(pst !=null){
pst.close();
}if(con !=null){
con.close();
}
}catch(SQLException se){

se.printStackTrace();
}



}
    }
}
