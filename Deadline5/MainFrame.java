import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class MainFrame extends JFrame {

    private JButton button1, button2,button3,button4,button5;
    private JPanel panel;

    public MainFrame() {

        setTitle("Home");

        // Create a panel to hold the buttons
        panel = new JPanel();

        // Create button1 and add an ActionListener to it
        button1 = new JButton("Find Group");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open a new frame when button1 is clicked
                new PageOneFrame();
            }
        });
        panel.add(button1);

        // Create button2 and add an ActionListener to it
        button2 = new JButton("View and Edit Profile");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open a new frame when button2 is clicked
                new PageTwoFrame();
            }
        });
        panel.add(button2);

        // Create button3 and add an ActionListener to it
        button3 = new JButton("Create Group");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open a new frame when button2 is clicked
                new PageThreeFrame();
            }
        });
        panel.add(button3);

        // Create button4 and add an ActionListener to it
        button4 = new JButton("Add Friends");
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open a new frame when button2 is clicked
                new PageFourFrame();
            }
        });
        panel.add(button4);

        // Create button5 and add an ActionListener to it
        button5 = new JButton("Book Court");
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open a new frame when button2 is clicked
                new PageFiveFrame();
            }
        });
        panel.add(button5);

        // Add the panel to the frame
        // add(panel);

        // Set the frame size and make it visible
        setSize(300, 250);
        setVisible(true);
        setLocationRelativeTo(null);
        panel.setBackground(Color.GREEN);

       /*  getContentPane().setLayout(new BorderLayout());
        ImageIcon imageIcon = new ImageIcon("r.jpg");
        JLabel backgroundLabel = new JLabel(imageIcon);
        backgroundLabel.setSize(getSize());
        getContentPane().add(backgroundLabel);*/

        JLabel label = new JLabel("Kalhspera Friend");
        label.setBounds(10, 10, 10, 20);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.BLACK);

        //panel.add(label);



        panel.setComponentZOrder(label, 0);
        setContentPane(panel);

        /* JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);
        mainPanel.add(button4);
        mainPanel.add(button5);

        JFrame mainFrame = new JFrame("Kalhspera Player");
        mainFrame.setContentPane(mainPanel);
        mainFrame.setSize(350, 350);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);*/
        //mainFrame.add(label);


    }


    public static void main(String[] args) {
        new MainFrame();

    }
}

// Example page one frame
class PageOneFrame extends JFrame {
    public PageOneFrame() {
        setTitle("Find Group");
        setSize(400, 500);
        setVisible(true);
        //  setLocationRelativeTo(null);

        JLabel label = new JLabel("Kalhspera Friend");
        label.setBounds(10, 10, 10, 20);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.BLACK);
        add(label);



    }
}

// Example page two frame
class PageTwoFrame extends JFrame {

    public PageTwoFrame() {
        setTitle("View and Edit Profile");
        setSize(400, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}

// Example page three frame
class PageThreeFrame extends JFrame {
    public PageThreeFrame() {
        setTitle("Create Group");
        setSize(400, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}

class PageFourFrame extends JFrame {
    public PageFourFrame() {
        setTitle("Add Friends");
        setSize(400, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
class PageFiveFrame extends JFrame {
    public PageFiveFrame() {
        setTitle("Book Court");
        setSize(400, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}