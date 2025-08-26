package ap.exercises.FinalProject;

import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;
    private LibrarySystem librarySystem;
    private Student currentUser;

    public MenuHandler(LibrarySystem librarySystem) {
        this.scanner = new Scanner(System.in);
        this.librarySystem = librarySystem;
        this.currentUser = null;
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n=== University Library Management System ===");
            System.out.println("1. Guest Access");
            System.out.println("2. Student Registration");
            System.out.println("3. Student Login");
            System.out.println("4. Staff Login");
            System.out.println("5. View Registered Student Count");
            System.out.println("6. Exit");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 6);

            switch (choice) {
                case 1:
                    displayGuestMenu();
                    break;
                case 2:
                    handleStudentRegistration();
                    break;
                case 3:
                    handleStudentLogin();
                    break;
                case 4:
                    displayStaffLoginMenu();
                    break;
                case 5:
                    displayStudentCount();
                    break;
                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println("___________________________");
        }
    }

    private void displayStudentCount() {
        int studentCount = librarySystem.getStudentCount();
        System.out.println("\nTotal registered students: " + studentCount);
    }

    public void displayGuestMenu() {
        while (true) {
            System.out.println("\n=== Guest Menu ===");
            System.out.println("1. View Registered Student Count");
            System.out.println("2. Search Book by Title");
            System.out.println("3. View Simple Library Statistics");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 4);

            switch (choice) {
                case 1:
                    int studentCount = librarySystem.getStudentCount();
                    System.out.println("\nTotal registered students: " + studentCount);
                    break;
                case 2:
                    librarySystem.searchBookByTitle();
                    break;
                case 3:
                    librarySystem.displayLibraryStats();
                    break;
                case 4:
                    System.out.println("Exiting guest menu.");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }



    private void handleStudentRegistration() {
        System.out.println("\n--- New Student Registration ---");

        System.out.print("Student name: ");
        String name = scanner.nextLine();

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        librarySystem.registerStudent(name, studentId, username, password);
    }

    private void handleStudentLogin() {
        System.out.println("\n--- Student Login ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        currentUser = librarySystem.authenticateStudent(username, password);

        if (currentUser != null) {
            System.out.println("Login successful! Welcome, " + currentUser.getName());
            displayLoggedInStudentMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private void displayLoggedInStudentMenu() {
        while (currentUser != null) {
            System.out.println("\n=== Student Dashboard ===");
            System.out.println("1. View My Information");
            System.out.println("2. Edit My Information");
            System.out.println("3. Search a Book");
            System.out.println("4. Borrow a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. View Available Books");
            System.out.println("7. Logout");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 6);

            switch (choice) {
                case 1:
                    System.out.println("\n--- My Information ---");
                    System.out.println(currentUser);
                    break;
                case 2:
                    librarySystem.editStudentInformation(currentUser);
                    break;
                case 3:
                    librarySystem.SearchBooks();
                    break;
                case 4:
                    librarySystem.borrowBook(currentUser);
                    break;
                case 5:
                    librarySystem.returnBook(currentUser);
                    break;
                case 6:
                    librarySystem.displayAvailableBooks();
                    break;
                case 7:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    public void displayStaffLoginMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Staff Login ---");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Staff staff = librarySystem.authenticateStaff(username, password);
        if (staff != null) {
            System.out.println("Login successful! Welcome, " + staff.getName());
            displayStaffDashboard(staff);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private void displayStaffDashboard(Staff staff) {
        while (true) {
            System.out.println("\n=== Staff Dashboard ===");
            System.out.println("1. View Statistics");
            System.out.println("2. Logout");
            System.out.print("Choose an option: ");
            int choice = getIntInput(1, 2);

            switch (choice) {
                case 1:
                    librarySystem.displayLibraryStats();
                    break;
                case 2:
                    System.out.println("Logged out successfully.");
                    return;
            }
        }
    }


    private int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.printf("Please enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
