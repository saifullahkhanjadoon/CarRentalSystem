package Controller;

import Model.Clint;
import Model.Operation;
import Model.Database;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import Model.JLabel;        // Use custom JLabel
import Model.JButton;       // Use custom JButton
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddNewAccount implements Operation {
    private int accType;    

    public AddNewAccount(int accType) {
        this.accType = accType;
    }

    @Override
    public void operation(Database database, JFrame f, User u) {
        JFrame frame = new JFrame("Create New Account");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(f);
        frame.getContentPane().setBackground(new Color(250, 206, 27));
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Welcome to Car Rental System", 22);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        frame.add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(7, 2, 15, 15));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("First Name:", 22));
        JTextField firstName = new JTextField(22);
        panel.add(firstName);

        panel.add(new JLabel("Last Name:", 22));
        JTextField lastName = new JTextField(22);
        panel.add(lastName);

        panel.add(new JLabel("Email:", 22));
        JTextField email = new JTextField(22);
        panel.add(email);

        panel.add(new JLabel("Phone Number:", 22));
        JTextField phNumber = new JTextField(22);
        panel.add(phNumber);

        panel.add(new JLabel("Password:", 22));
        JTextField password = new JTextField(22);
        panel.add(password);

        panel.add(new JLabel("Confirm Password:", 22));
        JTextField confirmPassword = new JTextField(22);
        panel.add(confirmPassword);

        JButton login = new JButton("Login", 22);
        login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            Main.start();
            frame.dispose(); 
            }
            
        });
        panel.add(login);

        JButton createAcc = new JButton("Create Account", 22);
        createAcc.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
               if(firstName.getText().equals("")){
               JOptionPane.showMessageDialog(frame, "First Name cann't be empty");
               return;
               }
           
           if(lastName.getText().equals("")){
               JOptionPane.showMessageDialog(frame, "Last Name cann't be empty");
               return;
           }
           if(email.getText().equals("")){
               JOptionPane.showMessageDialog(frame, "Email cann't be empty");
               return;
           }
           if(phNumber.getText().equals("")){
               JOptionPane.showMessageDialog(frame, "Phone Number cann;t be empty");
               return;
           }
           if(password.getText().equals("")){
               JOptionPane.showMessageDialog(frame, "Password cann;t be empty");
               return;
           }
           if(confirmPassword.getText().equals("")){
               JOptionPane.showMessageDialog(frame, "Confirm Password cann;t be empty");
               return;
           }
           if(!password.getText().equals(confirmPassword.getText())){
               JOptionPane.showMessageDialog(frame, "Password doesn't match");
               return;
           }
           
           
              try{
            ArrayList<String> emails=new ArrayList<>();
            ResultSet rs0=database.getStatement().executeQuery("SELECT  `Email` FROM `users`;");
                  while(rs0.next()){
                      emails.add(rs0.getString("Email"));
                  }
                  if (emails.contains(email.getText())) {
    JOptionPane.showMessageDialog(frame,"This email is already used!");
    return;
}

            ResultSet rs = database.getStatement().executeQuery("SELECT COUNT(*) AS total FROM `users`;");
rs.next();
int ID = rs.getInt("total"); 

            String insert="INSERT INTO `users`"
                    + "(`ID`, `FirstName`, `LastName`, `Email`, `PhoneNumber`, `Password`, `Type`) "
                    + "VALUES ('"+ID+"','"+firstName.getText()+"','"+lastName.getText()+"','"+email.getText()+"','"+phNumber.getText()+"','"+password.getText()+"','"+accType+"')";
        database.getStatement().execute(insert);
        JOptionPane.showMessageDialog(frame,"Account account created successfully\n");
            if(accType==0){
              User  user=new Clint();
                user.setID(ID);
                user.setFirstName(firstName.getText());
                user.setLastName(lastName.getText());
                user.setEmail(email.getText());
                user.setPhNumber(phNumber.getText());
                user.setPasword(password.getText());

                user.showList(database, frame);
                frame.dispose();
            }
        
         } catch (SQLException e1) {
             JOptionPane.showMessageDialog(frame,e1.getMessage());
        
    }
           }
        });
        panel.add(createAcc);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    

//        System.out.println("Enter First Name");
//        String firstName=s.next();
//        System.out.println("Enter Last Name");
//        String lastName=s.next();
//        System.out.println("Enter Email");
//        String email=s.next();
//        System.out.println("Enter Phone Number");
//        String phNumber=s.next();
//        System.out.println("Enter Password ");
//        String pasword=s.next();
//        System.out.println("Confirm Password ");
//        String confirmPassword=s.next();
//        while(!pasword.equals(confirmPassword)){
//                    System.out.println(" Password doesnot match");
//                            System.out.println("Enter Password ");
//                            pasword=s.next();
//                                    System.out.println("Confirm Password ");
//                                    confirmPassword=s.next();
//
//
//        }
//     
}
}
