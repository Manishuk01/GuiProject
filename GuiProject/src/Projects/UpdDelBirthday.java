/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
/**
 *
 * @author hp
 */
public class UpdDelBirthday extends JFrame implements ActionListener,ItemListener{
          private final String days[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","29","30","31"};
    private final String months[]= {"JANUARY","FEBUARY","MARCH","APRIL","MAY","JUNE","JULY","AUGUST","SEPTEMBER","OCTOBER", "NOVEMBER", "DECEMBER"} ;
        private final String[] select = {"Select"};
    JPanel p,p1,p2,p3;
    JLabel lbltitle, lblevent,lblentry,lblname,lblselect,lblday,lblmonth,lblyear,lblcontact;
    JButton btnupdate, btndelete, btnback;
    JTextField txtid,txtname,txtyear;
    JComboBox cmbselect ,cmbday,cmbmonth;
    public UpdDelBirthday(){
                  p= new JPanel();
            p1 = new JPanel();

        p2 = new JPanel();
//         p2.setBackground(Color.BLUE);
        p3 = new JPanel();
//         p3.setBackground(Color.GREEN);
      
//         p.setBackground(Color.YELLOW);
         
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//         this.setSize(300,30);
         this.setVisible(true);
         
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
        lbltitle = new JLabel("Update Delete Birthday From ");
      lblcontact = new JLabel("Select Contact");
       lblentry = new JLabel("Entry ID:");
       lblname= new JLabel("Name");
       lblselect = new JLabel("Select Date Of Birthday :");
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
      
      
      
      
//       p.setLayout(new FlowLayout());
//      frame.add(p);       
      
        frame.pack();
          frame.setVisible(true);
//               this.add(p);
        Dimension d = new Dimension(350, 400);
        this.setMinimumSize(d);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        UpdDelBirthday b = new UpdDelBirthday();
    }
    private void update() throws SQLException{
    String Id=txtid.getText();
    String username=txtname.getText();
    String day=cmbday.getSelectedItem().toString();
    String month=cmbmonth.getSelectedItem().toString();
    String year =txtyear.getText();
    if(Id.isEmpty()||username.isEmpty()||day.isEmpty()||month.isEmpty()||year.isEmpty()){
    JOptionPane.showConfirmDialog(null, "Please fill the all Fields");
    }else{
   String updateQuery="UPDATE Registration SET bDay=?,bMonth=?,bYear=? WHERE Id=?";
    
    String dbURL="jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
    String dbusername="sa";
    String password="root";
   try{
    Connection con = DriverManager.getConnection(dbURL,dbusername,password);
    PreparedStatement st = con.prepareStatement(updateQuery);
    st.setString(1, day);
    st.setString(2, month);
    st.setString(3, year);
    st.setString(4, Id);
    int rs=st.executeUpdate();
    if(rs>0){
    JOptionPane.showConfirmDialog(null, "Birhtdate Is Upadated Successfully");
    }else{
    JOptionPane.showConfirmDialog(null, "Error to Update ");
      }
    }catch(SQLServerException se){
    System.err.println("Error :"+se.getLocalizedMessage());
    }
    
    
    }
    
    
    
    }
private void Delete(){
String uid = txtid.getText();
String updateQuery="DELETE FROM Registration WHERE Id=?";
try{
String dbURL="jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
String dbusername="sa";
String password ="root";


Connection con = DriverManager.getConnection(dbURL,dbusername,password);
PreparedStatement st = con.prepareStatement(updateQuery);
st.setString(1, uid);
int rs=st.executeUpdate();
if(rs>0){
JOptionPane.showConfirmDialog(null, "Record Deleted Sucessfully");
txtid.setText("");
txtname.setText("");
txtyear.setText("");

                           cmbselect.removeItem(cmbselect.getSelectedItem());
                           System.out.println("Romoving data..");


}else{
JOptionPane.showConfirmDialog(null, "Error cant Delete the contact");
        


}

}catch(SQLException se){
    System.err.println("Error :"+se.getLocalizedMessage());


}

}
    @Override
    public void actionPerformed(ActionEvent e) {
          if(e.getSource()==btnupdate){
       
              try {
                  update();
              } catch (SQLException ex) {
                  Logger.getLogger(UpdDelBirthday.class.getName()).log(Level.SEVERE, null, ex);
              }
    
    }else if(e.getSource()==btndelete){
        Delete();
  
    }else if(e.getSource()==btnback){
     UpdateDeleteForm u = new UpdateDeleteForm();
     this.dispose();
    }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
String uid = cmbselect.getSelectedItem().toString();
String selQ="Select* from Registration where Id=?";
String dbURL="jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
String dbusername="sa";
String password ="root";
try{
Connection con = DriverManager.getConnection(dbURL,dbusername,password);
PreparedStatement st= con.prepareStatement(selQ);
st.setString(1, uid);

ResultSet rs = st.executeQuery();
if(rs.next()){
txtid.setText(rs.getString("id"));
txtname.setText(rs.getString("name"));
txtyear.setText(rs.getString("bYear"));
}



}catch(SQLException se){
System.out.println("Error :"+se.getLocalizedMessage());
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
}