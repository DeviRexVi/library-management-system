package Library;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    /**
     * Searches for a book by its title.
     *
     * @param title the title of the book
     * @return the matching book, or null if not found
     */
    public Book findBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (title.equals(books.get(i).getTitle())) {
                return books.get(i);
            }
        }
        return null;
    }

    public Book findBook(String title, String author) {

        String searchTitle = title.toLowerCase();
        String searchAuthor = author.toLowerCase();

        for (Book book : books) {

            boolean titleMatches = book.getTitle()
                    .toLowerCase()
                    .contains(searchTitle);

            boolean authorMatches = book.getAuthor()
                    .toLowerCase()
                    .contains(searchAuthor);

            if (titleMatches && authorMatches) {
                return book;
            }
        }

        return null;
    }

    public boolean addBook(Book book) {
        Book existingBook = findBook(book.getTitle(), book.getAuthor());

        if (existingBook != null) {
            existingBook.addCopies(book.getAvailableCopies());
            return false; // Updates an exixting book
        }

        books.add(book);
        return true; // Adds a new book
    }

    /**
     * Removes a book by its title.
     *
     * @param title the title of the book to remove
     * @return true if removed, false otherwise
     */
    public boolean removeBook(String title, String author) {
        Book book = findBook(title, author);
        if (book != null) {
            books.remove(book);
            return true;
        }
        return false;
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("There are no books in the library.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
}