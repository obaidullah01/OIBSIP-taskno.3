import java.util.Scanner;

public class AdminModule {
    private static final String ADMIN_USERNAME = "admin123";
    private static final String ADMIN_PASSWORD = "1234";

    private LibraryDatabase libraryDB;
    private Scanner scanner;
    private boolean exit;

    public AdminModule(LibraryDatabase libraryDB) {
        this.libraryDB = libraryDB;
        scanner = new Scanner(System.in);
        exit = false;
    }

    public void performAdminAction() {
        boolean authenticated = login();

        if (authenticated) {
            System.out.println("Admin logged in successfully.");
            while (!exit) {
                System.out.println("Admin Actions:");
                System.out.println("1. Add a new book");
                System.out.println("2. List all books");
                System.out.println("3. Update a book");
                System.out.println("4. Delete a book");
                System.out.println("5. Add a new member");
                System.out.println("6. List all members");
                System.out.println("7. Update a member");
                System.out.println("8. Delete a member");
                System.out.println("9. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        addNewBook();
                        break;
                    case 2:
                        listAllBooks();
                        break;
                    case 3:
                        updateBook();
                        break;
                    case 4:
                        deleteBook();
                        break;
                    case 5:
                        addNewMember();
                        break;
                    case 6:
                        listAllMembers();
                        break;
                    case 7:
                        updateMember();
                        break;
                    case 8:
                        deleteMember();
                        break;
                    case 9:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Invalid credentials. Access denied.");
        }
    }

    private boolean login() {
        System.out.println("Enter admin username:");
        String username = scanner.nextLine();

        System.out.println("Enter admin password:");
        String password = scanner.nextLine();

        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }


    private void addNewBook() {
        System.out.println("Enter book ID:");
        String bookId = scanner.nextLine();

        System.out.println("Enter book title:");
        String title = scanner.nextLine();

        System.out.println("Enter book author:");
        String author = scanner.nextLine();

        System.out.println("Enter book category:");
        String category = scanner.nextLine();

        Book newBook = new Book(bookId, title, author, category, true);
        libraryDB.addBook(newBook);
        System.out.println("New book added successfully.");
    }

    private void listAllBooks() {
        System.out.println("List of all books in the library:");
        int n =1;
        for (Book book : libraryDB.getAllBooks()) {
            System.out.println(n + ". " +  book.getTitle() + " by " + book.getAuthor());
            n++;
        }
    }

    private void updateBook() {
        System.out.println("Enter the ID of the book you want to update:");
        String bookId = scanner.nextLine();

        Book existingBook = libraryDB.findBookById(bookId);

        if (existingBook != null) {
            System.out.println("Enter updated book title:");
            String title = scanner.nextLine();

            System.out.println("Enter updated book author:");
            String author = scanner.nextLine();

            System.out.println("Enter updated book category:");
            String category = scanner.nextLine();

            Book updatedBook = new Book(bookId, title, author, category, existingBook.isAvailable());
            libraryDB.updateBook(updatedBook);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private void deleteBook() {
        System.out.println("Enter the ID of the book you want to delete:");
        String bookId = scanner.nextLine();

        libraryDB.deleteBook(bookId);
        System.out.println("Book deleted successfully.");
    }

    private void addNewMember() {
        System.out.println("Enter member ID:");
        String memberId = scanner.nextLine();

        System.out.println("Enter member name:");
        String name = scanner.nextLine();

        System.out.println("Enter member email:");
        String email = scanner.nextLine();

        Member newMember = new Member(memberId, name, email);
        libraryDB.addMember(newMember);
        System.out.println("New member added successfully.");
    }

    private void listAllMembers() {
        System.out.println("List of all members:");
        for (Member member : libraryDB.getAllMembers()) {
            System.out.println("ID: " + member.getMemberId() + ", Name: " + member.getName() + ", Email: " + member.getEmail());
        }
    }

    private void updateMember() {
        System.out.println("Enter the ID of the member you want to update:");
        String memberId = scanner.nextLine();

        Member existingMember = libraryDB.findMemberById(memberId);

        if (existingMember != null) {
            System.out.println("Enter updated member name:");
            String name = scanner.nextLine();

            System.out.println("Enter updated member email:");
            String email = scanner.nextLine();

            Member updatedMember = new Member(memberId, name, email);
            libraryDB.updateMember(updatedMember);
            System.out.println("Member updated successfully.");
        } else {
            System.out.println("Member not found.");
        }
    }

    private void deleteMember() {
        System.out.println("Enter the ID of the member you want to delete:");
        String memberId = scanner.nextLine();

        libraryDB.deleteMember(memberId);
        System.out.println("Member deleted successfully.");
    }
}
