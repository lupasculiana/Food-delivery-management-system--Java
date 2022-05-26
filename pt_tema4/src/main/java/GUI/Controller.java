package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;
        this.view.addLogInListener(new LogInListener());
    }

    class LogInListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                if(Objects.equals(view.getTypeField(), "Client")){
                    int found = 0;
                    String info = "Client: "+view.getUsernameField()+" "+view.getPasswordField();
                    try (FileReader file = new FileReader("users.txt");
                         BufferedReader reader = new BufferedReader(file)) {
                        String read = reader.readLine();
                        while (read != null) {
                            if (read.contains(info)) {
                                ViewClient viewClient = new ViewClient();
                                ClientController clientController = new ClientController(viewClient);
                                found = 1;
                            }
                            read = reader.readLine();
                        }
                        if(found == 0)
                        {
                            view.showMessage("Account does not exist! ");
                        }
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else if(Objects.equals(view.getTypeField(), "Admin")){
                    int found = 0;
                    String info = "Client: "+view.getUsernameField()+" "+view.getPasswordField();
                    try (FileReader file = new FileReader("users.txt");
                         BufferedReader reader = new BufferedReader(file)) {
                        String read = reader.readLine();
                        while (read != null) {
                            if (read.contains(info)) {
                                ViewAdmin viewAdmin = new ViewAdmin();
                                AdminController adminController = new AdminController(viewAdmin);
                                found = 1;
                            }
                            read = reader.readLine();
                        }
                        if(found == 0)
                        {
                            view.showMessage("Account does not exist! ");
                        }
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else if(Objects.equals(view.getTypeField(), "Employee")){
                    int found = 0;
                    String info = "Client: "+view.getUsernameField()+" "+view.getPasswordField();
                    try (FileReader file = new FileReader("users.txt");
                         BufferedReader reader = new BufferedReader(file)) {
                        String read = reader.readLine();
                        while (read != null) {
                            if (read.contains(info)) {
                               EmployeeView view = new EmployeeView();
                               EmployeeController controller = new EmployeeController(view);
                                found = 1;
                            }
                            read = reader.readLine();
                        }
                        if(found == 0)
                        {
                            view.showMessage("Account does not exist! ");
                        }
                    } catch (FileNotFoundException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

            } catch (Exception exception) {
                view.showMessage("Not a client yet! ");
            }
        }
    }
}
