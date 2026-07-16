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

    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Removes a book by its title.
     *
     * @param title the title of the book to remove
     * @return true if removed, false otherwise
     */
    public boolean removeBook(String title) {
        Book book = findBook(title);
        if (book != null) {
            books.remove(book);
            return true;
        }
        return false;
    }

    public void listBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
    }
}