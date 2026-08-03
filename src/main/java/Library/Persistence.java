package Library;

import java.io.IOException;

public interface Persistence {

    void save(Library library) throws IOException;

    void load(Library library) throws IOException;

    void updateBook(Book book) throws IOException;

    void deleteBook(Book book) throws IOException;
}