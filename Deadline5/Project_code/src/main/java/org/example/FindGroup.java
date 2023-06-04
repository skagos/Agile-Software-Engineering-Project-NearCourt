package org.example;//package org.example;

import javax.swing.*;
import java.sql.*;


public class FindGroup extends javax.swing.JFrame implements WindowCloseListener{
    private Object[] userData;

    public FindGroup(Object[] userData) {
        initComponents();
        this.userData = userData;
    }
    private void initComponents() {
        ImageIcon icon = new ImageIcon("D:\\Users\\Koukounaras\\Documents\\GitHub\\NearCourt-The-Easy-way-to-play\\Deadline5\\Project_code\\src\\main\\java\\org\\example\\Nearcourt.png");
        setIconImage(icon.getImage());

        jScrollPane1 = new javax.swing.JScrollPane();
        findGroupLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        groupsTable = new javax.swing.JTable();
        joinBut = new javax.swing.JButton();
        sportComboBox = new javax.swing.JComboBox<>();
        playersComboBox = new javax.swing.JComboBox<>();
        profileBut = new javax.swing.JButton();
        logoutBut = new javax.swing.JButton();
        findGroupsBut = new javax.swing.JButton();
        selectSportLabel = new javax.swing.JLabel();
        selectPlayersLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        findGroupLabel.setBackground(new java.awt.Color(0, 153, 0));
        findGroupLabel.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
        findGroupLabel.setForeground(new java.awt.Color(255, 255, 255));
        findGroupLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        findGroupLabel.setText("Find Group");
        findGroupLabel.setOpaque(true);


        groupsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                        {null, "", "", "", "",""},
                        {null, "", "", "", "",""},
                        {null, "", "", "", "",""},
                        {null, "", "", "", "",""},
                        {null, "", "", "", "",""},
                        {null, "", "", "", "",""},
                        {null, "", "", "", "",""},
                        {null, "", "", "", "",""},
                        {null, "", "", "", "",""},
                        {null, "", "", "", "",""},
                        {null, "", "", "", "",""},
                },
                new String [] {
                        "ID", "Court", "Date", "Sport", "Joined Players","Group Capacity"
                }
        ) {
            Class[] types = new Class [] {
                    Integer.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(groupsTable);

        joinBut.setBackground(new java.awt.Color(0, 204, 0));
        joinBut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        joinBut.setForeground(new java.awt.Color(255, 255, 255));
        joinBut.setText("Join");
        joinBut.setBorderPainted(false);
        joinBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButActionPerformed(evt);
            }
        });

        sportComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        sportComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Football", "Basket", "Tennis" }));

        playersComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        playersComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new Integer[] { 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22 }));

        profileBut.setBackground(new java.awt.Color(102, 153, 255));
        profileBut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileBut.setText("Profile");
        profileBut.setBorderPainted(false);
        profileBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButActionPerformed(evt);
            }
        });

        logoutBut.setBackground(new java.awt.Color(102, 153, 255));
        logoutBut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logoutBut.setText("LogOut");
        logoutBut.setBorderPainted(false);
        logoutBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButActionPerformed(evt);
            }
        });

        findGroupsBut.setBackground(new java.awt.Color(0, 51, 255));
        findGroupsBut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        findGroupsBut.setForeground(new java.awt.Color(255, 255, 255));
        findGroupsBut.setText("Find Groups");
        findGroupsBut.setBorderPainted(false);
        findGroupsBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getFilterGroupsData();
            }
        });

        selectSportLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        selectSportLabel.setText("Select Sport:");

        selectPlayersLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        selectPlayersLabel.setText("Select Players:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(271, 271, 271)
                                                .addComponent(joinBut))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGap(81, 95, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(263, 263, 263)
                                                                        .addComponent(findGroupsBut))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(107, 107, 107)
                                                                        .addComponent(selectSportLabel)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(sportComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(33, 33, 33)
                                                                        .addComponent(selectPlayersLabel)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(playersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(0, 0, Short.MAX_VALUE))))
                                .addContainerGap(175, Short.MAX_VALUE))
                        .addComponent(findGroupLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(profileBut)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(logoutBut))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(findGroupLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(profileBut)
                                        .addComponent(logoutBut))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(sportComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(playersComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(selectSportLabel)
                                        .addComponent(selectPlayersLabel))
                                .addGap(25, 25, 25)
                                .addComponent(findGroupsBut)
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(joinBut)
                                .addContainerGap(249, Short.MAX_VALUE))
        );

        pack();
        getAllGroupsData();
    }// </editor-fold>

    private void getFilterGroupsData() {
        // TODO add your handling code here:
        for(int i=0; i<6; i++){
            for (int j=0; j<10; j++){
                groupsTable.setValueAt("", j, i);
            }
        }
        String sport = (String) sportComboBox.getSelectedItem();
        int players = (int) playersComboBox.getSelectedItem();
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = con.prepareStatement("SELECT group_id,name,date,groups.sport,joined_players, group_capacity FROM `groups` INNER JOIN court ON court.court_id = groups.court_id WHERE groups.sport LIKE ? AND joined_players = ?;");
            stm.setString(1, sport);
            stm.setInt(2, players);
            ResultSet rslt = stm.executeQuery();
            ResultSetMetaData metaData = rslt.getMetaData();
            int numOfColumns = metaData.getColumnCount();
            int row = 0;
            while(rslt.next()){
                for(int i=1; i<=numOfColumns; i++){
                    groupsTable.setValueAt(rslt.getObject(i),row,i-1 );
                }
                row++;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    private void joinButActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        int row = groupsTable.getSelectedRow();
        int user_id = (int) userData[0];
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = con.prepareStatement("SELECT court_id FROM court WHERE court.name LIKE ?");
            String courtName = (String) groupsTable.getValueAt(row, 1);
            stm.setString(1, courtName);
            ResultSet rslt = stm.executeQuery();
            rslt.next();
            userData[4] = (int) rslt.getObject(1);
            userData[5] = (int) groupsTable.getValueAt(row, 0);
            privateGroupCheck();
        }catch(Exception e){
            System.out.println(e);}

    }

    private void privateGroupCheck(){
        int row = groupsTable.getSelectedRow();
        int user_id = (int) userData[0];
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            int groupId = (int) groupsTable.getValueAt(row, 0);
            PreparedStatement stm = con.prepareStatement("SELECT type FROM `groups` WHERE group_id = ?");
            stm.setInt(1,groupId);
            ResultSet rslt = stm.executeQuery();
            rslt.next();
            String type = (String) rslt.getObject(1);
            if(type.equals("private")){
                Payment payment = new Payment(userData);
                payment.setCloseListener(this);
                payment.setVisible(true);

            }else{
                stm = con.prepareStatement("INSERT INTO `belongs_to` (`user_id`, `court_id`, `group_id`) VALUES (?, ?, ?);");
                stm.setInt(1, (int) userData[0]);
                stm.setInt(2, (int) userData[4]);
                stm.setInt(3, (int) userData[5]);


                stm.executeUpdate();

                AddNotification(con, (int) userData[5], (int) userData[0]);

                int group_id = (int) groupsTable.getValueAt(row, 0);
                int players = (int) groupsTable.getValueAt(row, 4);
                players = players + 1;
                stm = con.prepareStatement("UPDATE `groups` SET joined_players = ? WHERE group_id = ?;");
                stm.setInt(2, group_id);
                stm.setInt(1, players);
                stm.executeUpdate();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private void logoutButActionPerformed(java.awt.event.ActionEvent evt){
        userData = null;
        User login = new User();
        login.setVisible(true);
        this.dispose();
    }
    public void successfullPayment(boolean isPaid) {
        // Use the returned value from the first window
        if(isPaid){
            this.updateGroupsData(userData);
        }else{
            JOptionPane.showMessageDialog(this, "The payment is declined.");
        }
    }

    private void updateGroupsData(Object[] userData){
        int row = groupsTable.getSelectedRow();
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            PreparedStatement stm;
            PreparedStatement stmnot;
            stm = con.prepareStatement("INSERT INTO `belongs_to` (`user_id`, `court_id`, `group_id`) VALUES (?, ?, ?);");
            stm.setInt(1, (int) userData[0]);
            stm.setInt(2, (int) userData[4]);
            stm.setInt(3, (int) userData[5]);


            stm.executeUpdate();

            AddNotification(con, (int) userData[5], (int) userData[0]);

            int group_id = (int) groupsTable.getValueAt(row, 0);
            int players = (int) groupsTable.getValueAt(row, 4);
            players = players + 1;
            stm = con.prepareStatement("UPDATE `groups` SET joined_players = ? WHERE group_id = ?;");
            stm.setInt(2, group_id);
            stm.setInt(1, players);
            stm.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    private void AddNotification(Connection con, int groupId, int userId) throws SQLException {
        PreparedStatement stm = con.prepareStatement("INSERT INTO `notifications` (date, user_id,group_id) VALUES ((SELECT date FROM `groups` WHERE group_id = ?), ?, ?);");
        stm.setInt(1, groupId);
        stm.setInt(2, userId);
        stm.setInt(3, groupId);
        stm.executeUpdate();
    }

    private void profileButActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        this.dispose();
        this.setVisible(false);
    }

    private void getAllGroupsData(){
        for(int i=0; i<6; i++){
            for (int j=0; j<10; j++){
                groupsTable.setValueAt("", j, i);
            }
        }
        String sport = (String) sportComboBox.getSelectedItem();
        int players = (int) playersComboBox.getSelectedItem();
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stm = con.createStatement();
            ResultSet rslt = stm.executeQuery("SELECT group_id,name,date,groups.sport,joined_players, group_capacity FROM `groups` INNER JOIN court ON court.court_id = groups.court_id;");
            ResultSetMetaData metaData = rslt.getMetaData();
            int numOfColumns = metaData.getColumnCount();
            int row = 0;
            while(rslt.next()){
                for(int i=1; i<=numOfColumns; i++){
                    groupsTable.setValueAt(rslt.getObject(i),row,i-1 );
                }
                row++;
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }


    private static javax.swing.JButton findGroupsBut;
    private static javax.swing.JTable groupsTable;
    private javax.swing.JLabel findGroupLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JButton joinBut;
    private static javax.swing.JButton logoutBut;
    private static javax.swing.JComboBox<Integer> playersComboBox;
    private static javax.swing.JButton profileBut;
    private static javax.swing.JLabel selectPlayersLabel;
    private static javax.swing.JLabel selectSportLabel;
    private static javax.swing.JComboBox<String> sportComboBox;
    // End of variables declaration
}
