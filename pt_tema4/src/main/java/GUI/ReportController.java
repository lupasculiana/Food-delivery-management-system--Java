package GUI;

import BusinessLayer.DeliveryService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ReportController {
    private ViewReport view;

    public ReportController(ViewReport view) {
        this.view = view;
        this.view.addEnterListener(new ReportController.EnterListener());
    }

    class EnterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                if(Objects.equals(view.getReportTypeField(), "Time interval of the orders")){
                    String data = view.getFirstField();
                    String[] array = data.split(",");
                    String[] start = array[0].split(":");
                    String[] end = array[1].split(":");
                    DeliveryService deliveryService = new DeliveryService();
                    deliveryService.generateFirstReport(start,end);
                }
                else if(Objects.equals(view.getReportTypeField(), "Products ordered more than a specified number of times so far")){
                    String data = view.getSecondField();
                    DeliveryService deliveryService = new DeliveryService();
                    deliveryService.generateSecondReport(Integer.parseInt(data));
                }
                else if(Objects.equals(view.getReportTypeField(), "Clients that have ordered more than a specified number of times so far and the value of the order was higher than a specified amount")){
                    String data = view.getThirdField();
                    String[] info = data.split(",");
                    DeliveryService deliveryService = new DeliveryService();
                    deliveryService.generateThirdReport(info[0],info[1]);
                }
                else if(Objects.equals(view.getReportTypeField(), "Products ordered within a specified day with the number of times they have been ordered")){
                    String data = view.getFourthField();
                    String[] info = data.split(",");
                    DeliveryService deliveryService = new DeliveryService();
                    deliveryService.generateFourthReport(Integer.parseInt(info[0]),Integer.parseInt(info[1]));
                }

            } catch (Exception exception) {
                view.showMessage("Wrong input! ");
            }
        }
    }
}
