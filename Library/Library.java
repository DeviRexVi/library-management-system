package Library;

public class Library {
    Book[] books = new Book[10];
    private int numberOfBooks;

    public Book findBook(String title) {
        for (int i = 0; i < books.length; i++) {// Iterates through every position in the array.
            if (books[i] != null) {// Skips empty positions in the array.
                if (title.equals(books[i].getTitle())) {// Checks whether this book's title matches the requested title.
                    return books[i];
                }
            }
        }
        return null;// If no matching book is found, returns null.
    }

    public void addBook(Book book) {
        if (numberOfBooks < books.length) {// checks if there is space in the array
            books[numberOfBooks] = book;// Stores the book in the next available position.
            numberOfBooks++;// Updates the number of books in the library.
        } else {
            System.out.println("Library is full.");
        }
    }

    public void removeBook(String title) {
        for (int i = 0; i < numberOfBooks; i++) {
            if (title.equals(books[i].getTitle())) {
                for (int j = i; j < numberOfBooks - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[numberOfBooks - 1] = null;
                numberOfBooks--;
                return;
            }
        }
    }
}