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
    }

    public void addStu(Student stu) {
        students.add(stu);
    }

    public void addLibrarian(Librarian librarian) {
        librarians.add(librarian);
    }

    public Student loginStudent(int studentID) {
        for (Student s : students) {
            if (s.getStudentID()==studentID) {
                return s;
            }
        }
        return null;
    }

    public Librarian loginLibrarian(int librarianID) {
        for (Librarian l : librarians) {
            if (l.getLibrarianID()==librarianID) {
                return l;
            }
        }
        return null;
    }

    public void changeLibrarianInfo(int librarianID, String first, String last){
        for (Librarian l : librarians) {
            if (l.getLibrarianID()==librarianID) {
                l.setFirstName(first);
                l.setLastName(last);
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
            if (b.getBook().equals(book) && !b.isReturned() && b.isApproved()) {
                System.out.println("Book is already borrowed or the librarian won't let you borrow it.");
                return;
            }
        }
        Random rand = new Random();
        Librarian librarian = librarians.get(rand.nextInt(librarians.size()));
        Borrow borrow = new Borrow(book, student, librarian, LocalDate.now());
        borrows.add(borrow);
        System.out.println("Borrow request submitted. Waiting for librarian approval.");
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

    public void addBooksInfo(String info){
        for (Borrow b : borrows){
            b.getBook().setInfo(info);
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

}
