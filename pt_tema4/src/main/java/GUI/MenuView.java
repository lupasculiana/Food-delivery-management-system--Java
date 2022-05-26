package GUI;

import BusinessLayer.BaseProduct;
import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.io.IOException;
import java.util.List;

public class MenuView extends JFrame {

    private JTextField titleField;
    private  JComboBox itemOne;
    private JComboBox itemTwo;
    private JComboBox itemThree;
    private JButton enterButton;
    private List<BaseProduct> productList;

    public MenuView() throws IOException {
        this.getContentPane().setForeground(SystemColor.inactiveCaptionBorder);
        this.getContentPane().setBackground(SystemColor.window);
        this.setBounds(100, 100, 734, 371);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        DeliveryService deliveryService = new DeliveryService();
        deliveryService.readFile();
        productList = deliveryService.getProductList();
        String[] titles = new String[deliveryService.getProductList().size()];
        for(int i=0;i<deliveryService.getProductList().size();i++){
            titles[i]= deliveryService.getProductList().get(i).getTitle();
        }
        itemOne = new JComboBox();
        itemOne.setModel(new DefaultComboBoxModel(titles));
        itemOne.setForeground(SystemColor.activeCaption);
        itemOne.setFont(new Font("Tahoma", Font.BOLD, 14));
        itemOne.setBounds(169, 73, 332, 21);
        this.getContentPane().add(itemOne);

        itemTwo = new JComboBox();
        itemTwo.setModel(new DefaultComboBoxModel(titles));
        itemTwo.setForeground(SystemColor.activeCaption);
        itemTwo.setFont(new Font("Tahoma", Font.BOLD, 14));
        itemTwo.setBounds(169, 115, 332, 21);
        this.getContentPane().add(itemTwo);

        itemThree = new JComboBox();
        itemThree.setModel(new DefaultComboBoxModel(titles));
        itemThree.setForeground(SystemColor.activeCaption);
        itemThree.setFont(new Font("Tahoma", Font.BOLD, 14));
        itemThree.setBounds(169, 159, 332, 21);
        this.getContentPane().add(itemThree);

        JLabel selectLabel = new JLabel("Select three items for the new menu :");
        selectLabel.setForeground(SystemColor.desktop);
        selectLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        selectLabel.setBounds(197, 41, 345, 13);
        this.getContentPane().add(selectLabel);

        JLabel titleLabel = new JLabel("Introduce title of the menu :");
        titleLabel.setForeground(SystemColor.desktop);
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        titleLabel.setBounds(235, 200, 345, 13);
        this.getContentPane().add(titleLabel);

        titleField = new JTextField();
        titleField.setForeground(SystemColor.activeCaption);
        titleField.setBounds(245, 223, 181, 19);
        this.getContentPane().add(titleField);
        titleField.setColumns(10);

        enterButton = new JButton("Create menu");
        enterButton.setForeground(SystemColor.activeCaption);
        enterButton.setBounds(279, 262, 104, 21);
        this.getContentPane().add(enterButton);
        this.setVisible(true);
    }
    public String getItemOneField(){return this.itemOne.getSelectedItem().toString();}
    public String getItemTwoField(){return this.itemTwo.getSelectedItem().toString();}
    public String getItemThreeField(){return this.itemThree.getSelectedItem().toString();}
    public String getTitleField() { return this.titleField.getText();}

    public List<BaseProduct> getProductList() {
        return productList;
    }

    public void addEnterListener(ActionListener action) {
        this.enterButton.addActionListener(action);
    }
}

