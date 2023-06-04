package org.example;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JTextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainMenuPage extends javax.swing.JFrame {
    private Object[] userData;

    public MainMenuPage(Object[] userData) {
        initComponents();
        this.userData = userData;
        String username = (String) userData[2];
        this.jLabel2.setText("Welcome, " + username + "!");
        loadNotificationText(userData);
        ImageIcon icon = new ImageIcon("D:\\Users\\Koukounaras\\Documents\\GitHub\\NearCourt-The-Easy-way-to-play\\Deadline5\\Project_code\\src\\main\\java\\org\\example\\Nearcourt.png");
        setIconImage(icon.getImage());


        this.jButtonProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenuPage.this.showProfile();
            }
        });
        this.jButtonCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenuPage.this.showCreateGroupPage();
            }
        });

        this.jButtonFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenuPage.this.showFindGroup();
            }
        });

        this.jButtonManage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenuPage.this.showManageMyGroup();
            }
        });

        this.jButtonBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenuPage.this.showChooseSportScreen();
            }
        });

        this.jButtonAddF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenuPage.this.showAddFriendsPage();
            }
        });

        this.jButtonRate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenuPage.this.showRatePage();
            }
        });
    }
    private void showProfile() {
        Profile profile = new Profile(this.userData);
        profile.setVisible(true);
        profile.getUserData(this.userData);
        //this.dispose();
    }
    private void showCreateGroupPage() {
        CreateGroupPage createGroupPage = new CreateGroupPage(this.userData);
        createGroupPage.setVisible(true);
        // this.dispose();
    }

    private void showFindGroup() {
        FindGroup findGroupGUI = new FindGroup(this.userData);
        findGroupGUI.setVisible(true);
        //this.dispose();
    }

    private void showManageMyGroup() {

        ManageMyGroup manageMyGroup = new ManageMyGroup(this.userData);
        manageMyGroup.setVisible(true);
        //this.dispose();


    }
    private void showChooseSportScreen() {
        ChooseSportScreen chooseSportScreen = new ChooseSportScreen(userData);
        chooseSportScreen.setVisible(true);
        //this.dispose();
    }
    private void showAddFriendsPage() {
        AddFriendsPage addFriendsPage = new AddFriendsPage(userData);
        addFriendsPage.setVisible(true);
        //this.dispose();
    }

    private void showRatePage() {
        RatePage ratePlayersCourts = new RatePage(userData);
        ratePlayersCourts.setVisible(true);
        //this.dispose();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButtonProfile = new javax.swing.JButton();
        jButtonFind = new javax.swing.JButton();
        jButtonBook = new javax.swing.JButton();
        jButtonCreate = new javax.swing.JButton();
        jButtonManage = new javax.swing.JButton();
        jButtonAddF = new javax.swing.JButton();
        jButtonRate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();

        jButton2.setText("jButton2");

        ImageIcon icon = new ImageIcon("C:/Users/user/Desktop/thumbnail.jpg");
        JLabel label = new JLabel(icon);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/example/thumbnail.jpg")));

       //jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("D:\\Users\\Koukounaras\\Documents\\GitHub\\NearCourt-The-Easy-way-to-play\\Deadline5\\Project_code\\src\\main\\java\\org\\example\\thumbnail.jpg")));

        jButtonProfile.setBackground(new java.awt.Color(0, 153, 0));
        jButtonProfile.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonProfile.setText("Profile");
        jButtonProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProfileActionPerformed(evt);
            }
        });

        jButtonFind.setBackground(new java.awt.Color(0, 153, 0));
        jButtonFind.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonFind.setText("Find Group");
        jButtonFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFindActionPerformed(evt);
            }
        });

        jButtonBook.setBackground(new java.awt.Color(0, 153, 0));
        jButtonBook.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonBook.setText("Book Court");

        jButtonCreate.setBackground(new java.awt.Color(0, 153, 0));
        jButtonCreate.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonCreate.setText("Create Group");

        jButtonManage.setBackground(new java.awt.Color(0, 153, 0));
        jButtonManage.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonManage.setText("ManageMy Group");

        jButtonAddF.setBackground(new java.awt.Color(0, 153, 0));
        jButtonAddF.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonAddF.setText("Add Friends");

        jButtonRate.setBackground(new java.awt.Color(0, 153, 0));
        jButtonRate.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButtonRate.setText("Rate");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel2.setText("Welcome,");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(158, 158, 158))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jButtonFind, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonBook, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                                                .addGap(33, 33, 33)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButtonCreate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonManage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jButtonAddF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(127, 127, 127)
                                                .addComponent(jButtonRate, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonProfile)
                                        .addComponent(jButtonCreate))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonFind)
                                        .addComponent(jButtonManage))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonBook)
                                        .addComponent(jButtonAddF))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonRate)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(16, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    private void loadNotificationText(Object[] userData) {
        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourt", "root", "");

            // Prepare the SELECT query
            String query = "SELECT text,date FROM notifications WHERE user_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, (int) userData[0]);

            // Execute the query and obtain the result set
            ResultSet resultSet = statement.executeQuery();

            // Create a StringBuilder to accumulate the notification text
            StringBuilder notificationTextBuilder = new StringBuilder();

            // Process the query results
            while (resultSet.next()) {
                String notificationText = resultSet.getString("text");
                String notificationDate = resultSet.getString("date");
                //notificationTextBuilder.append(notificationText).append("\n");
                notificationTextBuilder.append(notificationText).append(" ").append(notificationDate).append("\n");
            }

            // Create a JTextArea and set its text content
            JTextArea textArea = new JTextArea(notificationTextBuilder.toString());


            // Set the JTextArea as the viewport view of jScrollPane1
            jScrollPane1.setViewportView(textArea);

            // Close the database resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void jButtonProfileActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButtonFindActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    private javax.swing.JButton jButtonProfile;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonFind;
    private javax.swing.JButton jButtonBook;
    private javax.swing.JButton jButtonCreate;
    private javax.swing.JButton jButtonManage;
    private javax.swing.JButton jButtonAddF;
    private javax.swing.JButton jButtonRate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration
}
