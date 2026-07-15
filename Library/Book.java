package Library;

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
      if (availableCopies > 0) {// Checks if there are available copies to be borrowed
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

   @Override
   public String toString() {
      return "\n----------------------" +
            "Title: " + title +
            "\nAuthor: " + author +
            "\nAvailable copies: " + availableCopies +
            "\n----------------------";
   }
}