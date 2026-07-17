package Library;
/**
 * Represents a book and manages its available copies.
 */
public class Book {
   private String title;
   private String author;
   private int availableCopies;

   public Book() {
   }

   public Book(String title, String author, int availableCopies) {
      this.title = title;
      this.author = author;
      this.availableCopies = availableCopies;
   }

   public boolean borrow() {
      if (availableCopies > 0) {
         availableCopies--;
         return true;
      } else {
         return false;
      }
   }

   public void returnCopy() {
      availableCopies++;
   }

   public String getTitle() {
      return title;
   }

   public String getAuthor() {
      return author;
   }

   public boolean isBookTheSame(String title, String author){
      return this.title.equals(title) && this.author.equals(author);
   }

   public void addCopies(int amount){
      availableCopies += amount;
   }

   @Override
   public String toString() {
      return """
            ----------------------
            Title: %s
            Author: %s
            Available copies: %d
            ----------------------
            """.formatted(title, author, availableCopies);
   }
}