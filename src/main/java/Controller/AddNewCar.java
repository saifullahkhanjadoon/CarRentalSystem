package Controller;

import Model.Database;
import Model.Operation;
import Model.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class AddNewCar implements Operation {
    @Override
    public void operation(Database database, JFrame f, User user) {

        JFrame frame = new JFrame("Add New Car");
        frame.setSize(600, 525);
        frame.setLocationRelativeTo(f);
        frame.getContentPane().setBackground(new Color(250, 206, 27));
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Add New Car", SwingConstants.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
        frame.add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(6, 2, 15, 15));
        panel.setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Brand
        panel.add(new JLabel("Brand:"));
        JTextField brand = new JTextField();
        panel.add(brand);

        // Model
        panel.add(new JLabel("Model:"));
        JTextField model = new JTextField();
        panel.add(model);

        // Color
        panel.add(new JLabel("Color:"));
        JTextField color = new JTextField();
        panel.add(color);

        // Year
        panel.add(new JLabel("Year:"));
        JTextField year = new JTextField();
        panel.add(year);

        // Price Per Hour
        panel.add(new JLabel("Price Per Hour:"));
        JTextField price = new JTextField();
        panel.add(price);

        // Cancel Button
        JButton cancel = new JButton("Cancel");
        cancel.addActionListener(e -> frame.dispose());
        panel.add(cancel);

        // Confirm Button
        JButton confirm = new JButton("Confirm");
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Validate Inputs
                if (brand.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Brand can't be empty");
                    return;
                }

                if (color.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Color can't be empty");
                    return;
                }

                if (year.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Year can't be empty");
                    return;
                }

                if (price.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Price can't be empty");
                    return;
                }

                int yearInt;
                double priceDoub;

                try {
                    yearInt = Integer.parseInt(year.getText().trim());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Year must be an integer");
                    return;
                }

                try {
                    priceDoub = Double.parseDouble(price.getText().trim());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Price must be a double");
                    return;
                }

                int available = 0;

                try {
                    ResultSet rs = database.getStatement().executeQuery("SELECT COUNT(*) AS total FROM cars;");
                    rs.next();
                    int ID = rs.getInt("total") + 1;

                    String insert = "INSERT INTO cars(ID, Brand, Model, Color, Year, Price, Available) VALUES ('"
                            + ID + "', '" + brand.getText().trim() + "', '" + model.getText().trim() + "', '"
                            + color.getText().trim() + "', '" + yearInt + "', '" + priceDoub + "', '" + available + "')";

                    database.getStatement().execute(insert);
                    JOptionPane.showMessageDialog(frame, "Car added successfully!");
                    frame.dispose();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(frame, "Database Error: " + ex.getMessage());
                }
            }
        });

        panel.add(confirm);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
