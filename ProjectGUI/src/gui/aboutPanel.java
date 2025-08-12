package gui;

import manage.ThemeColors;
import manage.constant;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class aboutPanel {
    constant con = new constant();
    ThemeColors themeColors = new ThemeColors();

    private JPanel topPanel;
    private JPanel buttomPanel;
    private JPanel centerPanel;
    private JPanel[] imagePanel;
    private ImageIcon[] imageIcon;
    private JLabel[] imageLabel = new JLabel[3];
    private JLabel[] DataLabel = new JLabel[3];
    private JButton backButton;

    public aboutPanel() {
        setTopPanel();
        setBottomLabel();
        setCenterPanel();
        setImagePanel();
        setImageIcon();
        setDataLabel();
        setBackButton();

        addPanelImage(centerPanel);
        addImage(imageIcon, imagePanel);
        addData(DataLabel, imagePanel);

        buttomPanel.add(backButton);
        JLabel title = new JLabel("About Group");
        title.setFont(new Font("Arial", Font.BOLD, 48));
        title.setBounds(500, 30, 2000, 50);
        topPanel.add(title, BorderLayout.CENTER);
    }

    public void setTopPanel() {
        this.topPanel = new JPanel();
        this.topPanel.setPreferredSize(new Dimension(100, 100));
        this.topPanel.setBackground(themeColors.white);
        this.topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public void setBottomLabel() {
        this.buttomPanel = new JPanel();
        this.buttomPanel.setPreferredSize(new Dimension(100, 100));
        this.buttomPanel.setBorder(new LineBorder(themeColors.black, 2));
        this.buttomPanel.setBackground(themeColors.white);
        this.buttomPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 25));
    }

    public JPanel getButtomPanel() {
        return buttomPanel;
    }

    public void setCenterPanel() {
        this.centerPanel = new JPanel();
        this.centerPanel.setBorder(new LineBorder(themeColors.black, 2));
        this.centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 25));
    }

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public void setImagePanel() {
        this.imagePanel = new JPanel[3];
        for (int i = 0; i < 3; i++) {
            this.imagePanel[i] = new JPanel();
            this.imagePanel[i].setPreferredSize(new Dimension(300, 500));
            this.imagePanel[i].setBorder(new LineBorder(themeColors.black, 2));
            this.imagePanel[i].setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
            this.imagePanel[i].setBackground(themeColors.white);
        }
    }

    public void addPanelImage(JPanel panel) {
        for (int i = 0; i < imagePanel.length; i++) {
            panel.add(imagePanel[i]);
        }
    }

    public void setImageIcon() {
        this.imageIcon = new ImageIcon[3];
        this.imageIcon[0] = loadImage("/image/chok.JPG", 295, 400);
        this.imageIcon[1] = loadImage("/image/khunQ.JPG", 295, 400);
        this.imageIcon[2] = loadImage("/image/sudlor.JPG", 500, 400);
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
            panel[i].add(imageLabel[i]);
        }
    }

    public void setDataLabel() {
        this.DataLabel = new JLabel[3];
        for (int i = 0; i < DataLabel.length; i++) {
            DataLabel[i] = new JLabel("<html>Name : " + con.name[i] + "<br> SID : " + con.SID[i] + "</html>");
            DataLabel[i].setFont(new Font("TH Sarabun New", Font.PLAIN, 32));
        }
    }

    public void addData(JLabel[] labels, JPanel[] panel) {
        for (int i = 0; i < labels.length; i++) {
            panel[i].add(labels[i]);
        }
    }

    public void setBackButton() {
        this.backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(100, 50));
        backButton.setFocusable(false);
        backButton.setBackground(themeColors.red);
    }

    public JButton getBackButton() {
        return backButton;
    }
}
