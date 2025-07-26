package Controller;

import Model.Car;
import Model.Clint;
import Model.Database;
import Model.JLabel;
import Model.JTable;
import Model.Operation;
import Model.Rent;
import Model.User;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShowAllRents implements Operation {

    @Override
    public void operation(Database database, JFrame f, User user) {

        JFrame frame = new JFrame("Rents");
        frame.setSize(1200, 600);
        frame.setLocationRelativeTo(f);
        frame.getContentPane().setBackground(new Color(250, 206, 27));
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Rents", 35);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        frame.add(title, BorderLayout.NORTH);

        String[] header = new String[]{
            "ID", "Name", "Email", "Phone Number", "Car ID", "Car", "Date Time", "Hours", "Total", "Status"
        };

        ArrayList<Rent> rents = new ArrayList<>();
        ArrayList<Integer> carIDs = new ArrayList<>();
        ArrayList<Integer> userIDs = new ArrayList<>();

        try {
            String select = "SELECT * FROM `rents`;";
            ResultSet rs = database.getStatement().executeQuery(select);

            while (rs.next()) {
                Rent rent = new Rent();
                rent.setID(rs.getInt("ID"));
                userIDs.add(rs.getInt("User"));
                carIDs.add(rs.getInt("Car"));
                rent.setDatetime(rs.getString("DateTime"));
                rent.setHour(rs.getInt("Hours"));
                rent.setTotal(rs.getDouble("Total"));
                rent.setStatus(rs.getInt("Status"));
                rents.add(rent);
            }

            if (rents.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "❌ No rents found.");
                frame.dispose();
                return;
            }

            for (int j = 0; j < rents.size(); j++) {
                Rent r = rents.get(j);

                // Fetch user
                String selectUser = "SELECT * FROM `users` WHERE `ID`='" + userIDs.get(j) + "';";
                ResultSet rs2 = database.getStatement().executeQuery(selectUser);
                User u = new Clint();
                if (rs2.next()) {
                    u.setID(rs2.getInt("ID"));
                    u.setFirstName(rs2.getString("FirstName"));
                    u.setLastName(rs2.getString("LastName"));
                    u.setEmail(rs2.getString("Email"));
                    u.setPhNumber(rs2.getString("PhoneNumber"));
                    u.setPasword(rs2.getString("Password"));
                    r.setUser(u);
                } else {
                    rents.remove(j);
                    j--;
                    continue;
                }

                // Fetch car
                String selectCar = "SELECT * FROM `cars` WHERE `ID`='" + carIDs.get(j) + "';";
                ResultSet rs3 = database.getStatement().executeQuery(selectCar);
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
                    rents.remove(j);
                    j--;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(frame, "Database error: " + e.getMessage());
            frame.dispose();
            return;
        }

        if (rents.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "❌ No complete rent records found.");
            frame.dispose();
            return;
        }

        // Build table data
        String[][] rentsData = new String[rents.size()][10];
        for (int j = 0; j < rents.size(); j++) {
            Rent r = rents.get(j);
            Car car = r.getCar();
            User rentUser = r.getUser();

            rentsData[j][0] = String.valueOf(r.getID());
            rentsData[j][1] = rentUser != null ? rentUser.getFirstName() + " " + rentUser.getLastName() : "Unknown";
            rentsData[j][2] = rentUser != null ? rentUser.getEmail() : "Unknown";
            rentsData[j][3] = rentUser != null ? rentUser.getPhNumber() : "Unknown";
            rentsData[j][4] = car != null ? String.valueOf(car.getID()) : "N/A";
            rentsData[j][5] = car != null
                    ? car.getBrand() + " " + car.getModel() + " " + car.getColor() + " " + car.getYear()
                    : "Car data not available";
            rentsData[j][6] = r.getDatetime();
            rentsData[j][7] = String.valueOf(r.getHour());
            rentsData[j][8] = r.getTotal() + " Rs";
            rentsData[j][9] = r.getStatusToString();
        }

        Color tableColor = new Color(252, 242, 20);
        JScrollPane panel = new JScrollPane(new JTable(rentsData, header, Color.black, tableColor));
        panel.setBackground(null);
        panel.getViewport().setBackground(null);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
