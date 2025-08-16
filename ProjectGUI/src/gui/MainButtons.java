package gui;

import manage.ThemeColors;
import manage.constant;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public class MainButtons {
    private LegendPanel legendPanel;
    private JButton Calculate;
    private JButton OpenFile;
    private JButton Back;
    private JButton About;
    private JButton Credit;
    private JTextField textField;
    private JPanel[] Grid;
    private double[] PercenGas;
    public double[] gasVolume;
    private double[] dept;
    private String[] token;
    private File loadFile;

    public MainButtons(LegendPanel legendPanel) {
        this.legendPanel = legendPanel;
        Calculate = new JButton();
        setTextField();
        setCalculate(Calculate);
        setOpenFile();
    }

    public void setTextField() {
        textField = new JTextField("2500");
        textField.setPreferredSize(new Dimension(250, 30));
        textField.setCaretColor(new Color(0, 0, 0, 0));
        textField.setHorizontalAlignment(JTextField.CENTER);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setOpenFile() {
        OpenFile = new JButton("Open File");
        OpenFile.setPreferredSize(new Dimension(250, 30));
        OpenFile.setBackground(ThemeColors.brightTurquoise);
        OpenFile.setFocusable(false);
        OpenFile.addActionListener(e -> {
            clickOpenFile();
        });
    }

    public JButton getOpenFile() {
        return OpenFile;
    }

    public void setCalculate(JButton calculate) {
        Calculate = new JButton("Calculate");
        Calculate.setFocusable(false);
        Calculate.setPreferredSize(new Dimension(250, 30));
        Calculate.setBackground(ThemeColors.brightLime);
        Calculate.addActionListener(e -> {
            if (token != null && Grid != null && PercenGas != null) {
                clickCalculate();
                legendPanel.addGrid(Grid, PercenGas);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Please open a file first before calculating.",
                        "No File Loaded",
                        JOptionPane.WARNING_MESSAGE);
            }
        });
    }

    public JButton getCalculate() {
        return Calculate;
    }

    public void clickOpenFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("src"));
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File loadFile = fileChooser.getSelectedFile();
            setCalculateDept(loadFile);

            int[] rc = getRowColumGrid(loadFile);
            legendPanel.getPanelGrid().setLayout(new GridLayout(rc[0], rc[1]));
            legendPanel.getPanelGrid().revalidate();
            legendPanel.getPanelGrid().repaint();
        }
    }

    public File getLoadFile() {
        return loadFile;
    }

    public void clickCalculate() {
        try {
            if (token == null || dept == null) {
                JOptionPane.showMessageDialog(null,
                        "Please open a file first before calculating.",
                        "No File Loaded",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            String str = textField.getText().trim();
            int fluid = Integer.parseInt(textField.getText());
            calculateDepth(dept, token, fluid);
            legendPanel.addGrid(Grid, PercenGas);
            legendPanel.getPanelGrid().revalidate();
            legendPanel.getPanelGrid().repaint();
            textField.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Please enter the correct number",
                    "An error occurred",
                    JOptionPane.ERROR_MESSAGE);
            textField.requestFocus();
        }
    }

    public void setCalculateDept(File file) {
        try {
            BufferedReader readFile = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = readFile.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String str = sb.toString();
            token = str.trim().split("\\s+");

            dept = new double[token.length];
            Grid = new JPanel[dept.length];
            gasVolume = new double[dept.length];
            PercenGas = new double[dept.length];

            int fluid = Integer.parseInt(textField.getText().trim());

            calculateDepth(dept, token, fluid);
            legendPanel.addGrid(Grid, PercenGas);
            legendPanel.getPanelGrid().revalidate();
            legendPanel.getPanelGrid().repaint();

            System.out.println(PercenGas[0]);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "File Not Found",
                    "File Not Found",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
        }
    }

    public int getLength() {
        return Grid.length;
    }

    public double getGasVolume(double dept, double Fluid) {
        double topHorizon = dept - 200;
        double minDept = Math.min(Fluid, dept);
        if (Fluid <= topHorizon) return 0;
        double GasVolume = constant.WidthY * constant.LengthX * (minDept - (topHorizon));
        return GasVolume;
    }

    public double getPercen(double dept, double fluid) {
        double topHorizon = dept - 200;
        double totalGas = dept - topHorizon;
        if (totalGas <= 0) return 0;
        double GasVolume = Math.max(0, Math.min(fluid, dept) - topHorizon);
        return (GasVolume / totalGas) * 100;
    }

    public void calculateDepth(double[] dept, String[] token, double fluid) {
        for (int i = 0; i < token.length; i++) {
            if (!token[i].matches("\\d+") || token[i].equals("0")) {
                dept[i] = 0;
                gasVolume[i] = 0;
                PercenGas[i] = 0;

                Grid[i] = new JPanel();
                Grid[i].setBorder(new LineBorder(ThemeColors.black, 1));
                Grid[i].add(new JLabel("0%"));
                Grid[i].setFocusable(false);
                continue;
            }
            dept[i] = Double.parseDouble(token[i]);
            gasVolume[i] = getGasVolume(dept[i], fluid);
            PercenGas[i] = getPercen(dept[i], fluid);
            DecimalFormat df = new DecimalFormat("#0.##");
            Grid[i] = new JPanel();
            Grid[i].setBorder(new LineBorder(ThemeColors.black, 1));
            Grid[i].add(new JLabel(df.format(PercenGas[i]) + "%"));
            Grid[i].setFocusable(false);
        }
    }

    public int[] getRowColumGrid(File file) {
        try {
            BufferedReader readFile = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = readFile.readLine()) != null) {
                sb.append(line).append("\n");
            }
            String str = sb.toString();
            String[] lines = str.split("\n");
            int rows = lines.length;
            String[] colsInFirstRow = str.split(" ");
            int cols = colsInFirstRow.length;
            return new int[]{rows, cols};
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "File Not Found",
                    "File Not Found",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
        }
        return new int[]{0};
    }

    public void checkAlphabet(String[] token) {
        for (int i = 0; i < token.length; i++) {
            if (!token[i].matches("\\d+")) {
                token[i] = "0";
            }
        }
    }

    public JButton clearButton() {
        JButton clear = new JButton("Clear File");
        clear.setPreferredSize(new Dimension(250, 30));
        clear.setBackground(ThemeColors.hotPink);
        clear.setFocusable(false);
        clear.addActionListener(e -> {
            token = null;
            dept = null;
            gasVolume = null;
            PercenGas = null;
            Grid = null;
            loadFile = null;

            textField.setText("2500"); // รีเซ็ตค่า input กลับไปค่า default

            // ลบ Grid ออกจากหน้าจอ
            legendPanel.getPanelGrid().removeAll();
            legendPanel.getPanelGrid().revalidate();
            legendPanel.getPanelGrid().repaint();

            JOptionPane.showMessageDialog(null,
                    "Data has been cleared.",
                    "Clear Complete",
                    JOptionPane.INFORMATION_MESSAGE);
        });
        return clear;
    }
}
