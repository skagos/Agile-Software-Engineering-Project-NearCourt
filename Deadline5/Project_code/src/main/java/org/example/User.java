package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class User extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public User() {
        setTitle("Login Form");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon icon = new ImageIcon("D:\\Users\\Koukounaras\\Documents\\GitHub\\NearCourt-The-Easy-way-to-play\\Deadline5\\Project_code\\src\\main\\java\\org\\example\\Nearcourt.png");
        setIconImage(icon.getImage());



        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); // Empty label for alignment
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = usernameField.getText();
                String password = String.valueOf(passwordField.getPassword());

                // Perform login authentication against the database
                Object[] userData = authenticateUser(name, password);
                if (userData != null) {
                    JOptionPane.showMessageDialog(User.this, "Login Successful!");

                    // Pass user data to the NewPage and open it
                    // MainMenuPage mainMenuPage = new MainMenuPage(userData);
                    // mainMenuPage.selectGroupIdFromDatabase();
                    //  mainMenuPage.setVisible(true);

                    final String DB_URL = "jdbc:mysql://localhost:3306/nearcourt";
                    final String USERNAME = "root";
                    final String PASSWORD = "";
                    Connection conn = null;
                    PreparedStatement stmt = null;
                    ResultSet rs = null;

                    try {
                        // Establish a connection to the database
                        conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                        // Prepare the SQL statement to validate the user's credentials
                        String sql = "SELECT admin FROM users WHERE name = ? AND password = ?";
                        stmt = conn.prepareStatement(sql);

                        stmt.setString(1, name);
                        stmt.setString(2, password);

                        ResultSet resultSet = stmt.executeQuery();

                        if (resultSet.next()) {
                            boolean isAdmin = resultSet.getBoolean("admin");
                            if (isAdmin) {
                                System.out.println("User is an admin.");
                                AdminMainMenuPage adminmainMenuPage = new AdminMainMenuPage(userData);
                                adminmainMenuPage.setVisible(true);
                            } else {
                                System.out.println("User is not an admin.");
                                MainMenuPage mainMenuPage = new MainMenuPage(userData);
                                mainMenuPage.setVisible(true);
                            }
                        } else {

                            System.out.println("Invalid username or password.");
                        }


                    }catch(Exception er){
                        er.printStackTrace();
                    }



                    dispose(); // Close the login form
                } else {
                    JOptionPane.showMessageDialog(User.this, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }

            private Object[] authenticateUser(String username, String password) {
                final String DB_URL = "jdbc:mysql://localhost:3306/nearcourt";
                final String USERNAME = "root";
                final String PASSWORD = "";

                Connection conn = null;
                PreparedStatement stmt = null;
                ResultSet rs = null;
                Object[] userData = null;

                try {
                    // Establish a connection to the database
                    conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

                    // Prepare the SQL statement to validate the user's credentials
                    String sql = "SELECT * FROM users WHERE name = ? AND password = ?";
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, username);
                    stmt.setString(2, password);

                    // Execute the query
                    rs = stmt.executeQuery();

                    // If a matching record is found, retrieve user data
                    if (rs.next()) {
                        // Retrieve the user data as an Object array
                        // Modify this section as per your requirements
                        int id = rs.getInt("user_id");
                        String email = rs.getString("email");
                        String namee = rs.getString("name");
                        String passwordd = rs.getString("password");
                        int court_id = 0;
                        int group_id = 0;
                        // Retrieve other user data as needed

                        // Populate the userData array with the retrieved data
                        userData = new Object[] { id, email,namee,passwordd,court_id,group_id};
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    // Close the database resources
                    try {
                        if (rs != null) rs.close();
                        if (stmt != null) stmt.close();
                        if (conn != null) conn.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                return userData;
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }
}