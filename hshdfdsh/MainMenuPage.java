

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
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JLabel jLabel2;
    private JPanel jPanel1;

    public MainMenuPage(Object[] userData) {
        this.initComponents();
        this.userData = userData;
        String username = (String)userData[2];
        this.jLabel2.setText("Welcome, " + username + "!");
        this.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenuPage.this.openProfilePage();
            }
        });
        this.jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenuPage.this.openFindGroupPage();
            }
        });
        this.jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (MainMenuPage.this.groupId > 0) {
                    MainMenuPage.this.openManageMyGroup();
                } else {
                    System.out.println("error");
                }

            }

        });

        this.jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainMenuPage.this.ShowChooseSportScreen();
            }
        });
    }

    private void openProfilePage() {
        ProfileGUI profileGUI = new ProfileGUI(this.userData);
        profileGUI.setVisible(true);
        profileGUI.displayUserRate(this.userData);
        this.dispose();
    }

    private void openFindGroupPage() {
        FindGroupGUI findGroupGUI = new FindGroupGUI(this.userData);
        findGroupGUI.setVisible(true);
        this.dispose();
    }

    private void openManageMyGroup() {
        if (this.groupId > 0) {
            ManageMyGroup manageMyGroup = new ManageMyGroup(this.userData);
            manageMyGroup.setVisible(true);
        } else {
            System.out.println("error");
        }

    }
    private void ShowChooseSportScreen() {
        ChooseSportScreen chooseSportScreen = new ChooseSportScreen(this.userData);
        chooseSportScreen.setVisible(true);
        this.dispose();
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jLabel2 = new JLabel();
        this.jButton3 = new JButton();
        this.jButton2 = new JButton();
        this.jButton4 = new JButton();
        this.jButton5 = new JButton();
        this.jButton6 = new JButton();
        this.setDefaultCloseOperation(3);
        this.jLabel2.setText("jLabel2");
        this.jButton3.setBackground(new Color(51, 153, 0));
        this.jButton3.setText("Profile");
        this.jButton2.setBackground(new Color(0, 153, 0));
        this.jButton2.setText("jButton2");
        this.jButton4.setBackground(new Color(0, 153, 0));
        this.jButton4.setText("Find Group");
        this.jButton5.setBackground(new Color(51, 153, 0));
        this.jButton5.setText("Manage MyGroup");
        this.jButton6.setBackground(new Color(0, 153, 0));
        this.jButton6.setText("jButton6");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel2, -2, 121, -2).addContainerGap(-1, 32767)).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jButton4, -2, 96, -2).addGap(31, 31, 31).addComponent(this.jButton5, -2, 96, -2)).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jButton3, -2, 96, -2).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.jButton2, -2, 96, -2))).addGap(19, 19, 19)))).addGroup(jPanel1Layout.createSequentialGroup().addGap(70, 70, 70).addComponent(this.jButton6, -2, 96, -2).addGap(0, 0, 32767)));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGap(18, 18, 18).addComponent(this.jLabel2).addGap(45, 45, 45).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jButton3).addComponent(this.jButton2)).addGap(18, 18, 18).addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jButton4).addComponent(this.jButton5)).addGap(18, 18, 18).addComponent(this.jButton6).addContainerGap(96, 32767)));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(110, 110, 110).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(48, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel1, -1, -1, 32767).addGap(22, 22, 22)));
        this.pack();
    }

    public void selectGroupIdFromDatabase() {
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT group_id FROM groups WHERE owner_id = ?";
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
