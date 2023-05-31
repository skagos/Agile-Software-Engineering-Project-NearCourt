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
import javax.swing.*;



public class ManageMyGroup extends JFrame {
    private Object[] userData;


    public ManageMyGroup(Object[] userData) {
        this.initComponents();
        this.userData = userData;
        printUserNamesAndIDs(userData);
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        kickBut = new javax.swing.JButton();
        readyBut = new javax.swing.JButton();
        kickBut.setText("Kick");
        readyBut.setText("READY");


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.jPanel1.setBackground(new Color(0, 153, 0));

        kickBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kickButActionPerformed(evt);
            }
        });

        readyBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readyButActionPerformed(evt);
            }
        });

        usergroupsTable = new javax.swing.JTable();
        readygroupsTable = new javax.swing.JTable();
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
                        "Group", "ID", "username"
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

        jLabel1.setBackground(new Color(255, 255, 255));
        jLabel1.setFont(new Font("Arial Black", 0, 14));
        jLabel1.setText("Manage MyGroup");
        readygroupsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{


                },
                new String[]{
                        "Group","midas"
                }
        ) {
            Class[] types = new Class[]{
                    Integer.class, Object.class
            };
            boolean[] canEdit = new boolean[]{
                    false,false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        jScrollPane2.setViewportView(readygroupsTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(18, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(readyBut)
                                                .addGap(155, 155, 155))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(126, 126, 126))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(kickBut, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(21, 21, 21))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(90, 90, 90))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(kickBut)
                                .addGap(10, 10, 10)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(readyBut)
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 259, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(103, Short.MAX_VALUE))
        );

        pack();
    }

        public static void printUserNamesAndIDs (Object[] userData){
            // Step 1: Establish the database connection
            String url = "jdbc:mysql://localhost:3306/nearcourt";
            String username = "root";
            String password = "";

            try {
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
                    javax.swing.table.DefaultTableModel model2 = (javax.swing.table.DefaultTableModel) readygroupsTable.getModel();
                    model.setRowCount(0);

                    while (rs.next()) {
                        int group = rs.getInt("group_id");
                        model2.addRow(new Object[]{group});
                        int userID = rs.getInt("user_id");
                        String name = rs.getString("name");

                        model.addRow(new Object[]{group, userID, name});
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


            int option = JOptionPane.showConfirmDialog(this, "Are you sure you want to kick this player?", "Confirmation", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
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


                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
        private void readyButActionPerformed (java.awt.event.ActionEvent evt) {
            int row = readygroupsTable.getSelectedRow();

            String url = "jdbc:mysql://localhost:3306/nearcourt";
            String username = "root";
            String password = "";

            try (Connection con = DriverManager.getConnection(url, username, password)) {
                ;
                String selectpeopleQuery = "SELECT joined_players,group_capacity FROM `groups` WHERE group_id = ? ";

                try (PreparedStatement stmt = con.prepareStatement(selectpeopleQuery)) {
                    int group_id = (Integer) usergroupsTable.getValueAt(row, 0);

                    stmt.setInt(1, group_id);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        int joined_players = rs.getInt("joined_players");
                        int group_capacity = rs.getInt("group_capacity");

                    if (joined_players == group_capacity) {
                        System.out.println(joined_players);
                        System.out.println(group_capacity);
                    }
                    else System.out.println("arxidia");
                }

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }






    private static javax.swing.JTable usergroupsTable;
    private static javax.swing.JTable readygroupsTable;
    private javax.swing.JButton kickBut;
    private javax.swing.JButton readyBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
}


