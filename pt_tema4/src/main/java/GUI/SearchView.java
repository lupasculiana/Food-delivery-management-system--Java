package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SearchView extends JFrame {

    private JTextField keywordField;
    private JTextField textField;
    private JComboBox comboBox;
    private JButton enterButton;

    public SearchView() {
        this.getContentPane().setForeground(SystemColor.inactiveCaptionBorder);
        this.getContentPane().setBackground(SystemColor.window);
        this.setBounds(100, 100, 569, 343);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel keywordLabel = new JLabel("Enter keyword to search  :");
        keywordLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        keywordLabel.setForeground(SystemColor.desktop);
        keywordLabel.setBounds(34, 94, 256, 13);
        this.getContentPane().add(keywordLabel);

        keywordField = new JTextField();
        keywordField.setBounds(34, 117, 143, 19);
        this.getContentPane().add(keywordField);
        keywordField.setColumns(10);

        JLabel columnLabel = new JLabel("Select column to search by :");
        columnLabel.setForeground(SystemColor.desktop);
        columnLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        columnLabel.setBounds(34, 29, 256, 13);
        this.getContentPane().add(columnLabel);

        comboBox = new JComboBox();
        comboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        comboBox.setForeground(SystemColor.desktop);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"title", "rating", "calories", "proteins", "fats", "sodium", "price"}));
        comboBox.setBounds(34, 52, 143, 21);
        this.getContentPane().add(comboBox);

        enterButton = new JButton("Enter");
        enterButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        enterButton.setForeground(SystemColor.desktop);
        enterButton.setBounds(34, 148, 126, 21);
        this.getContentPane().add(enterButton);

        textField = new JTextField();
        textField.setForeground(SystemColor.activeCaption);
        textField.setFont(new Font("Tahoma", Font.BOLD, 12));
        textField.setBounds(34, 196, 337, 59);
        this.getContentPane().add(textField);
        textField.setColumns(10);

        this.setVisible(true);
    }
    public String getColumnField(){return this.comboBox.getSelectedItem().toString();}
    public String getKeywordField() { return this.keywordField.getText();}
    public void setTextField(List<String> s) { textField.setText(String.valueOf(s));}
    public void addEnterListener(ActionListener action) {
        this.enterButton.addActionListener(action);
    }
}
