package Library;

public class Library {
    Book[] books = new Book[10];
    private int numberOfBooks;

    /**
     * Searches for a book by its title.
     *
     * @param title the title of the book
     * @return the matching book, or null if not found
     */
    public Book findBook(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                if (title.equals(books[i].getTitle())) {
                    return books[i];
                }
            }
        }
        return null;
    }

    /**
     * Adds a book to the library if there is available space.
     *
     * @param book the book to add
     */
    public void addBook(Book book) {
        if (numberOfBooks < books.length) {
            books[numberOfBooks] = book;
            numberOfBooks++;
        } else {
            System.out.println("Library is full.");
        }
    }

    /**
     * Removes a book by its title and reorganizes the array.
     *
     * @param title the title of the book to remove
     * @return true if removed, false otherwise
     */
    public boolean removeBook(String title) {
        for (int i = 0; i < numberOfBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                for (int j = i; j < numberOfBooks - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[numberOfBooks - 1] = null;
                numberOfBooks--;
                return true;
            }
        }
        return false;
    }

    /**
     * Prints all books currently registered in the library.
     */
    public void listBooks() {
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.println(books[i]);
        }
    }
}