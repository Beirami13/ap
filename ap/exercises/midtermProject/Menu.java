package ap.exercises.midtermProject;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    private Library library;

    public  Menu(Library library){
        this.library=library;
    }

    public void showRoll(){
        System.out.println("Enter your roll:");
        String roll = input.nextLine();
        if (roll.equalsIgnoreCase("student")){

        } else if (roll.equalsIgnoreCase("Librarian")) {

        } else if (roll.equalsIgnoreCase("Manager")) {

        }
    }

    public void showStudentsMenu(Student student){
        System.out.println("As a student this is your menu: ");
        System.out.println("Enter 1 for registering to library");
        System.out.println("Enter 2 for entering to library");
        System.out.println("Enter 3 for search book");
        System.out.println("Enter 4 for borrowing the book");
        System.out.println("Enter 5 for returning the book");
        int choice = input.nextInt();
        switch (choice){
            case 1:{
                System.out.println("Enter your full name to add");
                String first = input.nextLine();
                String last = input.nextLine();
                String major = input.nextLine();
                int newID = Library.getStudents().size() + 1;
                Student students = new Student(first, last, newID, major, LocalDate.now());
                library.addStu(student);
                System.out.println("Student registered with ID: " + newID);
                break;
            } case 2:{
                System.out.println("Enter your ID to enter the library");
                int ID =input.nextInt();
                library.loginStudent(ID);
                break;
            } case 3:{
                System.out.println("Enter books title and author for searching");
                String title = input.nextLine();
                String author = input.nextLine();
                library.search(title, author);
                break;
            } case 4:{
                System.out.println("Enter your ID to borrow book");
                System.out.println("Enter the books title and author");
                int ID =input.nextInt();
                String title = input.nextLine();
                String author = input.nextLine();
                library.borrowBook(ID, title, author);
            } case 5:{
                System.out.println("Enter your ID to return book");
                System.out.println("Enter the books title and author");
                int ID =input.nextInt();
                String title = input.nextLine();
                String author = input.nextLine();
                library.returnBook(ID, title, author);
            }case 6 : {
                System.out.println("Exiting student menu.");
                return;
            }
            default :{
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}