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
public class DisplayAnniversaryDate extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JButton btnback;
    private JPanel p;

    public DisplayAnniversaryDate(String month) {
        setTitle("Anniversary Record");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        btnback = new JButton("Back");
        btnback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  SearchAnniversary A = new SearchAnniversary ();
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
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String query = "SELECT * FROM Registration WHERE aMonth= ?";
        String dbURL = "jdbc:sqlserver://MANISHMATELA:1433;databaseName=MyDB;integratedSecurity=false;trustServerCertificate=true;";
        String dbUsername = "sa";
        String dbPassword = "root";

        try {
            con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
            pst = con.prepareStatement(query);
            pst.setString(1, month);
            rs = pst.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            tableModel.setColumnCount(0);

            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            tableModel.setRowCount(0);

            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(rowData);
            }

            System.out.println("Ended...");
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DisplayAnniversaryDate("Jan").setVisible(true));
    }
}
