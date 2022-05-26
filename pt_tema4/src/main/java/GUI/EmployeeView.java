package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;

public class EmployeeView extends JFrame{

    private JTextField textField;

    public EmployeeView() {
        this.getContentPane().setForeground(SystemColor.inactiveCaptionBorder);
        this.getContentPane().setBackground(SystemColor.window);
        this.setBounds(100, 100, 569, 343);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Waiting for new orders ...");
        titleLabel.setForeground(SystemColor.desktop);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
        titleLabel.setBounds(156, 29, 359, 25);
        this.getContentPane().add(titleLabel);

        textField = new JTextField();
        textField.setForeground(SystemColor.activeCaption);
        textField.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField.setBounds(180, 64, 172, 152);
        this.getContentPane().add(textField);
        textField.setColumns(10);

        this.setVisible(true);
    }
    public String getTitleField() { return this.textField.getText();}
    public void setTitleField(String s) { textField.setText(s);}
}
