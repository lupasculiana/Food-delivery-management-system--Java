package GUI;

import BusinessLayer.DeliveryService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AdminController {
    private ViewAdmin view;

    public AdminController(ViewAdmin view) {
        this.view = view;
        this.view.addImportProducts(new AdminController.ImportListener());
        this.view.addProducts(new AdminController.AddListener());
        this.view.addDeleteProducts(new AdminController.DeleteListener());
        this.view.addModifyProducts(new AdminController.ModifyListener());
        this.view.addCreateMenu(new AdminController.MenuListener());
        this.view.addGenerateReports(new AdminController.ReportsListener());

    }

    class ImportListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
           DeliveryService deliveryService = new DeliveryService();
            try {
                deliveryService.readFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    class AddListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            InfoView view2 =new InfoView();
            ControllerInfo controllerInfo = new ControllerInfo(view2,2);
        }
    }
    class DeleteListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            InfoView view2 =new InfoView();
            ControllerInfo controllerInfo = new ControllerInfo(view2,1);
        }
    }
    class ModifyListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            ModifyView view = new ModifyView();
            ModifyController modifyController = new ModifyController(view);
        }
    }
    class MenuListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                MenuView view = new MenuView();
                MenuController controller = new MenuController(view);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }
    class ReportsListener implements ActionListener {

        //TODO
        public void actionPerformed(ActionEvent e) {
            ViewReport viewReport = new ViewReport();
            ReportController reportController = new ReportController(viewReport);
        }
    }
}
