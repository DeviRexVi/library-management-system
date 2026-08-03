package Library;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import org.junit.jupiter.api.Test;

public class DatabasePersistenceTest {

    @Test
    void shouldUpdateBookCopies() throws IOException {

        DatabasePersistence persistence = new DatabasePersistence();

        // Clear the table before the test
        persistence.save(new Library());

        Library library = new Library();

        // 1. Create a book
        Book book = new Book("Clean Code", "Robert C. Martin", 5);
        library.addBook(book);

        // 2. Save it to the database
        persistence.save(library);

        // 3. Load it again to get the generated ID
        Library loadedLibrary = new Library();
        persistence.load(loadedLibrary);

        Book loadedBook = loadedLibrary.getBooks().get(0);

        // 4. Change the object state
        loadedBook.borrow(); // availableCopies changes from 5 to 4

        // 5. Update the database record
        persistence.updateBook(loadedBook);

        // 6. Reload from the database
        Library updatedLibrary = new Library();
        persistence.load(updatedLibrary);

        Book updatedBook = updatedLibrary.getBooks().get(0);

        // 7. Verify that the UPDATE worked correctly
        assertEquals(4, updatedBook.getAvailableCopies());
        assertEquals(5, updatedBook.getTotalCopies());
        assertEquals(loadedBook.getId(), updatedBook.getId());
    }

    @Test
    void shouldDeleteBook() throws IOException {

        DatabasePersistence persistence = new DatabasePersistence();

        // Clear the table before the test
        persistence.save(new Library());

        Library library = new Library();

        // 1. Create a book
        Book book = new Book("Clean Code", "Robert C. Martin", 5);
        library.addBook(book);

        // 2. Save it to the database
        persistence.save(library);

        // 3. Load it again to get the generated ID
        Library loadedLibrary = new Library();
        persistence.load(loadedLibrary);

        assertEquals(1, loadedLibrary.getBooks().size());

        Book loadedBook = loadedLibrary.getBooks().get(0);

        // 4. Delete the book
        persistence.deleteBook(loadedBook);

        // 5. Reload the database
        Library updatedLibrary = new Library();
        persistence.load(updatedLibrary);

        // 6. Verify deletion
        assertTrue(updatedLibrary.getBooks().isEmpty());
    }

    @Test
    void shouldInsertBookAndGenerateId() throws IOException {
        DatabasePersistence persistence = new DatabasePersistence();

        Book book = new Book("Clean Code", "Robert C. Martin", 5);

        persistence.insertBook(book);

        assertTrue(book.getId() > 0);
    }
}