package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.ResultSet;


public class AddCourtPage extends javax.swing.JFrame {

    private JButton addbutton;
    public AddCourtPage() {
        initComponents();
    }
    private boolean ValidateFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to get court_id and name values
                String[] values = line.split(",");

                // Check if the line has the correct number of values
                if (values.length != 5) {
                    System.out.println("There has been an error with the uploaded file format: " + file.getName());
                    return false;
                }

                // Prepare the SQL statement to check for duplicate records
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourt", "root", "");
                String sql = "SELECT COUNT(*) FROM court WHERE  name = ?";
                PreparedStatement statement = con.prepareStatement(sql);
               // statement.setInt(1, Integer.parseInt(values[0].trim()));
                statement.setString(1, values[0].trim());


                ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                resultSet.close();
                statement.close();

                // Check if a duplicate record exists
                if (count > 0) {
                    System.out.println("There has been an error with the uploaded file duplicate row found at: " + line);
                    return false;
                }
            }
            return true; // File is valid
        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
            return false; // An error occurred while reading the file or querying the database
        }
    }

    private void UpdateCourts(String [] ropt){try {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourt", "root", "");
        String sql = "INSERT INTO court ( name,sport_center_id,sport,capacity,price) VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, ropt[0].trim());
        statement.setInt(2, Integer.parseInt(ropt[1].trim()));
        statement.setString(3, ropt[2].trim());
        statement.setInt(4, Integer.parseInt(ropt[3].trim()));
        statement.setInt(5, Integer.parseInt(ropt[4].trim()));

        statement.executeUpdate();
        statement.close();
    }catch (Exception e){
        e.printStackTrace();
    }

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        ImageIcon icon = new ImageIcon("C:\\Users\\user\\Documents\\GitHub\\NearCourt-The-Easy-way-to-play\\Deadline5\\Project_code\\src\\main\\java\\org\\example\\Nearcourt.png");
        setIconImage(icon.getImage());
        add_panel = new javax.swing.JPanel();
        add_label = new javax.swing.JLabel();
        addbutton = new javax.swing.JButton();
        addbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a file chooser dialog
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Select Text File");

                // Show the dialog and wait for user selection
                int result = fileChooser.showOpenDialog(null);

                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String filePath = selectedFile.getAbsolutePath();


                    if(ValidateFile(selectedFile)==false){
                        JOptionPane.showMessageDialog(AddCourtPage.this, "There has been an error with the uploaded file");
                    }else{

                        try (
                                BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

                            String line;
                            while ((line = reader.readLine()) != null) {
                                // Split the line by comma to get court_id and name values
                                String[] values = line.split(",");

                                UpdateCourts(values);

                            }
                            JOptionPane.showMessageDialog(AddCourtPage.this, "Modify Completed!");
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        add_panel.setBackground(new java.awt.Color(204, 204, 255));

        add_label.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        add_label.setText("Add Court");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(add_panel);
        add_panel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(add_label)
                                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(add_label)
                                .addContainerGap(14, Short.MAX_VALUE))
        );

        addbutton.setBackground(new java.awt.Color(0, 153, 51));
        addbutton.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        addbutton.setText("Choose file to upload");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(add_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(add_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(addbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private javax.swing.JLabel add_label;
    private javax.swing.JPanel add_panel;
    // End of variables declaration
}
