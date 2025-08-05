package gui;

import manage.ThemeColors;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.*;

public class LegendPanel {
    private JPanel leftPanel;
    private JPanel RightPanel;
    private JPanel panelGridInfo;
    private JPanel dataPanel;
    private JPanel panelGrid;
    private JPanel SouthPanal;
    ThemeColors themeColors = new ThemeColors();

    public LegendPanel() {
        leftPanel = new JPanel();
        RightPanel = new JPanel();
        panelGridInfo = new JPanel();
        dataPanel = new JPanel();
        SouthPanal = new JPanel();
        setLeftPanel(leftPanel);
        setRightPanel(RightPanel);
        setPanelGridInfo(panelGridInfo);
        setDataPanel(dataPanel);
        setSouthPanal(SouthPanal);
        addInfoGrid();
        addInfoData();
    }

    public void setLeftPanel(JPanel leftPanel) {
        this.leftPanel.setPreferredSize(new Dimension(900, 100));
        this.leftPanel.setBackground(themeColors.salmonPink);
        this.leftPanel.setBorder(new LineBorder(Color.BLACK, 2));
        this.leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30 ,30));
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
        this.panelGridInfo.setBorder(new LineBorder(Color.BLACK, 2));
    }

    public void setDataPanel(JPanel dataPanel) {
        this.dataPanel.setPreferredSize(new Dimension(400,400));
        this.dataPanel.setBackground(themeColors.white);
        this.dataPanel.setBorder(new LineBorder(themeColors.black, 2));
    }

    public JPanel getPanelGridInfo() {
        return panelGridInfo;
    }
    public void addInfoGrid(){
        leftPanel.add(panelGridInfo);
    }
    public void addInfoData(){
        RightPanel.add(dataPanel);
    }

    public void setSouthPanal(JPanel leftPanel) {
        this.SouthPanal.setPreferredSize(new Dimension(900, 100));
        this.SouthPanal.setBackground(themeColors.salmonPink);
        this.SouthPanal.setBorder(new LineBorder(Color.BLACK, 2));
        this.SouthPanal.setLayout(new FlowLayout(FlowLayout.CENTER, 30 ,30));
    }

    public JPanel getSouthPanal() {
        return SouthPanal;
    }
}
