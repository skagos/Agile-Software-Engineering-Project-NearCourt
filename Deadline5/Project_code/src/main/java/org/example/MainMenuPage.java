package org.example;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MainMenuPage extends JFrame {
    private Object[] userData;
    private int groupId = 0;
    private JButton jButtonCreate;
    private JButton jButtonProfile;
    private JButton jButtonFind;
    private JButton jButtonManage;
    private JButton jButtonBook;
    private JButton jButtonAddF;

    private JLabel jLabel2;
    private JPanel jPanel1;

    public MainMenuPage(Object[] userData) {
        this.initComponents();
        this.userData = userData;
        String username = (String) userData[2];
        this.jLabel2.setText("Welcome, " + username + "!");
        this.jButtonProfile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenuPage.this.showProfile();
            }
        });
        this.jButtonCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenuPage.this.showCreateGroup();
            }
        });

        this.jButtonFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenuPage.this.showFindGroup();
            }
        });
        this.jButtonManage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (MainMenuPage.this.groupId > 0) {
                    MainMenuPage.this.showManageMyGroup();
                } else {
                    System.out.println("error");
                }

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
    }

    private void showProfile() {
        Profile profile = new Profile(this.userData);
        profile.setVisible(true);
        profile.displayUserRate(this.userData);
        this.dispose();
    }
    private void showCreateGroup() {
        CreateGroupPage createGroupPage = new CreateGroupPage(this.userData);
        createGroupPage.setVisible(true);
        this.dispose();
    }

    private void showFindGroup() {
        FindGroupGUI findGroupGUI = new FindGroupGUI(this.userData);
        findGroupGUI.setVisible(true);
        this.dispose();
    }

    private void showManageMyGroup() {
        if (this.groupId > 0) {
            ManageMyGroup manageMyGroup = new ManageMyGroup(this.userData);
            manageMyGroup.setVisible(true);
            this.dispose();
        } else {
            System.out.println("error");
        }

    }
    private void showChooseSportScreen() {
        ChooseSportScreen chooseSportScreen = new ChooseSportScreen(userData);
        chooseSportScreen.setVisible(true);
        this.dispose();
    }
    private void showAddFriendsPage() {
        AddFriendsPage addFriendsPage = new AddFriendsPage(userData);
        addFriendsPage.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jButtonProfile = new JButton();
        this.jButtonCreate = new JButton();
        this.jButtonFind = new JButton();
        this.jButtonManage = new JButton();
        this.jButtonBook = new JButton();
        this.jButtonAddF = new JButton();
        this.setDefaultCloseOperation(3);
        this.jLabel2.setText("jLabel2");
        this.jButtonProfile.setBackground(new Color(51, 153, 0));
        this.jButtonProfile.setText("Profile");
        this.jButtonCreate.setBackground(new Color(0, 153, 0));
        this.jButtonCreate.setText("Create Group");
        this.jButtonFind.setBackground(new Color(0, 153, 0));
        this.jButtonFind.setText("Find Group");
        this.jButtonManage.setBackground(new Color(51, 153, 0));
        this.jButtonManage.setText("Manage MyGroup");
        this.jButtonBook.setBackground(new Color(0, 153, 0));
        this.jButtonBook.setText("Book Court");
        this.jButtonAddF.setText("Add Friends");
        this.jButtonAddF.setBackground(new Color(0, 153, 0));

        /*GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2, -2, 121, -2).addContainerGap(-1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jButtonFind, -2, 96, -2).addGap(31, 31, 31).addComponent(this.jButtonManage, -2, 96, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jButtonProfile, -2, 96, -2).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButtonCreate, -2, 96, -2))).addGap(19, 19, 19)))).addGroup(jPanel1Layout.createSequentialGroup().addGap(70, 70, 70).addComponent(this.jButtonBook, -2, 96, -2).addGap(0, 0, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jLabel2).addGap(45, 45, 45).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jButtonProfile).addComponent(this.jButtonCreate)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jButtonFind).addComponent(this.jButtonManage)).addGap(18, 18, 18).addComponent(this.jButtonBook).addContainerGap(96, 32767)));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(110, 110, 110).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(48, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addGap(22, 22, 22)));
        this.pack();*/

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(this.jLabel2, -2, 121, -2)
                                                .addComponent(jButtonProfile)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonCreate))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButtonFind)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonManage))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButtonBook)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonAddF)
                                                .addGap(0, 1, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(this.jLabel2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonProfile)
                                        .addComponent(jButtonCreate))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonFind)
                                        .addComponent(jButtonManage))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonBook)
                                        .addComponent(jButtonAddF))
                                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(27, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))
        );

        pack();
    }

    public void selectGroupIdFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT group_id FROM `groups` WHERE owner_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (Integer)this.userData[0]);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.groupId = resultSet.getInt("group_id");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException var8) {
            var8.printStackTrace();
        } catch (SQLException var9) {
            var9.printStackTrace();
        }

    }
}
