package GUI;

import java.util.Observable;
import java.util.Observer;

public class EmployeeController implements Observer {
   public static EmployeeView view;

    public EmployeeController() {
    }

    public EmployeeController(EmployeeView view2) {
       view = view2;
    }

    @Override
    public void update(Observable o, Object arg) {
        view.setTitleField((String)arg);
    }
}
