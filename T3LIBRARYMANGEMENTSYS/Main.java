package T3LIBRARYMANGEMENTSYS;

import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. View Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: addUser(); break;
                case 3: library.viewBooks(); break;
                case 4: issueBook(); break;
                case 5: returnBook(); break;
                case 6: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 6);
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();
        library.addBook(new Book(id, title, author));
    }

    private static void addUser() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter User Name: ");
        String name = sc.nextLine();
        library.addUser(new User(id, name));
    }

    private static void issueBook() {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        library.issueBook(bookId, userId);
    }

    private static void returnBook() {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        library.returnBook(bookId);
    }
}