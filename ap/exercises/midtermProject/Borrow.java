package ap.exercises.midtermProject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Borrow {
    private Book book;
    private Student student;
    private Librarian librarian1;
    private Librarian librarian2;
    private LocalDate borrowedDate;
    private LocalDate endDate;
    private LocalDate returnDate;
    private int daysLate;

    public Borrow(Book book, Student student, Librarian librarian1, Librarian librarian2,
                  LocalDate borrowedDate, LocalDate endDate) {
        this.book = book;
        this.student = student;
        this.librarian1 = librarian1;
        this.librarian2 = librarian2;
        this.borrowedDate = borrowedDate;
        this.endDate = endDate;
        this.returnDate = null;
        this.daysLate = -1;
    }

    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
    }

    public Librarian getLibrarian1() {
        return librarian1;
    }

    public Librarian getLibrarian2() {
        return librarian2;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public int getDaysLate() {
        return daysLate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        if (returnDate.isAfter(endDate)) {
            this.daysLate = (int) ChronoUnit.DAYS.between(endDate, returnDate);
        } else {
            this.daysLate = 0;
        }
    }

    public boolean isReturned() {
        return returnDate != null;
    }
}
