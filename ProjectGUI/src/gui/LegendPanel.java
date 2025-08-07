package gui;

import manage.ThemeColors;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LegendPanel {
    private JPanel leftPanel;
    private JPanel RightPanel;
    private JPanel panelGridInfo;
    private JPanel dataPanel;
    private JPanel panelGrid;
    private JPanel SouthPanal;
    private JPanel fileControlPanel;
    ThemeColors themeColors = new ThemeColors();
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

        setLeftPanel(leftPanel);
        setRightPanel(RightPanel);
        setPanelGridInfo(panelGridInfo);
        setDataPanel(dataPanel);
        setSouthPanal(SouthPanal);
        setPanelGrid(panelGrid);
        setFileControlPanel(fileControlPanel);
        mainButtons = new MainButtons(this);

        addInfoGrid();
        addInfoData();
        fileControl();
    }

    public void setLeftPanel(JPanel leftPanel) {
        this.leftPanel.setPreferredSize(new Dimension(900, 100));
        this.leftPanel.setBackground(themeColors.salmonPink);
        this.leftPanel.setBorder(new LineBorder(Color.BLACK, 2));
        this.leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public void setRightPanel(JPanel RightPanel) {
        this.RightPanel.setPreferredSize(new Dimension(500, 100));
        this.RightPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 30));
        this.RightPanel.setBackground(themeColors.salmonPink);
        this.RightPanel.setBorder(new LineBorder(Color.BLACK, 2));
    }

    public JPanel getRightPanel() {
        return RightPanel;
    }

    public void setPanelGridInfo(JPanel panelGridInfo) {
        this.panelGridInfo.setPreferredSize(new Dimension(800, 400));
        this.panelGridInfo.setBackground(themeColors.white);
        this.panelGridInfo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        this.panelGridInfo.setBorder(new LineBorder(Color.BLACK, 2));
    }

    public void setDataPanel(JPanel dataPanel) {
        this.dataPanel.setPreferredSize(new Dimension(400, 400));
        this.dataPanel.setBackground(themeColors.white);
        this.dataPanel.setBorder(new LineBorder(themeColors.black, 2));
    }

    public JPanel getPanelGridInfo() {
        return panelGridInfo;
    }

    public void setPanelGrid(JPanel panelGrid) {
        this.panelGrid.setPreferredSize(new Dimension(795, 395));
        this.panelGrid.setBackground(themeColors.white);
        this.panelGrid.setLayout(new GridLayout(10, 20));
        this.panelGrid.setBorder(new LineBorder(themeColors.black, 2));
    }

    public JPanel getDataPanel() {
        return dataPanel;
    }

    public void setSouthPanal(JPanel leftPanel) {
        this.SouthPanal.setPreferredSize(new Dimension(900, 100));
        this.SouthPanal.setBackground(themeColors.salmonPink);
        this.SouthPanal.setBorder(new LineBorder(Color.BLACK, 2));
        this.SouthPanal.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 30));
    }

    public JPanel getSouthPanal() {
        return SouthPanal;
    }

    public void setFileControlPanel(JPanel fileControlPanel) {
        this.fileControlPanel = fileControlPanel;
        this.fileControlPanel.setPreferredSize(new Dimension(400, 170));
        this.fileControlPanel.setBackground(themeColors.white);
        this.fileControlPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 40, 10));
        this.fileControlPanel.setBorder(new LineBorder(themeColors.black, 2));
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

    public void addGrid(JButton[] button) {
        panelGrid.removeAll();
        for (int i = 0; i < button.length; i++) {
            button[i].setBackground(themeColors.aquaMarine);
            panelGrid.add(button[i]);
        }
    }
}
