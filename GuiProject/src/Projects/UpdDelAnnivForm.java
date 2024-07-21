/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;


/**
 *
 * @author hp
 */
public class UpdDelAnnivForm extends JFrame implements ActionListener,ItemListener{
           String days[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","29","30","31"};
   String months[]= {"JANUARY","FEBUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER", "NOVEMBER", "DECEMBER"} ;
        String[] select = {"Select"};
    JPanel p,p1,p2,p3;
    JLabel lbltitle, lblevent,lblcontact,lblentry,lblname,lblselect,lblday,lblmonth,lblyear;
    JButton btnupdate, btndelete, btnback;
    JTextField txtid,txtname,txtyear;
    JComboBox cmbselect ,cmbday,cmbmonth;
    
    public UpdDelAnnivForm(){
                 p= new JPanel();
            p1 = new JPanel();

        p2 = new JPanel();

        p3 = new JPanel();


         
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);

   
         
         this.setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));
          this.add(p);
         this.add(p1);
         this.add(p2);
         this.add(p3);
        
         p.setLayout(new GridLayout(2,0));
               p1.setLayout(new GridLayout(4,2));
               p2.setLayout(new GridLayout(1,7));
               p3.setLayout(new GridLayout(1,3));
               
                 p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
          JFrame frame = new JFrame("");
       lblevent = new JLabel("Events Inc");
        lbltitle = new JLabel("Update Delete Aniversary From");
      lblcontact = new JLabel("Selected Contact");
       lblentry = new JLabel("Entry ID:");
       lblname= new JLabel("Name");
       lblselect = new JLabel("Select Date Of Aniversary :");
       lblday = new JLabel("Day");
       lblmonth = new JLabel("Month");
       lblyear = new JLabel("Year");
       
       cmbselect = new JComboBox(select);
        getId();
       
  cmbselect.addItemListener(this); 
 
  
       cmbday = new JComboBox(days);
       cmbmonth = new JComboBox(months);

       
       btnupdate = new JButton("Update");
       btnupdate.addActionListener(this);
       btndelete = new JButton("Delete");
       btndelete.addActionListener(this);
       btnback = new JButton("Back");
       btnback.addActionListener(this);
       
       txtid = new JTextField(20);
       txtname = new JTextField(20);
       txtyear = new JTextField(20);
       
      
  c.gridx=0;
  c.gridy=0;
  c.anchor=c.CENTER;
      p.add(lblevent,c);
        c.gridx=0;
  c.gridy=1;
  c.anchor=c.CENTER;
      p.add(lbltitle,c);
      p1.add(lblcontact);
      p1.add(cmbselect);
      p1.add(lblentry);
      p1.add(txtid);
      p1.add(lblname);
      p1.add(txtname);
     p2.add(lblselect);
     p2.add(lblday);
     p2.add(cmbday);
     p2.add(lblmonth);
     p2.add(cmbmonth);
     p2.add(lblyear);
     p2.add(txtyear);
          p3.add(btnupdate);
      p3.add(btndelete);
      p3.add(btnback);
      
      
      
      
   
      
        frame.pack();
       

        Dimension d = new Dimension(350,300);
        this.setMinimumSize(d);
        this.setVisible(true);
       
    }
    public static void main(String[] args) {
       UpdDelAnnivForm  u = new UpdDelAnnivForm(); 
    }
    private void Update(){
    String Id=txtid.getText();
    String username=txtname.getText();
    String day=cmbday.getSelectedItem().toString();
    String month =cmbmonth.getSelectedItem().toString();
    String year =txtyear.getText();
    if(Id.isEmpty()||username.isEmpty()||day.isEmpty()||month.isEmpty()||year.isEmpty()){
    JOptionPane.showConfirmDialog(null, "Please fill the all Fields");
    }else{
    String updateQuery = "UPDATE Registration SET aDay=?,aMonth=?,aYear=? WHERE Id=?";

    String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
    String dbusername = "sa";
    String password = "root";
    try{
        Connection con = DriverManager.getConnection(dbURL,dbusername,password);
    PreparedStatement st=con.prepareStatement(updateQuery);
    st.setString(1, day);
    st.setString(2, month);
    st.setString(3, year);
    st.setString(4, Id);
    int rs = st.executeUpdate();
    if(rs>0){
    JOptionPane.showConfirmDialog(null, "Anniversary updated Successfully");
    
    
    }else{
    JOptionPane.showConfirmDialog(null, "Error cannot Update ");
    }
    
    }catch(SQLException se){
    System.err.println("Error :"+se.getLocalizedMessage());
    }   
    }
    
    
    }
    private void Delete(){
    String uid=txtid.getText();
    String updateQuery="Delete from Registration where Id=?";
 String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
    String dbusername = "sa";
    String password = "root";
    
    try{
    Connection con =DriverManager.getConnection(dbURL,dbusername,password);
   PreparedStatement st = con.prepareStatement(updateQuery);
   st.setString(1,uid);
   int rs =st.executeUpdate();
   if(rs>0){
   JOptionPane.showConfirmDialog(null, "Record Deleted");
              txtid.setText("");
              txtname.setText("");
              txtyear.setText("");
                           cmbselect.removeItem(cmbselect.getSelectedItem());
                           System.out.println("Romoving data..");

              
   
   }else{
   JOptionPane.showConfirmDialog(null, "Error to Deleteing Contact");
   }
     }catch(SQLException se){
    System.out.println("Error :"+ se.getLocalizedMessage());
    }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource()==btnupdate){
              
              
                  Update();
              
       
    
    }else if(e.getActionCommand().equalsIgnoreCase("Delete")){
              Delete();
           
          
  
    }else if(e.getSource()==btnback){
     UpdateDeleteForm u = new UpdateDeleteForm();
     this.dispose();
    }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
String uid =cmbselect.getSelectedItem().toString();

String selQ="select* from Registration where Id=?";

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
txtyear.setText(rs.getString("aYear"));
}
}catch(SQLException se){
System.err.println("Error :"+se.getLocalizedMessage());

}  }
    
  private void getId(){
  String selQ="Select Id from Registration";
  try{
  String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
    String dbusername = "sa";
    String password = "root";
  Connection con =DriverManager.getConnection(dbURL,dbusername,password);
  PreparedStatement st = con.prepareStatement(selQ);
  ResultSet rs = st.executeQuery();
  while(rs.next()){
  System.out.println("Adding Id :"+rs.getString("Id"));
  cmbselect.addItem(rs.getString("Id"));
  
  }
  
  }catch(SQLException se){
  System.err.println("Errror :"+se.getLocalizedMessage());
  }
  }  
    
}
