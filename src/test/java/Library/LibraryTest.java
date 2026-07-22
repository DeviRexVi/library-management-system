package Library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    void addBookShouldIncreaseLibrarySize() {
        Library library = new Library();
        Book book = new Book("Clean Code", "Robert C. Martin", 5);

        library.addBook(book);

        assertEquals(1, library.getBooks().size());
    }

    @Test
    void findBookShouldReturnBookWhenItExists() {
        Library library = new Library();
        Book book = new Book("Clean Code", "Robert C. Martin", 5);

        library.addBook(book);

        Book foundBook = library.findBook("Clean Code");

        assertSame(book, foundBook);
    }

    @Test
    void findBookShouldReturnNullWhenBookDoesNotExist() {
        Library library = new Library();

        Book foundBook = library.findBook("Clean Code");

        assertNull(foundBook);
    }

    @Test
    void removeBookShouldRemoveBookFromLibrary() {
        Library library = new Library();
        Book book = new Book("Clean Code", "Robert C. Martin", 5);

        library.addBook(book);

        library.removeBook("Clean Code", "Robert C. Martin");

        assertEquals(0, library.getBooks().size());
    }

    @Test
    void removeBookShouldDoNothingWhenBookDoesNotExist() {
        Library library = new Library();

        library.removeBook("Clean Code", "Seila");

        assertEquals(0, library.getBooks().size());
    }

    @Test
    void addBookShouldMergeDuplicateBooks() {
        Library library = new Library();

        Book book1 = new Book("Clean Code", "Robert C. Martin", 5);
        Book book2 = new Book("Clean Code", "Robert C. Martin", 5);

        library.addBook(book1);
        library.addBook(book2);

        Book mergedBook = library.findBook("Clean Code", "Robert C. Martin");

        assertEquals(1, library.getBooks().size());
        assertEquals(10, mergedBook.getAvailableCopies());
        assertEquals(10, mergedBook.getTotalCopies());
    }
}