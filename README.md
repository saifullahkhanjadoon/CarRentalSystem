Car Rental Management System (Java + MySQL)
📝 Overview
The Car Rental Management System is a console-based Java application designed using Object-Oriented Programming (OOP) principles. It interacts with a MySQL database using JDBC (MySQL Connector/J 9.3.0) to manage real-time operations related to car rentals, users, and admin tasks.

The system provides separate roles for Admin and User, enabling full rental workflows, user account management, and car inventory tracking — all via a simple text-based interface.

🔧 Technologies Used
Java – Core programming language (OOP)

MySQL – Relational database for persistent storage

JDBC (MySQL Connector/J 9.3.0) – Java-MySQL integration

Scanner Class – For handling console input

NetBeans / IntelliJ IDEA – IDEs used for development

🔑 User Roles
👤 Admin
Add, update, and delete car records

Manage user accounts and view rental history

View all available cars and current rental records

🙋 User
Register and log in securely

View available cars

Rent and return cars

View personal rental history

Change account password

🚗 Car Management Features
Add new cars with:

Brand

Model

Number plate

Rent price

Availability status

Update or delete existing car entries

Real-time status updates (Available/Unavailable)

🧾 Rental Operations
Rent a car: Marks the car as unavailable

Return a car: Marks the car as available

Each transaction is recorded in the database instantly

👨‍💻 Database Integration
MySQL database includes the following tables:

users

cars

rents

The system uses MySQL Connector/J 9.3.0 for real-time communication between Java and the database.

All major actions (registration, car rental, returns, updates) reflect instantly in the database.

📥 Setup & Usage
📦 Prerequisites
Java JDK (8 or higher)

MySQL Server installed and running locally

MySQL Connector/J 9.3.0 .jar file

🛠️ Setup Steps
Create the database and required tables (users, cars, rents) in MySQL.

Download MySQL Connector/J 9.3.0 from the official website.

Add the .jar to your project’s classpath (in NetBeans or IntelliJ).

Compile and run the project.

Use the console to log in as Admin or register as a new User.

📈 Future Enhancements
🖥️ Graphical User Interface (GUI) using JavaFX or Swing

🌐 Web-based version using Spring Boot + HTML/CSS

📊 Analytics module to track:

Most rented cars

Active users

Revenue statistics
