package org.example;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RatePage extends javax.swing.JFrame {

    private Object[] userData;
    public RatePage(Object[] userData) {
        this.userData = userData;
        initComponents();
    }

    private void initComponents() {

        jLayeredPane2 = new javax.swing.JLayeredPane();
        mainRateLabel = new javax.swing.JLabel();
        ratePlayersLabel = new javax.swing.JLabel();
        rateCourtsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        ratePLabel = new javax.swing.JLabel();
        playerSlider = new javax.swing.JSlider();
        nameLabel = new javax.swing.JLabel();
        ratePlayerLabel = new javax.swing.JLabel();
        submitPlayerRate = new javax.swing.JButton();
        courtSlider = new javax.swing.JSlider();
        rateCLabel = new javax.swing.JLabel();
        submitCourtRate1 = new javax.swing.JButton();
        rateCourtLabel = new javax.swing.JLabel();
        playersTextField = new javax.swing.JTextField();
        courtsTextField = new javax.swing.JTextField();

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
                jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 400, Short.MAX_VALUE)
        );
        jLayeredPane2Layout.setVerticalGroup(
                jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        mainRateLabel.setBackground(new java.awt.Color(0, 204, 0));
        mainRateLabel.setFont(new java.awt.Font("Tw Cen MT", 1, 36)); // NOI18N
        mainRateLabel.setForeground(new java.awt.Color(255, 255, 255));
        mainRateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainRateLabel.setText("Rate Players & Courts");
        mainRateLabel.setOpaque(true);

        ratePlayersLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ratePlayersLabel.setText("Rate Players");

        rateCourtsLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rateCourtsLabel.setText("Rate Courts");


        getCourtHistory();
        getPlayers();

        ratePLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        ratePLabel.setText("Rate: 1/5");

        playerSlider.setMaximum(4);
        playerSlider.setPaintLabels(true);
        playerSlider.setPaintTicks(true);
        playerSlider.setSnapToTicks(true);
        playerSlider.setValue(1);
        playerSlider.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        playerSlider.setInheritsPopupMenu(true);
        playerSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                playerSliderStateChanged(evt);
            }
        });

        ratePlayerLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ratePlayerLabel.setText("Rate for:");

        submitPlayerRate.setBackground(new java.awt.Color(102, 255, 102));
        submitPlayerRate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        submitPlayerRate.setForeground(new java.awt.Color(255, 255, 255));
        submitPlayerRate.setText("Submit");
        submitPlayerRate.setBorderPainted(false);
        submitPlayerRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeDataPlayer(evt);
            }
        });

        courtSlider.setMaximum(4);
        courtSlider.setPaintLabels(true);
        courtSlider.setPaintTicks(true);
        courtSlider.setSnapToTicks(true);
        courtSlider.setValue(1);
        courtSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                courtSliderStateChanged(evt);
            }
        });

        rateCLabel.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        rateCLabel.setText("Rate: 1/5");

        submitCourtRate1.setBackground(new java.awt.Color(102, 255, 102));
        submitCourtRate1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        submitCourtRate1.setForeground(new java.awt.Color(255, 255, 255));
        submitCourtRate1.setText("Submit");
        submitCourtRate1.setBorderPainted(false);
        submitCourtRate1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeDataCourt(evt);
            }
        });

        rateCourtLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rateCourtLabel.setText("Rate for:");

        playersTextField.setText("Write your rate");

        courtsTextField.setText("Write your rate");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainRateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(84, 84, 84)
                                                .addComponent(ratePlayersLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(nameLabel)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(ratePlayerLabel))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(30, 30, 30)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(playersTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                                                        .addComponent(jScrollPane2))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(rateCourtsLabel)
                                                .addGap(163, 163, 163))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(rateCourtLabel)
                                                .addGap(273, 273, 273))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jScrollPane1)
                                                        .addComponent(courtsTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                                                .addGap(149, 149, 149))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(playerSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(ratePLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(submitPlayerRate)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(courtSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(rateCLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(submitCourtRate1)))
                                .addGap(132, 132, 132))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(mainRateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ratePlayersLabel)
                                        .addComponent(rateCourtsLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(playersTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                        .addComponent(courtsTextField))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(nameLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(ratePlayerLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rateCourtLabel)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(playerSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(courtSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ratePLabel)
                                        .addComponent(submitPlayerRate)
                                        .addComponent(rateCLabel)
                                        .addComponent(submitCourtRate1))
                                .addGap(40, 40, 40))
        );

        pack();
        submitPlayerRate.setVisible(false);
        ratePLabel.setVisible(false);
        playerSlider.setVisible(false);
        ratePlayerLabel.setVisible(false);
        playersTextField.setVisible(false);
        submitCourtRate1.setVisible(false);
        rateCLabel.setVisible(false);
        courtSlider.setVisible(false);
        rateCourtLabel.setVisible(false);
        courtsTextField.setVisible(false);
    }

    private void getCourtHistory(){
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";
        List<String> courts = null;
        try {
            courts = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = con.prepareStatement("SELECT name FROM court WHERE court_id IN (SELECT court_id FROM `belongs_to` WHERE user_id=?);");
            stm.setInt(1, (int) userData[0]);
            ResultSet rslt = stm.executeQuery();
            while(rslt.next()){
                courts.add((String) rslt.getObject(1));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        List<String> finalcourrts = courts;
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = finalcourrts.toArray(new String[0]);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);
    }

    private void getPlayers(){
        List<String> users = null;
        try {
            String url = "jdbc:mysql://localhost:3306/nearcourt";
            String username = "root";
            String password = "";
            users = new ArrayList<>();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = con.prepareStatement("SELECT name FROM users WHERE user_id IN(SELECT user_id FROM belongs_to WHERE group_id IN (SELECT group_id FROM `belongs_to` WHERE user_id = ?) AND user_id != ?);");
            stm.setInt(1, (int) userData[0]);
            stm.setInt(2, (int) userData[0]);
            ResultSet rslt = stm.executeQuery();
            while(rslt.next()){
                users.add((String) rslt.getObject(1));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        List<String> finalusers = users;
        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = finalusers.toArray(new String[0]);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jList2);
    }

    private void playerSliderStateChanged(javax.swing.event.ChangeEvent evt) {
        int rate = playerSlider.getValue() + 1;
        ratePLabel.setText("Rate: " + rate + "/5");
    }

    private void courtSliderStateChanged(javax.swing.event.ChangeEvent evt) {
        int rate = courtSlider.getValue() + 1;
        rateCLabel.setText("Rate: " + rate + "/5");
    }

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        ratePlayerLabel.setText("Rate: "+jList2.getSelectedValue());
        showRatePage(true);
    }

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        rateCourtLabel.setText("Rate: "+jList1.getSelectedValue());
        showRatePage(false);
    }
    private void showRatePage(boolean player){
        if(player) {
            submitPlayerRate.setVisible(true);
            ratePLabel.setVisible(true);
            playerSlider.setVisible(true);
            ratePlayerLabel.setVisible(true);
            playersTextField.setVisible(true);
        }else{
            submitCourtRate1.setVisible(true);
            rateCLabel.setVisible(true);
            courtSlider.setVisible(true);
            rateCourtLabel.setVisible(true);
            courtsTextField.setVisible(true);
        }
    }

    private void storeDataPlayer(java.awt.event.ActionEvent evt) {
        int stars = playerSlider.getValue();
        String playerComment = playersTextField.getText();
        if(playerComment.equals("Write your rate")){
            JOptionPane.showMessageDialog(this, "Please insert a rate!");
        }else {
            String url = "jdbc:mysql://localhost:3306/nearcourt";
            String username = "root";
            String password = "";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement stm = con.prepareStatement("SELECT user_id FROM users WHERE name = ?;");
                stm.setString(1, jList2.getSelectedValue());
                ResultSet rslt = stm.executeQuery();
                rslt.next();
                int userId = rslt.getInt(1);
                stm = con.prepareStatement("INSERT INTO rates (rate,stars,rate_id,user_id) VALUES (?, ?, DEFAULT, ?)");
                stm.setString(1, playerComment);
                stm.setInt(2, stars);
                stm.setInt(3, userId);
                stm.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(this, "Your rate has been submitted!");
        }
    }

    private void storeDataCourt(java.awt.event.ActionEvent evt) {
        int stars = courtSlider.getValue();
        String courtComment = courtsTextField.getText();
        if(courtComment.equals("Write your rate")){
            JOptionPane.showMessageDialog(this, "Please insert a rate!");
        }else {
            String url = "jdbc:mysql://localhost:3306/nearcourt";
            String username = "root";
            String password = "";
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement stm = con.prepareStatement("SELECT court_id FROM court WHERE name = ?;");
                stm.setString(1, jList1.getSelectedValue());
                ResultSet rslt = stm.executeQuery();
                rslt.next();
                int courtId = rslt.getInt(1);
                stm = con.prepareStatement("INSERT INTO courts_rate (rate_id,stars,rate,court_id) VALUES (DEFAULT, ?, ?, ?)");
                stm.setInt(1, stars);
                stm.setString(2, courtComment);
                stm.setInt(3, courtId);
                stm.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(this, "Your rate has been submitted!");
        }
    }


    // Variables declaration
    private static javax.swing.JSlider courtSlider;
    private static javax.swing.JTextField courtsTextField;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JLabel mainRateLabel;
    private static javax.swing.JLabel nameLabel;
    private static javax.swing.JSlider playerSlider;
    private static javax.swing.JTextField playersTextField;
    private static javax.swing.JLabel rateCLabel;
    private static javax.swing.JLabel rateCourtLabel;
    private static javax.swing.JLabel rateCourtsLabel;
    private static javax.swing.JLabel ratePLabel;
    private static javax.swing.JLabel ratePlayerLabel;
    private static javax.swing.JLabel ratePlayersLabel;
    private static javax.swing.JButton submitCourtRate1;
    private static javax.swing.JButton submitPlayerRate;
    // End of variables declaration
}
