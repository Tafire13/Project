package gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import manage.constant;



public class MainFrame extends JFrame {
    constant constant = new constant();
    LegendPanel legendPanel = new LegendPanel();
    public MainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(constant.width, constant.height);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        addComponent();
    }
    public void addComponent(){
        add(legendPanel.getLeftPanel(), BorderLayout.WEST);
        add(legendPanel.getRightPanel(), BorderLayout.EAST);
        add(legendPanel.getSouthPanal(), BorderLayout.SOUTH);
    }

}
