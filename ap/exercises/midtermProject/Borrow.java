package ap.exercises.midtermProject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Borrow {
    private Book book;
    private Student student;
    private Librarian librarian;
    private LocalDate borrowedDate;
    private LocalDate endDate;
    private LocalDate returnDate;
    private int daysLate;
    private boolean approved;

    public Borrow(Book book, Student student, Librarian librarian, LocalDate borrowedDate) {
        this.book = book;
        this.student = student;
        this.librarian = librarian;
        this.borrowedDate = borrowedDate;
        this.endDate = borrowedDate.plusMonths(1);
        this.returnDate = null;
        this.daysLate = -1;
        this.approved = false;
    }

    public Book getBook() {
        return book;
    }
    public Student getStudent() {
        return student;
    }
    public Librarian getLibrarian() {
        return librarian;
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
    public boolean isApproved() {
        return approved;
    }

    public void approve() {
        this.approved = true;
    }

    @Override
    public String toString() {
        return "Book: " + book.getTitle() + " Author: " + book.getAuthor() +
                " Student: " + student.getFirstName() + " " + student.getLastName() + " ID: " + student.getStudentID() +
                " Librarian: " + librarian.getFirstName() + " " + librarian.getLastName() +
                " Borrowed: " + borrowedDate + " in: " + endDate +
                " Returned: " + (returnDate != null ? returnDate : "Not yet") +
                " Days Late: " + (daysLate >= 0 ? daysLate : "N/A");
    }
}
