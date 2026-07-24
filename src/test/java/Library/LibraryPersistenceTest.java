package Library;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LibraryPersistenceTest {

    private static final String TEST_FILE = "test-books.txt";

    @AfterEach
    void cleanUp() {
        new File(TEST_FILE).delete();
    }

    @Test
    void saveShouldCreateFile() throws IOException {

        Library library = new Library();
        library.addBook(new Book("Clean Code", "Robert C. Martin", 5));

        LibraryPersistence persistence = new LibraryPersistence(TEST_FILE);

        persistence.save(library);

        assertTrue(new File(TEST_FILE).exists());
    }

    @Test
    void saveShouldWriteBooksToFile() throws IOException {

        Library library = new Library();

        library.addBook(new Book("Clean Code", "Robert C. Martin", 5));
        library.addBook(new Book("Effective Java", "Joshua Bloch", 3));

        LibraryPersistence persistence = new LibraryPersistence(TEST_FILE);

        persistence.save(library);

        Library loadedLibrary = new Library();

        persistence.load(loadedLibrary);

        assertEquals(2, loadedLibrary.getBooks().size());

        assertNotNull(
                loadedLibrary.findBook("Clean Code", "Robert C. Martin"));

        assertNotNull(
                loadedLibrary.findBook("Effective Java", "Joshua Bloch"));
    }

    @Test
    void loadShouldCreateFileWhenItDoesNotExist() throws IOException {

        Library library = new Library();

        LibraryPersistence persistence = new LibraryPersistence(TEST_FILE);

        persistence.load(library);

        assertTrue(new File(TEST_FILE).exists());
    }

    @Test
    void loadShouldLoadBooksFromFile() throws IOException {

        try (FileWriter writer = new FileWriter(TEST_FILE)) {
            writer.write("Clean Code;Robert C. Martin;5\n");
            writer.write("Effective Java;Joshua Bloch;3\n");
        }

        Library library = new Library();

        LibraryPersistence persistence = new LibraryPersistence(TEST_FILE);

        persistence.load(library);

        assertEquals(2, library.getBooks().size());

        assertNotNull(
                library.findBook("Clean Code", "Robert C. Martin"));

        assertNotNull(
                library.findBook("Effective Java", "Joshua Bloch"));
    }

    @Test
    void loadShouldHandleEmptyFile() throws IOException {

        new File(TEST_FILE).createNewFile();

        Library library = new Library();

        LibraryPersistence persistence = new LibraryPersistence(TEST_FILE);

        persistence.load(library);

        assertTrue(library.getBooks().isEmpty());
    }
}