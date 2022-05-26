package GUI;

import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;
import BusinessLayer.Order;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class OrderController {
    private OrderView view;
    public OrderController(OrderView view) {
        this.view = view;
        this.view.addEnterListener(new OrderController.EnterListener());
    }

    class EnterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            DeliveryService deliveryService2 = new DeliveryService();
            EmployeeController reader1 = new EmployeeController();
            deliveryService2.addObserver(reader1);
            Random rand = new Random();
            Integer clientID = rand.nextInt(1000);
            Integer orderID =  rand.nextInt(1000);
            Date orderDate = new Date();
            Order order = new Order(orderDate.toString());
            order.setClientID(clientID);
            order.setOrderID(orderID);
            try {
               for(MenuItem m : view.getOrders())
               {
                   deliveryService2.getProductsOrders().add(m.getTitle());
               }
                deliveryService2.addOrder(order,view.getOrders(),clientID,orderID);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
            view.setOrders();
        }

    }

}

