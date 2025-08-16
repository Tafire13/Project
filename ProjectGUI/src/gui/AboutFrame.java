package gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JButton;

import manage.ThemeColors;

public class AboutFrame extends JFrame {
    private aboutPanel AboutPanel;
    public AboutFrame() {
        AboutPanel = new aboutPanel();
        setTitle("About");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250, 800);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        getContentPane().setBackground(ThemeColors.white);
        addComponentAbout();
        setVisible(true);
        clickBackButton(AboutPanel.getBackButton());
    }


    public void addComponentAbout(){
        add(AboutPanel.getTopPanel(), BorderLayout.NORTH);
        add(AboutPanel.getCenterPanel(), BorderLayout.CENTER);
        add(AboutPanel.getButtomPanel(), BorderLayout.SOUTH);
    }
    public void clickBackButton(JButton button){
        button.addActionListener(e->{
            dispose();
            setVisible(false);
            new MainFrame().setVisible(true);
        });
    }
}
