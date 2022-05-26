package GUI;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

public class ViewReport extends JFrame{

    private JTextField firstReportField;
    private JTextField secondReportField;
    private JTextField thirdReportField;
    private JTextField fourthReportField;
    private JComboBox comboBox;
    private JButton generateButton;

    public ViewReport() {
        this.getContentPane().setForeground(SystemColor.window);
        this.getContentPane().setBackground(SystemColor.control);
        this.setBounds(100, 100, 774, 539);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel typeLabel = new JLabel("Choose the type of report : ");
        typeLabel.setForeground(Color.BLACK);
        typeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        typeLabel.setBounds(52, 39, 302, 13);
        this.getContentPane().add(typeLabel);

        comboBox = new JComboBox();
        comboBox.setForeground(SystemColor.desktop);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Time interval of the orders", "Products ordered more than a specified number of times so far", "Clients that have ordered more than a specified number of times so far and the value of the order was higher than a specified amount", "Products ordered within a specified day with the number of times they have been ordered"}));
        comboBox.setBounds(52, 74, 585, 38);
        this.getContentPane().add(comboBox);

        firstReportField = new JTextField();
        firstReportField.setForeground(SystemColor.desktop);
        firstReportField.setBounds(52, 150, 228, 38);
        this.getContentPane().add(firstReportField);
        firstReportField.setColumns(10);

        JLabel firstReportLabel = new JLabel("Introduce the start hour and end hour for first report :");
        firstReportLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        firstReportLabel.setForeground(new Color(0, 0, 0));
        firstReportLabel.setBounds(52, 127, 414, 13);
        this.getContentPane().add(firstReportLabel);

        JLabel secondReportLabel = new JLabel("Introduce the amount of times the product was ordered for second report :");
        secondReportLabel.setForeground(Color.BLACK);
        secondReportLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        secondReportLabel.setBounds(52, 198, 569, 13);
        this.getContentPane().add(secondReportLabel);

        secondReportField = new JTextField();
        secondReportField.setForeground(SystemColor.desktop);
        secondReportField.setColumns(10);
        secondReportField.setBounds(52, 221, 228, 38);
        this.getContentPane().add(secondReportField);

        JLabel thirdReportLabel = new JLabel("Introduce the amount of times a client ordered and the min cost for the third report :");
        thirdReportLabel.setForeground(Color.BLACK);
        thirdReportLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        thirdReportLabel.setBounds(52, 276, 646, 13);
        this.getContentPane().add(thirdReportLabel);

        thirdReportField = new JTextField();
        thirdReportField.setForeground(SystemColor.desktop);
        thirdReportField.setColumns(10);
        thirdReportField.setBounds(52, 299, 228, 38);
        this.getContentPane().add(thirdReportField);

        JLabel fourthReportLabel = new JLabel("Introduce the day until the products were placed for the fourth report :");
        fourthReportLabel.setForeground(Color.BLACK);
        fourthReportLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        fourthReportLabel.setBounds(52, 347, 646, 13);
        this.getContentPane().add(fourthReportLabel);

        fourthReportField = new JTextField();
        fourthReportField.setForeground(SystemColor.desktop);
        fourthReportField.setColumns(10);
        fourthReportField.setBounds(52, 370, 228, 38);
        this.getContentPane().add(fourthReportField);

        generateButton = new JButton("Generate report");
        generateButton.setForeground(SystemColor.desktop);
        generateButton.setFont(new Font("Tahoma", Font.BOLD, 14));
        generateButton.setBounds(52, 428, 183, 38);
        this.getContentPane().add(generateButton);

        this.setVisible(true);
    }

    public String getReportTypeField(){return this.comboBox.getSelectedItem().toString();}
    public String getFirstField() { return this.firstReportField.getText();}
    public String getSecondField() { return this.secondReportField.getText();}
    public String getThirdField() { return this.thirdReportField.getText();}
    public String getFourthField() { return this.fourthReportField.getText();}

    public void addEnterListener(ActionListener action) {
        this.generateButton.addActionListener(action);
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
