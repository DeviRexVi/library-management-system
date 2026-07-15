package src.app;

import java.util.Scanner;
import Library.Library;
import Library.Book;

public class App {
    private static App instance;
    Library library = new Library();
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

        System.out.print("Choose an option: ");
    }

    /**
     * Starts the application loop.
     * 
     * Continuously displays the menu, receives user input,
     * and executes the corresponding operation until the user chooses exit.
     */
    public void run() {

        do {
            showMenu();
            option = scanner.nextInt();
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
        System.out.print("title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("Available copies: ");
        int availableCopies = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book(title, author, availableCopies);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    /**
     * Searches for a book by its title.
     *
     * If the book exists, its information is displayed.
     * Otherwise, a message indicating that the book was not found is shown.
     */
    private void findBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        Book book = library.findBook(title);

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
        System.out.print("Title: ");
        String title = scanner.nextLine();

        Book book = library.findBook(title);

        if (book != null) {
            if (book.borrow()) {
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("No copies available.");
            }
        }else{
            System.out.println("Book not found.");
        }
    }

    /**
     * Returns a borrowed book.
     *
     * Searches for a book by title and increases its available copies.
     */
    private void returnBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        Book book = library.findBook(title);

        if (book != null) {
            book.returnCopy();
            System.out.println("Book returned successfully.");
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
        System.out.print("Title: ");
        String title = scanner.nextLine();

        if (library.removeBook(title)) {
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
}