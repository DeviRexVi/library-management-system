package Library;

public class Library {
    Book[] books = new Book[10];
    private int numberOfBooks;

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
    public void addBook(Book book){
        if(numberOfBooks < books.length){
            books[numberOfBooks] = book;
            numberOfBooks++;
        }else{
            System.out.println("LIbrary is full.");
        }
    }
}
