import java.util.*;

public class LibraryManagement {
    private static List<Book> books = new ArrayList<>();
    private static List<Member> members = new ArrayList<>();

    // Add a new book to the library
    public static void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    // Add a new member
    public static void addMember(String name, String email) {
        members.add(new Member(name, email));
    }

    // Checkout a book
    public static void checkoutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Book checked out: " + title);
                return;
            }
        }
        System.out.println("Book is not available.");
    }

    // Return a book
    public static void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Book returned: " + title);
                return;
            }
        }
        System.out.println("Book was not checked out.");
    }

    // Display all books
    public static void displayBooks() {
        System.out.println("Books in Library:");
        for (Book book : books) {
            String status = book.isAvailable() ? "Available" : "Checked out";
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - " + status);
        }
    }

    // Display all members
    public static void displayMembers() {
        System.out.println("Members:");
        for (Member member : members) {
            System.out.println(member.getName() + " (" + member.getEmail() + ")");
        }
    }
}