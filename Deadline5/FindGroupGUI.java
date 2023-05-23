
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.PreparedStatement;


public class FindGroupGUI extends javax.swing.JFrame {
    private Object[] userData;

    public FindGroupGUI(Object[] userData) {
        initComponents();
        this.userData = userData;
    }


    private void initComponents() {

            jScrollPane1 = new javax.swing.JScrollPane();
            jLabel5 = new javax.swing.JLabel();
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

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jLabel5.setBackground(new java.awt.Color(51, 204, 0));
            jLabel5.setFont(new java.awt.Font("Showcard Gothic", 0, 36)); // NOI18N
            jLabel5.setForeground(new java.awt.Color(255, 255, 255));
            jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel5.setText("jLabel5");
            jLabel5.setOpaque(true);

            groupsTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, "yehj", "gfhdhf", "hgdhgh", "hfdhg"},
                    {null, "dfhfhd", "fdhhfd", "fhdhf", "hgfd"},
                    {null, "fdhhf", "hffh", "fhhf", "fdhf"},
                    {null, "gfhf", "hfhf", "fdhfh", "fhfh"},
                    {null, "fgdhf", "ffghfghdf", "fgfh", "ffhd"},
                    {null, "fhgfh", "fhfghfd", "fdhfd", "hfhhdf"},
                    {null, "fhfd", "hfdhfd", "hfdh", "fghfdhf"},
                    {null, "fdfdhhf", "fghfdhhfdhfd", "gfhdfghfd", "fgdhdh"},
                    {null, "dfhhdf", "fdfdh", "dhfhffd", "dfhfdhd"},
                    {null, "hhdf", "fghfdh", "fdhfh", null}
                },
                new String [] {
                    "ID", "Court", "Date", "Sport", "Players"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, false
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
            playersComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22" }));

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

            findGroupsBut.setBackground(new java.awt.Color(0, 51, 255));
            findGroupsBut.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
            findGroupsBut.setForeground(new java.awt.Color(255, 255, 255));
            findGroupsBut.setText("Find Groups");
            findGroupsBut.setBorderPainted(false);
            findGroupsBut.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    findGroupsButActionPerformed(evt);
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
                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(profileBut)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBut))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        }// </editor-fold>

    private void findGroupsButActionPerformed(java.awt.event.ActionEvent evt) {
            // TODO add your handling code here:
            String sport = (String) sportComboBox.getSelectedItem();
            int players = (int) playersComboBox.getSelectedItem();
            String url = "jdbc:mysql://localhost:3306/near";
            String username = "root";
            String password = "";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement stm = con.prepareStatement("SELECT id,name,date,groups.sport,players FROM `groups` INNER JOIN court ON court.court_id = groups.court_id WHERE sport LIKE ? AND players = ?;");
                stm.setString(1, sport);
                stm.setInt(2, players);
                ResultSet rslt = stm.executeQuery();
                ResultSetMetaData metaData = rslt.getMetaData();
                int numOfColumns = metaData.getColumnCount();
                while(rslt.next()){
                    for(int i=1; i<=numOfColumns; i++){
                        groupsTable.setValueAt(rslt.getObject(i),0,i-1 );
                    }
                }
            }catch (Exception e){
                System.out.println(e);
            }
        }

    //na balw ta
    private void joinButActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int row = groupsTable.getSelectedRow();
        int colum = groupsTable.getSelectedColumn();
        int user_id = (int) userData[0];
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = con.prepareStatement("SELECT court_id FROM court WHERE name LIKE ?");
            String name = (String) groupsTable.getValueAt(row, 1);
            stm.setString(1, name);
            ResultSet rslt = stm.executeQuery();
            rslt.next();
            int court_id = (int) rslt.getObject(1);
            System.out.print(court_id);
            stm = con.prepareStatement("INSERT INTO `belongs_to` (`user_id`, `court_id`) VALUES (?, ?);");
            stm.setInt(1, user_id);
            stm.setInt(2, court_id);
            stm.executeUpdate();
            int group_id = (int) groupsTable.getValueAt(row, 0);
            int players = (int) groupsTable.getValueAt(row, 4);
            players = players + 1;
            stm = con.prepareStatement("UPDATE TABLE groups SET players = ? WHERE group_id = ?;");
            stm.executeUpdate();
        }catch(Exception e){
            System.out.println(e);}

    }

    private void profileButActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        this.dispose();
        this.setVisible(false);
    }


    private static javax.swing.JButton findGroupsBut;
        private static javax.swing.JTable groupsTable;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private static javax.swing.JButton joinBut;
        private static javax.swing.JButton logoutBut;
        private static javax.swing.JComboBox<String> playersComboBox;
        private static javax.swing.JButton profileBut;
        private static javax.swing.JLabel selectPlayersLabel;
        private static javax.swing.JLabel selectSportLabel;
        private static javax.swing.JComboBox<String> sportComboBox;
    // End of variables declaration
}
