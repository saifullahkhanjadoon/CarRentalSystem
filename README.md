# CarRentalSystem
Car Rental Management System – Java (OOP & MySQL)
Overview
The Car Rental Management System is a console-based application developed in Java using Object-Oriented Programming (OOP) principles. It streamlines the operations of a car rental business by providing functionalities for administrators and users. The system is connected to a MySQL database through MySQL Connector/J, enabling real-time data management for cars, customers, and rental transactions.

Key Features

🔑 User Roles

Admin: Can add/update/delete cars, view all cars, manage user data, and track rental history.

User: Can register/login, view available cars, rent cars, return vehicles, and view personal rental history.

🚗 Car Management

Add new car entries with brand, model, number plate, rent price, and availability status.

Update or delete car information dynamically from the database.

🧾 Rental Operations

Rent and return cars using real-time database updates.

Automatically marks cars as available/unavailable based on rental status.

👤 User Management

User authentication with username and password.

Allows admins to edit or delete user information.

Users can change their password securely.

📊 Data Storage & Retrieval

Integrated with MySQL to store and retrieve data for users, cars, and rental records.

Uses JDBC (MySQL Connector/J 9.3.0) to connect Java application with the database.

Technologies Used

Java – Core language with OOP principles

MySQL – Backend database for persistent storage

JDBC (MySQL Connector/J) – For database communication

Scanner – For console-based input handling

NetBeans/IntelliJ IDEA – (Assumed) IDE for development and testing

Usage Instructions

Start the MySQL server and create required tables (cars, users, rents).

Run the Java application in your IDE or terminal.

Login as admin or register as a new user.

Interact with the system to manage cars, users, and rental operations.

Future Enhancements

🖥️ GUI Integration: Add a graphical interface using JavaFX or Swing for better usability.

🌐 Web-Based Version: Convert the system into a web app using Spring Boot and HTML/CSS.

📈 Analytics Module: Add reports for top rented cars, customer activity, and rental trends.
