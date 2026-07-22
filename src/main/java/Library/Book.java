package Library;

/**
 * Represents a book and manages its available copies.
 */
public class Book {
   private String title;
   private String author;
   private int availableCopies;
   private int totalCopies;

   public Book() {
   }

   public Book(String title, String author, int totalCopies) {

      if (title == null || title.isBlank()) {
         throw new IllegalArgumentException("Title cannot be empty.");
      } else if (author == null || author.isBlank()) {
         throw new IllegalArgumentException("Author cannot be empty.");
      }

      if (totalCopies < 0) {
         throw new IllegalArgumentException("Enter a number greater than or equal to 0.");
      }

      this.title = title;
      this.author = author;
      this.totalCopies = totalCopies;
      this.availableCopies = totalCopies;
   }

   public boolean borrow() {
      if (availableCopies > 0) {
         availableCopies--;
         return true;
      } else {
         return false;
      }
   }

   public boolean returnCopy() {
      if (availableCopies < totalCopies) {
         availableCopies++;
         return true;
      }
      return false;
   }

   public String getTitle() {
      return title;
   }

   public String getAuthor() {
      return author;
   }

   public int getAvailableCopies() {
      return availableCopies;
   }

   public int getTotalCopies() {
      return totalCopies;
   }

   public boolean isBookTheSame(String title, String author) {
      return this.title.equals(title) && this.author.equals(author);
   }

   public void addCopies(int amount) {
      if (amount < 0) {
         throw new IllegalArgumentException("Amount cannot be negative");
      }
      availableCopies += amount;
      totalCopies += amount;
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