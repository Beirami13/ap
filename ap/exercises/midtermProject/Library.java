package ap.exercises.midtermProject;

import java.time.LocalDate;
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

    public List<Book> getBooks() {
        return books;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public Manager getManager() {
        return manager;
    }

    public List<Librarian> getLibrarians() {
        return librarians;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }


    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added.");
    }

    public void addStu(Student stu) {
        students.add(stu);
        System.out.println("Your ID is: " + stu.getStudentID());
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
        System.out.println("Librarian with "+librarian.getLibrarianID()+" added.");
    }

    public Student loginStudent(int studentID) {
        for (Student s : students) {
            if (s.getStudentID()==studentID) {
                System.out.println("Student"+ students.getFirst()+ students.getLast()+" login.");
                return s;
            }
        }
        System.out.println("Invalid librarian ID. Exiting program...");
        System.exit(0);
        return null;
    }

    public Librarian loginLibrarian(int librarianID) {
        for (Librarian l : librarians) {
            if (l.getLibrarianID()==librarianID) {
                System.out.println("Librarian "+l.getFirstName()+l.getLastName()+" with ID "+l.getLibrarianID()+"login.");
                return l;
            }
        }
        System.out.println("Invalid librarian ID. Exiting program...");
        System.exit(0);
        return null;
    }

    public void changeLibrarianInfo(int librarianID, String first, String last){
        for (Librarian l : librarians) {
            if (l.getLibrarianID()==librarianID) {
                l.setFirstName(first);
                l.setLastName(last);
                System.out.println("information had changed.");
            }
        }
    }

    public Book search(String title, String author) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    public void requestBorrow(int studentId, String title, String author) {
        Student student = loginStudent(studentId);
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
                if (b.isApproved()) {
                    System.out.println("Book is already borrowed.");
                } else {
                    System.out.println("There is already a pending request for this book.");
                }
                return;
            }
        }
        Random rand = new Random();
        Librarian librarian = librarians.get(rand.nextInt(librarians.size()));
        Borrow borrow = new Borrow(book, student, librarian, LocalDate.now());
        borrows.add(borrow);
        System.out.println("Borrow request submitted. Waiting for librarian approval.");
        System.out.println("Request ID: " + (borrows.size() - 1)); // نمایش شناسه درخواست
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
            if (b.getBook().equals(book) && b.getStudent().equals(student) && !b.isReturned() && b.isApproved()) {
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
    public void showBorrows() {
        for (Borrow b : borrows) {
            if (!b.isReturned() && b.isApproved()) {
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

    public void showLibrarianActivity1(){
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

    public void showLibrarianActivity2() {
        for (Librarian librarian : librarians) {
            int returnCount = 0;
            for (Borrow borrow : borrows) {
                if (borrow.isApproved() &&
                        borrow.isReturned() &&
                        borrow.getLibrarian().getLibrarianID() == librarian.getLibrarianID()) {
                    returnCount++;
                }
            }
            System.out.println("Librarian " + librarian.getFirstName() + " " + librarian.getLastName() +
                    " (ID: " + librarian.getLibrarianID() + ") handled " + returnCount + " returned books.");
        }
    }

    public void showTop10BorrowedBooks() {
        List<Book> topBooks = new ArrayList<>();

        for (Book book : books) {
            int count = 0;
            for (Borrow b : borrows) {
                if (b.isApproved() && b.getBook().equals(book)) {
                    count++;
                }
            }
            int i = 0;
            while (i < topBooks.size()) {
                Book current = topBooks.get(i);
                int currentCount = 0;
                for (Borrow b : borrows) {
                    if (b.isApproved() && b.getBook().equals(current)) {
                        currentCount++;
                    }
                }
                if (count > currentCount) break;
                i++;
            }
            topBooks.add(i, book);
            if (topBooks.size() > 10) {
                topBooks.remove(topBooks.size() - 1);
            }
        }
        System.out.println("Top 10 Borrowed Books:");
        for (int i = 0; i < topBooks.size(); i++) {
            Book book = topBooks.get(i);
            int count = 0;
            for (Borrow b : borrows) {
                if (b.isApproved() && b.getBook().equals(book)) {
                    count++;
                }
            }
            System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor() + " - Borrowed " + count + " times");
        }
    }
    public void reviewBorrowRequest(int requestId, boolean approve) {
        if (requestId < 0 || requestId >= borrows.size()) {
            System.out.println("Invalid request ID.");
            return;
        }
        Borrow borrow = borrows.get(requestId);
        if (borrow.isApproved() || borrow.isReturned()) {
            System.out.println("This request has already been processed.");
            return;
        }
        borrow.setApproved(approve);
        if (approve) {
            System.out.println("Request approved for student: " +
                    borrow.getStudent().getFirstName() + " " +
                    borrow.getStudent().getLastName() +
                    " to borrow: " + borrow.getBook().getTitle());
        } else {
            System.out.println("Request rejected.");
        }
    }



}
