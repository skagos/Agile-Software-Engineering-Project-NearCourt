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
        jTextField1 = new javax.swing.JTextField();
        currentPassword = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (jTextField3.getText().isEmpty() && jTextField4.getText().isEmpty()) {
                    updateUsername();
                }

                else if (jTextField5.getText().isEmpty()) {
                    updatePassword();
                }
                else {
                    updateUsername();
                    updatePassword();
                }

            }
        });

        jTextField1.setText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
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

        jTextField3.setText("");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel4.setText("New Password:");

        jLabel5.setText("Confirm New Password:");

        jTextField4.setText("");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel6.setText("New Username:");

        jTextField5.setText("");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 102, 255));
        jButton1.setText("Change");



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
                                                .addComponent(jLabel6)
                                                .addGap(9, 9, 9)
                                                .addComponent(jTextField5))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jTextField4)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(currentPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addComponent(jButton1)
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
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addComponent(jButton1)
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

    private void updatePassword() {
        String currentPassword = jTextField1.getText();
        String newPassword = jTextField3.getText();
        String confirmNewPassword = jTextField4.getText();

        if (newPassword.isEmpty() || confirmNewPassword.isEmpty()) {
            // Either "New Password" or "Confirm New Password" is empty
            JOptionPane.showMessageDialog(EditProfilePage.this, "Please enter values for both New Password and Confirm New Password fields.","Change Personal Info Failed",JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!newPassword.equals(confirmNewPassword)) {
            // Passwords don't match, display an error message or handle it accordingly
            JOptionPane.showMessageDialog(EditProfilePage.this, "Passwords don't match!", "Change Personal Info Failed",JOptionPane.ERROR_MESSAGE);
            System.out.println("Passwords don't match!");
            return;
        }

        if (newPassword.length() < 8 || !newPassword.matches(".*\\d.*") || !newPassword.matches(".*[a-zA-Z].*")) {
            // Password does not meet the criteria
            JOptionPane.showMessageDialog(EditProfilePage.this, "The password must be at least 8 characters long and contain both numbers and letters.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
            System.out.println("Invalid password format!");
            return;
        }

        // Database connection and update logic
        try {
            // Establish the database connection
            String url = "jdbc:mysql://localhost:3306/nearcourt";
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url, username, password);

            String currentPasswordSql = "SELECT password FROM users WHERE user_id = ?";
            PreparedStatement currentPasswordStatement = conn.prepareStatement(currentPasswordSql);
            currentPasswordStatement.setInt(1, (int) userData[0]);

            ResultSet currentPasswordResult = currentPasswordStatement.executeQuery();
            if (currentPasswordResult.next()) {
                String storedPassword = currentPasswordResult.getString("password");

                if (!storedPassword.equals(currentPassword)) {
                    // Current password does not match the one stored in the database
                    JOptionPane.showMessageDialog(EditProfilePage.this, "Current password is incorrect.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Current password is incorrect!");
                    return;
                }
            } else {
                // No user record found, handle the error or display a message accordingly
                JOptionPane.showMessageDialog(EditProfilePage.this, "Failed to retrieve user record.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
                System.out.println("Failed to retrieve user record!");
                return;
            }

            // Prepare the SQL statement
            String sql = "UPDATE users SET password = ? WHERE user_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);

            // Set the parameters for the SQL statement
            statement.setString(1, newPassword);
            statement.setInt(2, (int) userData[0]);

            // Execute the update
            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                // The user record was updated successfully
                JOptionPane.showMessageDialog(EditProfilePage.this, "Success password change!");
            } else {
                // No rows were updated, handle the error or display a message accordingly
                JOptionPane.showMessageDialog(EditProfilePage.this, "Failed to update user record!","Change Personal Info Failed",JOptionPane.ERROR_MESSAGE);
                System.out.println("Failed to update user record!");
            }

            // Close the database connection and statement
            statement.close();
            conn.close();
        } catch (SQLException e) {
            // Handle any database errors
            e.printStackTrace();
        }
    }

   /* private void updateUsername() {
        String currentPassword = jTextField1.getText();
        String newUsername = jTextField5.getText();

        if (currentPassword.isEmpty() || newUsername.isEmpty()) {
            // Either "Current Password" or "New Username" is empty
            JOptionPane.showMessageDialog(EditProfilePage.this, "Please enter values for both Current Password and New Username fields.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Database connection and update logic
        try {
            // Establish the database connection
            String url = "jdbc:mysql://localhost:3306/nearcourtdatabase";
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url, username, password);

            // Check if the current password is correct
            String currentPasswordSql2 = "SELECT password FROM users WHERE user_id = ?";
            PreparedStatement currentPasswordSql2Stmt = conn.prepareStatement(currentPasswordSql2);
            currentPasswordSql2Stmt.setInt(1, (int) userData[0]);
            //checkPasswordStmt.setString(2, currentPassword);

            ResultSet currentPassword2Result = currentPasswordSql2Stmt.executeQuery();

            if (currentPassword2Result.next()) {
                String storedPassword = currentPassword2Result.getString("password");

                if (!storedPassword.equals(currentPassword)) {
                    // Current password does not match the one stored in the database
                    JOptionPane.showMessageDialog(EditProfilePage.this, "Current password is incorrect.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Current password is incorrect!");
                    return;
                }
            }else {
                // No user record found, handle the error or display a message accordingly
                JOptionPane.showMessageDialog(EditProfilePage.this, "Failed to retrieve user record.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
                System.out.println("Failed to retrieve user record!");
                return;
            }

            String updateUsernameSql = "UPDATE users SET name = ? WHERE user_id = ?";
            PreparedStatement updateUsernameStmt = conn.prepareStatement(updateUsernameSql);
            updateUsernameStmt.setString(1, newUsername);
            updateUsernameStmt.setInt(2, (int) userData[0]);

            // Execute the update
            int rowsUpdated = updateUsernameStmt.executeUpdate();

            if (rowsUpdated > 0) {
                // The username was updated successfully
                JOptionPane.showMessageDialog(EditProfilePage.this, "Success! Username has been updated.");
            } else {
                // No rows were updated, handle the error or display a message accordingly
                JOptionPane.showMessageDialog(EditProfilePage.this, "Failed to update username.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
                System.out.println("Failed to update username.");
            }
            updateUsernameStmt.close();
            conn.close();

        } catch (SQLException e) {
            // Handle any database errors
            e.printStackTrace();
        }
    }*/

    private void updateUsername() {
        String currentPassword = jTextField1.getText();
        String newUsername = jTextField5.getText();
        String newPassword = jTextField3.getText();
        String confirmNewPassword = jTextField4.getText();

        if (currentPassword.isEmpty() || newUsername.isEmpty()) {
            // Either "Current Password" or "New Username" is empty
            JOptionPane.showMessageDialog(EditProfilePage.this, "Please enter values for both Current Password and New Username fields.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (newPassword.isEmpty() || confirmNewPassword.isEmpty()) {
            // Either "New Password" or "Confirm New Password" is empty
            JOptionPane.showMessageDialog(EditProfilePage.this, "Please enter values for both New Password and Confirm New Password fields.","Change Personal Info Failed",JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!validatePassword(currentPassword)) {
            // Current password is incorrect
            JOptionPane.showMessageDialog(EditProfilePage.this, "Current password is incorrect.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
            System.out.println("Current password is incorrect!");
            return;
        }
        if (newPassword.length() < 8 || !newPassword.matches(".*\\d.*") || !newPassword.matches(".*[a-zA-Z].*")) {
            // Password does not meet the criteria
            JOptionPane.showMessageDialog(EditProfilePage.this, "The password must be at least 8 characters long and contain both numbers and letters.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
            System.out.println("Invalid password format!");
            return;
        }

        // Database connection and update logic
        try {
            // Establish the database connection
            String url = "jdbc:mysql://localhost:3306/nearcourt";
            String username = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url, username, password);

            String updateUsernameSql = "UPDATE users SET name = ? WHERE user_id = ?";
            PreparedStatement updateUsernameStmt = conn.prepareStatement(updateUsernameSql);
            updateUsernameStmt.setString(1, newUsername);
            updateUsernameStmt.setInt(2, (int) userData[0]);

            // Execute the update
            int rowsUpdated = updateUsernameStmt.executeUpdate();

            if (rowsUpdated > 0) {
                // The username was updated successfully
                JOptionPane.showMessageDialog(EditProfilePage.this, "Success! Username has been updated.");
            } else {
                // No rows were updated, handle the error or display a message accordingly
                JOptionPane.showMessageDialog(EditProfilePage.this, "Failed to update username.", "Change Personal Info Failed", JOptionPane.ERROR_MESSAGE);
                System.out.println("Failed to update username.");
            }
            updateUsernameStmt.close();
            conn.close();

        } catch (SQLException e) {
            // Handle any database errors
            e.printStackTrace();
        }
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


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }







    private javax.swing.JButton jButton1;
    private javax.swing.JLabel currentPassword;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration
}
