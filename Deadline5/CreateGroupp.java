import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.util.Date;
import java.lang.String;
import java.sql.Time;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;




/**
 *
 * @author user
 */
public class CreateGroupp extends javax.swing.JFrame {

    /**
     * Creates new form CreateGroupp
     */
    private Object[] userData;
    private String  p = "private";

    public CreateGroupp(Object[] userData) {
        initComponents();
        this.userData = userData;
        int user_id = (int) userData[0];
        System.out.println("Welcome malaka me user id: " + user_id );


    }
    private void CreateGroup(){

        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourtdatabase", "root", "");
            PreparedStatement ps= con.prepareStatement("INSERT INTO groupp(type,sport,date,number_of_players,time,player_id) values(?,?,?,?,?,?)");

            // String selectdate =((JTextField)date.getDateEditor().getUiComponent()).getText();


            String combo,combo2,combo3;
            combo=combo_sport.getSelectedItem().toString();
            combo2=jComboBox2.getSelectedItem().toString();



            // Retrieve the time input from the text field
            String timeString = jTextField1.getText();

            // Parse the time input into a Time object
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date time;
            try {
                time = timeFormat.parse(timeString);
            } catch (ParseException ex) {
                ex.printStackTrace();
                return;
            }


            ps.setTime(5, new Time(time.getTime()));


            String selectdate =((JTextField)date.getDateEditor().getUiComponent()).getText();
            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(selectdate);
            ps.setDate(3, new java.sql.Date(date1.getTime()));





            //   ps.setTime(5, new java.sql.Time(timee.getTime()));
            ps.setString(2,combo);
            ps.setString(4,combo2);
            ps.setString(1,p);
            // ps.setString(3,selectdate);
            ps.setInt(6,(int) userData[0]);


            ps.execute();
            JOptionPane.showMessageDialog(this,"poutana mana exeis");
        } catch (Exception e) {
            System.out.println(e);
        }

       // int selectedIndex = jTabbedPane1.getSelectedIndex();
       // System.out.println("Selected Index: " + selectedIndex);
    }

    private void allFieldsRequired(){
        String sport = combo_sport.getSelectedItem().toString();
        String datee =((JTextField)date.getDateEditor().getUiComponent()).getText();
        String time = jTextField1.getText();
        String number_of_people = jComboBox2.getSelectedItem().toString();

        if (sport.isEmpty() || datee.isEmpty() || time.isEmpty() ||number_of_people.isEmpty() ) {
            // A field is not filled
            JOptionPane.showMessageDialog(CreateGroupp.this, "All fields required!", "All fields required!", JOptionPane.ERROR_MESSAGE);

        }

    }

    private void PrivateGroupCheck(){
        jTabbedPane1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = jTabbedPane1.getSelectedIndex();
                System.out.println("Selected Index: " + selectedIndex);

                // Perform actions based on the selected index
                if (selectedIndex == 0) {
                    // The first tab is selected
                    CreateGroup();
                } else if (selectedIndex == 1) {
                    // The second tab is selected
                    CreateGroup();//PUBLIC
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        combo_sport = new javax.swing.JComboBox<>();
        show_available = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        date = new com.toedter.calendar.JDateChooser();
        jTextField5 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        date1 = new com.toedter.calendar.JDateChooser();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBox2.setBackground(new java.awt.Color(102, 153, 255));
        jComboBox2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Number of players", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));

        combo_sport.setBackground(new java.awt.Color(102, 153, 255));
        combo_sport.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        combo_sport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sport", "Football", "Basketball", "Tennis" }));
        combo_sport.setToolTipText("");
        combo_sport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                combo_sportMousePressed(evt);
            }
        });
        combo_sport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_sportActionPerformed(evt);
            }
        });

        show_available.setBackground(new java.awt.Color(102, 153, 255));
        show_available.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        show_available.setText("Show Available Courts");
        show_available.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_availableActionPerformed(evt);
            }
        });

        jTextField3.setBackground(new java.awt.Color(102, 153, 255));
        jTextField3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField3.setText("Choose Time:");
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        date.setDateFormatString("yyyy-MM-dd");
        date.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        jTextField5.setBackground(new java.awt.Color(102, 153, 255));
        jTextField5.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextField5.setText("Choose Date:");
        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextField1.setText("                  00:00:00");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addComponent(show_available, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(combo_sport, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(jTextField3)
                                                                        .addComponent(jTextField5))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addComponent(date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(combo_sport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(57, 57, 57)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(show_available)
                                .addContainerGap(137, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Private Court", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jComboBox3.setBackground(new java.awt.Color(102, 153, 255));
        jComboBox3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Number of players", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));

        jComboBox4.setBackground(new java.awt.Color(102, 153, 255));
        jComboBox4.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sport", "Football", "Basketball", "Tennis" }));
        jComboBox4.setToolTipText("");
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jComboBox4MousePressed(evt);
            }
        });
        jComboBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 153, 255));
        jButton3.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton3.setText("Show Available Courts");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        date1.setDateFormatString("yyyy-MM-dd");
        date1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N

        jTextField6.setBackground(new java.awt.Color(102, 153, 255));
        jTextField6.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextField6.setText("Choose Date:");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jTextField7.setBackground(new java.awt.Color(102, 153, 255));
        jTextField7.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField7.setText("Choose Time:");
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jTextField2.setText("                  00:00:00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField7)
                                                        .addComponent(jTextField6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(date1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)))
                                        .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(jButton3)
                                .addContainerGap(139, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Public Court", jPanel2);
        jPanel2.getAccessibleContext().setAccessibleName("Private Court");

        jPanel3.setBackground(new java.awt.Color(0, 101, 66));

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jButton1.setText("HOME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        jLabel1.setText("Create Group");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(0, 156, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(119, 119, 119)
                                .addComponent(jButton1))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1)
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 838, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(271, Short.MAX_VALUE))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Create Group");
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("");
        jTabbedPane1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = jTabbedPane1.getSelectedIndex();
                System.out.println("Selected Index: " + selectedIndex);

                // Perform actions based on the selected index
                if (selectedIndex == 0) {
                    // The first tab is selected
                    System.out.println("PRIVATE");
                } else if (selectedIndex == 1) {
                    // The second tab is selected
                    System.out.println("PUBLIC");
                }
            }
        });

        pack();
    }// </editor-fold>

    private void combo_sportActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void combo_sportMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void show_availableActionPerformed(java.awt.event.ActionEvent evt) {
        allFieldsRequired();
        CreateGroup();
      /*  try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourtdatabase", "root", "");
            PreparedStatement ps= con.prepareStatement("INSERT INTO groupp(type,sport,date,number_of_players,time) values(?,?,?,?,?)");

           // String selectdate =((JTextField)date.getDateEditor().getUiComponent()).getText();


            String combo,combo2,combo3;
            combo=combo_sport.getSelectedItem().toString();
            combo2=jComboBox2.getSelectedItem().toString();



                        // Retrieve the time input from the text field
                        String timeString = jTextField3.getText();

                        // Parse the time input into a Time object
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                        Date time;
                        try {
                            time = timeFormat.parse(timeString);
                        } catch (ParseException ex) {
                            ex.printStackTrace();
                            return;
                        }


                            ps.setTime(5, new Time(time.getTime()));


            String selectdate =((JTextField)date.getDateEditor().getUiComponent()).getText();
            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(selectdate);
            ps.setDate(3, new java.sql.Date(date1.getTime()));





            //   ps.setTime(5, new java.sql.Time(timee.getTime()));
            ps.setString(2,combo);
            ps.setString(4,combo2);
            ps.setString(1,"private");
           // ps.setString(3,selectdate);


            ps.execute();
            JOptionPane.showMessageDialog(this,"poutana mana exeis");
        } catch (Exception e) {
            System.out.println(e);
        }*/

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:


    }

    private void jComboBox4MousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:

        try {

            // Class.forName("conn.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/nearcourtdatabase", "root", "");
            PreparedStatement ps= con.prepareStatement("INSERT INTO groupp(type,sport,date,number_of_players,time,player_id) values(?,?,?,?,?,?)");


            // Retrieve the time input from the text field
            String timeString = jTextField2.getText();

            // Parse the time input into a Time object
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            Date time;
            try {
                time = timeFormat.parse(timeString);
            } catch (ParseException ex) {
                ex.printStackTrace();
                return;
            }


            ps.setTime(5, new Time(time.getTime()));


            String selectdate =((JTextField)date1.getDateEditor().getUiComponent()).getText();
            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(selectdate);
            ps.setDate(3, new java.sql.Date(date1.getTime()));




            String combo,combo2;

            combo=jComboBox4.getSelectedItem().toString();
            combo2=jComboBox3.getSelectedItem().toString();
            ps.setString(2,combo);
            ps.setString(4,combo2);
            ps.setString(1,"public");
            ps.setString(3,selectdate);
            ps.setInt(6,(int) userData[0]);
            ps.execute();
            JOptionPane.showMessageDialog(this,"poutana mana exeis");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }
    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateGroupp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateGroupp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateGroupp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateGroupp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            //    new CreateGroupp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> combo_sport;
    private com.toedter.calendar.JDateChooser date;
    private com.toedter.calendar.JDateChooser date1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JButton show_available;
    // End of variables declaration
}