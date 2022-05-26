package GUI;

import BusinessLayer.BaseProduct;
import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;
import BusinessLayer.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class OrderView extends JFrame {

    private JTable table;
    private List<MenuItem> orders = new ArrayList<>() ;
    private JButton enterButton;

    public List<MenuItem> getOrders() {
        return orders;
    }

    public void setOrders() {
        this.orders = new ArrayList<>();
    }

    public OrderView() throws IOException {
        this.getContentPane().setForeground(SystemColor.inactiveCaptionBorder);
        this.getContentPane().setBackground(SystemColor.window);
        this.setBounds(100, 100, 824, 544);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(45, 58, 719, 395);
        this.getContentPane().add(scrollPane);

        enterButton = new JButton("Enter");
        enterButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        enterButton.setForeground(SystemColor.desktop);
        enterButton.setBounds(190, 10, 126, 21);
        this.getContentPane().add(enterButton);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                },
                new String[] {
                        "Title", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"
                }
        ));

        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBounds(747, 69, 17, 48);
        this.getContentPane().add(scrollBar);
        this.setVisible(true);

        DeliveryService deliveryService = new DeliveryService();
        deliveryService.readFile();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for(int i=0;i<deliveryService.getProductList().size();i++){
            model.addRow(new Object[]{deliveryService.getProductList().get(i).getTitle(),deliveryService.getProductList().get(i).getRating(),
                    deliveryService.getProductList().get(i).getCalories(),deliveryService.getProductList().get(i).getProteins(),
                    deliveryService.getProductList().get(i).getFats(),deliveryService.getProductList().get(i).getSodium(),
                    deliveryService.getProductList().get(i).getPrice()});

        }
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedRowIndex = table.getSelectedRow();
                int selectedColumnIndex = table.getSelectedColumn();
                String product = String.valueOf(model.getDataVector().get(selectedRowIndex));
                product = product.replace("[", "");
                product = product.replace("]", "");
                String name = product.substring(0,product.indexOf(","));
                product = product.replace(" ", "");
                String[] tokens = product.split(",");
                BaseProduct item = new BaseProduct(name,Double.parseDouble(tokens[1]),
                        Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]),
                        Integer.parseInt(tokens[5]),Double.parseDouble(tokens[6]));
                orders.add(item);

            }
        });

    }
    public void addEnterListener(ActionListener action) {
        this.enterButton.addActionListener(action);
    }

}
