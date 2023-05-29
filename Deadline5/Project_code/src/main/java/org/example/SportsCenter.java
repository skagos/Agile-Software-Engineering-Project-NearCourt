package org.example;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SportsCenter {
    private String selectedSport;
    private Object[] userData;

    public SportsCenter(String selectedSport,Object[] userData) {
        this.selectedSport = selectedSport;
        this.userData = userData;
    }

    public void requestnearbycourts() {
        // Perform actions when the SportsCenter is opened
        System.out.println("Opening SportsCenter for " + selectedSport);
        // Add your desired functionality here
        String url = "jdbc:mysql://localhost:3306/nearcourt";
        String username = "root";
        String password = "";

        // SQL query
        String query = "SELECT * FROM timetable WHERE court_type = ? AND Availability=0";

        List<String> sportList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement(query)) {
            // Set the selected sport as a parameter in the query
            statement.setString(1, selectedSport);

            // Execute the query and retrieve the result set
            try (ResultSet resultSet = statement.executeQuery()) {
                // Process the result set
                while (resultSet.next()) {
                    // Retrieve data from the result set
                    String time = resultSet.getString("time");
                    String player = resultSet.getString("court_name");


                    //sportList.add(player);
                    sportList.add(time);

                    for (String item : sportList) {
                        System.out.println(item);
                    }
                }
            }

            ChooseCourtScreen selectCourt = new ChooseCourtScreen(userData);
            selectCourt.setItems(sportList);
            selectCourt.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}