package ap.exercises.ex7;

import ap.exercises.midtermProject.*;

import java.io.*;
import java.util.*;

public class TabSplitStorage implements LibraryStorage {

    private final String basePath = "storage/";

    @Override
    public void saveLibrary(Library library) {
        try {
            new File(basePath).mkdirs();

            try (PrintWriter writer = new PrintWriter(basePath + "books.tsv")) {
                for (Book book : library.getBooks()) {
                    writer.println(book.getTitle() + "\t" + book.getAuthor());
                }
            }

            try (PrintWriter writer = new PrintWriter(basePath + "students.tsv")) {
                for (Student s : library.getStudents()) {
                    writer.println(s.getFirstName() + "\t" + s.getLastName() + "\t" + s.getStudentID());
                }
            }

            try (PrintWriter writer = new PrintWriter(basePath + "borrows.tsv")) {
                for (Borrow b : library.getBorrows()) {
                    writer.println(
                            b.getStudent().getStudentID() + "\t" +
                                    b.getBook().getTitle() + "\t" +
                                    b.getBook().getAuthor() + "\t" +
                                    b.getLibrarian().getLibrarianID() + "\t" +
                                    b.getBorrowedDate() + "\t" +
                                    (b.getReturnDate() == null ? "null" : b.getReturnDate()) + "\t" +
                                    b.isApproved()
                    );
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Library loadLibrary() {
        Library library = new Library("MyLib", new Manager("Admin", "Manager", Manager.Level.master));
        return library;
    }
}


