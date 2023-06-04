package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.lang.String;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class CreateGroupPage extends javax.swing.JFrame {

    private Object[] userData;
    int x=0;

    public CreateGroupPage(Object[] userData) {
        initComponents();
        this.userData = userData;
    }

    private void ValidateGroup(int type,String s,String n){
        String datee =((JTextField)date.getDateEditor().getUiComponent()).getText();
        String datees =((JTextField)date1.getDateEditor().getUiComponent()).getText();
        String combor=combo_sport.getSelectedItem().toString();
        String comod=sportc.getSelectedItem().toString();
        String comora=private_players.getSelectedItem().toString();
        String comorai=public_players.getSelectedItem().toString();

        if ((type == 1) && ( datee.isEmpty() || s==combor || n==comora) ){

            // A field is not filled
            JOptionPane.showMessageDialog(CreateGroupPage.this, "All fields required!", "All fields required!", JOptionPane.ERROR_MESSAGE);

        }
        else  if ((type == 2) && ( datees.isEmpty() || s==comod || n==comorai) ){
            // A field is not filled
            JOptionPane.showMessageDialog(CreateGroupPage.this, "All fields required!", "All fields required!", JOptionPane.ERROR_MESSAGE);

        }
        else if((type == 1) && (!( datee.isEmpty() || s==combor || n==comora)) ) {

            PrivateGroupCheck(1);
            getPrivateCompatableCourts();
        }
        else if((type == 2) && (!( datees.isEmpty() || s==comod || n==comorai)) ) {

            PrivateGroupCheck(2);
            getPublicCompatableCourts();
        }
    }

    private void PrivateGroupCheck(int type){

        if(  type == 1 ){
            JOptionPane.showMessageDialog(CreateGroupPage.this, "You choose PRIVATE court");
        }else{ JOptionPane.showMessageDialog(CreateGroupPage.this, "You choose PUBLIC court");}
    }

    private void UpdatePublicGroupsData(String s,int i){

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourt", "root", "");
            PreparedStatement insertPs = con.prepareStatement("INSERT INTO `groups` (type,sport,date,group_capacity,time,owner_id,court_id,joined_players) values(?,?,?,?,?,?,?,1)");

            String combo = sportc.getSelectedItem().toString();
            String  combo2 = public_players.getSelectedItem().toString();
            String selectdate = ((JTextField) date1.getDateEditor().getUiComponent()).getText();
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(selectdate);
            insertPs.setString(5, s);
            insertPs.setString(2,combo);
            insertPs.setDate(3, new java.sql.Date(date1.getTime()));
            insertPs.setString(4,combo2);
            insertPs.setInt(6,(int) userData[0]);
            insertPs.setString(1,"public");
            insertPs.setInt(7,i);


            insertPs.executeUpdate();
            AddNotification(con, date1, (int) userData[0],(int) userData[5]);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void UpdatePrivateGroupsData(String s,int i,Object[] userData){
        try{
            String combo = combo_sport.getSelectedItem().toString();
            String combo2 = private_players.getSelectedItem().toString();
            String selectdate = ((JTextField) date.getDateEditor().getUiComponent()).getText();
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(selectdate);

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourt", "root", "");
            PreparedStatement insertPs = con.prepareStatement("INSERT INTO `groups`(type,sport,date,group_capacity,time,owner_id,court_id,joined_players) values(?,?,?,?,?,?,?,1)");
            insertPs.setString(5, s);
            insertPs.setString(2, combo);
            insertPs.setDate(3, new java.sql.Date(date1.getTime()));

            insertPs.setString(4, combo2);
            insertPs.setInt(6, (int) userData[0]);
            insertPs.setString(1, "private");
            insertPs.setInt(7,i);

            insertPs.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void AddNotification(Connection con, Date date1, int userId,int groupId) throws SQLException {
        PreparedStatement insertNotification = con.prepareStatement("INSERT INTO `notifications`(date,user_id,group_id) values(?,?,?)");
        insertNotification.setDate(1, new java.sql.Date(date1.getTime()));
        insertNotification.setInt(2, userId);
        insertNotification.setInt(3, groupId);
        insertNotification.executeUpdate();
    }

    private void getPrivateCompatableCourts() {


        try {
            String combo, combo2;
            combo = combo_sport.getSelectedItem().toString();
            String selectdate = ((JTextField) date.getDateEditor().getUiComponent()).getText();
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(selectdate);
            combo2 = private_players.getSelectedItem().toString();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourt", "root", "");
            PreparedStatement ps = con.prepareStatement("SELECT time,court_id FROM timetable WHERE court_type = ? AND date = ? AND number_of_players >= ? AND Availability = 0");
            ps.setString(1, combo);
            ps.setDate(2, new java.sql.Date(date1.getTime()));
            ps.setString(3, combo2);

            ResultSet rs = ps.executeQuery();

            DefaultTableModel tableModel = new DefaultTableModel();

            // Add columns to the table model
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            // Add rows to the table model
            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(rowData);
            }

            JTable table = new JTable(tableModel);
            JScrollPane scrollPane = new JScrollPane(table);

            int result = JOptionPane.showConfirmDialog(this, scrollPane, "Select a row", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {

                    Object[] selectedRowData = new Object[columnCount];
                    for (int i = 0; i < columnCount; i++) {
                        selectedRowData[i] = tableModel.getValueAt(selectedRow, i);
                    }

                    String selectedTime = selectedRowData[0].toString();
                    int selectedCourtId = Integer.parseInt(selectedRowData[1].toString());
                    userData[4]=selectedCourtId;

                    UpdatePrivateGroupsData(selectedTime,selectedCourtId,userData);

                    PreparedStatement ferma = con.prepareStatement("SELECT group_id FROM `groups` WHERE type = ? AND sport = ? AND  date = ? AND group_capacity = ? AND time = ? AND owner_id = ?");

                    ferma.setString(5, selectedTime);
                    ferma.setString(2,combo);
                    ferma.setDate(3, new java.sql.Date(date1.getTime()));
                    ferma.setString(4,combo2);
                    ferma.setInt(6,(int) userData[0]);
                    ferma.setString(1,"private");


                    ResultSet rsr = ferma.executeQuery();

                    int selectedGroupId = -1; // Default value in case no group_id is found
                    if (rsr.next()) {
                        selectedGroupId = rsr.getInt("group_id");
                        userData[5]=selectedGroupId;

                        AddNotification(con, date1, (int) userData[0],selectedGroupId);
                    }

                    PreparedStatement lol = con.prepareStatement("UPDATE `timetable` SET availability = 1 WHERE time = ?");

                    lol.setString(1, selectedTime);
                    lol.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Success Create!");
                    Payment payment = new Payment(userData);
                    payment.setVisible(true);


                } else {
                    JOptionPane.showMessageDialog(this, "No row selected.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getPublicCompatableCourts(){

        {
            try {
                String combo, combo2;
                combo = sportc.getSelectedItem().toString();
                String selectdate = ((JTextField) date1.getDateEditor().getUiComponent()).getText();
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(selectdate);
                combo2 = public_players.getSelectedItem().toString();

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourt", "root", "");
                PreparedStatement ps = con.prepareStatement("SELECT time,court_id FROM `timetable` WHERE court_type = ? AND date = ? AND number_of_players >= ? AND Availability = 0");
                PreparedStatement insertPs = con.prepareStatement("INSERT INTO `groups` (type,sport,date,group_capacity,time,owner_id,court_id,joined_players) values(?,?,?,?,?,?,?,1)");
                ps.setString(1, combo);
                ps.setDate(2, new java.sql.Date(date1.getTime()));
                ps.setString(3, combo2);

                ResultSet rs = ps.executeQuery();

                DefaultTableModel tableModel = new DefaultTableModel();

                // Add columns to the table model
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    tableModel.addColumn(metaData.getColumnName(i));
                }

                // Add rows to the table model
                while (rs.next()) {
                    Object[] rowData = new Object[columnCount];
                    for (int i = 1; i <= columnCount; i++) {
                        rowData[i - 1] = rs.getObject(i);
                    }
                    tableModel.addRow(rowData);
                }

                JTable table = new JTable(tableModel);
                JScrollPane scrollPane = new JScrollPane(table);

                int result = JOptionPane.showConfirmDialog(this, scrollPane, "Select a row", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {

                        Object[] selectedRowData = new Object[columnCount];
                        for (int i = 0; i < columnCount; i++) {
                            selectedRowData[i] = tableModel.getValueAt(selectedRow, i);
                        }

                        String selectedTime = selectedRowData[0].toString();
                        int selectedCourtId = Integer.parseInt(selectedRowData[1].toString());

                        UpdatePublicGroupsData(selectedTime,selectedCourtId);

                        PreparedStatement lol = con.prepareStatement("UPDATE `timetable` SET availability = 1 WHERE time = ?");

                        lol.setString(1, selectedTime);
                        lol.executeUpdate();

                        JOptionPane.showMessageDialog(this, "Success Create!");
                    } else {
                        JOptionPane.showMessageDialog(this, "No row selected.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        ImageIcon icon = new ImageIcon("C:\\Users\\user\\Documents\\GitHub\\NearCourt-The-Easy-way-to-play\\Deadline5\\Project_code\\src\\main\\java\\org\\example\\Nearcourt.png");
        setIconImage(icon.getImage());
        pblc = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        private_players = new javax.swing.JComboBox<>();
        combo_sport = new javax.swing.JComboBox<>();
        show_available = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();
        cdate = new javax.swing.JTextField();
        public_panel = new javax.swing.JPanel();
        public_players = new javax.swing.JComboBox<>();
        sportc = new javax.swing.JComboBox<>();
        show_public = new javax.swing.JButton();
        date1 = new com.toedter.calendar.JDateChooser();
        choose_date = new javax.swing.JTextField();
        main_panel = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        private_players.setBackground(new java.awt.Color(102, 153, 255));
        private_players.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        private_players.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Number of players", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));

        combo_sport.setBackground(new java.awt.Color(102, 153, 255));
        combo_sport.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        combo_sport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sport", "Football", "Basket", "Tennis" }));
        combo_sport.setToolTipText("");
        combo_sport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo_sportMousePressed(evt);
            }
        });
        combo_sport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_sportActionPerformed(evt);
            }
        });

        show_available.setBackground(new java.awt.Color(102, 153, 255));
        show_available.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        show_available.setText("Show Available Courts");
        show_available.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_availableActionPerformed(evt);
            }
        });

        date.setDateFormatString("yyyy-MM-dd");
        date.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        cdate.setBackground(new java.awt.Color(102, 153, 255));
        cdate.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        cdate.setText("Choose Date:");
        cdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(84, 84, 84)
                                                .addComponent(show_available, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(private_players, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(cdate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(combo_sport, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(combo_sport, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cdate, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(45, 45, 45)
                                .addComponent(private_players, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(show_available, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(158, Short.MAX_VALUE))
        );

        pblc.addTab("Private Court", jPanel1);

        public_panel.setBackground(new java.awt.Color(255, 255, 255));
        public_panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        public_players.setBackground(new java.awt.Color(102, 153, 255));
        public_players.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        public_players.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Number of players", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));

        sportc.setBackground(new java.awt.Color(102, 153, 255));
        sportc.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        sportc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sport", "Football", "Basket", "Tennis" }));
        sportc.setToolTipText("");
        sportc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox4MousePressed(evt);
            }
        });
        sportc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        show_public.setBackground(new java.awt.Color(102, 153, 255));
        show_public.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        show_public.setText("Show Available Courts");
        show_public.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        date1.setDateFormatString("yyyy-MM-dd");
        date1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        choose_date.setBackground(new java.awt.Color(102, 153, 255));
        choose_date.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        choose_date.setText("Choose Date:");
        choose_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(public_panel);
        public_panel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(sportc, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(public_players, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(choose_date, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(42, 42, 42))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(show_public, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(sportc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(choose_date, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addComponent(public_players, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(show_public, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(151, Short.MAX_VALUE))
        );

        pblc.addTab("Public Court", public_panel);
        public_panel.getAccessibleContext().setAccessibleName("Private Court");

        main_panel.setBackground(new java.awt.Color(0, 153, 0));

        home.setBackground(new java.awt.Color(102, 153, 255));
        home.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        home.setText("HOME");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        title.setText("Create Group");


        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(main_panel);
        main_panel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 156, Short.MAX_VALUE)
                                .addComponent(title)
                                .addGap(119, 119, 119)
                                .addComponent(home))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(home)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(title)
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pblc, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(main_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pblc, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE))
                                //.addContainerGap(271, Short.MAX_VALUE))
        );

        pblc.getAccessibleContext().setAccessibleName("Create Group");
        pblc.getAccessibleContext().setAccessibleDescription("");

       // jPanel1.setPreferredSize(new Dimension(300, 300));
       // public_panel.setPreferredSize(new Dimension(300, 300));
        //main_panel.setPreferredSize(new Dimension(300, 300));



        pack();

    }// </editor-fold>

    private void combo_sportActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void combo_sportMousePressed(java.awt.event.MouseEvent evt) {
    }

    private void show_availableActionPerformed(java.awt.event.ActionEvent evt) {
        ValidateGroup(1,"Sport","Number of players");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jComboBox4MousePressed(java.awt.event.MouseEvent evt) {
    }

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        ValidateGroup(2,"Sport","Number of players");
    }

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private javax.swing.JComboBox<String> combo_sport;
    private com.toedter.calendar.JDateChooser date;
    private com.toedter.calendar.JDateChooser date1;
    private javax.swing.JButton home;
    private javax.swing.JButton show_public;
    
    private javax.swing.JComboBox<String> private_players;
    private javax.swing.JComboBox<String> public_players;
    private javax.swing.JComboBox<String> sportc;
    private javax.swing.JLabel title;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel public_panel;
    private javax.swing.JPanel main_panel;
    private javax.swing.JTextField cdate;
    private javax.swing.JTextField choose_date;
    private javax.swing.JTabbedPane pblc;
    private javax.swing.JButton show_available;
    // End of variables declaration
}
