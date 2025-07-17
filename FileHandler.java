import java.io.*;

public class FileHandler {
    public static void saveBookToFile(String title, String author) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt", true))) {
            writer.write("Book Title: " + title + ", Author: " + author + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveMemberToFile(String name, String email) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.txt", true))) {
            writer.write("Member: " + name + ", Email: " + email + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}