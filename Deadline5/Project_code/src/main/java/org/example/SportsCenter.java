package org.example;

import javax.swing.*;
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

        System.out.println("Opening SportsCenter for " + selectedSport);

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


            try (ResultSet resultSet = statement.executeQuery()) {
                // Process the result set
                while (resultSet.next()) {

                    String time = resultSet.getString("time");
                    String player = resultSet.getString("court_name");


                    //sportList.add(player);
                    sportList.add(time);


                }
            }

            if (sportList.isEmpty()) {
                String message = "No nearby courts available for " + selectedSport;
                JOptionPane.showMessageDialog(null, message, "No Courts Available", JOptionPane.INFORMATION_MESSAGE);
            } else {
                ChooseCourtScreen selectCourt = new ChooseCourtScreen(userData);
                selectCourt.setItems(sportList);
                selectCourt.setVisible(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}