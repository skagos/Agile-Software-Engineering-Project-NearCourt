package org.example;

import javax.swing.*;

public class ModifyOptionsPage extends javax.swing.JFrame {

    private Object[] userData;
    public ModifyOptionsPage(Object[] userData) {
        initComponents();
        this.userData = userData;
    }

    private void AddCourt() {
        AddCourtPage addCourtPage= new AddCourtPage();
        addCourtPage.setVisible(true);
        this.dispose();
    }
    private void showDeleteCourtPage() {
        DeleteCourtPage deleteCourtPage = new DeleteCourtPage();
        deleteCourtPage.setVisible(true);
        deleteCourtPage.getCourtsData();
        this.dispose();
    }
    private void showDeletePlayerPage() {
        DeletePlayerPage deletePlayerPage = new DeletePlayerPage();
        deletePlayerPage.setVisible(true);
        deletePlayerPage.getPlayerData();
        this.dispose();
    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
        ImageIcon icon = new ImageIcon("C:\\Users\\user\\Documents\\GitHub\\NearCourt-The-Easy-way-to-play\\Deadline5\\Project_code\\src\\main\\java\\org\\example\\Nearcourt.png");
        setIconImage(icon.getImage());
        modify_panel = new javax.swing.JPanel();
        modify_label = new javax.swing.JLabel();
        add_court = new javax.swing.JButton();
        delete_court = new javax.swing.JButton();
        delete_player = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        modify_panel.setBackground(new java.awt.Color(204, 204, 255));

        modify_label.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        modify_label.setText("Modify Application");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(modify_panel);
        modify_panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(modify_label)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(modify_label)
                                .addContainerGap(21, Short.MAX_VALUE))
        );

        add_court.setBackground(new java.awt.Color(102, 153, 255));
        add_court.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        add_court.setText("Add Court");

        delete_court.setBackground(new java.awt.Color(102, 153, 255));
        delete_court.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        delete_court.setText("Delete Court");

        delete_player.setBackground(new java.awt.Color(102, 153, 255));
        delete_player.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        delete_player.setText("Delete Player");
        delete_player.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_playerActionPerformed(evt);
            }
        });
        add_court.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_courtActionPerformed(evt);
            }
        });
        delete_court.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_courtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(modify_panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(add_court)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                                .addComponent(delete_court)
                                .addGap(37, 37, 37))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(delete_player)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(modify_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(add_court)
                                        .addComponent(delete_court))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                                .addComponent(delete_player)
                                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>

    private void delete_playerActionPerformed(java.awt.event.ActionEvent evt) {
        showDeletePlayerPage();
    }
    private void add_courtActionPerformed(java.awt.event.ActionEvent evt) {
        AddCourt();
    }
    private void delete_courtActionPerformed(java.awt.event.ActionEvent evt) {
        showDeleteCourtPage();
    }



    private javax.swing.JButton add_court;
    private javax.swing.JButton delete_court;
    private javax.swing.JButton delete_player;
    private javax.swing.JLabel modify_label;
    private javax.swing.JPanel modify_panel;
    // End of variables declaration
}
