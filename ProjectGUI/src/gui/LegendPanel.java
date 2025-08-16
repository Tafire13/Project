package gui;

import manage.ThemeColors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;

public class LegendPanel {
    private JPanel leftPanel;
    private JPanel RightPanel;
    private JPanel panelGridInfo;
    private JPanel dataPanel;
    private JPanel panelGrid;
    private JPanel SouthPanal;
    private JPanel fileControlPanel;
    private MainButtons mainButtons;

    private JButton[] Grid;

    public LegendPanel() {
        leftPanel = new JPanel();
        RightPanel = new JPanel();
        panelGridInfo = new JPanel();
        panelGrid = new JPanel();
        dataPanel = new JPanel();
        SouthPanal = new JPanel();
        fileControlPanel = new JPanel();

        mainButtons = new MainButtons(this);

        setLeftPanel(leftPanel);
        setRightPanel(RightPanel);
        setPanelGridInfo(panelGridInfo);
        setDataPanel(dataPanel);
        setSouthPanal(SouthPanal);
        setPanelGrid(panelGrid);
        setFileControlPanel(fileControlPanel);

        addInfoGrid();
        addInfoData();
        BoxColorGas(GasBoxPanel(), textPercenGas());
        fileControl();
    }

    public void setLeftPanel(JPanel leftPanel) {
        this.leftPanel.setPreferredSize(new Dimension(1050, 100));
        this.leftPanel.setBackground(ThemeColors.salmonPink);
        this.leftPanel.setBorder(new LineBorder(ThemeColors.black, 2));
        this.leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public void setRightPanel(JPanel RightPanel) {
        this.RightPanel.setPreferredSize(new Dimension(350, 100));
        this.RightPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 30));
        this.RightPanel.setBackground(ThemeColors.salmonPink);
        this.RightPanel.setBorder(new LineBorder(ThemeColors.black, 2));
    }

    public JPanel getRightPanel() {
        return RightPanel;
    }

    public void setPanelGridInfo(JPanel panelGridInfo) {
        this.panelGridInfo.setPreferredSize(new Dimension(1000, 500));
        this.panelGridInfo.setBackground(ThemeColors.white);
        this.panelGridInfo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 2));
        this.panelGridInfo.setBorder(new LineBorder(ThemeColors.black, 2));
    }

    public void setDataPanel(JPanel dataPanel) {
        this.dataPanel.setPreferredSize(new Dimension(280, 350));
        this.dataPanel.setBackground(ThemeColors.white);
        this.dataPanel.setBorder(new LineBorder(ThemeColors.black, 2));
    }

    public JPanel getPanelGridInfo() {
        return panelGridInfo;
    }

    public void setPanelGrid(JPanel panelGrid) {
        this.panelGrid.setPreferredSize(new Dimension(990, 490));
        this.panelGrid.setBackground(ThemeColors.white);
        File file = mainButtons.getLoadFile();
        if (file != null) {
            int[] rc = mainButtons.getRowColumGrid(file);
            this.panelGrid.setLayout(new GridLayout(rc[0], rc[1], 1 ,1));
        } else {
            this.panelGrid.setLayout(new GridLayout(1, 1 , 1,1));
        }

        this.panelGrid.setBorder(new LineBorder(ThemeColors.black, 2));
    }


    public JPanel getDataPanel() {
        return dataPanel;
    }

    public void setSouthPanal(JPanel leftPanel) {
        this.SouthPanal.setPreferredSize(new Dimension(900, 100));
        this.SouthPanal.setBackground(ThemeColors.salmonPink);
        this.SouthPanal.setBorder(new LineBorder(ThemeColors.black, 2));
        this.SouthPanal.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
    }

    public JPanel getSouthPanal() {
        return SouthPanal;
    }

    public void setFileControlPanel(JPanel fileControlPanel) {
        this.fileControlPanel = fileControlPanel;
        this.fileControlPanel.setPreferredSize(new Dimension(280, 170));
        this.fileControlPanel.setBackground(ThemeColors.white);
        this.fileControlPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
        this.fileControlPanel.setBorder(new LineBorder(ThemeColors.black, 2));
    }

    public JPanel getPanelGrid() {
        return panelGrid;
    }

    public void addInfoData() {
        RightPanel.add(dataPanel);
        RightPanel.add(fileControlPanel);
    }

    public void addInfoGrid() {
        leftPanel.add(panelGridInfo);
        panelGridInfo.add(panelGrid);
    }

    public void fileControl() {
        fileControlPanel.add(mainButtons.getTextField());
        fileControlPanel.add(mainButtons.getCalculate());
        fileControlPanel.add(mainButtons.getOpenFile());
    }

    public void addGrid(JPanel[] GasBox, double[] Percen) {
        panelGrid.removeAll();
        for (int i = 0; i < GasBox.length; i++) {
            if (Percen[i] >= 50.0) {
                GasBox[i].setBackground(ThemeColors.brightGreen);
            } else if (Percen[i] <= 50.0 && Percen[i] > 0.0) {
                GasBox[i].setBackground(ThemeColors.brightYellow);
            } else {
                GasBox[i].setBackground(ThemeColors.red);
            }
            panelGrid.add(GasBox[i]);
        }
    }

    public JPanel[] GasBoxPanel() {
        JPanel[] box = new JPanel[3];
        for (int i = 0; i < box.length; i++) {
            box[i] = new JPanel();
            box[i].setPreferredSize(new Dimension(60, 60));
        }
        box[0].setBackground(ThemeColors.red);
        box[1].setBackground(ThemeColors.brightYellow);
        box[2].setBackground(ThemeColors.brightGreen);
        return box;
    }

    public void BoxColorGas(JPanel[] box, JLabel[] Percen) {
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        for (int i = 0; i < box.length; i++) {
            JPanel row = new JPanel();
            row.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 30));
            row.add(box[i]);
            row.add(Percen[i]);
            dataPanel.add(row);
        }
    }
    public JLabel[] textPercenGas(){
        JLabel[] Percen = new JLabel[3];
        Percen[0] = new JLabel(" = 0%");
        Percen[1] = new JLabel(" < 50%");
        Percen[2] = new JLabel(" >= 50%");
        for (int i = 0; i < Percen.length; i++) {
            Percen[i].setFont(new Font(null, Font.PLAIN, 36));
        }
        return Percen;
    }
}
