package org.example;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.List;


public class ChooseCourtScreen extends javax.swing.JFrame {

    private DefaultListModel<String> listModel;
    private Object[] userData;

    public ChooseCourtScreen(Object[] userData) {
        initComponents();
        // Initialize the DefaultListModel
        this.userData = userData;
        listModel = new DefaultListModel<>();

        jList1.setModel(listModel);

        // Set the listModel as the model for jList1
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setBackground(new java.awt.Color(51, 255, 0));

        jList1.setBackground(new java.awt.Color(0, 204, 0));
        jList1.setForeground(new java.awt.Color(153, 0, 153));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 102, 51));
        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose Court");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(163, 163, 163))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // Get the selected item from the JList
        String selectedValue = jList1.getSelectedValue();
        if (selectedValue != null) {
            // Print the selected item
            System.out.println("Selected item: " + selectedValue);
            JOptionPane.showMessageDialog(this, "You Selected " + selectedValue, "Success", JOptionPane.INFORMATION_MESSAGE);

            String url = "jdbc:mysql://localhost:3306/nearcourt";
            String username = "root";
            String password = "";
            String updateQuery = "UPDATE timetable SET availability = 1 WHERE time = ?";
            String insertQuery = "INSERT INTO reservation (user_id, court_id, time) VALUES (?, ?, ?)";

            try (Connection connection = DriverManager.getConnection(url, username, password);
                 PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                 PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {

                connection.setAutoCommit(false); // Disable auto-commit

                // Update timetable
                updateStatement.setString(1, selectedValue);
                int rowsUpdated = updateStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    // Get user_id from userData or wherever it is stored
                    int user_id = (int) userData[0];

                    // Retrieve court_id from the timetable based on selectedValue
                    int court_id = 0;
                    String courtIdQuery = "SELECT court_id FROM timetable WHERE time = ?";
                    try (PreparedStatement courtIdStatement = connection.prepareStatement(courtIdQuery)) {
                        courtIdStatement.setString(1, selectedValue);
                        try (ResultSet resultSet = courtIdStatement.executeQuery()) {
                            if (resultSet.next()) {
                                court_id = ((ResultSet) resultSet).getInt("court_id");
                            }
                        }
                    }

                    if (court_id != 0) {
                        // Insert into the reservation table
                        insertStatement.setInt(1, user_id);
                        insertStatement.setInt(2, court_id);
                        insertStatement.setString(3, selectedValue);
                        int rowsInserted = insertStatement.executeUpdate();

                        if (rowsInserted > 0) {
                            userData[4] = court_id;

                            connection.commit();
                            String courtType = null;
                            int courtId = 0;
                            String datett = null;
                            String timett = null;
                            String courtDataQuery = "SELECT court_type, court_id ,date , time FROM timetable WHERE time = ?";
                            try (PreparedStatement courtDataStatement = connection.prepareStatement(courtDataQuery)) {
                                courtDataStatement.setString(1, selectedValue);
                                try (ResultSet resultSet = courtDataStatement.executeQuery()) {
                                    if (resultSet.next()) {
                                        courtType = resultSet.getString("court_type");
                                        courtId = resultSet.getInt("court_id");
                                        datett = resultSet.getString("date");
                                        timett = resultSet.getString("time");
                                    }
                                }
                            }

                            if (courtType != null && courtId != 0) {

                                String groupInsertQuery = "INSERT INTO groups (group_capacity, owner_id, sport, court_id,joined_players,type,date,time) VALUES (?, ?, ?, ?, ? , ?, ?, ?)";
                                try (PreparedStatement groupInsertStatement = connection.prepareStatement(groupInsertQuery, Statement.RETURN_GENERATED_KEYS)) {
                                    int groupCapacity = 1;  // Set the group capacity value as required
                                    int joinedplayers = 1;
                                    String typeCourt = "private";
                                    int ownerId = (int) userData[0];  // Assuming userData[0] contains the owner_id
                                    groupInsertStatement.setInt(1, groupCapacity);
                                    groupInsertStatement.setInt(2, ownerId);
                                    groupInsertStatement.setString(3, courtType);
                                    groupInsertStatement.setInt(4, courtId);
                                    groupInsertStatement.setInt(5, joinedplayers);
                                    groupInsertStatement.setString(6, typeCourt);
                                    groupInsertStatement.setString(7, datett);
                                    groupInsertStatement.setString(8, timett);
                                    int rowsInsertedToGroups = groupInsertStatement.executeUpdate();
                                    if (rowsInsertedToGroups > 0) {
                                        connection.commit(); // Commit the changes


                                        int group_id = 0;
                                        try (ResultSet generatedKeys = groupInsertStatement.getGeneratedKeys()) {
                                            if (generatedKeys.next()) {
                                                group_id = generatedKeys.getInt(1);
                                                userData[5] = group_id;
                                            }
                                        }

                                        JOptionPane.showMessageDialog(this, "Updated availability, inserted reservation, created group, and added sport for " + selectedValue, "Success",
                                                JOptionPane.INFORMATION_MESSAGE);

                                        // Open the Payment class with userData object
                                        Payment payment = new Payment(userData);
                                        payment.setVisible(true);

                                        dispose();
                                    } else {
                                        connection.rollback();
                                        JOptionPane.showMessageDialog(this, "Failed to create group", "Error",
                                                JOptionPane.ERROR_MESSAGE);
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            connection.rollback();
                            JOptionPane.showMessageDialog(this, "Failed to insert reservation", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to retrieve court_id from timetable", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update availability", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            // No item selected error message
            JOptionPane.showMessageDialog(this, "No item selected!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    public void setItems(List<String> items) {
        for (String item : items) {
            listModel.addElement(item);
        }
    }


    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;

}