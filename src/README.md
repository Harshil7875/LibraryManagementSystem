# Technical Documentation: Library Management System

## Overview
The Library Management System is a Java-based console application that demonstrates core object-oriented programming concepts, file serialization, and basic command-line interactions. The system manages books, users, and their interactions, such as issuing and returning books. The application persists its data to disk, allowing for data recovery between sessions.

---

## Project Structure

```plaintext
LibraryManagementSystem/
├── src/                  # Source files
│   ├── Book.java         # Represents a book in the library
│   ├── Library.java      # Main library logic and data persistence
│   ├── Main.java         # Entry point for the program
│   └── User.java         # Represents a user of the library
├── bin/                  # Compiled `.class` files
├── data/
│   └── library_data.txt  # Serialized library data file
├── README.md             # General project documentation
├── technical_readme.md   # Detailed technical documentation
└── compile_and_run.sh    # Script to compile and run the application
```

---

## Core Components

### 1. **Book.java**
Represents a book entity with the following fields and methods:
- **Fields**:
  - `int id`: Unique identifier for the book.
  - `String title`: Title of the book.
  - `String author`: Author of the book.
  - `boolean isIssued`: Indicates if the book is currently issued.

- **Methods**:
  - Getters and setters for all fields.
  - `toString()`: Returns a string representation of the book.

**Example:**
```java
Book book = new Book(1, "Java Programming", "John Doe");
System.out.println(book);
```

---

### 2. **User.java**
Represents a library user with the following fields and methods:
- **Fields**:
  - `int id`: Unique identifier for the user.
  - `String name`: Name of the user.

- **Methods**:
  - Getters for all fields.
  - `toString()`: Returns a string representation of the user.

**Example:**
```java
User user = new User(1001, "Alice");
System.out.println(user);
```

---

### 3. **Library.java**
Implements the core functionality of the library system, including:
- **Data Storage**:
  - `List<Book> books`: Stores the list of books in the library.
  - `Map<Integer, User> issuedBooks`: Maps book IDs to the user who has issued them.

- **Methods**:
  - `addBook(Book book)`: Adds a book to the library.
  - `listBooks()`: Prints a list of all books in the library.
  - `issueBook(int bookId, User user)`: Issues a book to a user.
  - `returnBook(int bookId)`: Returns a book to the library.
  - `saveLibraryData(String filePath)`: Serializes the library data to a file.
  - `loadLibraryData(String filePath)`: Deserializes library data from a file.

**Persistence**:
Data is saved and loaded using Java's `ObjectOutputStream` and `ObjectInputStream`. The file path for saving data is defined in the `Main` class as `data/library_data.txt`.

---

### 4. **Main.java**
The entry point of the application. It handles:
- **Menu-driven Interaction**:
  - Displays the main menu with options: Add Book, List Books, Issue Book, Return Book, Save, and Exit.
  - Captures and processes user input.
- **Error Handling**:
  - Catches and handles `IOException` and `ClassNotFoundException` during data loading and saving.
- **Resource Management**:
  - Uses try-with-resources to manage the `Scanner` object for user input.

---

## Technical Details

### 1. **Serialization**
The `Library`, `Book`, and `User` classes implement the `Serializable` interface to allow the objects to be saved to and loaded from a file. The library data is persisted to `data/library_data.txt`.

- **Save Data**:
  ```java
  library.saveLibraryData("data/library_data.txt");
  ```

- **Load Data**:
  ```java
  Library library = Library.loadLibraryData("data/library_data.txt");
  ```

### 2. **Error Handling**
The system gracefully handles missing or corrupted data files:
- If the `data/library_data.txt` file is missing or unreadable, the program starts with an empty library and informs the user.

**Example**:
```java
try {
    library = Library.loadLibraryData(DATA_FILE);
    System.out.println("Library data loaded.");
} catch (IOException | ClassNotFoundException e) {
    System.out.println("No existing library data found. Starting fresh.");
}
```

### 3. **Menu Interaction**
The program uses a loop to present a menu to the user:
- Each menu option corresponds to a method in the `Library` class.
- Input validation ensures proper functioning.

**Menu Example**:
```plaintext
Library Management System
1. Add Book
2. List Books
3. Issue Book
4. Return Book
5. Save and Exit
Enter your choice:
```

---

## Data Flow Diagram

1. **Add Book**:
   - User provides book details (ID, Title, Author).
   - Book is added to the `books` list.

2. **Issue Book**:
   - User provides book ID and user details.
   - Book is marked as issued, and the `issuedBooks` map is updated.

3. **Return Book**:
   - User provides book ID.
   - Book is marked as available, and the entry is removed from `issuedBooks`.

4. **Save and Exit**:
   - All data is serialized and saved to `data/library_data.txt`.

---

## Example Scenarios

1. **Adding and Listing a Book**:
```plaintext
Enter your choice: 1
Enter Book ID: 1
Enter Title: Clean Code
Enter Author: Robert C. Martin
Book added.

Enter your choice: 2
Book[ID=1, Title='Clean Code', Author='Robert C. Martin', Issued=No]
```

2. **Issuing a Book**:
```plaintext
Enter your choice: 3
Enter Book ID to issue: 1
Enter User ID: 1001
Enter User Name: Alice
Book 'Clean Code' issued to Alice.
```

3. **Returning a Book**:
```plaintext
Enter your choice: 4
Enter Book ID to return: 1
Book 'Clean Code' returned.
```

4. **Saving and Exiting**:
```plaintext
Enter your choice: 5
Library data saved. Goodbye!
```

---

## Technical Requirements

- **Java Version**: Java 11 or higher
- **Dependencies**: No external libraries required
- **File System**: Ensure write permissions for the `data/` directory.

---

## Future Improvements

1. Implement search functionality for books and users.
2. Add a graphical user interface (GUI) using JavaFX or Swing.
3. Introduce role-based access (e.g., admin and user roles).