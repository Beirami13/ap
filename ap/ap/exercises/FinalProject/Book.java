package ap.exercises.FinalProject;

import java.time.LocalDate;

public class Book {
    private String id;
    private String title;
    private String author;
    private int year;
    private boolean borrowed;
    private LocalDate startDate;
    private LocalDate endDate;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.borrowed = false;
        this.startDate = null;
        this.endDate = null;
    }

    public String getId() { return id; }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public boolean isBorrowed() {
        return borrowed;
    }
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author +
                ", Year: " + year + ", Available: " + !borrowed;
    }
}