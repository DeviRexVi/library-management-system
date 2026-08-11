# 📚 Library Management System

> A console-based Library Management System developed in Java to practice Object-Oriented Programming, clean code principles, software design, JDBC persistence, and incremental application evolution.

This project simulates the core operations of a library while focusing on **Object-Oriented Programming (OOP)**, **clean code**, **software design**, **data persistence**, and **continuous refactoring**.

Rather than being a one-time project, it serves as a practical environment where I apply new Java concepts and improve the architecture as the project evolves.

The project started with **file-based persistence** and was later expanded with **database persistence using JDBC and MySQL**, allowing multiple persistence implementations through abstraction.

---

## ✨ Features

- 📖 Add new books
- 🔍 Search books using **partial title and author matching**
- 📚 Borrow books
- ↩️ Return borrowed books
- ❌ Remove books
- 📋 List all registered books
- 🔄 Automatically merge duplicate books by increasing copies
- ✅ Input validation
- ⚠️ Exception handling
- 🛡️ Domain validation using `IllegalArgumentException`
- 🧩 Persistence abstraction through interfaces
- 📄 File-based persistence
- 🗄️ Database persistence using JDBC
- 💾 Automatic saving and loading of library data
- 🔄 Incremental database updates (`INSERT`, `UPDATE`, and `DELETE`)
- 🖥️ Interactive console menu

---

## 🛠️ Technologies

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework (`ArrayList`)
- Java I/O
- JDBC
- SQL
- MySQL
- Maven
- JUnit 5
- Git & GitHub

---

## 📂 Project Structure

```text
src/
└── main/
    ├── java/
    │   ├── Main.java
    │   ├── app/
    │   │   └── App.java
    │   └── Library/
    │       ├── Book.java
    │       ├── Library.java
    │       ├── Persistence.java
    │       ├── LibraryPersistence.java
    │       └── DatabasePersistence.java
    │
    └── resources/
        ├── database.properties.example
        └── database-schema.sql
```

---

## 🧩 Class Responsibilities

| Class | Responsibility |
|---|---|
| **Book** | Represents a book entity and protects its own state through domain validation. |
| **Library** | Manages the collection of books and contains business rules, such as merging duplicate books and searching books. |
| **Persistence** | Defines the contract for persistence implementations. |
| **LibraryPersistence** | Implements file-based persistence for saving and loading library data. |
| **DatabasePersistence** | Implements database persistence using JDBC, including incremental `INSERT`, `UPDATE`, and `DELETE` operations. |
| **App** | Handles user interaction, input validation, and menu navigation. |
| **Main** | Application entry point. |

---

## 🗄️ Database Configuration

The project supports database persistence using **JDBC and MySQL**.

Before using the database persistence implementation:

### 1. Create a MySQL database

### 2. Execute the schema file

```text
src/main/resources/database-schema.sql
```

### 3. Create a `database.properties` file based on

```text
src/main/resources/database.properties.example
```

Example:

```properties
db.url=jdbc:mysql://localhost:3306/library
db.user=your_username
db.password=your_password
```

The real `database.properties` file is ignored by Git to prevent exposing sensitive information.

---

## 🧠 Concepts Practiced

### Object-Oriented Programming

- Classes and Objects
- Encapsulation
- Constructors
- Method Overloading
- Object References

### Collections Framework

- `List`
- `ArrayList`
- Enhanced `for-each` loops
- Collection traversal and search

### Persistence and JDBC

- File I/O
- JDBC Connections
- Prepared Statements
- SQL `INSERT`
- SQL `UPDATE`
- SQL `DELETE`
- SQL `SELECT`
- Incremental persistence strategies
- Automatic ID generation with MySQL

### Software Design

- Interfaces
- Polymorphism
- Programming to Interfaces
- Separation of Responsibilities
- Defensive Programming
- Domain Validation
- Refactoring and Clean Code Practices

### General Java Concepts

- Try-with-resources
- Exception Handling
- Input Validation
- Console Applications
- Git Branching and Incremental Development

---

## 🧪 Running Tests

Run all tests using Maven:

```bash
mvn test
```

---

## 🚀 Running the Project

### Clone the repository

```bash
git clone https://github.com/DeviRexVi/library-management-system.git
```

### Build the project

```bash
mvn clean package
```

### Run the application

```bash
java -jar target/library-management-system-1.0.0.jar
```

---

## 🔮 Future Improvements

This project will continue evolving as I practice new Java concepts and improve my software design skills.

Planned improvements include:

- 🧪 Expanding unit tests with JUnit
- 🔎 Advanced search and filtering features
- 🔃 Sorting books by different criteria
- 🧠 Introducing `HashMap` for faster internal lookups
- 🖥️ Creating a graphical user interface with JavaFX
- 📦 Improving package structure following Java conventions
- 🌐 Developing a REST API version
- 🏗️ Introducing a dedicated **Service Layer** to better separate business logic from user interaction

---

## 👨‍💻 Author

**Davi Rexhausen Vieira**

Software Engineering Student

GitHub: https://github.com/DeviRexVi

---

## 📄 License

This project is intended for **educational and portfolio purposes**.