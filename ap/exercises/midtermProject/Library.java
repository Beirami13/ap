package ap.exercises.midtermProject;

import java.util.*;

public class Library {
    private String name;
    private List<Book> books;
    private List<Student> students;
    private List<Librarian> librarians;
    private Manager manager;
    private List<Borrow> borrows;
    public Library(String name, Manager manager) {
        this.name = name;
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
        this.librarians = new ArrayList<>();
        this.manager = manager;
        this.borrows = new ArrayList<>();
        librarians.add(new Librarian("Ali", "Rezai", 111));
        librarians.add(new Librarian("Sara", "Ahmadi", 122));
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void registerStu(Student stu) {
        students.add(stu);
    }
    public Book search(String title, String author) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(int studentId, String title, String author) {
        Student student = null;
        for (Student s : students) {
            if (s.getStudentID()==studentId) {
                student = s;
                break;
            }
        }
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        Book book = search(title, author);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        for (Borrow b : borrows) {
            if (b.getBook().equals(book) && !b.isReturned()) {
                System.out.println("Book has already been borrowed.");
                return;
            }
        }
        Random rand = new Random();
        Librarian librarian = librarians.get(rand.nextInt(librarians.size()));
        Borrow borrow = new Borrow(book, student, librarian, java.time.LocalDate.now());
        borrows.add(borrow);
        System.out.println("Book borrowed successfully Librarian is " + librarian.getFirstName() + " " + librarian.getLastName());
    }
    public void returnBook(int studentId, String title, String author) {
        Student student = null;
        for (Student s : students) {
            if (s.getStudentID() == studentId) {
                student = s;
                break;
            }
        }
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        Book book = search(title, author);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        for (Borrow b : borrows) {
            if (b.getBook().equals(book) && b.getStudent().equals(student) && !b.isReturned()) {
                b.setReturnDate(java.time.LocalDate.now());
                System.out.println("Book returned by " + student.getFirstName() + " " + student.getLastName());
                if (b.getDaysLate() > 0) {
                    System.out.println("Book was returned " + b.getDaysLate() + " days late.");
                }
                return;
            }
        }
        System.out.println("hasn't borrowed.");
    }
    public void showBorrows(){
        for (Borrow b : borrows){
            if(!b.isReturned()){
                System.out.println(b);
            }
        }
    }
    public void showLateBorrows(){
        for (Borrow b : borrows){
            if(b.isReturned()){
                if (b.getDaysLate() > 0) {
                    System.out.println(b);
                }
            }
        }
    }
    public void showLibrarianActivity(){
        for (Librarian l : librarians){
            int count=0;
            for (Borrow b : borrows){
                if (b.getLibrarian().getLibrarianID()==l.getLibrarianID()){
                    count++;
                }
            }
            System.out.println("Librarian "+l.getFirstName()+l.getLastName()+" ID "+l.getLibrarianID()+" has "+count+" borrows");
        }
    }
}
