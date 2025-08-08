package gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AboutFrame extends JFrame {

    public AboutFrame() {
        setTitle("About");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250, 800);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(255, 230, 230)); 
        setLayout(null); 



        JLabel title = new JLabel("About Group");
        title.setFont(new Font("Arial", Font.BOLD, 48));
        title.setBounds(500, 30, 2000, 50);
        add(title);



        
        ImageIcon imageIcon = new ImageIcon("c.JPG"); 
        Image image = imageIcon.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);


        JLabel imgLabel1 = new JLabel(scaledIcon);
        imgLabel1.setBounds(60, 150, 350, 350);
        add(imgLabel1);
        
           JFrame data = new JFrame();
           JLabel label = new JLabel(
                    "Chok");
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            data.setSize(200, 100);
            data.setLayout(new GridLayout(1, 1));
            label.setOpaque(true);
            label.setBackground(new Color(255, 192, 203));
            data.setUndecorated(true);
            data.setLocationRelativeTo(null);
            data.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            data.add(label);
        imgLabel1.addMouseListener(new MouseAdapter() {
                     @Override
                public void mouseEntered(MouseEvent e) {
                  data.setVisible(true);
              
                }

                @Override
                public void mouseExited(MouseEvent e) {
                     data.setVisible(false);
                    
                }
        }); 
        ImageIcon imageIcon2 = new ImageIcon("p.JPG");
        Image image2 = imageIcon2.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(image2);
       


        JLabel imgLabel2 = new JLabel(scaledIcon2);
        imgLabel2.setBounds(445, 150, 350, 350);
        add(imgLabel2);
          JFrame data2 = new JFrame();
         JLabel label2 = new JLabel(
                    "Plume");
            label2.setHorizontalAlignment(JLabel.CENTER);
            label2.setVerticalAlignment(JLabel.CENTER);
            data2.setSize(200, 100);
            data2.setLayout(new GridLayout(1, 1));
            label2.setOpaque(true);
            label2.setBackground(new Color(255, 192, 203));
            data2.setUndecorated(true);
            data2.setLocationRelativeTo(null);
            data2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            data2.add(label2);
        imgLabel2.addMouseListener(new MouseAdapter() {
                     @Override
                public void mouseEntered(MouseEvent e) {
                  data2.setVisible(true);
              
                }

                @Override
                public void mouseExited(MouseEvent e) {
                     data2.setVisible(false);
                    
                }
        }); 
     


          ImageIcon imageIcon3 = new ImageIcon("q.png");
        Image image3 = imageIcon3.getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(image3);


        JLabel imgLabel3 = new JLabel(scaledIcon3);
        imgLabel3.setBounds(830, 150, 350, 350);
        add(imgLabel3);
        JFrame data3 = new JFrame();
         JLabel label3 = new JLabel(
                    "Kiw");
            label3.setHorizontalAlignment(JLabel.CENTER);
            label3.setVerticalAlignment(JLabel.CENTER);
            data3.setSize(200, 100);
            data3.setLayout(new GridLayout(1, 1));
            label3.setOpaque(true);
            label3.setBackground(new Color(255, 192, 203));
            data3.setUndecorated(true);
            data3.setLocationRelativeTo(null);
            data3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            data3.add(label3); 
        imgLabel3.addMouseListener(new MouseAdapter() {
                     @Override
                public void mouseEntered(MouseEvent e) {
                  data3.setVisible(true);
              
                }

                @Override
                public void mouseExited(MouseEvent e) {
                 data3.setVisible(false);
                    
                }
        }); 
    
     
        JButton backButton = new JButton("Back");
        backButton.setBounds(30, 700, 120, 40);
        backButton.setBackground(new Color(255, 0, 0));
        backButton.setFont(new Font("Arial", Font.PLAIN, 18));
        add(backButton);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AboutFrame();
    }
}