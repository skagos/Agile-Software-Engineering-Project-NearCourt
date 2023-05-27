//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ManageMyGroup extends JFrame {
    private Object[] userData;
    private JButton jButton1;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;

    public ManageMyGroup(Object[] userData) {
        this.initComponents();
        this.userData = userData;
    }

    private void initComponents() {
        this.jPanel1 = new JPanel();
        this.jScrollPane1 = new JScrollPane();
        this.jButton1 = new JButton();
        this.jLabel1 = new JLabel();
        this.setDefaultCloseOperation(3);
        this.jPanel1.setBackground(new Color(0, 153, 0));
        this.jButton1.setText("Kick");
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ManageMyGroup.this.jButton1ActionPerformed(evt);
            }
        });
        this.jLabel1.setBackground(new Color(255, 255, 255));
        this.jLabel1.setFont(new Font("Arial Black", 0, 14));
        this.jLabel1.setText("Manage MyGroup");
        GroupLayout jPanel1Layout = new GroupLayout(this.jPanel1);
        this.jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jScrollPane1).addContainerGap()).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addGap(0, 40, 32767).addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jLabel1, -2, 141, -2).addGap(31, 31, 31)).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addComponent(this.jButton1, -2, 81, -2).addGap(69, 69, 69)))))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup().addContainerGap(21, 32767).addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jScrollPane1, -2, 137, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jButton1).addGap(18, 18, 18)));
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(88, 88, 88).addComponent(this.jPanel1, -2, -1, -2).addContainerGap(94, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(32, 32767).addComponent(this.jPanel1, -2, -1, -2).addGap(24, 24, 24)));
        this.pack();
    }

    private void jButton1ActionPerformed(ActionEvent evt) {
    }
}

