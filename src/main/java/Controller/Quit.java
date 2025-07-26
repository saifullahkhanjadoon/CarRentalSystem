package Controller;

import Model.Database;
import Model.Operation;
import Model.User;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Quit implements Operation {

    @Override
    public void operation(Database database, JFrame f, User user) {
        
        JOptionPane.showMessageDialog(f, "Thanks for visiting us! Goodbye");
        f.dispose();
        System.exit(0);
    }
}
