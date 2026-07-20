package app;

import java.util.Scanner;
import Library.Library;
import Library.LibraryPersistence;
import Library.Book;

import java.io.IOException;
import java.util.InputMismatchException;

public class App {
    private static App instance;
    Library library = new Library();
    LibraryPersistence persistence = new LibraryPersistence();
    Scanner scanner = new Scanner(System.in);
    int option;

    /**
     * Private constructor that prevents direct instantiation of the class.
     * The App class follows the Singleton pattern, meaning only one instance
     * of the application can exist.
     */
    private App() {
    }

    /**
     * Returns the unique instance of the App class.
     * Creates a new instance only if one does not already exist.
     *
     * @return the single App instance
     */
    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

    /**
     * Displays the main menu options available to the user.
     */
    private void showMenu() {
        System.out.println("""
                ===============================
                   Library Management System
                ===============================

                1. Add Book
                2. Find Book
                3. Borrow Book
                4. Return Book
                5. Remove Book
                6. List Books
                0. Exit
                """);
    }

    /**
     * Starts the application loop.
     * 
     * Continuously displays the menu, receives user input,
     * and executes the corresponding operation until the user chooses exit.
     */
    public void run() {
        try {
            persistence.load(library);
        } catch (IOException e) {
            System.out.println("Error loading books.");
        }
        do {
            showMenu();
            boolean validOption = false;
            while (!validOption) {

                try {
                    System.out.print("Choose an option: ");
                    option = scanner.nextInt();

                    if (option < 0 || option > 6) {
                        System.out.println("Choose an option between 0 and 6.");
                    } else {
                        validOption = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid option. Please enter a number between 0 and 6.");
                    scanner.nextLine();
                }
            }
            scanner.nextLine();// Consume the leftover newLine
            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    findBook();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    removeBook();
                    break;
                case 6:
                    listBooks();
                    break;
                case 0:
                    try {
                        persistence.save(library);
                    } catch (IOException e) {
                        System.out.println("Error saving books.");
                    }

                    System.out.println("Goodbye!");
                    break;
                default:
                    break;
            }
        } while (option != 0);
    }

    /**
     * Adds a new book to the library.
     *
     * Reads the book title, author, and number of available copies
     * from the user, creates a Book object, and stores it in the library.
     */
    private void addBook() {
        String title = readNonEmptyString("Title: ");
        String author = readNonEmptyString("Author: ");

        boolean validInput = false;
        int totalCopies = 0;

        while (!validInput) {
            System.out.print("Total copies: ");
            try {
                totalCopies = scanner.nextInt();
                scanner.nextLine(); // Consume the leftover newLine
                if (totalCopies < 0) {
                    System.out.println("Enter a number greater than or equal to 0.");
                    validInput = false;
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        Book existingBook = library.findBook(title, author);

        if (existingBook != null) {
            existingBook.addCopies(totalCopies);
            System.out.println("Book copies updated.");
        } else {
            Book book = new Book(title, author, totalCopies);
            library.addBook(book);
            System.out.println("Book added successfully.");
        }
    }

    /**
     * Searches for a book by its title.
     *
     * If the book exists, its information is displayed.
     * Otherwise, a message indicating that the book was not found is shown.
     */
    private void findBook() {
        String title = readNonEmptyString("Title: ");
        String author = readNonEmptyString("Author: ");

        Book book = library.findBook(title, author);

        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found.");
        }
    }

    /**
     * Borrows a book from the library.
     *
     * Searches for a book by title and decreases its available copies
     * if at least one copy is available.
     */
    private void borrowBook() {
        String title = readNonEmptyString("Title: ");
        String author = readNonEmptyString("Author: ");

        Book book = library.findBook(title, author);

        if (book != null) {
            if (book.borrow()) {
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("No copies available.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    /**
     * Returns a borrowed book.
     *
     * Searches for a book by title and increases its available copies.
     */
    private void returnBook() {
        String title = readNonEmptyString("Title: ");
        String author = readNonEmptyString("Author: ");

        Book book = library.findBook(title, author);

        if (book != null) {
            if (book.returnCopy()) {
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("All copies are already available.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    /**
     * Removes a book from the library.
     *
     * Searches for a book by title and removes it if found.
     */
    private void removeBook() {
        String title = readNonEmptyString("Title: ");
        String author = readNonEmptyString("Author: ");

        if (library.removeBook(title, author)) {
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    /**
     * Displays all books currently stored in the library.
     */
    private void listBooks() {
        library.listBooks();
    }

    private String readNonEmptyString(String message) {
        String input;

        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim();

            if (input.isBlank()) {
                System.out.println(message + "cannot be empty.");
            } else {
                break;
            }
        }
        return input;
    }
}