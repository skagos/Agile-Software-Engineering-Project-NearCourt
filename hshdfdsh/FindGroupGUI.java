//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

public class FindGroupGUI extends JFrame {
    private Object[] userData;
    private static JButton findGroupsBut;
    private static JTable groupsTable;
    private JLabel jLabel5;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private static JButton joinBut;
    private static JButton logoutBut;
    private static JComboBox<String> playersComboBox;
    private static JButton profileBut;
    private static JLabel selectPlayersLabel;
    private static JLabel selectSportLabel;
    private static JComboBox<String> sportComboBox;

    public FindGroupGUI(Object[] userData) {
        this.initComponents();
        this.userData = userData;
    }

    private void initComponents() {
        this.jScrollPane1 = new JScrollPane();
        this.jLabel5 = new JLabel();
        this.jScrollPane2 = new JScrollPane();
        groupsTable = new JTable();
        joinBut = new JButton();
        sportComboBox = new JComboBox();
        playersComboBox = new JComboBox();
        profileBut = new JButton();
        logoutBut = new JButton();
        findGroupsBut = new JButton();
        selectSportLabel = new JLabel();
        selectPlayersLabel = new JLabel();
        this.setDefaultCloseOperation(3);
        this.jLabel5.setBackground(new Color(51, 204, 0));
        this.jLabel5.setFont(new Font("Showcard Gothic", 0, 36));
        this.jLabel5.setForeground(new Color(255, 255, 255));
        this.jLabel5.setHorizontalAlignment(0);
        this.jLabel5.setText("jLabel5");
        this.jLabel5.setOpaque(true);
        groupsTable.setModel(new DefaultTableModel(new Object[][]{{null, "", "", "", "", "", ""}, {null, "", "", "", "", "", ""}, {null, "", "", "", "", "", ""}, {null, "", "", "", "", "", ""}, {null, "", "", "", "", "", ""}, {null, "", "", "", "", "", ""}, {null, "", "", "", "", "", ""}, {null, "", "", "", "", "", ""}, {null, "", "", "", "", "", ""}, {null, "", "", "", "", "", ""}, {null, "", "", "", "", "", ""}}, new String[]{"ID", "Court", "Date", "Sport", "Joined Players", "Price", "Group Capacity"}) {
            Class[] types = new Class[]{Integer.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class};
            boolean[] canEdit = new boolean[]{false, false, false, false, false, false, false};

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.jScrollPane2.setViewportView(groupsTable);
        joinBut.setBackground(new Color(0, 204, 0));
        joinBut.setFont(new Font("Segoe UI", 1, 18));
        joinBut.setForeground(new Color(255, 255, 255));
        joinBut.setText("Join");
        joinBut.setBorderPainted(false);
        joinBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FindGroupGUI.this.joinButActionPerformed(evt);
            }
        });
        sportComboBox.setFont(new Font("Segoe UI", 0, 18));
        sportComboBox.setModel(new DefaultComboBoxModel(new String[]{"Football", "Basket", "Tennis"}));
        playersComboBox.setFont(new Font("Segoe UI", 0, 14));
        playersComboBox.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22"}));
        profileBut.setBackground(new Color(102, 153, 255));
        profileBut.setFont(new Font("Segoe UI", 1, 14));
        profileBut.setText("Profile");
        profileBut.setBorderPainted(false);
        profileBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FindGroupGUI.this.profileButActionPerformed(evt);
            }
        });
        logoutBut.setBackground(new Color(102, 153, 255));
        logoutBut.setFont(new Font("Segoe UI", 1, 14));
        logoutBut.setText("LogOut");
        logoutBut.setBorderPainted(false);
        findGroupsBut.setBackground(new Color(0, 51, 255));
        findGroupsBut.setFont(new Font("Segoe UI", 1, 14));
        findGroupsBut.setForeground(new Color(255, 255, 255));
        findGroupsBut.setText("Find Groups");
        findGroupsBut.setBorderPainted(false);
        findGroupsBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                FindGroupGUI.this.findGroupsButActionPerformed(evt);
            }
        });
        selectSportLabel.setFont(new Font("Segoe UI", 0, 18));
        selectSportLabel.setText("Select Sport:");
        selectPlayersLabel.setFont(new Font("Segoe UI", 0, 18));
        selectPlayersLabel.setText("Select Players:");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(271, 271, 271).addComponent(joinBut)).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGap(81, 95, 32767).addComponent(this.jScrollPane2, -2, -1, -2)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(263, 263, 263).addComponent(findGroupsBut)).addGroup(layout.createSequentialGroup().addGap(107, 107, 107).addComponent(selectSportLabel).addPreferredGap(ComponentPlacement.RELATED).addComponent(sportComboBox, -2, -1, -2).addGap(33, 33, 33).addComponent(selectPlayersLabel).addPreferredGap(ComponentPlacement.RELATED).addComponent(playersComboBox, -2, -1, -2))).addGap(0, 0, 32767)))).addContainerGap(175, 32767)).addComponent(this.jLabel5, Alignment.TRAILING, -1, -1, 32767).addGroup(layout.createSequentialGroup().addComponent(profileBut).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(logoutBut)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addComponent(this.jLabel5, -2, 65, -2).addGap(2, 2, 2).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(profileBut).addComponent(logoutBut)).addGap(44, 44, 44).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(sportComboBox, -2, -1, -2).addComponent(playersComboBox, -2, -1, -2).addComponent(selectSportLabel).addComponent(selectPlayersLabel)).addGap(25, 25, 25).addComponent(findGroupsBut).addGap(12, 12, 12).addComponent(this.jScrollPane2, -2, 151, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(joinBut).addContainerGap(249, 32767)));
        this.pack();
    }

    private void findGroupsButActionPerformed(ActionEvent evt) {
        for(int i = 0; i < 5; ++i) {
            for(int j = 0; j < 10; ++j) {
                groupsTable.setValueAt("", j, i);
            }
        }

        String sport = (String)sportComboBox.getSelectedItem();
        System.out.println(sport);
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = con.prepareStatement("SELECT group_id,name,date,groups.sport,joined_players, group_capacity FROM `groups` INNER JOIN court ON court.court_id = groups.court_id WHERE groups.sport LIKE ? ;");
            stm.setString(1, sport);
            ResultSet rslt = stm.executeQuery();
            ResultSetMetaData metaData = rslt.getMetaData();
            int numOfColumns = metaData.getColumnCount();

            while(rslt.next()) {
                for(int i = 1; i <= numOfColumns; ++i) {
                    groupsTable.setValueAt(rslt.getObject(i), 0, i - 1);
                }
            }
        } catch (Exception var12) {
            System.out.println(var12);
        }

    }

    private void joinButActionPerformed(ActionEvent evt) {
        int row = groupsTable.getSelectedRow();
        int colum = groupsTable.getSelectedColumn();
        int user_id = (Integer)this.userData[0];
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement stm = con.prepareStatement("SELECT court_id FROM court WHERE court.name LIKE ?");
            String name = (String)groupsTable.getValueAt(row, 1);
            stm.setString(1, name);
            ResultSet rslt = stm.executeQuery();
            rslt.next();
            int group_id = (Integer)groupsTable.getValueAt(row, 0);
            this.userData[5] = group_id;
            int players = (Integer)groupsTable.getValueAt(row, 4);
            ++players;
            stm = con.prepareStatement("UPDATE `groups` SET joined_players = ? WHERE group_id = ?;");
            stm.setInt(2, group_id);
            stm.setInt(1, players);
            stm.executeUpdate();
            int court_id = (Integer)rslt.getObject(1);
            System.out.println(court_id);
            this.userData[4] = court_id;
            System.out.println("malakia" + String.valueOf(this.userData[4]));
            stm = con.prepareStatement("INSERT INTO `belongs_to` (`user_id`, `court_id`,`groups_id`) VALUES (?, ?, ?);");
            stm.setInt(1, user_id);
            stm.setInt(2, court_id);
            stm.setInt(3, group_id);
        } catch (Exception var15) {
            System.out.println(var15);
        }

    }

    private void profileButActionPerformed(ActionEvent evt) {
        this.dispose();
        this.setVisible(false);
    }
}

