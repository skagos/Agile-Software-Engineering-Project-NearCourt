package org.example;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AddFriendsPage extends javax.swing.JFrame {
    private DefaultListModel<String> friendsListModel;
    private Object[] userData;



    public AddFriendsPage(Object[] userData) {
        initComponents();
        this.userData = userData;

        friendsListModel = new DefaultListModel<>();
        jList1.setModel(friendsListModel);

        jTextArea1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFriendList();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFriendList();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateFriendList();
            }
        });
    }

    private void updateFriendList() {
        String searchText = jTextArea1.getText();

        if (searchText.isEmpty()) {
            getTeammates();
        } else {
            getUsername(searchText);
        }
    }

    private void getTeammates() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourt", "root", "")) {
            friendsListModel.clear();


            String groupQuery = "SELECT group_id FROM belongs_to WHERE user_id = ?";
            List<Integer> groupIds = new ArrayList<>();

            try (PreparedStatement groupStatement = connection.prepareStatement(groupQuery)) {
                groupStatement.setInt(1, (int) userData[0]); // Set parameter at index 1 for user_id

                try (ResultSet groupResultSet = groupStatement.executeQuery()) {
                    while (groupResultSet.next()) {
                        int groupId = groupResultSet.getInt("group_id");
                        groupIds.add(groupId);
                    }
                }
            }


            String query = "SELECT name FROM users WHERE users.user_id IN (SELECT b.user_id FROM belongs_to b WHERE b.group_id = ?) AND name <> ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                for (int groupId : groupIds) {
                    statement.setInt(1, groupId); // Set parameter at index 1 for groups_id
                    statement.setString(2, (String) userData[2]); // Set parameter at index 2 for name <> ?

                    try (ResultSet resultSet = statement.executeQuery()) {
                        while (resultSet.next()) {
                            String playerName = resultSet.getString("name");
                            friendsListModel.addElement(playerName);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
    }

    private void getUsername(String searchText) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourt", "root", "")) {
            friendsListModel.clear();
            String query = "SELECT name FROM users WHERE name LIKE ? AND name <> ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "%" + searchText + "%");
                statement.setString(2, (String) userData[2]); // Replace 'userData.getName()' with the appropriate method to get the specific value you want to exclude

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String username = resultSet.getString("name");
                        friendsListModel.addElement(username);
                    }
                    if (friendsListModel.isEmpty()) {
                        // Print a message when the list is empty
                        JOptionPane.showMessageDialog(this, "No usernames found.", "Empty List", JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to connect to the database.");
        }
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButtonSelect = new javax.swing.JButton();
        jButtonViewfriends = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));

        jLabel1.setBackground(new java.awt.Color(0, 153, 0));
        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Friends");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(205, 205, 205)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jTextArea1.setColumns(1);
        jTextArea1.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jTextArea1.setRows(1);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextArea1.setText("Add Friends"); // Set the text to be empty
        jScrollPane1.setViewportView(jTextArea1);

        jList1.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jList1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(jList1);

        jButtonSelect.setBackground(new java.awt.Color(0, 204, 102));
        jButtonSelect.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonSelect.setText("Select");
        jButtonSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendFriendRequest(e);
            }
            public void SendFriendRequest(ActionEvent e) {
                String selectedFriend = jList1.getSelectedValue();
                if (selectedFriend != null) {
                    int option = JOptionPane.showOptionDialog(AddFriendsPage.this,
                            "Are you sure you want to add " + selectedFriend + " as a friend?",
                            "Confirmation",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new Object[]{"Yes", "No"},
                            "No");

                    if (option == JOptionPane.YES_OPTION) {
                        // User clicked "Yes"
                        // Perform the action
                        System.out.println("Adding " + selectedFriend + " as a friend");

                        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourt", "root", "")) {
                            // Retrieve the user ID based on the selected friend's username
                            String getUserIdQuery = "SELECT user_id FROM users WHERE name = ?";
                            try (PreparedStatement getUserIdStatement = connection.prepareStatement(getUserIdQuery)) {
                                getUserIdStatement.setString(1, selectedFriend);
                                try (ResultSet userIdResult = getUserIdStatement.executeQuery()) {
                                    if (userIdResult.next()) {
                                        int userId = userIdResult.getInt("user_id");
                                        int senderId = (int) userData[0]; // Assuming userData[0] holds the sender's ID

                                        // Insert the data into the friend_req table
                                        String insertQuery = "INSERT INTO friend_req (sender_id, receiver_id) VALUES (?, ?)";
                                        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                                            insertStatement.setInt(1, senderId);
                                            insertStatement.setInt(2, userId);
                                            insertStatement.executeUpdate();
                                            System.out.println("Friend request sent successfully.");
                                        } catch (SQLException ex) {
                                            ex.printStackTrace();
                                            System.out.println("Failed to insert friend request into the database.");
                                        }
                                    } else {
                                        System.out.println("User ID not found for the selected friend.");
                                    }
                                }
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            System.out.println("Failed to connect to the database.");
                        }
                    } else if (option == JOptionPane.NO_OPTION) {
                        // User clicked "No"
                        // Perform alternative action or do nothing
                        System.out.println("Cancelled adding " + selectedFriend + " as a friend");
                    }
                } else {
                    JOptionPane.showMessageDialog(AddFriendsPage.this, "No friend selected.");
                }
            }
        });

        jButtonViewfriends.setBackground(new java.awt.Color(0, 153, 0));
        jButtonViewfriends.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jButtonViewfriends.setText("View Friends");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(113, 113, 113)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButtonSelect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(jScrollPane2)
                                                        .addComponent(jButtonViewfriends, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 116, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addComponent(jButtonViewfriends, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36))
        );

        pack();
    }
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JButton jButtonViewfriends;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    
}
