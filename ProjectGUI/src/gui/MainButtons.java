package gui;

import manage.ThemeColors;
import manage.constant;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.time.Period;

public class MainButtons {
    private LegendPanel legendPanel;
    private JButton Calculate;
    private JButton OpenFile;
    private JButton Back;
    private JButton Credit;
    private JTextField textField;
    private JButton[] Grid;
    private double[] PercenGas;
    public int[] gasVolume;
    private int[] dept;
    private String[] token;
    ThemeColors themeColors = new ThemeColors();
    constant con = new constant();

    public MainButtons(LegendPanel legendPanel) {
        this.legendPanel = legendPanel;
        Calculate = new JButton();
        setTextField();
        setCalculate(Calculate);
        setOpenFile();
    }

    public void setTextField() {
        textField = new JTextField("2500");
        textField.setPreferredSize(new Dimension(300, 30));
        textField.setHorizontalAlignment(JTextField.CENTER);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setOpenFile() {
        OpenFile = new JButton("Open File");
        OpenFile.setPreferredSize(new Dimension(300, 30));
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
        Calculate.setPreferredSize(new Dimension(300, 30));
        Calculate.addActionListener(e -> {
            clickCalculate();
            legendPanel.addGrid(Grid, PercenGas);
        });
    }

    public JButton getCalculate() {
        return Calculate;
    }

    public void clickOpenFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("src"));
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            setCalculateDept(selectedFile);
        }


    }

    public void clickCalculate() {
        try {
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
            dept = new int[token.length];
            Grid = new JButton[dept.length];
            gasVolume = new int[dept.length];
            PercenGas = new double[dept.length];
            int fluid = Integer.parseInt(textField.getText().trim());
            calculateDepth(dept, token, fluid);
            legendPanel.addGrid(Grid, PercenGas);
            legendPanel.getPanelGrid().revalidate();
            legendPanel.getPanelGrid().repaint();

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
    public int getGasVolume(int dept, int Fluid){
        int topHorizon = dept-200;
        int minDept = Math.min(Fluid, dept);
        if(Fluid <= topHorizon) return 0;
        int GasVolume = con.WidthY * con.LengthX * (minDept-(topHorizon));
        return GasVolume;
    }
    public double getPercen(int dept, int fluid){
        int topHorizon  = dept - 200;
        int totalGas = dept - topHorizon;
        if(totalGas <= 0) return 0;
        double GasVolume = Math.max(0,Math.min(fluid, dept)-topHorizon);
        return (GasVolume / totalGas) *100;
    }
    public void calculateDepth(int[] dept, String[] token, int fluid){
        for (int i = 0; i < token.length; i++) {
            dept[i] = Integer.parseInt(token[i]);
            gasVolume[i] = getGasVolume(dept[i], fluid);
            PercenGas[i] = getPercen(dept[i], fluid);
            Grid[i] = new JButton(String.valueOf(PercenGas[i]));
            Grid[i].setFocusable(false);
        }
    }
}
