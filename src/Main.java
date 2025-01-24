import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final String DATA_FILE = "data/library_data.txt";

    public static void main(String[] args) {
        Library library = new Library();

        try {
            library = Library.loadLibraryData(DATA_FILE);
            System.out.println("Library data loaded.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing library data found. Starting fresh.");
        }

        try (Scanner scanner = new Scanner(System.in)) {  // Use try-with-resources here
            while (true) {
                System.out.println("\nLibrary Management System");
                System.out.println("1. Add Book");
                System.out.println("2. List Books");
                System.out.println("3. Issue Book");
                System.out.println("4. Return Book");
                System.out.println("5. Save and Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        library.addBook(new Book(id, title, author));
                        System.out.println("Book added.");
                        break;

                    case 2:
                        library.listBooks();
                        break;

                    case 3:
                        System.out.print("Enter Book ID to issue: ");
                        int issueId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter User ID: ");
                        int userId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter User Name: ");
                        String userName = scanner.nextLine();
                        library.issueBook(issueId, new User(userId, userName));
                        break;

                    case 4:
                        System.out.print("Enter Book ID to return: ");
                        int returnId = scanner.nextInt();
                        scanner.nextLine();
                        library.returnBook(returnId);
                        break;

                    case 5:
                        try {
                            library.saveLibraryData(DATA_FILE);
                            System.out.println("Library data saved. Goodbye!");
                        } catch (IOException e) {
                            System.out.println("Error saving library data: " + e.getMessage());
                        }
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }
}
