// src/Library.java
import java.io.*;
import java.util.*;

public class Library implements Serializable {
    private List<Book> books = new ArrayList<>();
    private Map<Integer, User> issuedBooks = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBooks() {
        books.forEach(System.out::println);
    }

    public void issueBook(int bookId, User user) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (!book.isIssued()) {
                    book.setIssued(true);
                    issuedBooks.put(bookId, user);
                    System.out.printf("Book '%s' issued to %s.\n", book.getTitle(), user.getName());
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(int bookId) {
        if (issuedBooks.containsKey(bookId)) {
            for (Book book : books) {
                if (book.getId() == bookId) {
                    book.setIssued(false);
                    System.out.printf("Book '%s' returned.\n", book.getTitle());
                    issuedBooks.remove(bookId);
                    return;
                }
            }
        }
        System.out.println("Book not found in issued list.");
    }

    public void saveLibraryData(String filePath) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(this);
        }
    }

    public static Library loadLibraryData(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Library) ois.readObject();
        }
    }
}
