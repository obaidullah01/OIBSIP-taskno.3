import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryDatabase libraryDB = new LibraryDatabase();
        AdminModule adminModule = new AdminModule(libraryDB);
        UserModule userModule = new UserModule(libraryDB);

        // For simplicity, we assume some initial data for the library
        Book book1 = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", "Novel", true);
        Book book2 = new Book("B002", "To Kill a Mockingbird", "Harper Lee", "Novel", true);
        Book book3 = new Book("B003", "IT", "Stephen King", "Horror", true);
        Book book4 = new Book("B004", "Harry Potter : The Order Of Phoenix", "JK Rowlings", "Fantasy", true);
        Book book5 = new Book("B005", "How To Train Your Dragon ", "Cressida Cowell", "Adventure", true);
        Book book6 = new Book("B006", "Why Not Me : Feeling Of Millions ", "Anubhav Agrawal", "Biography", true);

        Member member1 = new Member("M001", "Obaid Ullah ", "obaidullah0512@gmail.com");

        libraryDB.addBook(book1);
        libraryDB.addBook(book2);
        libraryDB.addBook(book3);
        libraryDB.addBook(book4);
        libraryDB.addBook(book5);
        libraryDB.addBook(book6);
        libraryDB.addMember(member1);

        boolean exit = false;
        System.out.println("\n -WELCOME TO STEVE'S LIBRARY- \n");
        while (!exit) {
            System.out.println("Choose your role:");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Please log in as an admin.");
                    adminModule.performAdminAction();
                    break;
                case 2:
                    userModule.performUserAction();
                    break;
                case 3:
                    System.out.println("   Thank you for using our service. Have a nice day !!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

