/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects;


import java.awt.BorderLayout;
import static java.awt.FlowLayout.CENTER;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author hp
 */
public class Login  extends JFrame implements ActionListener{
     JPanel p,p1,p2;
         JLabel lbltitle, lblLoginID,lblPassword ;
         JTextField txtusername,txtpassword; 
         JButton btnlogin, btncancel,btnexit;
         public Login(){
              p= new JPanel();
             p1= new JPanel();
             p2 = new JPanel();
             setLayout(new BorderLayout());
    add(p,BorderLayout.NORTH);
    add(p1,BorderLayout.CENTER);
    add(p2, BorderLayout.SOUTH);
    p.setLayout(new GridLayout(1,0));
    
    p1.setLayout(new GridLayout(2,2));
    p2.setLayout(new GridLayout(1,3));
              setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
               this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            
//             this.add(p);
//             this.add(p1);
//             this.add(p2);
             
             
              
               p.setLayout(new GridBagLayout());
               GridBagConstraints c= new GridBagConstraints();
              
             lbltitle = new JLabel("Events Inc.");
             lblLoginID = new JLabel("Login ID :");
             lblPassword= new JLabel("Password :");
             
             
             txtusername = new JTextField(15);
             txtpassword = new JPasswordField(15);
            
             btnlogin = new JButton("Login");
             btnlogin.addActionListener(this);
             btncancel = new JButton("Cancel");
             btncancel.addActionListener(this);
             btnexit = new JButton("Exit");
             btnexit.addActionListener(this);
             
            
             
             //adding controls
             p.add(lbltitle);
             
             p.add(lblLoginID);
             p.add(txtusername);
             
             p.add(lblPassword);
             p.add(txtpassword);
             
             p.add(btnlogin);
             p.add(btncancel);
             p.add(btnexit);
             
//             adding panel to frame
//             this.add(p);
             c.gridx =1;
             c.gridy=0;
             c.anchor =c.CENTER;
             p.add(lbltitle,c);
//             c.gridx =0;
//             c.gridy=1;
             p1.add( lblLoginID);
//              c.gridx=1;
//             c.gridy=1;
             p1.add(txtusername);
//             c.gridx=0;
//             c.gridy=2;
             p1.add(lblPassword);
//            c.gridx=1;
//            c.gridy=2;
            p1.add(txtpassword);
//            c.gridx=0;
//            c.gridy=3;
              p2.add(btnlogin);
//              c.gridx=1;
//            c.gridy=3;
              p2.add(btncancel);
//             c.gridx=2;
//            c.gridy=3;
              p2.add(btnexit);
             
             
               setTitle("Login Form");
        setVisible(true);
        setSize(300,2);
             pack();
        
                   
         }
         public static void main(String[] args) {
        Login lobj = new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnlogin){
                String username = txtusername.getText();
    String password= txtpassword.getText(); 
              if(username.isEmpty()||password.isEmpty()){
            JOptionPane.showConfirmDialog(this, "please fill all th fields");
            
            }else{
                  System.out.print("Running");
        logform();
        }
        }
       
        if(e.getSource()==btncancel){
                   txtusername.setText("");
        txtpassword.setText("");

            this.remove(this);
        }
        if(e.getSource()==btnexit){
            this.dispose();
            System.exit(0);
        }
       
    
   }
    
    private void logform(){
    String username = txtusername.getText();
    String password= txtpassword.getText();

     if(Validate(username, password)){
                            
          
                        JOptionPane.showConfirmDialog(this, "Log In succesfull !");
                     
                        System.out.println("Enter Started");
                        new Mainform();
                        System.out.println("Welcome");
                        this.dispose();
     }
                       else{
         System.out.println("Error :");
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                      
    
    
    }
    
    private boolean Validate(String username ,String password){
         boolean isValid = false;
//            username= txtusername.getText();
//            password= txtpassword.getText();
          
            
               try{
        
    Connection con = DriverManager.getConnection("jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;","sa","root");

                        String query ="SELECT * FROM login WHERE username = ? AND password = ?";
                     PreparedStatement   st = con.prepareStatement(query);
                       st.setString(1, username);
            st.setString(2, password);
   ResultSet rs = st.executeQuery();
            if(rs.next()){
             txtusername.setText(rs.getString("username"));
                txtpassword.setText(rs.getString("password"));
                
               isValid=true;
            }
                con.close();        
                        
    
    
    
    }catch(SQLException se){
    System.out.println("Error :"+se.getLocalizedMessage());
                      }
           
       

               
    
    
       return isValid;
}
}

