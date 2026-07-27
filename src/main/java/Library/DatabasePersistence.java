package Library;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DatabasePersistence implements Persistence {

    private String url;
    private String user;
    private String password;

    public DatabasePersistence() {
        Properties properties = new Properties();

        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("database.properties")) {

            if (input == null) {
                throw new RuntimeException("database.properties not found");
            }

            properties.load(input);

            url = properties.getProperty("db.url");
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");

        } catch (Exception e) {
            throw new RuntimeException("Could not load database configuration", e);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void save(Library library) throws IOException {
        try (Connection connection = getConnection()) {

            connection.createStatement()
                    .executeUpdate("DELETE FROM books");

            String sql = """
                    INSERT INTO books(title, author, total_copies, available_copies)
                    VALUES (?, ?, ?, ?)
                    """;

            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                for (Book book : library.getBooks()) {
                    statement.setString(1, book.getTitle());
                    statement.setString(2, book.getAuthor());
                    statement.setInt(3, book.getTotalCopies());
                    statement.setInt(4, book.getAvailableCopies());

                    statement.executeUpdate();
                }
            }

        } catch (SQLException e) {
            throw new IOException("Error saving books to database.", e);
        }
    }

    @Override
    public void load(Library library) throws IOException {
        try (Connection connection = getConnection()) {
            String sql = "SELECT * FROM books";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Book book = new Book(
                        result.getString("title"),
                        result.getString("author"),
                        result.getInt("available_copies"),
                        result.getInt("total_copies"));

                library.addBook(book);
            }

        } catch (SQLException e) {
            throw new IOException("Error loading books from database.", e);
        }
    }
}