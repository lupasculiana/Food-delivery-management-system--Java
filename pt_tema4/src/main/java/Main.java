import BusinessLayer.DeliveryService;
import BusinessLayer.Order;
import GUI.*;

import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
      MainView view = new MainView();
      MainController controller = new MainController(view);

    }
}
