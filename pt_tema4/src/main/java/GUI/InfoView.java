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

public class InfoView extends JFrame {

    private JFrame frame;
    private JTextField priceField;
    private JTextField sodiumField;
    private JTextField fatsField;
    private JTextField proteinsField;
    private JTextField caloriesField;
    private JTextField ratingField;
    private JTextField titleField;
    private JButton enterButton;

    public InfoView() {
        this.getContentPane().setForeground(SystemColor.inactiveCaptionBorder);
        this.getContentPane().setBackground(SystemColor.window);
        this.setBounds(100, 100, 569, 418);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel titleLabel = new JLabel("Enter title of the product :");
        titleLabel.setForeground(new Color(216, 168, 199));
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        titleLabel.setBounds(145, 13, 302, 29);
        this.getContentPane().add(titleLabel);

        enterButton = new JButton("Enter info");
        enterButton.setForeground(SystemColor.desktop);
        enterButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        enterButton.setBounds(10, 322, 129, 29);
        this.getContentPane().add(enterButton);

        priceField = new JTextField();
        priceField.setForeground(SystemColor.activeCaption);
        priceField.setBounds(10, 293, 129, 19);
        this.getContentPane().add(priceField);
        priceField.setColumns(10);

        sodiumField = new JTextField();
        sodiumField.setForeground(SystemColor.activeCaption);
        sodiumField.setColumns(10);
        sodiumField.setBounds(10, 251, 129, 19);
        this.getContentPane().add(sodiumField);

        JLabel ratingLabel = new JLabel("Enter rating of the product :");
        ratingLabel.setForeground(SystemColor.desktop);
        ratingLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        ratingLabel.setBounds(10, 39, 302, 29);
        this.getContentPane().add(ratingLabel);

        JLabel caloriesLabel = new JLabel("Enter calories of the product :");
        caloriesLabel.setForeground(SystemColor.desktop);
        caloriesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        caloriesLabel.setBounds(10, 78, 302, 29);
        this.getContentPane().add(caloriesLabel);

        JLabel proteinsLabel = new JLabel("Enter proteins of the product :");
        proteinsLabel.setForeground(SystemColor.desktop);
        proteinsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        proteinsLabel.setBounds(10, 127, 302, 29);
        this.getContentPane().add(proteinsLabel);

        JLabel fatsLabel = new JLabel("Enter fats of the product :");
        fatsLabel.setForeground(SystemColor.desktop);
        fatsLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        fatsLabel.setBounds(10, 166, 302, 29);
        this.getContentPane().add(fatsLabel);

        JLabel sodiumLabel = new JLabel("Enter sodium of the product :");
        sodiumLabel.setForeground(SystemColor.desktop);
        sodiumLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        sodiumLabel.setBounds(10, 215, 302, 29);
        this.getContentPane().add(sodiumLabel);

        JLabel lblEnterPriceOf = new JLabel("Enter price of the product :");
        lblEnterPriceOf.setForeground(SystemColor.desktop);
        lblEnterPriceOf.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblEnterPriceOf.setBounds(10, 265, 302, 29);
        this.getContentPane().add(lblEnterPriceOf);

        fatsField = new JTextField();
        fatsField.setForeground(SystemColor.activeCaption);
        fatsField.setColumns(10);
        fatsField.setBounds(10, 196, 129, 19);
        this.getContentPane().add(fatsField);

        proteinsField = new JTextField();
        proteinsField.setForeground(SystemColor.activeCaption);
        proteinsField.setColumns(10);
        proteinsField.setBounds(10, 152, 129, 19);
        this.getContentPane().add(proteinsField);

        caloriesField = new JTextField();
        caloriesField.setForeground(SystemColor.activeCaption);
        caloriesField.setColumns(10);
        caloriesField.setBounds(10, 106, 129, 19);
        this.getContentPane().add(caloriesField);

        ratingField = new JTextField();
        ratingField.setForeground(SystemColor.activeCaption);
        ratingField.setColumns(10);
        ratingField.setBounds(10, 65, 129, 19);
        this.getContentPane().add(ratingField);

        titleField = new JTextField();
        titleField.setForeground(SystemColor.activeCaption);
        titleField.setColumns(10);
        titleField.setBounds(10, 20, 129, 19);
        this.getContentPane().add(titleField);
        this.setVisible(true);
    }
    public void addEnterListener(ActionListener action) {
        this.enterButton.addActionListener(action);
    }
    public String getTitleField() { return this.titleField.getText();}
    public Double getRatingField(){return Double.parseDouble(this.ratingField.getText());}
    public int getCaloriesField(){return Integer.parseInt(this.caloriesField.getText());}
    public int getProteinsField(){return Integer.parseInt(this.proteinsField.getText());}
    public int getFatsField(){return Integer.parseInt(this.fatsField.getText());}
    public int getSodiumField(){return Integer.parseInt(this.sodiumField.getText());}
    public Double getPriceField(){return Double.parseDouble(this.priceField.getText());}




}
