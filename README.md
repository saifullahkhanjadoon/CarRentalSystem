
    body {
      font-family: Arial, sans-serif;
      background-color: #f9f9f9;
      margin: 0;
      padding: 2rem;
      line-height: 1.6;
    }
    h1, h2 {
      color: #2c3e50;
    }
    ul {
      margin-top: 0;
    }
    .section {
      margin-bottom: 2rem;
    }
    .highlight {
      font-weight: bold;
      color: #2980b9;
    }
    code {
      background-color: #eee;
      padding: 2px 4px;
      border-radius: 4px;
      font-size: 90%;
    }
  </style>
</head>
<body>
  <h1>🚗 Car Rental Management System (Java + MySQL)</h1>

  <div class="section">
    <h2>📍 Overview</h2>
    <p>This is a console-based Java application built with OOP principles. It uses JDBC (MySQL Connector/J 9.3.0) for real-time interaction with a MySQL database to manage users, cars, and rental operations.</p>
    <p>Roles: <strong>Admin</strong> and <strong>User</strong>, each having specific functionalities.</p>
  </div>

  <div class="section">
    <h2>🔧 Technologies Used</h2>
    <ul>
      <li>Java (OOP-based)</li>
      <li>MySQL</li>
      <li>JDBC (MySQL Connector/J 9.3.0)</li>
      <li>Scanner Class (Console Input)</li>
      <li>NetBeans / IntelliJ IDEA</li>
    </ul>
  </div>

  <div class="section">
    <h2>🔑 User Roles</h2>
    <h3>👤 Admin</h3>
    <ul>
      <li>Add, update, delete cars</li>
      <li>Manage user accounts</li>
      <li>View rental history</li>
      <li>Check available cars</li>
    </ul>
    <h3>🙋 User</h3>
    <ul>
      <li>Register / Login</li>
      <li>View available cars</li>
      <li>Rent/Return cars</li>
      <li>View rental history</li>
      <li>Change password</li>
    </ul>
  </div>

  <div class="section">
    <h2>🚗 Car Management Features</h2>
    <ul>
      <li>Add cars with brand, model, number plate, rent price, availability</li>
      <li>Update/delete cars</li>
      <li>Real-time availability updates</li>
    </ul>
  </div>

  <div class="section">
    <h2>📟 Rental Operations</h2>
    <ul>
      <li><strong>Rent a Car:</strong> Car becomes <em>Unavailable</em>, rental record created</li>
      <li><strong>Return a Car:</strong> Car becomes <em>Available</em>, return time recorded</li>
    </ul>
  </div>

  <div class="section">
    <h2>👨‍💻 Database Structure</h2>
    <p>MySQL tables:</p>
    <ul>
      <li><code>users</code></li>
      <li><code>cars</code></li>
      <li><code>rents</code></li>
    </ul>
  </div>

  <div class="section">
    <h2>📥 Setup & Usage</h2>
    <h3>📦 Prerequisites</h3>
    <ul>
      <li>Java JDK 8 or above</li>
      <li>MySQL Server</li>
      <li>MySQL Connector/J 9.3.0 (.jar)</li>
    </ul>
    <h3>🛠️ Setup Steps</h3>
    <ol>
      <li>Create MySQL database and tables: <code>users</code>, <code>cars</code>, <code>rents</code></li>
      <li>Add JDBC jar to project classpath</li>
      <li>Open in NetBeans or IntelliJ</li>
      <li>Compile and run</li>
      <li>Use console to register/login</li>
    </ol>
  </div>

  <div class="section">
    <h2>📊 Future Enhancements</h2>
    <ul>
      <li>💻 GUI with JavaFX or Swing</li>
      <li>🌐 Web version using Spring Boot</li>
      <li>📊 Analytics for rentals, revenue, and users</li>
    </ul>
  </div>

  <div class="section">
    <h2>📄 Sample Output (Console)</h2>
    <pre>
Welcome to the Car Rental Management System
1. Register
2. Login as User
3. Login as Admin
4. Quit
    </pre>
  </div>

  <div class="section">
    <h2>📚 License</h2>
    <p>This project is for educational purposes. Feel free to fork, use, and modify it.</p>
  </div>
</body>
</html>
