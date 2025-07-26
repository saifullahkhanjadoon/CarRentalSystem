🚗 Car Rental Management System (Java + MySQL)
📝 Overview
The Car Rental Management System is a console-based Java application developed using Object-Oriented Programming (OOP) principles. It connects to a MySQL database using JDBC (MySQL Connector/J 9.3.0) to handle real-time car rental operations, including managing users, rentals, and the car inventory.

The system supports two main roles — Admin and User — each with tailored functionalities to ensure smooth rental workflows and secure account management.

🔧 Technologies Used
Java – Core programming language (OOP-based)

MySQL – Relational database for persistent storage

JDBC (MySQL Connector/J 9.3.0) – Java-MySQL integration

Scanner Class – Console input handling

NetBeans / IntelliJ IDEA – IDEs used for development

🔑 User Roles
👤 Admin
Add, update, and delete car records

Manage user accounts

View all rental history and currently rented cars

View available car inventory

🙋 User
Register and log in

View available cars

Rent a car (marks as unavailable)

Return a car (marks as available)

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
Rent a Car

Car status becomes "Unavailable"

Rental record created in database

Return a Car

Car status becomes "Available"

Return time is recorded

All operations are recorded in the database in real time

👨‍💻 Database Structure
The MySQL database includes the following tables:

users

cars

rents

Real-time communication is handled using MySQL Connector/J (version 9.3.0). All major actions reflect instantly in the database.

📥 Setup & Usage
📦 Prerequisites
Java JDK (8 or above)

MySQL Server (Installed & Running)

MySQL Connector/J 9.3.0 (.jar file)

🛠️ Setup Steps
Create a MySQL database and the following tables: users, cars, rents

Add MySQL Connector/J 9.3.0 to your project’s classpath

Open the project in NetBeans or IntelliJ IDEA

Compile and run the application

Use the console to:

Register or log in as a User

Log in as Admin for car and user management

📈 Future Enhancements
🖥️ GUI Integration using JavaFX or Swing

🌐 Web-Based Version using Spring Boot + HTML/CSS

📊 Analytics Module to track:

Most Rented Cars

Active Users

Revenue Statistics

📌 Sample Output (Console)
pgsql
Copy
Edit
Welcome to the Car Rental Management System
1. Register
2. Login as User
3. Login as Admin
4. Quit
📚 License
This project is for educational purposes. Feel free to fork and modify it.
