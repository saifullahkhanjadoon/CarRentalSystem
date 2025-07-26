package Controller;

import Model.Car;
import Model.Clint;
import Model.Database;
import Model.JLabel;
import Model.JTable;
import Model.Operation;
import Model.Rent;
import Model.User;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class ShowUserRents implements Operation {

    private int userID;

    public ShowUserRents(int userID) {
        this.userID = userID;
    }

    @Override
    public void operation(Database database, JFrame f, User user) {
        if (userID == -9999) userID = user.getID();

        JFrame frame = new JFrame("Rents");
        frame.setSize(1200, 600);
        frame.setLocationRelativeTo(f);
        frame.getContentPane().setBackground(new Color(250, 206, 27));
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Rents", 35);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        frame.add(title, BorderLayout.NORTH);

        String[] header = new String[]{
            "ID", "Name", "Email", "Tel", "Car ID", "Car", "Date Time", "Hours", "Total", "Status"
        };

        ArrayList<Rent> rents = new ArrayList<>();
        ArrayList<Integer> carIDs = new ArrayList<>();

        try {
            // Fetch all rents for this user
            String select = "SELECT * FROM `rents` WHERE `User`='" + userID + "';";
            ResultSet rs = database.getStatement().executeQuery(select);

            while (rs.next()) {
                Rent rent = new Rent();
                rent.setID(rs.getInt("ID"));
                rent.setDatetime(rs.getString("DateTime"));
                rent.setHour(rs.getInt("Hours"));
                rent.setTotal(rs.getDouble("Total"));
                rent.setStatus(rs.getInt("Status"));
                carIDs.add(rs.getInt("Car")); // Keep car ID to fetch later
                rents.add(rent);
            }

            if (rents.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "You have no rented cars.");
                return;
            }

            // Fetch user info once
            String selectUser = "SELECT * FROM `users` WHERE `ID`='" + userID + "';";
            ResultSet rs2 = database.getStatement().executeQuery(selectUser);

            User u = new Clint();
            if (rs2.next()) {
                u.setID(rs2.getInt("ID"));
                u.setFirstName(rs2.getString("FirstName"));
                u.setLastName(rs2.getString("LastName"));
                u.setEmail(rs2.getString("Email"));
                u.setPhNumber(rs2.getString("PhoneNumber"));
                u.setPasword(rs2.getString("Password"));
            }

            // Attach user and car to each rent
            for (int j = 0; j < rents.size(); j++) {
                Rent r = rents.get(j);
                r.setUser(u);

                ResultSet rs3 = database.getStatement().executeQuery(
                        "SELECT * FROM `cars` WHERE `ID`='" + carIDs.get(j) + "';"
                );

                if (rs3.next()) {
                    Car car = new Car();
                    car.setID(rs3.getInt("ID"));
                    car.setBrand(rs3.getString("Brand"));
                    car.setModel(rs3.getString("Model"));
                    car.setColor(rs3.getString("Color"));
                    car.setYear(rs3.getInt("Year"));
                    car.setPrice(rs3.getDouble("Price"));
                    car.setAvailable(rs3.getInt("Available"));
                    r.setCar(car);
                } else {
                    System.out.println("⚠ Car with ID " + carIDs.get(j) + " not found.");
                    r.setCar(null); // explicitly set to null
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage());
            frame.dispose();
            return;
        }

        // Build table data
        String[][] rentsData = new String[rents.size()][10];
        for (int j = 0; j < rents.size(); j++) {
            Rent r = rents.get(j);

            rentsData[j][0] = String.valueOf(r.getID());
            rentsData[j][1] = r.getUser().getFirstName() + " " + r.getUser().getLastName();
            rentsData[j][2] = r.getUser().getEmail();
            rentsData[j][3] = r.getUser().getPhNumber();

            if (r.getCar() != null) {
                rentsData[j][4] = String.valueOf(r.getCar().getID());
                rentsData[j][5] = r.getCar().getBrand() + " " +
                                  r.getCar().getModel() + " " +
                                  r.getCar().getColor() + " " +
                                  r.getCar().getYear();
            } else {
                rentsData[j][4] = "N/A";
                rentsData[j][5] = "Car not found";
            }

            rentsData[j][6] = r.getDatetime();
            rentsData[j][7] = String.valueOf(r.getHour());
            rentsData[j][8] = r.getTotal() + " Rs";
            rentsData[j][9] = r.getStatusToString();
        }

        // Display in custom JTable
        Color color2 = new Color(252, 242, 20);
        JScrollPane panel = new JScrollPane(new JTable(rentsData, header, Color.black, color2));
        panel.setBackground(null);
        panel.getViewport().setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
