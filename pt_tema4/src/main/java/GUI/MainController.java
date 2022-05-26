package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainController {
    private MainView view;

    public MainController(MainView view) {
        this.view = view;
        this.view.addLogInListener(new MainController.LogInListener());
        this.view.addCreateAccListener(new MainController.CreateListener());
    }

    class LogInListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            View view2 = new View();
            Controller controller = new Controller(view2);

        }
    }

    class CreateListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String username = view.getUsernameField();
            String password = view.getPasswordField();
            try {
                File file1 = new File("users.txt");
                file1.createNewFile();
                FileWriter write = new FileWriter("users.txt",true);
                BufferedWriter buffWr = new BufferedWriter(write);
                buffWr.append("Client: "+username+" "+password);
                buffWr.newLine();
                buffWr.flush();
                buffWr.close();
                write.close();
            } catch (IOException err) {
                System.out.println("An error occurred.");
                err.printStackTrace();
            }
        }
    }
}
