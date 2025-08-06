package gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainButtons {
    private JButton Calculate;
    private JButton OpenFile;
    private JButton Back;
    private JButton Credit;
    private JTextField textField;

    public MainButtons() {
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
        });
    }

    public JButton getCalculate() {
        return Calculate;
    }

    public void clickOpenFile() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
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
}
