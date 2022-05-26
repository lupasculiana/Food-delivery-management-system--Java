package GUI;

import javax.swing.*;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

public class View extends JFrame{

    private JTextField usernameField;
    private JTextField passwordField;
    private JButton btnNewButton;
    private JComboBox comboBox;

    public View() {
        this.getContentPane().setForeground(SystemColor.window);
        this.getContentPane().setBackground(SystemColor.control);
        this.setBounds(100, 100, 348, 404);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        comboBox = new JComboBox();
        comboBox.setForeground(SystemColor.desktop);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Client", "Admin", "Employee"}));
        comboBox.setBounds(73, 63, 148, 27);
        this.getContentPane().add(comboBox);

        JLabel typeLabel = new JLabel("Select which type of user you are :");
        typeLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        typeLabel.setBounds(25, 27, 302, 13);
        this.getContentPane().add(typeLabel);

        JLabel usernameLabel = new JLabel("Enter username :");
        usernameLabel.setForeground(SystemColor.activeCaptionText);
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        usernameLabel.setBounds(73, 113, 164, 13);
        this.getContentPane().add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setForeground(SystemColor.desktop);
        usernameField.setBounds(73, 146, 148, 27);
        this.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        JLabel passwordLabel = new JLabel("Enter password :");
        passwordLabel.setForeground(SystemColor.infoText);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        passwordLabel.setBounds(73, 183, 164, 13);
        this.getContentPane().add(passwordLabel);

        passwordField = new JTextField();
        passwordField.setForeground(SystemColor.desktop);
        passwordField.setColumns(10);
        passwordField.setBounds(73, 206, 148, 27);
        this.getContentPane().add(passwordField);

        btnNewButton = new JButton("LOG IN");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnNewButton.setForeground(SystemColor.desktop);
        btnNewButton.setBounds(82, 264, 139, 54);
        this.getContentPane().add(btnNewButton);

        this.setVisible(true);
    }

    public String getUsernameField() { return this.usernameField.getText();}

    public void addLogInListener(ActionListener action) {
        this.btnNewButton.addActionListener(action);
    }

    public String getPasswordField(){return this.passwordField.getText();}

    public String getTypeField(){return this.comboBox.getSelectedItem().toString();}

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
