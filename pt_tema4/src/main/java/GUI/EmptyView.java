package GUI;

import BusinessLayer.DeliveryService;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.io.IOException;
import javax.swing.JScrollBar;

public class EmptyView extends JFrame {

    private JTable table;

    public EmptyView() throws IOException {
        this.getContentPane().setForeground(SystemColor.inactiveCaptionBorder);
        this.getContentPane().setBackground(SystemColor.window);
        this.setBounds(100, 100, 824, 544);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(45, 58, 719, 395);
        this.getContentPane().add(scrollPane);

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
    }
}
