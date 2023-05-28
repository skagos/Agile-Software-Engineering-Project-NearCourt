import javax.swing.*;
import java.util.Date;
import java.lang.String;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData;


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
        String comod=jComboBox4.getSelectedItem().toString();
        String comora=jComboBox2.getSelectedItem().toString();
        String comorai=jComboBox3.getSelectedItem().toString();

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

    private void UpdateGroupsData(String s,int i){

        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourtdatabase", "root", "");
            PreparedStatement insertPs = con.prepareStatement("INSERT INTO groups(type,sport,date,group_capacity,time,owner_id,court_id) values(?,?,?,?,?,?,?)");
            String combo = jComboBox4.getSelectedItem().toString();
            String  combo2 = jComboBox3.getSelectedItem().toString();
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
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void CreateReservation(String s,int i){
        try{
            String combo = combo_sport.getSelectedItem().toString();
            String combo2 = jComboBox2.getSelectedItem().toString();
            String selectdate = ((JTextField) date.getDateEditor().getUiComponent()).getText();
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(selectdate);

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourtdatabase", "root", "");
            PreparedStatement insertPs = con.prepareStatement("INSERT INTO groups(type,sport,date,group_capacity,time,owner_id,court_id) values(?,?,?,?,?,?,?)");
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

    private void getPrivateCompatableCourts() {


        try {
            String combo, combo2;
            combo = combo_sport.getSelectedItem().toString();
            String selectdate = ((JTextField) date.getDateEditor().getUiComponent()).getText();
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(selectdate);
            combo2 = jComboBox2.getSelectedItem().toString();

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourtdatabase", "root", "");
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

                    CreateReservation(selectedTime,selectedCourtId);

                    PreparedStatement ferma = con.prepareStatement("SELECT group_id FROM groups WHERE type = ? AND sport = ? AND  date = ? AND group_capacity = ? AND time = ? AND owner_id = ?");

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

                    }

                    PreparedStatement lol = con.prepareStatement("UPDATE timetable SET availability = 1 WHERE time = ?");

                    lol.setString(1, selectedTime);
                    lol.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Success Create!");
                    Payment Payment = new Payment(userData);
                    Payment.setVisible(true);


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
                combo = jComboBox4.getSelectedItem().toString();
                String selectdate = ((JTextField) date1.getDateEditor().getUiComponent()).getText();
                Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(selectdate);
                combo2 = jComboBox3.getSelectedItem().toString();

                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourtdatabase", "root", "");
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

                        // Use the selected values as needed
                        String selectedTime = selectedRowData[0].toString();
                        int selectedCourtId = Integer.parseInt(selectedRowData[1].toString());

                        UpdateGroupsData(selectedTime,selectedCourtId);

                        PreparedStatement lol = con.prepareStatement("UPDATE timetable SET availability = 1 WHERE time = ?");

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

        pblc = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        combo_sport = new javax.swing.JComboBox<>();
        show_available = new javax.swing.JButton();
        date = new com.toedter.calendar.JDateChooser();
        jTextField5 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        date1 = new com.toedter.calendar.JDateChooser();
        jTextField6 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBox2.setBackground(new java.awt.Color(102, 153, 255));
        jComboBox2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Number of players", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));

        combo_sport.setBackground(new java.awt.Color(102, 153, 255));
        combo_sport.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        combo_sport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sport", "Football", "Basketball", "Tennis" }));
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

        jTextField5.setBackground(new java.awt.Color(102, 153, 255));
        jTextField5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextField5.setText("Choose Date:");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
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
                                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(45, 45, 45)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(show_available, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(158, Short.MAX_VALUE))
        );

        pblc.addTab("Private Court", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBox3.setBackground(new java.awt.Color(102, 153, 255));
        jComboBox3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Number of players", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));

        jComboBox4.setBackground(new java.awt.Color(102, 153, 255));
        jComboBox4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sport", "Football", "Basketball", "Tennis" }));
        jComboBox4.setToolTipText("");
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox4MousePressed(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 153, 255));
        jButton3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton3.setText("Show Available Courts");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        date1.setDateFormatString("yyyy-MM-dd");
        date1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        jTextField6.setBackground(new java.awt.Color(102, 153, 255));
        jTextField6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextField6.setText("Choose Date:");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                .addGap(42, 42, 42))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(82, 82, 82)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(151, Short.MAX_VALUE))
        );

        pblc.addTab("Public Court", jPanel2);
        jPanel2.getAccessibleContext().setAccessibleName("Private Court");

        jPanel3.setBackground(new java.awt.Color(0, 101, 66));

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setText("Create Group");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 156, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(119, 119, 119)
                                .addComponent(jButton1))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1)
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pblc, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 838, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pblc, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(271, Short.MAX_VALUE))
        );

        pblc.getAccessibleContext().setAccessibleName("Create Group");
        pblc.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>

    private void combo_sportActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void combo_sportMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void show_availableActionPerformed(java.awt.event.ActionEvent evt) {

        ValidateGroup(1,"Sport","Number of players");
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

    }

    private void jComboBox4MousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        ValidateGroup(2,"Sport","Number of players");
    }

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateGroupp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateGroupp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateGroupp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateGroupp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //     new CreateGroupp().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> combo_sport;
    private com.toedter.calendar.JDateChooser date;
    private com.toedter.calendar.JDateChooser date1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTabbedPane pblc;
    private javax.swing.JButton show_available;
    // End of variables declaration
}
