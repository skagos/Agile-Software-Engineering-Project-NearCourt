import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JDialog{
    private JTextField tfemail;
    private JPasswordField pfpassword;
    private JButton loginButton;
    private JButton cancelButton;
    private JPanel LoginPanel;
    private Player user;

    public LoginForm(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(LoginPanel);
        setMinimumSize(new Dimension(550,574));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfemail.getText();
                String password = String.valueOf(pfpassword.getPassword());

                user = getAuthenticatedUser(email, password);

                if (user != null) {
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(  LoginForm.this,
                            "Email or Password Invalid",
                            "try again", JOptionPane.ERROR_MESSAGE);

                }
            }

            private Player getAuthenticatedUser(String email, String password) {
                Player user = null;

                final String DB = "jdbc:mysql://localhost:3306/nearcourtdatabase";
                final String USERNAME = "root";
                final String PASSWORD = "";



                try {
                    Connection conn = DriverManager.getConnection(DB, USERNAME,PASSWORD);

                    Statement stmt = conn.createStatement();
                    String sql = "SELECT * FROM users WHERE email= ? AND password= ?";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, email);
                    preparedStatement.setString(2, password);

                    ResultSet resultSet = preparedStatement.executeQuery();

                    if (resultSet.next()) {
                        user = new Player();
                        user.id = resultSet.getString("id");
                        user.name = resultSet.getString("name");
                        user.email = resultSet.getString("email");
                        user.password = resultSet.getString("password");


                    }

                    stmt.close();
                    conn.close();

                }catch(Exception e){
                    e.printStackTrace();
                }
                return user;
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
        Player user = loginForm.user;
        if (user != null) {
            System.out.println("Succes:" +user.name);
            System.out.println("Email:" +user.email);

            // Create and display the MainFrame
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    MainFrame mainFrame = new MainFrame(user);
                    mainFrame.setVisible(true);
                }

            });
        }
        else {
            System.out.println("Authentication Canceled");
        }


    }
}