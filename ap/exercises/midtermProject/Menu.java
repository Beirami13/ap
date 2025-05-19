package ap.exercises.midtermProject;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    private Library library;

    public Menu(Library library) {
        this.library = library;
    }

    public void showRoll() {
        System.out.println("Enter your roll:");
        String roll = input.nextLine();
        if (roll.equalsIgnoreCase("student")) {
            showStudentsMenu();
        } else if (roll.equalsIgnoreCase("Librarian")) {
            showLibrarianMenu();
        } else if (roll.equalsIgnoreCase("Manager")) {
            showManagerMenu();
        } else {
            System.out.println("Invalid role.");
        }
    }

    public void showStudentsMenu() {
        while (true) {
            System.out.println("\nAs a student this is your menu:");
            System.out.println("Enter 1 for registering to library");
            System.out.println("Enter 2 for entering to library");
            System.out.println("Enter 3 for search book");
            System.out.println("Enter 4 for borrowing the book");
            System.out.println("Enter 5 for returning the book");
            System.out.println("Enter 6 to exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("First name: ");
                    String first = input.nextLine();
                    System.out.print("Last name: ");
                    String last = input.nextLine();
                    System.out.print("Major: ");
                    String major = input.nextLine();

                    int newID = library.getStudents().size() + 1;
                    Student student = new Student(first, last, newID, major, LocalDate.now());
                    library.addStu(student);
                    System.out.println("Student registered with ID: " + newID);
                    break;
                }
                case 2: {
                    System.out.print("Enter your ID to enter the library: ");
                    int ID = input.nextInt();
                    input.nextLine();
                    library.loginStudent(ID);
                    break;
                }
                case 3: {
                    System.out.println("Enter book's title and author for searching");
                    System.out.print("Title: ");
                    String title = input.nextLine();
                    System.out.print("Author: ");
                    String author = input.nextLine();
                    library.search(title, author);
                    break;
                }
                case 4: {
                    System.out.print("Enter your ID to borrow book: ");
                    int ID = input.nextInt();
                    input.nextLine();
                    System.out.print("Title: ");
                    String title = input.nextLine();
                    System.out.print("Author: ");
                    String author = input.nextLine();
                    library.requestBorrow(ID, title, author);
                    break;
                }
                case 5: {
                    System.out.print("Enter your ID to return book: ");
                    int ID = input.nextInt();
                    input.nextLine();
                    System.out.print("Title: ");
                    String title = input.nextLine();
                    System.out.print("Author: ");
                    String author = input.nextLine();
                    library.returnBook(ID, title, author);
                    break;
                }
                case 6: {
                    System.out.println("Exiting student menu.");
                    return;
                }
                default: {
                    System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
    public void showLibrarianMenu() {
        while (true) {
            System.out.println("\nAs a librarian this is your menu:");
            System.out.println("Enter 1 for entering to library");
            System.out.println("Enter 2 for change your information");
            System.out.println("Enter 3 for add books information");
            System.out.println("Enter 4 for pend request book");
            System.out.println("Enter 5 to exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("Enter your ID to enter the library: ");
                    int ID = input.nextInt();
                    input.nextLine();
                    library.loginLibrarian(ID);
                    break;
                }
                case 2: {
                    System.out.print("Enter your ID to change your information: ");
                    int ID = input.nextInt();
                    input.nextLine();
                    System.out.print("First name that you want to change: ");
                    String first = input.nextLine();
                    System.out.print("Last name that you want to change: ");
                    String last = input.nextLine();
                    library.changeLibrarianInfo(ID, first, last);
                    break;
                }

                case 3: {
                    System.out.println("Enter book's title for adding book");
                    String title = input.nextLine();
                    System.out.println("Enter book's author");
                    String author = input.nextLine();
                    System.out.println("Enter book's created year");
                    int year = input.nextInt();
                    System.out.println("Enter book's pages");
                    int page = input.nextInt();
                    Book book = new Book(title,author,year,page);
                    library.addBook(book);
                    break;
                }
                case 4: {
                    System.out.println("Pending borrow requests:");
                    System.out.print("Enter request ID to process: ");
                    int requestId = input.nextInt();
                    input.nextLine();
                    System.out.print("Approve? (true/false): ");
                    boolean approve = input.nextBoolean();
                    input.nextLine();
                    library.reviewBorrowRequest(requestId, approve);
                    break;
                }
                case 5:{
                    System.out.println("Exiting student menu.");
                    return;
                }
                default: {
                    System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
    public void showManagerMenu() {
        while (true) {
            System.out.println("\nAs a manager this is your menu:");
            System.out.println("Enter 1 for adding librarian");
            System.out.println("Enter 2 for showing the books that returned late");
            System.out.println("Enter 3 for showing borrows  of each librarian");
            System.out.println("Enter 4 for showing returns  of each librarian");
            System.out.println("Enter 5 for showing 10 books that were most borrowed");
            System.out.println("Enter 6 to exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: {
                    System.out.println("Enter the librarian's information to add");
                    System.out.print("First name: ");
                    String first = input.nextLine();
                    System.out.print("Last name: ");
                    String last = input.nextLine();
                    int newID = library.getLibrarians().size() + 1;
                    Librarian librarian = new Librarian(first, last, newID);
                    library.addLibrarian(librarian);
                    System.out.println("Librarian added with ID: " + newID);
                    break;
                }
                case 2: {
                    System.out.print("The list of book that are returned late: ");
                    library.showLateBorrows();
                    break;
                }
                case 3: {
                    System.out.println("The list of borrowed book for each librarian");
                    library.showLibrarianActivity1();
                    break;
                }
                case 4:{
                    System.out.println("The list of returned book for each librarian");
                    library.showLibrarianActivity2();
                    break;
                }
                case 5:{
                    library.showTop10BorrowedBooks();
                    break;
                }
                case 6: {
                    System.out.println("Exiting student menu.");
                    return;
                }
                default: {
                    System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
}
