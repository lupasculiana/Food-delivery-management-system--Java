package GUI;

import BusinessLayer.BaseProduct;
import BusinessLayer.DeliveryService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControllerInfo {
    private InfoView view;
    private int varianta;

    public ControllerInfo(InfoView view, int varianta) {
        this.view = view;
        this.varianta = varianta;
        this.view.addEnterListener(new ControllerInfo.EnterListener());
    }

    class EnterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            BaseProduct baseProduct = new BaseProduct(view.getTitleField(),view.getRatingField(),view.getCaloriesField(),view.getProteinsField()
            ,view.getFatsField(),view.getSodiumField(),view.getPriceField());
            if(varianta == 1)
            {
                DeliveryService deliveryService = new DeliveryService();
                try {
                    deliveryService.deleteProduct(baseProduct);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else if(varianta ==2){
                DeliveryService deliveryService = new DeliveryService();
                try {
                    deliveryService.addProduct(baseProduct);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
