Car Rental Management System (Java + MySQL)
📝 Overview
The Car Rental Management System is a console-based application developed in Java using Object-Oriented Programming (OOP) principles. It connects to a MySQL database using MySQL Connector/J (JDBC) to manage real-time data operations for cars, users, and rental records. This system provides separate roles for Admin and User, enabling complete rental workflow and data management via a simple interface.

🔧 Technologies Used
Java – Core language with OOP principles

MySQL – Relational database for persistent data storage

JDBC (MySQL Connector/J 9.3.0) – For Java–MySQL integration

Scanner Class – For handling user inputs via the console

NetBeans / IntelliJ IDEA – IDEs used for development and testing

🔑 User Roles
👤 Admin
Add, update, and delete car records

Manage user accounts and rental history

View all available cars and rental data

🙋 User
Register and log in securely

View available cars

Rent and return cars

View their own rental history

Change account password

🚗 Car Management Features
Add new car entries with:

Brand

Model

Number plate

Rent price

Availability status

Update or delete car records dynamically

🧾 Rental Operations
Rent a car: marks the car as unavailable

Return a car: marks the car as available

Records each transaction in the database in real-time

👨‍💻 Database Integration
MySQL database includes the following tables:

users

cars

rents

Uses MySQL Connector/J 9.3.0 for database communication

All actions (registration, renting, updating cars) update the database in real-time

📥 Setup & Usage
📦 Prerequisites
Java JDK installed

MySQL Server running locally

MySQL Connector/J 9.3.0 downloaded and added to your project

🛠️ Setup Steps
Start MySQL and create the required database with tables:
users, cars, and rents

Download MySQL Connector/J 9.3.0 from the official site or Maven repo.

Connect JDBC in your project by importing the .jar file or configuring the dependency.

Compile and run the project in your IDE (NetBeans or IntelliJ) or terminal.

Interact with the system by logging in as an admin or registering as a user.

📈 Future Enhancements
🖥️ Graphical User Interface using JavaFX or Swing

🌐 Web-Based Version using Spring Boot + HTML/CSS

📊 Analytics Module for rental statistics, most rented cars, and user activity reports
