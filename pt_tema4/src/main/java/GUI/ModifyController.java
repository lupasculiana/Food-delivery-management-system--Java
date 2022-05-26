package GUI;

import BusinessLayer.BaseProduct;
import BusinessLayer.DeliveryService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ModifyController {
    private ModifyView view;

    public ModifyController(ModifyView view) {
        this.view = view;
        this.view.addEnterListener(new ModifyController.EnterListener());
    }

    class EnterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String product = view.getProductField();
            String[] tokens = product.split(",");
            BaseProduct baseProduct = new BaseProduct(tokens[0],Double.parseDouble(tokens[1]),
                    Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]),
                    Integer.parseInt(tokens[5]),Integer.parseInt(tokens[6]));
            String column = view.getColumnField();
            String value = view.getNewValueField();
            DeliveryService deliveryService = new DeliveryService();
            try {
                deliveryService.modifyProduct(baseProduct,column,value);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
