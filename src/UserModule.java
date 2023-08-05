import java.util.Scanner;

public class UserModule {
    private LibraryDatabase libraryDB;
    private Scanner scanner;

    public UserModule(LibraryDatabase libraryDB) {
        this.libraryDB = libraryDB;
        scanner = new Scanner(System.in);
    }

    // Method to handle user actions like browsing, searching, borrowing, returning books
    public void performUserAction() {
        boolean exit = false;

        while (!exit) {
            System.out.println("User Actions:");
            System.out.println("1. Browse available books");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    browseAvailableBooks();
                    break;
                case 2:
                    borrowBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void browseAvailableBooks() {
        System.out.println("Available Books:");
        int n = 1;
        for (Book book : libraryDB.getAllBooks()) {
            if (book.isAvailable()) {
                System.out.println(n + ". " + book.getTitle() + " by " + book.getAuthor() + " (Category: " + book.getCategory() + ")");
                n++;
            }
        }
    }

    private void borrowBook() {
        System.out.println("Enter the ID of the book you want to borrow:");
        String bookId = scanner.nextLine();

        Book bookToBorrow = libraryDB.findBookById(bookId);

        if (bookToBorrow != null && bookToBorrow.isAvailable()) {

            // Mark the book as unavailable in the library database
            bookToBorrow.setAvailable(false);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book not found or already borrowed.");
        }
    }

    private void returnBook() {
        System.out.println("Enter the ID of the book you want to return:");
        String bookId = scanner.nextLine();

        Book bookToReturn = libraryDB.findBookById(bookId);

        if (bookToReturn != null && !bookToReturn.isAvailable()) {

            // Mark the book as available in the library database
            bookToReturn.setAvailable(true);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found or already available.");
        }
    }
}
