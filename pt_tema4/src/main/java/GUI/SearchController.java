package GUI;

import BusinessLayer.DeliveryService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Objects;

public class SearchController {
    private SearchView view;

    public SearchController(SearchView view) {
        this.view = view;
        this.view.addEnterListener(new SearchController.EnterListener());
    }

    class EnterListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String column = view.getColumnField();
            String keyword = view.getKeywordField();
            DeliveryService deliveryService = new DeliveryService();
            List<String> result = deliveryService.searchProduct(keyword);
            view.setTextField(result);
        }

    }
}
