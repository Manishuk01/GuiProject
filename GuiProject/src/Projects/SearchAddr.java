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
import javax.swing.*;
import java.sql.*;

/**
 *
 * @author hp
 */
public class SearchAddr extends JFrame implements ActionListener {
    
    JPanel p, p1, p2;
    JLabel lblevents, lbltitle, lblname;
    JTextField txtname;
    JButton btnsearch, btnback;
    
    public SearchAddr() {
        p = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        setLayout(new BorderLayout());
        
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        add(p, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
//    p.setLayout(new GridLayout(2,0));
        p1.setLayout(new GridLayout(1, 1));
        p2.setLayout(new GridLayout(1, 1));
        lblevents = new JLabel("Events Inc");
        lbltitle = new JLabel("Address Details From");
        lblname = new JLabel("Name");
        txtname = new JTextField(20);
        btnsearch = new JButton("Search");
        btnsearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtname.getText();
                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields");
                    
                } else {
                    SearchContact(name);
                }
            }
            
        });
        btnback = new JButton("Back");
        btnback.addActionListener(this);
        
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = c.CENTER;
        
        p.add(lblevents, c);
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = c.CENTER;
        p.add(lbltitle, c);
        
        p1.add(lblname);
        p1.add(txtname);
        p2.add(btnsearch);
        p2.add(btnback);

//       this.add(p);
        setTitle("Search Address From");
        setVisible(true);
        setSize(200, 200);
        pack();
        
    }
    
    public static void main(String[] args) {
        SearchAddr ad = new SearchAddr();
    }
    
    private void SearchContact(String name) {
        DisplayRecordWithTableGUI obj = new DisplayRecordWithTableGUI(name);
        obj.setVisible(true);
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnback) {
            
            SearchFrom s = new SearchFrom();
            this.dispose();
        }
    }
    
}
