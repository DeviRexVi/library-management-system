package Library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void borrowShouldDecreaseAvailableCopies() {
        Book book = new Book("Clean Code", "Robert C. Martin", 5);

        book.borrow();

        assertEquals(4, book.getAvailableCopies());
    }

    @Test
    void borrowShouldNotDecreaseAvailableCopiesWhenNoCopiesAreAvailable() {
        Book book = new Book("Clean Code", "Robert C. Martin", 0);

        book.borrow();

        assertEquals(0, book.getAvailableCopies());
    }

    @Test
    void returnCopyShouldIncreaseAvailableCopies() {
        Book book = new Book("Clean Code", "Robert C. Martin", 5);

        book.borrow();
        book.returnCopy();

        assertEquals(5, book.getAvailableCopies());
    }

    @Test
    void returnCopyShouldNotExceedTotalCopies() {
        Book book = new Book("Clean Code", "Robert C. Martin", 5);

        book.returnCopy();

        assertEquals(5, book.getAvailableCopies());
    }

    @Test
    void addCopiesShouldIncreaseAvailableCopies() {
        Book book = new Book("Clean Code", "Robert C. Martin", 5);

        book.addCopies(3);

        assertEquals(8, book.getAvailableCopies());
        assertEquals(8, book.getTotalCopies());
    }

    @Test
    void addCopiesShouldThrowExceptionWhenAmountIsNegative() {
        Book book = new Book("Clean Code", "Robert C. Martin", 5);

        assertThrows(
                IllegalArgumentException.class,
                () -> book.addCopies(-1));
    }

    @Test
    void constructorShouldThrowExceptionWhenCopiesAreNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Book("Clean Code", "Robert C. Martin", -1);
        });
    }

    @Test
    void constructorShouldThrowExceptionWhenTitleIsBlank() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Book("", "Robert C. Martin", 5));
    }

    @Test
    void constructorShouldThrowExceptionWhenAuthorIsBlank() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Book("Clean Code", "", 5));
    }

    @Test
    void constructorShouldThrowExceptionWhenTotalCopiesIsNegative() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new Book("Clean Code", "Robert C. Martin", -1));
    }
}