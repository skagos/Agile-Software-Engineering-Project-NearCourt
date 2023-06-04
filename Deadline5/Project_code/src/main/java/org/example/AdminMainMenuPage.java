package org.example;

import javax.swing.*;

public class AdminMainMenuPage extends javax.swing.JFrame {

    private Object[] userData;
    public AdminMainMenuPage(Object[] userData) {
        this.initComponents();
        this.userData = userData;
        String username = (String) userData[2];
        this.welcome_label.setText("Welcome, " + username + "!");
    }
    private void ModifyApp() {
        ModifyOptionsPage modifyOptionsPage = new ModifyOptionsPage(this.userData);
        modifyOptionsPage.setVisible(true);
        this.dispose();
    }


    @SuppressWarnings("unchecked")

    private void initComponents() {
        ImageIcon icon = new ImageIcon("D:\\Users\\Koukounaras\\Documents\\GitHub\\NearCourt-The-Easy-way-to-play\\Deadline5\\Project_code\\src\\main\\java\\org\\example\\Nearcourt.png");
        setIconImage(icon.getImage());

        welcome_panel = new javax.swing.JPanel();
        welcome_label = new javax.swing.JLabel();
        gifts = new javax.swing.JButton();
        Modify_button = new javax.swing.JButton();
        incomes = new javax.swing.JButton();
        tsupport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        welcome_panel.setBackground(new java.awt.Color(204, 204, 255));

        welcome_label.setFont(new java.awt.Font("Arial Black", 0, 12));
        welcome_label.setText("Welcome Admin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(welcome_panel);
        welcome_panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(welcome_label)
                                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(welcome_label)
                                .addContainerGap(15, Short.MAX_VALUE))
        );

        gifts.setBackground(new java.awt.Color(0, 101, 66));
        gifts.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        gifts.setText("Give Gifts");
        gifts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Modify_button.setBackground(new java.awt.Color(0, 101, 66));
        Modify_button.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        Modify_button.setText("Modify Application");
        Modify_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        incomes.setBackground(new java.awt.Color(0, 101, 66));
        incomes.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        incomes.setText("Show incomes");

        tsupport.setBackground(new java.awt.Color(0, 101, 66));
        tsupport.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        tsupport.setText("Technical Support");
        tsupport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(incomes)
                                        .addComponent(gifts, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tsupport)
                                        .addComponent(Modify_button))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(53, Short.MAX_VALUE)
                                .addComponent(welcome_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(welcome_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(gifts)
                                        .addComponent(Modify_button))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(incomes)
                                        .addComponent(tsupport))
                                .addGap(61, 61, 61))
        );

        pack();
    }// </editor-fold>

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        AdminMainMenuPage.this.ModifyApp();
    }


    private javax.swing.JButton gifts;
    private javax.swing.JButton Modify_button;
    private javax.swing.JButton incomes;
    private javax.swing.JButton tsupport;
    private javax.swing.JLabel welcome_label;
    private javax.swing.JPanel welcome_panel;
    // End of variables declaration
}
