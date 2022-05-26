package GUI;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Objects;

public class ClientController {
    private ViewClient view;

    public ClientController(ViewClient view) {
        this.view = view;
        this.view.addViewProducts(new ClientController.ViewListener());
        this.view.addSearchProducts(new ClientController.SearchListener());
        this.view.addCreateOrder(new ClientController.CreateListener());
    }

    class ViewListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                EmptyView view = new EmptyView();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
    class SearchListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            SearchView view = new SearchView();
            SearchController controller = new SearchController(view);
        }
    }
    class CreateListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                OrderView view = new OrderView();
                OrderController controller = new OrderController(view);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
