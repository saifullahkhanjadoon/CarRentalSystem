package Model;

import java.sql.*;

public class Database {
    private String user = "root"; 
    private String password = "1234"; 
    String url = "jdbc:mysql://localhost:3307/carrentalsystem"
           + "?useSSL=false"
           + "&allowPublicKeyRetrieval=true"
           + "&serverTimezone=UTC";

 
    private Statement statement;

    public Database() {
        try {
            // Try to load JDBC driver (optional for newer versions but safe)
           Class.forName("com.mysql.cj.jdbc.Driver");


            Connection connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
            );

            System.out.println(" Connected to MySQL Database!");
        } catch (SQLException e) {
            System.out.println("X SQL Connection Error:");
            e.printStackTrace(); // 💥 This will show exact error
        } catch (ClassNotFoundException e) {
            System.out.println("X JDBC Driver Not Found:");
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }
}
