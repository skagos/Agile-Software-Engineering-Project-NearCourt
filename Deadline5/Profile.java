import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Profile extends JFrame {
    private JLabel usernameLabel;
    private JLabel emailLabel;
    private JLabel rateLabel;
    private JLabel starsLabel;

    public Profile() {
        setTitle("User Profile");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPane = new JPanel(new BorderLayout());

        JPanel userDetailsPanel = new JPanel(new GridLayout(3, 2));
        usernameLabel = new JLabel();
        emailLabel = new JLabel();
        rateLabel = new JLabel();
        starsLabel = new JLabel();

        userDetailsPanel.add(new JLabel("Username:"));
        userDetailsPanel.add(usernameLabel);
        userDetailsPanel.add(new JLabel("Email:"));
        userDetailsPanel.add(emailLabel);
        userDetailsPanel.add(new JLabel("Rate:"));
        userDetailsPanel.add(rateLabel);
        userDetailsPanel.add(new JLabel("Stars:"));
        userDetailsPanel.add(starsLabel);

        JButton runCodeButton = new JButton("Run Code");
        runCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to execute when the button is clicked
                // Add your desired logic here
                // For example, you can create an instance of the other Java code file class and call its methods.
                MyOtherClass otherClass = new MyOtherClass();
                otherClass.run();
            }
        });

        contentPane.add(userDetailsPanel, BorderLayout.CENTER);
        setContentPane(contentPane);
    }
    public class MyOtherClass {
        public void run() {
            // Add your code here to be executed when the button is clicked
            // This can include any desired logic or operations
            System.out.println("Running MyOtherClass");
        }
    }

    public void displayUserDetails(int userId) {
        String url = "jdbc:mysql://localhost:3306/nearcourtdatabase"; // Replace with your database URL
        String username = "root"; // Replace with your database username
        String password = ""; // Replace with your database password

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM users WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, userId);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    String usernameValue = resultSet.getString("username");
                    String emailValue = resultSet.getString("email");


                    usernameLabel.setText(usernameValue);
                    emailLabel.setText(emailValue);

                } else {
                    System.out.println("User not found.");
                }
            }
            String query2 = "SELECT rate, stars FROM rates WHERE user_id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query2)) {
                statement.setInt(1, userId); // Assuming you have the user ID stored in the "userId" variable
                ResultSet resultSet = statement.executeQuery();

                List<String> rateList = new ArrayList<>();
                List<String> starsList = new ArrayList<>();

                while (resultSet.next()) {
                    String rateValue = resultSet.getString("rate");
                    String starsValue = resultSet.getString("stars");

                    // Process the rate and stars values here (e.g., add them to a list, display them, etc.)

                    // Example: Adding them to a list
                    rateList.add(rateValue);
                    starsList.add(starsValue);
                }

                // Example: Displaying the values in a label (you may need to adapt this part based on your UI framework)
                rateLabel.setText(rateList.toString());
                starsLabel.setText(starsList.toString());

                // You can also perform additional processing with the collected rate and stars values
                // ...
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }catch (SQLException e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Profile profile = new Profile();
            int userId = 1; // Replace with the desired user ID
            profile.displayUserDetails(userId);
            profile.setVisible(true);
        });
    }
}

