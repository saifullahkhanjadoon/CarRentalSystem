package Controller;

import Model.Admin;
import Model.Clint;
import Model.Database;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Main {
    private static Database database;
    public static void main(String[] args) {
         database = new Database();
         start();

        
    }
    public static void start(){
        JFrame frame = new JFrame("Login");
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(250, 206, 27));
        frame.setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("Welcome to Car Rental System");
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        title.setHorizontalAlignment(JLabel.CENTER);
        frame.add(title, BorderLayout.NORTH);

        // Panel
        JPanel panel = new JPanel(new GridLayout(3, 2, 15, 15));
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Email
        panel.add(new JLabel("Email:"));
        JTextField email = new JTextField();
        panel.add(email);

        // Password
        panel.add(new JLabel("Password:"));
        JPasswordField password = new JPasswordField();
        panel.add(password);

        // Create Account Button
        JButton createAcc = new JButton("Create New Account");
        createAcc.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            new AddNewAccount(0).operation(database, frame, null);
            frame.dispose();
            
        }
    });
        createAcc.setFont(new Font("SansSerif", Font.BOLD, 22));
        panel.add(createAcc);

        // Login Button
        JButton login = new JButton("Login");
        login.setFont(new Font("SansSerif", Font.BOLD, 22));
       

        // Fetch users
        ArrayList<User> users = new ArrayList<>();
        try {
            String select = "SELECT * FROM users;";
            ResultSet rs = database.getStatement().executeQuery(select);
            while (rs.next()) {
                User user;
                int ID = rs.getInt("ID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String em = rs.getString("Email");
                String phoneNumber = rs.getString("PhoneNumber");
                String pass = rs.getString("Password");
                int type = rs.getInt("Type");

                if (type == 0) {
                    user = new Clint();
                } else {
                    user = new Admin();
                }
                user.setID(ID);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setEmail(em);
                user.setPhNumber(phoneNumber);
                user.setPasword(pass);
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Login Action
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(email.getText().equals("")){
                    JOptionPane.showMessageDialog(frame,"Email cananot be empty");
                    return;
                }
                if(password.getText().equals(""))
                {JOptionPane.showMessageDialog(frame, "Password cannot be empty");
                return;
                    
                }
                boolean loggedIn = false;
              
                for (User u : users) {
                    if (u.getEmail().equals(email.getText()) && u.getPasword().equals(password.getText())) {
                        loggedIn = true;
                        u.showList(database, frame);
                        frame.dispose();
                    }
                }
                if (!loggedIn) {
                     JOptionPane.showMessageDialog(frame, "Email or Password doesn't match");
                     
                }
            }
        });
         panel.add(login);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
