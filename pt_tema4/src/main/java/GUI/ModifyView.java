package GUI;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

public class ModifyView extends JFrame {

    private JTextField productField;
    private JTextField newValueField;
    private JComboBox comboBox;
    private JButton enterButton;

    public ModifyView() {
        this.getContentPane().setForeground(SystemColor.inactiveCaptionBorder);
        this.getContentPane().setBackground(SystemColor.window);
        this.setBounds(100, 100, 569, 343);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel modifyLabel = new JLabel("Introduce the details of the product that you want to modify :");
        modifyLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        modifyLabel.setForeground(SystemColor.desktop);
        modifyLabel.setBounds(20, 22, 452, 19);
        this.getContentPane().add(modifyLabel);

        enterButton = new JButton("Modify product");
        enterButton.setForeground(SystemColor.desktop);
        enterButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        enterButton.setBounds(20, 249, 129, 29);
        this.getContentPane().add(enterButton);

        productField = new JTextField();
        productField.setForeground(SystemColor.activeCaption);
        productField.setBounds(20, 57, 370, 19);
        this.getContentPane().add(productField);
        productField.setColumns(10);

        comboBox = new JComboBox();
        comboBox.setForeground(SystemColor.desktop);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"title", "rating", "calories", "protein", "sodium", "fat", "price"}));
        comboBox.setBounds(20, 132, 129, 21);
        this.getContentPane().add(comboBox);

        JLabel columnLabel = new JLabel("Select what do you want to modify for the product :");
        columnLabel.setForeground(SystemColor.desktop);
        columnLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        columnLabel.setBounds(20, 102, 452, 19);
        this.getContentPane().add(columnLabel);

        JLabel newValueLabel = new JLabel("Introduce the new value for the chosen column :");
        newValueLabel.setForeground(SystemColor.desktop);
        newValueLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        newValueLabel.setBounds(20, 173, 452, 19);
        this.getContentPane().add(newValueLabel);

        newValueField = new JTextField();
        newValueField.setForeground(SystemColor.activeCaption);
        newValueField.setColumns(10);
        newValueField.setBounds(20, 206, 370, 19);
        this.getContentPane().add(newValueField);

        this.setVisible(true);
    }
    public String getColumnField(){return this.comboBox.getSelectedItem().toString();}
    public String getProductField(){return this.productField.getText();}
    public String getNewValueField(){return this.newValueField.getText();}
    public void addEnterListener(ActionListener action) {
        this.enterButton.addActionListener(action);
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
