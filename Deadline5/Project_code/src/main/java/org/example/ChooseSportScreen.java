package org.example;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseSportScreen extends javax.swing.JFrame {

    private String selectedSport;
    private Object[] userData;



    public ChooseSportScreen(Object[] userData) {
        initComponents();
        this.userData = userData;
        addButtonActionListeners();
    }



    private void addButtonActionListeners() {
        // Add ActionListener to jButton1
        jButtonFootball.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform the action when jButton1 is clicked
                selectedSport = "Football";
                System.out.println("Football button clicked!");
                ShowChooseSportScreen();
                dispose(); // Close the MainFrame
            }
        });

        // Add ActionListener to jButton2
        jButtonBasketball.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform the action when jButton2 is clicked
                selectedSport = "Basketball";
                System.out.println("Basketball button clicked!");
                ShowChooseSportScreen();
                dispose(); // Close the MainFrame
            }
        });

        // Add ActionListener to jButton4
        jButtonTennis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform the action when jButton4 is clicked
                selectedSport = "Tennis";
                System.out.println("Tennis button clicked!");
                ShowChooseSportScreen();
                dispose(); // Close the MainFrame
            }
        });
    }

    private void ShowChooseSportScreen() {
        SportsCenter sportsCenter = new SportsCenter(selectedSport,userData);
        sportsCenter.requestnearbycourts();
        // Use the SportsCenter object as needed
    }



    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonFootball = new javax.swing.JButton();
        jButtonBasketball = new javax.swing.JButton();
        jButtonTennis = new javax.swing.JButton();
        jButtonAnother = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(0, 153, 0));
        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose Sport");

        jButtonFootball.setBackground(new java.awt.Color(0, 204, 0));
        jButtonFootball.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jButtonFootball.setText("Football");

        jButtonBasketball.setBackground(new java.awt.Color(255, 153, 0));
        jButtonBasketball.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jButtonBasketball.setText("Basketball");

        jButtonTennis.setBackground(new java.awt.Color(204, 255, 51));
        jButtonTennis.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jButtonTennis.setText("Tennis");

        jButtonAnother.setBackground(new java.awt.Color(255, 0, 0));
        jButtonAnother.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jButtonAnother.setText("Cancel Reservation");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jButtonFootball, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonBasketball, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonTennis, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonAnother, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(254, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonFootball, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButtonBasketball, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButtonTennis, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jButtonAnother, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }
    private javax.swing.JButton jButtonFootball;
    private javax.swing.JButton jButtonBasketball;
    private javax.swing.JButton jButtonTennis;

    private javax.swing.JButton jButtonAnother;
    private javax.swing.JLabel jLabel1;

}