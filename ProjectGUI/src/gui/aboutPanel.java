package gui;

import manage.ThemeColors;
import manage.constant;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class aboutPanel {
    constant con = new constant();
    ThemeColors themeColors = new ThemeColors();
    private JPanel topPanel;
    private JPanel buttomPanel;
    private JPanel centerPanel;
    private JPanel[] imagePanel = new JPanel[3];
    private ImageIcon[] imageIcon;
    private JLabel[] imageLabel = new JLabel[3];
    private JLabel[] DataLabel = new JLabel[3];
    public aboutPanel() {
        topPanel = new JPanel();
        centerPanel = new JPanel();
        buttomPanel = new JPanel();
        imagePanel = new JPanel[3];
        imageIcon = new ImageIcon[3];
        setTopPanel(topPanel);
        setBottomLabel(buttomPanel);
        setCenterPanel(centerPanel);
        setImagePanel(imagePanel);
        setImageIcon();
        setDataLabel(DataLabel);
        addPanelImage(centerPanel);
        addImage(imageIcon, imagePanel);
        addData(DataLabel, imagePanel);
        JLabel title = new JLabel("About Group");
        title.setFont(new Font("Arial", Font.BOLD, 48));
        title.setBounds(500, 30, 2000, 50);
        topPanel.add(title, BorderLayout.CENTER);
    }

    public void setTopPanel(JPanel topPanel) {
        this.topPanel = topPanel;
        this.topPanel.setPreferredSize(new Dimension(100, 100));
        this.topPanel.setBackground(themeColors.white);
        this.topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public void setBottomLabel(JPanel buttomPanel) {
        this.buttomPanel = buttomPanel;
        this.buttomPanel.setPreferredSize(new Dimension(100, 100));
        this.buttomPanel.setBorder(new LineBorder(themeColors.black, 2));
        this.buttomPanel.setBackground(themeColors.white);
        this.buttomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 40));
    }

    public JPanel getButtomPanel() {
        return buttomPanel;
    }

    public void setCenterPanel(JPanel centerPanel) {
        this.centerPanel = centerPanel;
        this.centerPanel.setBorder(new LineBorder(themeColors.black, 2));
        this.centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public void setImagePanel(JPanel[] imagePanel) {
        this.imagePanel = imagePanel;
        for (int i = 0; i < imagePanel.length; i++) {
            this.imagePanel[i] = new JPanel();
            this.imagePanel[i].setPreferredSize(new Dimension(300, 500));
            this.imagePanel[i].setBorder(new LineBorder(themeColors.black, 2));
            this.imagePanel[i].setLayout(new FlowLayout(FlowLayout.CENTER,0 , 0));
            this.imagePanel[i].setBackground(themeColors.white);
        }
    }

    public void addPanelImage(JPanel panel) {
        for (int i = 0; i < imagePanel.length; i++) {
            panel.add(imagePanel[i]);

        }
    }
    public void addData(JLabel[] labels, JPanel[] panel){
        for (int i = 0; i < labels.length; i++) {
            panel[i].add(labels[i]);
        }
    }
    public void setImageIcon() {
        this.imageIcon = new ImageIcon[]{
                loadImage("/image/chok.JPG", 295, 400),
                loadImage("/image/khunQ.JPG", 295, 400),
                loadImage("/image/p.JPG", 295, 400)
        };
    }
    private ImageIcon loadImage(String path, int width, int height) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL == null) {
            return null;
        }
        Image img = new ImageIcon(imgURL).getImage()
                .getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }

    public void addImage(ImageIcon[] imageIcon, JPanel[] panel) {
        for (int i = 0; i < imageIcon.length; i++) {
            imageLabel[i] = new JLabel(imageIcon[i]);
            panel[i].add(imageLabel[i], BorderLayout.CENTER);
        }
    }

    public void setDataLabel(JLabel[] dataLabel) {
        for (int i = 0; i < dataLabel.length; i++) {
            dataLabel[i] = new JLabel("<html>Name :"+con.name[i] + "<br> SID :" + con.SID[i] + "</html>");
            dataLabel[i].setFont(new Font("TH Sarabun New", Font.PLAIN, 32));
        }
    }
}
