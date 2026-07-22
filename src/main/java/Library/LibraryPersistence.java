package Library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

public class LibraryPersistence implements Persistence {
    private static final String FILE_NAME = "books.txt";

    @Override
    public void load(Library library) throws IOException {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                String title = parts[0];
                String author = parts[1];
                int totalCopies = Integer.parseInt(parts[2]);

                Book book = new Book(title, author, totalCopies);
                library.addBook(book);
            }
        }
    }

    @Override
    public void save(Library library) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book book : library.getBooks()) {
                writer.write(
                        book.getTitle() + ";" +
                                book.getAuthor() + ";" +
                                book.getAvailableCopies());

                writer.newLine();
            }
        }
    }
}