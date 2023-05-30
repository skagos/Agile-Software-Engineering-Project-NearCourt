package org.example;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSetMetaData;


public class ManageMyGroup extends JFrame {
    private Object[] userData;

    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public ManageMyGroup(Object[] userData) {
        this.initComponents();
        this.userData = userData;
        printUserNamesAndIDs(userData);
    }

    private void initComponents() {
        this.usergroupsTable = new JTable();
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        kickBut = new javax.swing.JButton();
        this.jLabel1 = new JLabel();
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBackground(new Color(0, 153, 0));
        this.kickBut.setText("Kick");
        this.kickBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ManageMyGroup.this.kickButActionPerformed(evt);
            }
        });
        usergroupsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, "", ""},
                        {null, "", ""},
                        {null, "", ""},
                        {null, "", ""},
                        {null, "", ""},
                        {null, "", ""},
                        {null, "", ""},
                        {null, "", ""},
                        {null, "", ""},
                        {null, "", ""},
                        {null, "", ""},
                },
                new String[]{
                        "Group","ID", "username"
                }
        ) {
            Class[] types = new Class[]{
                    Integer.class, Object.class, Object.class
            };
            boolean[] canEdit = new boolean[]{
                    false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(usergroupsTable);
        this.jLabel1.setBackground(new Color(255, 255, 255));
        this.jLabel1.setFont(new Font("Arial Black", 0, 14));
        this.jLabel1.setText("Manage MyGroup");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1).addContainerGap()).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 40, 32767).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1, -2, 141, -2).addGap(31, 31, 31)).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.kickBut, -2, 81, -2).addGap(69, 69, 69)))))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(21, 32767).addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 137, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.kickBut).addGap(18, 18, 18)));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(88, 88, 88).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(94, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(32, 32767).addComponent(this.jPanel1, -2, -1, -2).addGap(24, 24, 24)));
        this.pack();
    }

    public static void printUserNamesAndIDs(Object[] userData) {
        // Step 1: Establish the database connection
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";

        try  {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            int groupID = 0;
            String selectGroupIDQuery = "SELECT users.user_id, group_id, users.name FROM `belongs_to` INNER JOIN `users` ON users.user_id=belongs_to.user_id WHERE group_id IN (SELECT group_id FROM `groups` WHERE owner_id = ?) AND belongs_to.user_id != ? ;";
            //String selectGroupIDQuery = "SELECT group_id FROM `groups` WHERE owner_id = ?";

            try (PreparedStatement stmt = con.prepareStatement(selectGroupIDQuery)) {
                stmt.setInt(1, (int) userData[0]);
                stmt.setInt(2, (int) userData[0]);
                ResultSet rs = stmt.executeQuery();

                javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) usergroupsTable.getModel();
                model.setRowCount(0);

                while (rs.next()) {
                    int group = rs.getInt("group_id");
                    int userID = rs.getInt("user_id");
                    String name = rs.getString("name");

                    model.addRow(new Object[]{group,userID, name});
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    private void kickButActionPerformed (java.awt.event.ActionEvent evt){
        int row = usergroupsTable.getSelectedRow();
        System.out.println(row);
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = con.prepareStatement("DELETE FROM belongs_to WHERE group_id = ? AND user_id = ? ");
            int group = (Integer) usergroupsTable.getValueAt(row, 0);
            int user = (Integer) usergroupsTable.getValueAt(row, 1);

            stm.setInt(1, group);
            stm.setInt(2, user);

            int affectedRows = stm.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Row deleted successfully.");
            } else {
                System.out.println("No rows were deleted.");
            }



        }catch(Exception e){
            System.out.println(e);}
    }


    private static javax.swing.JTable usergroupsTable;
    private static javax.swing.JButton kickBut;

}


