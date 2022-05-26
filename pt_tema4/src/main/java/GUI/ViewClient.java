package GUI;

import javax.swing.*;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

public class ViewClient extends JFrame {
    private JButton viewProducts;
    private JButton searchProducts;
    private JButton createOrder;

    public ViewClient() {
        this.getContentPane().setForeground(SystemColor.window);
        this.getContentPane().setBackground(SystemColor.control);
        this.setBounds(100, 100, 299, 357);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel operationLabel = new JLabel("Choose the operation :");
        operationLabel.setForeground(SystemColor.desktop);
        operationLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        operationLabel.setBounds(52, 39, 302, 13);
        this.getContentPane().add(operationLabel);

        viewProducts = new JButton("View products");
        viewProducts.setFont(new Font("Tahoma", Font.BOLD, 15));
        viewProducts.setForeground(SystemColor.desktop);
        viewProducts.setBounds(68, 72, 139, 54);
        this.getContentPane().add(viewProducts);

        searchProducts = new JButton("Search products");
        searchProducts.setForeground(SystemColor.desktop);
        searchProducts.setFont(new Font("Tahoma", Font.BOLD, 15));
        searchProducts.setBounds(66, 152, 151, 54);
        this.getContentPane().add(searchProducts);

        createOrder = new JButton("Create order");
        createOrder.setForeground(SystemColor.desktop);
        createOrder.setFont(new Font("Tahoma", Font.BOLD, 15));
        createOrder.setBounds(68, 227, 151, 54);
        this.getContentPane().add(createOrder);

        this.setVisible(true);
    }

    public void addViewProducts(ActionListener action) {
        this.viewProducts.addActionListener(action);
    }

    public void addSearchProducts(ActionListener action) {
        this.searchProducts.addActionListener(action);
    }

    public void addCreateOrder(ActionListener action) {
        this.createOrder.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
