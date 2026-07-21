package Library;

import java.io.IOException;

public interface Persistence {
    void load(Library library) throws IOException;

    void save(Library library) throws IOException;
}
