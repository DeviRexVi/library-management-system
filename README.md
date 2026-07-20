# 📚 Library Management System

> A console-based Library Management System developed in Java to practice Object-Oriented Programming, clean code principles, and software design.

This project simulates the core operations of a library while emphasizing **Object-Oriented Programming (OOP)**, **clean code**, and **progressive refactoring**.

Rather than being a one-time project, it serves as a learning playground where I continuously practice new Java concepts by applying them to a real project.

---

## ✨ Features

- 📖 Add new books
- 🔍 Search books by title or by title and author
- 📚 Borrow books
- ↩️ Return borrowed books
- ❌ Remove books
- 📋 List all registered books
- 💾 Automatically save library data to a text file
- 📂 Automatically load library data when the application starts
- 🔄 Automatically merge duplicate books by increasing the available copies
- ✅ Input validation
- ⚠️ Exception handling
- 🛡️ Domain validation using `IllegalArgumentException`
- 🖥️ Interactive console menu

---

## 🛠️ Technologies

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework (`ArrayList`)
- Java I/O (`File`, `FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`)
- Git & GitHub

---

## 📂 Project Structure

```text
src/
├── Main.java
├── app/
│   └── App.java
└── Library/
    ├── Book.java
    ├── Library.java
    └── LibraryPersistence.java
```

### Class Responsibilities

| Class | Responsibility |
|--------|----------------|
| **Book** | Represents a book and protects its own state through domain validation. |
| **Library** | Stores and manages the collection of books. |
| **LibraryPersistence** | Handles loading and saving the library data using file persistence. |
| **App** | Handles user interaction, input validation, and menu navigation. |
| **Main** | Application entry point. |

---

## 📸 Screenshots

### 💻 Code

Example of the `load()` implementation.

![load Method](images/load-code.png)

Example of the `save()` implementation.

![save Method](images/save-code.png)

---

### 🖥️ Application

#### Main Menu

![Main Menu](images/menu.png)

#### Listing Books

![Listing Books](images/list-books.png)

#### Borrowing a Book

![Borrow Book](images/borrow-book.png)

---

## 🧠 Concepts Practiced

- Object-Oriented Programming
- Classes and Objects
- Encapsulation
- Constructors
- Method Overloading
- Object References
- Collections Framework (`ArrayList`)
- File I/O
- Data Persistence
- Buffered Streams (`BufferedReader` / `BufferedWriter`)
- Try-with-resources
- Searching Algorithms
- Input Validation
- Exception Handling
- Defensive Programming
- Domain Validation
- Separation of Responsibilities
- Refactoring (DRY)
- Console Applications
- Control Structures (`if`, `switch`, `for`, `while`, `do-while`)
- Git Branching and Incremental Development

---

## 🚀 Running the Project

Clone the repository:

```bash
git clone https://github.com/DeviRexVi/library-management-system.git
```

Compile the project:

```bash
javac -d bin src/Main.java src/app/App.java src/Library/*.java
```

Run the application:

```bash
java -cp bin Main
```

---

## 🔮 Future Improvements

This project will continue evolving as I practice new Java concepts and improve my software design skills.

Planned improvements include:

- 🔃 Sorting books by different criteria
- 🔎 Partial search and filtering
- 🧪 Unit tests with JUnit
- 🗄️ Database integration (JDBC)
- 🖥️ Graphical user interface (JavaFX)
- 📦 Package refactoring following Java conventions

---

## 👨‍💻 Author

**Davi Rexhausen Vieira**

Software Engineering Student

GitHub: **https://github.com/DeviRexVi**

---

## 📄 License

This project is intended for educational purposes.