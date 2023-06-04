package org.example;

import  javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;


public class Payment extends javax.swing.JFrame {
    private Object[] userData;
    private javax.swing.JLabel jLabelAmount;
    private double amount;
    private boolean isPaid;
    public Payment(Object[] userData) {

        initComponents();
        this.userData = userData;
        // price = getPrice((int) userData[4]);
        //System.out.println("timi prwth" + price);
        amount = calculateAmount(userData);
        for (Object obj : userData) {
            System.out.println(obj.toString());
        }
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeWindow();
            }
        });
    }

    private void initComponents() {
        ImageIcon icon = new ImageIcon("D:\\Users\\Koukounaras\\Documents\\GitHub\\NearCourt-The-Easy-way-to-play\\Deadline5\\Project_code\\src\\main\\java\\org\\example\\Nearcourt.png");
        setIconImage(icon.getImage());
        jPanel1 = new javax.swing.JPanel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelName = new javax.swing.JLabel();
        jLabelNumber = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabelCVV = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButtonSubmit = new javax.swing.JButton();
        jLabelAmount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelName.setText("Name");

        jLabelNumber.setText("Number");

        jLabelCVV.setText("CVV");

        jLabelAmount.setText("Amount:");

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setText("MM/YY");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jButtonSubmit.setBackground(new java.awt.Color(102, 204, 0));
        jButtonSubmit.setText("Submit Payment");
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        jLabelAmount.setBackground(new java.awt.Color(0, 153, 0));
        jLabelAmount.setText("Amount");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(jButtonSubmit))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelAmount,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 124,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabelName,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                60,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelNumber,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                64,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addGroup(jPanel1Layout
                                                                                        .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(jLabelCVV)
                                                                                        .addComponent(jTextFieldName,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                161,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                        false)
                                                                                                .addGroup(jPanel1Layout
                                                                                                        .createSequentialGroup()
                                                                                                        .addComponent(
                                                                                                                jTextField3)
                                                                                                        .addGap(18, 18,
                                                                                                                18)
                                                                                                        .addComponent(
                                                                                                                jTextField4,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addComponent(
                                                                                                        jTextField2,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                        161,
                                                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                                .addGap(7, 7, 7)))))
                                .addContainerGap(37, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelName)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelNumber)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelCVV, javax.swing.GroupLayout.PREFERRED_SIZE, 14,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26,
                                        Short.MAX_VALUE)
                                .addComponent(jLabelAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSubmit)
                                .addContainerGap()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(109, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(17, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)));

        pack();

    }

    private boolean validateCardInfo() {
        String name = jTextFieldName.getText();
        String number = jTextField2.getText();
        String cvv = jTextField3.getText();
        String expiration = jTextField4.getText();

        if (name.isEmpty()) {
            isPaid = false;
            JOptionPane.showMessageDialog(this, "Name field cannot be empty.");
            return false;
        }

        if (number.length() != 12) {
            isPaid = false;
            JOptionPane.showMessageDialog(this, "Number should contain 12 digits.");
            return false;
        }

        if (cvv.length() != 3) {
            isPaid = false;
            JOptionPane.showMessageDialog(this, "CVV should contain 3 digits.");
            return false;
        }
        if (!expiration.matches("\\d{2}/\\d{2}")) {
            isPaid = false;
            JOptionPane.showMessageDialog(this, "Expiration should be in the format MM/YY.");
            return false;
        }

        return true;
    }

    public double calculateAmount(Object[] userData) {
        double amount = 0.0;

        try {
            // Establishing database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourt", "root", "");

            // Retrieving price from the court table
            PreparedStatement courtStmt = connection.prepareStatement("SELECT price FROM `court` WHERE court_id = ?");
            courtStmt.setInt(1, (int) userData[4]);
            ResultSet courtResult = courtStmt.executeQuery();

            if (courtResult.next()) {
                double price = courtResult.getDouble("price");

                // Retrieving group_capacity from the groups table
                PreparedStatement groupStmt = connection.prepareStatement("SELECT group_capacity FROM `groups` WHERE group_id = ?");
                groupStmt.setInt(1, (int) userData[5]);
                ResultSet groupResult = groupStmt.executeQuery();

                if (groupResult.next()) {
                    int groupCapacity = groupResult.getInt("group_capacity");

                    // Calculating amount
                    if (groupCapacity != 0) {
                        amount = price / groupCapacity;
                    } else {
                        amount = price;
                    }
                }

                groupStmt.close();
                courtStmt.close();
            } else {
                JOptionPane.showMessageDialog(this, "Court not found.");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jLabelAmount.setText("Amount: $" + amount);
        return amount;
    }


    private void addPayment ( double amount){
            try {
                // Establishing database connection
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourt", "root", "");

                // Inserting payment data into the payment table
                PreparedStatement paymentStmt = connection.prepareStatement("INSERT INTO payment (user_id, amount) VALUES (?, ?)");
                paymentStmt.setInt(1, (int) userData[0]);                                                              // Assuming userData[0] contains the user ID
                paymentStmt.setDouble(2, amount);                                                                      // Call calculateAmount method to get the amount
                paymentStmt.executeUpdate();

                paymentStmt.close();
                connection.close();

                JOptionPane.showMessageDialog(this, "Payment added successfully!");
                isPaid = true;
            } catch (SQLException e) {
                e.printStackTrace();
                isPaid = false;
                JOptionPane.showMessageDialog(this, "Failed to add payment.");
            }
        }
    private WindowCloseListener closeListener;

    public void setCloseListener(WindowCloseListener listener) {
        this.closeListener = listener;
    }

    // Call this method when the window is closing
    private void closeWindow() {
        if (closeListener != null) {
            closeListener.successfullPayment(isPaid);
        }
        dispose(); // Close the second window
    }



    private void jTextField3ActionPerformed (java.awt.event.ActionEvent evt){
            // TODO: Add your handling code here (if any)
        }

    private void jTextField4ActionPerformed (java.awt.event.ActionEvent evt){
            // TODO: Add your handling code here (if any)
        }

    private void jButtonSubmitActionPerformed (java.awt.event.ActionEvent evt){
        if (validateCardInfo()) {
                addPayment(amount);
            }
        }


    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelNumber;
    private javax.swing.JLabel jLabelCVV;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;

    }
