package ap.exercises.midtermProject;

import java.util.*;

public class Library {
    private String name;
    private List<Book> books;
    private List<Student> students;
    private List<Librarian> librarians;
    private Manager manager;
    private List<Borrow> borrows;
    public Library(String name, Manager manager, List<Librarian> librarians) {
        this.name = name;
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();
        this.librarians = librarians;
        this.manager = manager;
        this.borrows = new ArrayList<>();
    }
    public void addBook(Book book){
        books.add(book);
    }
    public void registerStu(Student stu){
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

}
