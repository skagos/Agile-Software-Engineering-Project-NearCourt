package org.example;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditProfilePage extends javax.swing.JFrame {

    private Object[] userData;

    public EditProfilePage(Object[] userData) {
        initComponents();
        this.userData = userData;


    }
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CurPs = new javax.swing.JTextField();
        currentPassword = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        NewPass = new javax.swing.JTextField();
        jLabelnewpas = new javax.swing.JLabel();
        jLabelconfnewpass = new javax.swing.JLabel();
        ConfNewPass = new javax.swing.JTextField();
        jLabelnewUname = new javax.swing.JLabel();
        NewUname = new javax.swing.JTextField();
        jButtonChange = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonChange.setBackground(new java.awt.Color(102, 102, 255));
        jButtonChange.setText("Change");
        jButtonChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserData();
            }
        });
        CurPs.setText("");
        CurPs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurPsActionPerformed(evt);
            }
        });

        currentPassword.setText("Current Password:");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setText("Personal Info");

        jPanel2.setBackground(new java.awt.Color(0, 153, 51));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel3.setText("Change Username/Password");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(54, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                                .addContainerGap())
        );

        NewPass.setText("");
        NewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewPassActionPerformed(evt);
            }
        });

        jLabelnewpas.setText("New Password:");

        jLabelconfnewpass.setText("Confirm New Password:");

        ConfNewPass.setText("");
        ConfNewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfNewPassActionPerformed(evt);
            }
        });

        jLabelnewUname.setText("New Username:");

        NewUname.setText("");
        NewUname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewUnameActionPerformed(evt);
            }
        });

        jButtonChange.setBackground(new java.awt.Color(102, 102, 255));
        jButtonChange.setText("Change");



        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelnewUname)
                                                .addGap(9, 9, 9)
                                                .addComponent(NewUname))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabelconfnewpass)
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(NewPass, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(CurPs)
                                                        .addComponent(ConfNewPass)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelnewpas, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(currentPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jButtonChange)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(currentPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CurPs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(NewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelnewpas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ConfNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelconfnewpass, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelnewUname, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NewUname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jButtonChange)
                                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }
    private void updateUserData() {
        String currentPassword = CurPs.getText();
        String newUsername = NewUname.getText();
        String newPassword = NewPass.getText();
        String confirmNewPassword = ConfNewPass.getText();
        String oldUsername = (String) userData[2];
        String oldPassword = (String) userData[3];

        if (currentPassword.isEmpty()) {
            // Either "Current Password" or "New Username" is empty
            JOptionPane.showMessageDialog(EditProfilePage.this, "Please enter value for both Current Password ", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }

        
        if (!validatePasswordForm(newPassword) && !newPassword.isEmpty()) {
            // Password does not meet the criteria
            JOptionPane.showMessageDialog(EditProfilePage.this, "The password must be at least 8 characters long and contain both numbers and letters.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
            System.out.println("Invalid password format!");
            return;
        }
        if (!validatePassword(currentPassword)) {
            // Current password is incorrect
            JOptionPane.showMessageDialog(EditProfilePage.this, "Current password is incorrect.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
            System.out.println("Current password is incorrect!");
            return;
        }

        if (newUsername.isEmpty()) {

            newUsername = (String) userData[2];
        }else{
            newUsername = NewUname.getText();
            userData[2] = NewUname.getText();
        }

        if (newPassword.isEmpty()) {
            newPassword = (String) userData[3];
            confirmNewPassword = (String) userData[3];

        }
        else{
            newPassword = NewPass.getText();
            userData[3] = NewPass.getText();
        }

        if (!newPassword.equals(confirmNewPassword)) {
            JOptionPane.showMessageDialog(EditProfilePage.this, "Passwords don't match!", "Change Personal Info Failed",JOptionPane.ERROR_MESSAGE);
            System.out.println("Passwords don't match!");
            return;
        }

        // Database connection and update logic
        try {
            // Establish the database connection
            String url = "jdbc:mysql://localhost:3306/nearcourt";
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url, username, password);



            String sql = "UPDATE users SET password = ? WHERE user_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newPassword);
            statement.setInt(2, (int) userData[0]);

            statement.executeUpdate();

            String updateUsernameSql = "UPDATE users SET name = ? WHERE user_id = ?";
            PreparedStatement updateUsernameStmt = conn.prepareStatement(updateUsernameSql);
            updateUsernameStmt.setString(1, newUsername);
            updateUsernameStmt.setInt(2, (int) userData[0]);

            // Execute the update
            updateUsernameStmt.executeUpdate();

            if(newPassword.equals(oldPassword) && !newUsername.equals(oldUsername) ){
                JOptionPane.showMessageDialog(EditProfilePage.this, "Success! Username has been updated");
            }
            else if (newUsername.equals(oldUsername) && !newPassword.equals(oldPassword)) {
                JOptionPane.showMessageDialog(EditProfilePage.this, "Success! Password has been updated");
            }
            else if (!newPassword.equals(oldPassword) && !newUsername.equals(oldUsername) ) {
                JOptionPane.showMessageDialog(EditProfilePage.this, "Success! Password and Username has been updated");
            }
            else{
                JOptionPane.showMessageDialog(EditProfilePage.this, "Failed", "Change Personal Info Failed, please insert data", JOptionPane.ERROR_MESSAGE);
            }

            statement.close();
            conn.close();

            updateUsernameStmt.close();
            conn.close();

        } catch (SQLException e) {
            // Handle any database errors
            e.printStackTrace();
        }
    }
    private boolean validatePasswordForm(String newPassword) {
        return newPassword.length() >= 8 && newPassword.matches(".*\\d.*") && newPassword.matches(".*[a-zA-Z].*");
    }


    private boolean validatePassword(String currentPassword) {
        try {
            // Establish the database connection
            String url = "jdbc:mysql://localhost:3306/nearcourt";
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url, username, password);

            // Check if the current password is correct
            String currentPasswordSql2 = "SELECT password FROM users WHERE user_id = ?";
            PreparedStatement currentPasswordSql2Stmt = conn.prepareStatement(currentPasswordSql2);
            currentPasswordSql2Stmt.setInt(1, (int) userData[0]);

            ResultSet currentPassword2Result = currentPasswordSql2Stmt.executeQuery();

            if (currentPassword2Result.next()) {
                String storedPassword = currentPassword2Result.getString("password");
                return storedPassword.equals(currentPassword);

            } else {
                // No user record found, handle the error or display a message accordingly
                JOptionPane.showMessageDialog(EditProfilePage.this, "Failed to retrieve user record.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
                System.out.println("Failed to retrieve user record!");
            }

            currentPasswordSql2Stmt.close();
            conn.close();

        } catch (SQLException e) {
            // Handle any database errors
            e.printStackTrace();
        }

        return false;
    }




    private void CurPsActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void NewPassActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void ConfNewPassActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void NewUnameActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }







    private javax.swing.JButton jButtonChange;
    private javax.swing.JLabel currentPassword;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelnewpas;
    private javax.swing.JLabel jLabelconfnewpass;
    private javax.swing.JLabel jLabelnewUname;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField CurPs;
    private javax.swing.JTextField NewPass;
    private javax.swing.JTextField ConfNewPass;
    private javax.swing.JTextField NewUname;
    // End of variables declaration
}
