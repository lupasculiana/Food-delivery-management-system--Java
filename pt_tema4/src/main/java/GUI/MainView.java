package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JTextField usernameField;
    private JTextField passwordField;
    private JButton logInButton;
    private JButton createAccButton;


    public MainView() {
        this.getContentPane().setForeground(SystemColor.inactiveCaptionBorder);
        this.getContentPane().setBackground(SystemColor.window);
        this.setBounds(100, 100, 569, 398);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome !");
        welcomeLabel.setForeground(new Color(216, 168, 199));
        welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
        welcomeLabel.setBounds(185, 41, 302, 29);
        this.getContentPane().add(welcomeLabel);

        JLabel logInLabel = new JLabel("Don't have an account yet ?");
        logInLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        logInLabel.setForeground(new Color(0, 0, 0));
        logInLabel.setBounds(140, 147, 234, 19);
        this.getContentPane().add(logInLabel);

        logInButton = new JButton("Log In");
        logInButton.setForeground(SystemColor.desktop);
        logInButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        logInButton.setBounds(185, 92, 129, 29);
        this.getContentPane().add(logInButton);

        createAccButton = new JButton("Create account");
        createAccButton.setForeground(SystemColor.desktop);
        createAccButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        createAccButton.setBounds(185, 241, 129, 29);
        this.getContentPane().add(createAccButton);

        usernameField = new JTextField();
        usernameField.setForeground(SystemColor.activeCaption);
        usernameField.setBounds(185, 177, 129, 19);
        this.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        passwordField = new JTextField();
        passwordField.setForeground(SystemColor.activeCaption);
        passwordField.setColumns(10);
        passwordField.setBounds(185, 206, 129, 19);
        this.getContentPane().add(passwordField);

        JLabel usernameLabel = new JLabel("Username :");
        usernameLabel.setForeground(SystemColor.activeCaption);
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        usernameLabel.setBounds(105, 177, 103, 16);
        this.getContentPane().add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password :");
        passwordLabel.setForeground(SystemColor.activeCaption);
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        passwordLabel.setBounds(105, 209, 103, 16);
        this.getContentPane().add(passwordLabel);

        this.setVisible(true);
    }
    public void addLogInListener(ActionListener action) {
        this.logInButton.addActionListener(action);
    }
    public void addCreateAccListener(ActionListener action) {
        this.createAccButton.addActionListener(action);
    }
    public String getUsernameField() { return this.usernameField.getText();}
    public String getPasswordField(){return this.passwordField.getText();}
}
