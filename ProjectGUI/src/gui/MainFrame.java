package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.*;

import manage.constant;
import manage.ThemeColors;



public class MainFrame extends JFrame {
    LegendPanel legendPanel = new LegendPanel();
    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(constant.width, constant.height);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        addComponent();
    }
    public void addComponent(){
        add(legendPanel.getLeftPanel(), BorderLayout.WEST);
        add(legendPanel.getRightPanel(), BorderLayout.EAST);
        add(legendPanel.getSouthPanal(), BorderLayout.SOUTH);
        legendPanel.getSouthPanal().add(getAboutButton());
    }
    public JButton getAboutButton() {
        JButton About = new JButton("About");
        About.setPreferredSize(new Dimension(300, 50));
        About.setBackground(ThemeColors.pinkkie);
        About.setFocusable(false);
        About.setFont(new Font("" ,0,20));
        About.addActionListener(e -> {
            dispose();
            new AboutFrame();
        });
        return About;
    }
}
