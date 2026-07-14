package src.app;

import java.util.Scanner;
import Library.Library;
import Library.Book;

public class App {
    private static App instance;
    Library library = new Library();
    Scanner scanner = new Scanner(System.in);
    int opition;

    private App() {
    }

    public static App getInstance() {
        if (instance == null) {
            instance = new App();
        }
        return instance;
    }

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

    
    public void run() {

        do {
            showMenu();
            opition = scanner.nextInt();
            scanner.nextLine();// Consume the leftover newLine
            switch (opition) {
                case 1:
                    addBook();
                    break;
                default:
                    break;
            }
        } while (opition != 0);
    }

    private void addBook() {
        System.out.print("title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        System.out.print("How many?: ");
        int availableCopies = scanner.nextInt();
        scanner.nextLine();

        Book book = new Book(title, author, availableCopies);
        library.addBook(book);
    }
}