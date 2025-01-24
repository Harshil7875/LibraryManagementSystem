<!-- LibraryManagementSystem/README.md -->

# Library Management System

## Overview
The Library Management System is a console-based Java application that allows users to manage books and their issuance status. It leverages Object-Oriented Programming principles and file storage to ensure persistence of data across sessions.

---

## Features
1. Add books to the library.
2. List all available books.
3. Issue books to users.
4. Return books to the library.
5. Save and load library data using file serialization.

---

## **How to Compile and Run the Library Management System**

### **Step 1: Ensure the Directory Structure**
Your project directory should be structured as follows:
```plaintext
LibraryManagementSystem/
├── README.md             # Project documentation
├── LICENSE               # License file
├── src/                  # Source files
│   ├── Library.java
│   ├── Book.java
│   ├── Main.java
│   └── User.java
├── bin/                  # Compiled class files
│   ├── Book.class
│   ├── Library.class
│   ├── Main.class
│   └── User.class
├── data/                 # Data storage for serialized library information
│   └── Library_data.txt
└── compile_and_run.sh    # Optional script for automation
```

If the `bin/` or `data/` directories are missing, create them using:
```bash
mkdir -p bin data
```

---

### **Step 2: Compile the Code**
Navigate to the project root directory and compile the Java files:
```bash
javac -d bin src/*.java
```

**Explanation**:
- `-d bin`: Specifies the output directory (`bin`) for compiled `.class` files.
- `src/*.java`: Compiles all Java files located in the `src/` directory.

**Expected Output**:
```plaintext
(No output if compilation is successful.)
```

If there are syntax errors, they will appear in the terminal. Resolve them before proceeding.

---

### **Step 3: Run the Program**
Run the program by executing the `Main` class from the **root** directory:
```bash
java -cp bin Main
```

**Explanation**:
- `-cp bin`: Sets the classpath to the `bin/` directory, where the `.class` files are located.
- `Main`: Specifies the entry point of the program.

**Expected Output**:
The program will display the main menu:
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

### **Example Workflow**

1. **Add a Book**:
   - Input:
     ```plaintext
     Enter your choice: 1
     Enter Book ID: 1
     Enter Title: Java Programming
     Enter Author: John Doe
     ```
   - Output:
     ```plaintext
     Book added.
     ```

2. **List Books**:
   - Input:
     ```plaintext
     Enter your choice: 2
     ```
   - Output:
     ```plaintext
     Book[ID=1, Title='Java Programming', Author='John Doe', Issued=No]
     ```

3. **Issue a Book**:
   - Input:
     ```plaintext
     Enter your choice: 3
     Enter Book ID to issue: 1
     Enter User ID: 1001
     Enter User Name: Alice
     ```
   - Output:
     ```plaintext
     Book 'Java Programming' issued to Alice.
     ```

4. **Return a Book**:
   - Input:
     ```plaintext
     Enter your choice: 4
     Enter Book ID to return: 1
     ```
   - Output:
     ```plaintext
     Book 'Java Programming' returned.
     ```

5. **Save and Exit**:
   - Input:
     ```plaintext
     Enter your choice: 5
     ```
   - Output:
     ```plaintext
     Library data saved. Goodbye!
     ```

---

### **Step 4: Verify Saved Data**
The program saves data in the `data/Library_data.txt` file after running. To verify:
```bash
cat data/Library_data.txt
```

---

### **Summary of Commands**
Here’s a concise list of commands to set up, compile, and run the project:

1. Create necessary directories:
   ```bash
   mkdir -p bin data
   ```

2. Compile the project:
   ```bash
   javac -d bin src/*.java
   ```

3. Run the program:
   ```bash
   java -cp bin Main
   ```

4. Verify saved data:
   ```bash
   cat data/Library_data.txt
   ```

---

### **Menu Options and Input Types**

| Menu Option       | Input Field        | Data Type  |
|-------------------|--------------------|------------|
| **Add Book**      | Book ID            | `int`      |
|                   | Title              | `String`   |
|                   | Author             | `String`   |
| **List Books**    | -                  | *(No Input)* |
| **Issue Book**    | Book ID            | `int`      |
|                   | User ID            | `int`      |
|                   | User Name          | `String`   |
| **Return Book**   | Book ID            | `int`      |
| **Save and Exit** | -                  | *(No Input)* |

---

### **License**
This project is licensed under the **MIT License**. See the [LICENSE](./LICENSE) file for more details.