package ap.exercises.FinalProject;

import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private int year;
    private boolean isBorrowed;
    private LocalDate startDate;
    private LocalDate endDate;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isBorrowed = false;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYear() {
        return year;
    }
    public boolean isBorrowed() {
        return isBorrowed;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        String status = isBorrowed ? "Borrowed from " + startDate + " to " + endDate : "Available";
        return "Title: " + title + ", Author: " + author + ", Year: " + year + ", Status: " + status;
    }
}
