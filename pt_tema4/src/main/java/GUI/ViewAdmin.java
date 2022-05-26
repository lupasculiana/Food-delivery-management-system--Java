package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

public class ViewAdmin extends JFrame{

    private JButton importProducts;
    private JButton addProducts;
    private JButton deleteProducts;
    private JButton modifyProducts;
    private JButton createMenu;
    private JButton generateReports;

    public ViewAdmin() {
        this.getContentPane().setForeground(SystemColor.window);
        this.getContentPane().setBackground(SystemColor.control);
        this.setBounds(100, 100, 534, 459);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel operationLabel = new JLabel("Choose the operation :");
        operationLabel.setForeground(SystemColor.desktop);
        operationLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        operationLabel.setBounds(52, 39, 302, 13);
        this.getContentPane().add(operationLabel);

        importProducts = new JButton("Import menu");
        importProducts.setFont(new Font("Tahoma", Font.BOLD, 15));
        importProducts.setForeground(SystemColor.desktop);
        importProducts.setBounds(52, 62, 194, 54);
        this.getContentPane().add(importProducts);

        addProducts = new JButton("Add products");
        addProducts.setForeground(SystemColor.desktop);
        addProducts.setFont(new Font("Tahoma", Font.BOLD, 15));
        addProducts.setBounds(52, 126, 194, 54);
        this.getContentPane().add(addProducts);

        deleteProducts = new JButton("Delete products");
        deleteProducts.setForeground(SystemColor.desktop);
        deleteProducts.setFont(new Font("Tahoma", Font.BOLD, 15));
        deleteProducts.setBounds(52, 190, 194, 54);
        this.getContentPane().add(deleteProducts);

        modifyProducts = new JButton("Modify products");
        modifyProducts.setForeground(SystemColor.desktop);
        modifyProducts.setFont(new Font("Tahoma", Font.BOLD, 15));
        modifyProducts.setBounds(52, 252, 194, 54);
        this.getContentPane().add(modifyProducts);

        createMenu = new JButton("Create daily menu");
        createMenu.setForeground(SystemColor.desktop);
        createMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
        createMenu.setBounds(52, 317, 194, 54);
        this.getContentPane().add(createMenu);

        generateReports = new JButton("Generate reports");
        generateReports.setForeground(SystemColor.desktop);
        generateReports.setFont(new Font("Tahoma", Font.BOLD, 15));
        generateReports.setBounds(286, 156, 183, 88);
        this.getContentPane().add(generateReports);

        this.setVisible(true);
    }
    public void addImportProducts(ActionListener action) {
        this.importProducts.addActionListener(action);
    }

    public void addProducts(ActionListener action) {
        this.addProducts.addActionListener(action);
    }

    public void addDeleteProducts(ActionListener action) {
        this.deleteProducts.addActionListener(action);
    }

    public void addModifyProducts(ActionListener action) {
        this.modifyProducts.addActionListener(action);
    }

    public void addCreateMenu(ActionListener action) {
        this.createMenu.addActionListener(action);
    }

    public void addGenerateReports(ActionListener action) {
        this.generateReports.addActionListener(action);
    }
}
