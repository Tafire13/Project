package gui;

import manage.ThemeColors;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MainButtons {
    private LegendPanel legendPanel;
    private JButton Calculate;
    private JButton OpenFile;
    private JButton Back;
    private JButton Credit;
    private JTextField textField;
    private JButton[] Grid;
    ThemeColors themeColors = new ThemeColors();

    public MainButtons(LegendPanel legendPanel) {
        this.legendPanel = legendPanel;
        Calculate = new JButton();
        setTextField();
        setCalculate(Calculate);
        setOpenFile();
    }

    public void setTextField() {
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 30));
        textField.setHorizontalAlignment(JTextField.CENTER);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setOpenFile() {
        OpenFile = new JButton("Open File");
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
            legendPanel.addGrid(Grid);
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
            textField.setText("");
            int dept = Integer.parseInt(str);
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
            String[] token = str.trim().split("\\s+");
            int[] Numeric = new int[token.length];
            Grid = new JButton[Numeric.length];
            for (int i = 0; i < token.length; i++) {
                Numeric[i] = Integer.parseInt(token[i]);
                Grid[i] = new JButton(String.valueOf(Numeric[i]));
                Grid[i].setFocusable(false);
            }

            legendPanel.addGrid(Grid);
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
}
