package GUI;


import BusinessLayer.BaseProduct;
import BusinessLayer.CompositeProduct;
import BusinessLayer.DeliveryService;
import BusinessLayer.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuController {
    private MenuView view;

    public MenuController(MenuView view) {
        this.view = view;
        this.view.addEnterListener(new MenuController.EnterListener());
    }

    class EnterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           String firstItem = view.getItemOneField();
           String secondItem = view.getItemTwoField();
           String thirdItem = view.getItemThreeField();
           String name = view.getTitleField();
            List<BaseProduct> productList = view.getProductList();
            ArrayList<BaseProduct> products = new ArrayList<>();
            for(BaseProduct p : productList){
                if(p.getTitle().equals(firstItem) || p.getTitle().equals(secondItem) || p.getTitle().equals(thirdItem)){
                    products.add(p);
                }
            }
            CompositeProduct menu = new CompositeProduct(products,name);
            menu.computePrice();
            System.out.println(menu);
            try {
                DeliveryService deliveryService = new DeliveryService();
                deliveryService.setProductList(productList);
                deliveryService.addProduct(menu);
            } catch (IOException ex) {
                System.out.println("Done");
            }
        }
    }
}
