package ap.exercises.ex7;

import ap.exercises.midtermProject.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SQLiteStorage implements LibraryStorage {
    private static final String DB_URL = "jdbc:sqlite:storage/library.db";

    public SQLiteStorage() {
        createTables();
    }

    private void createTables() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS books (
                    title TEXT,
                    author TEXT,
                    year INTEGER
                );
            """);

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS students (
                    id INTEGER PRIMARY KEY,
                    first TEXT,
                    last TEXT
                );
            """);

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS manager (
                    first TEXT,
                    last TEXT,
                    level TEXT
                );
            """);

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS librarians (
                    id INTEGER PRIMARY KEY,
                    first TEXT,
                    last TEXT
                );
            """);

            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS borrows (
                    studentID INTEGER,
                    bookTitle TEXT,
                    bookAuthor TEXT,
                    librarianID INTEGER,
                    borrowedDate TEXT,
                    returnDate TEXT,
                    approved INTEGER
                );
            """);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveLibrary(Library library) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM books");
            stmt.executeUpdate("DELETE FROM students");
            stmt.executeUpdate("DELETE FROM manager");
            stmt.executeUpdate("DELETE FROM librarians");
            stmt.executeUpdate("DELETE FROM borrows");

            PreparedStatement psBook = conn.prepareStatement("INSERT INTO books VALUES (?, ?, ?)");
            for (Book book : library.getBooks()) {
                psBook.setString(1, book.getTitle());
                psBook.setString(2, book.getAuthor());
                psBook.setInt(3, book.getYear());
                psBook.executeUpdate();
            }

            PreparedStatement psStudent = conn.prepareStatement("INSERT INTO students VALUES (?, ?, ?)");
            for (Student s : library.getStudents()) {
                psStudent.setInt(1, s.getStudentID());
                psStudent.setString(2, s.getFirstName());
                psStudent.setString(3, s.getLastName());
                psStudent.executeUpdate();
            }

            PreparedStatement psManager = conn.prepareStatement("INSERT INTO manager VALUES (?, ?, ?)");
            Manager m = library.getManager();
            psManager.setString(1, m.getFirstName());
            psManager.setString(2, m.getLastName());
            psManager.setString(3, m.getLevel().name());
            psManager.executeUpdate();

            PreparedStatement psLibrarian = conn.prepareStatement("INSERT INTO librarians VALUES (?, ?, ?)");
            for (Librarian l : library.getLibrarians()) {
                psLibrarian.setInt(1, l.getLibrarianID());
                psLibrarian.setString(2, l.getFirstName());
                psLibrarian.setString(3, l.getLastName());
                psLibrarian.executeUpdate();
            }

            PreparedStatement psBorrow = conn.prepareStatement("INSERT INTO borrows VALUES (?, ?, ?, ?, ?, ?, ?)");
            for (Borrow b : library.getBorrows()) {
                psBorrow.setInt(1, b.getStudent().getStudentID());
                psBorrow.setString(2, b.getBook().getTitle());
                psBorrow.setString(3, b.getBook().getAuthor());
                psBorrow.setInt(4, b.getLibrarian().getLibrarianID());
                psBorrow.setString(5, b.getBorrowedDate().toString());
                psBorrow.setString(6, b.getReturnDate() == null ? "null" : b.getReturnDate().toString());
                psBorrow.setInt(7, b.isApproved() ? 1 : 0);
                psBorrow.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Library loadLibrary() {
        Library library = new Library("MyLib", new Manager("Admin", "Manager", Manager.Level.master));

        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            Statement stmt = conn.createStatement();

            ResultSet rsBooks = stmt.executeQuery("SELECT * FROM books");
            while (rsBooks.next()) {
                library.addBook(new Book(rsBooks.getString("title"), rsBooks.getString("author"), rsBooks.getInt("year"), rsBooks.getInt("pages")));
            }

            ResultSet rsStudents = stmt.executeQuery("SELECT * FROM students");
            while (rsStudents.next()) {
                DateTimeFormatter formatter = null;
                library.addStu(new Student(
                        rsStudents.getString("first"),
                        rsStudents.getString("last"),
                        rsStudents.getInt("id"),
                        rsStudents.getString("major"),
                        LocalDate.parse(rsStudents.getString("joinDate"), formatter)
                ));

            }

            ResultSet rsManager = stmt.executeQuery("SELECT * FROM manager");
            if (rsManager.next()) {
                Manager m = new Manager(
                        rsManager.getString("first"),
                        rsManager.getString("last"),
                        Manager.Level.valueOf(rsManager.getString("level"))
                );
                library.setManager(m);
            }

            ResultSet rsLibrarians = stmt.executeQuery("SELECT * FROM librarians");
            while (rsLibrarians.next()) {
                library.addLibrarian(new Librarian(rsLibrarians.getString("first"), rsLibrarians.getString("last"), rsLibrarians.getInt("id")));
            }

            ResultSet rsBorrows = stmt.executeQuery("SELECT * FROM borrows");
            while (rsBorrows.next()) {
                Student student = null;
                for (Student s : library.getStudents()) {
                    if (s.getStudentID() == rsBorrows.getInt("studentID")) {
                        student = s;
                        break;
                    }
                }

                Book book = library.search(rsBorrows.getString("bookTitle"), rsBorrows.getString("bookAuthor"));

                Librarian librarian = null;
                for (Librarian l : library.getLibrarians()) {
                    if (l.getLibrarianID() == rsBorrows.getInt("librarianID")) {
                        librarian = l;
                        break;
                    }
                }

                if (student != null && book != null && librarian != null) {
                    Borrow borrow = new Borrow(book, student, librarian, LocalDate.parse(rsBorrows.getString("borrowedDate")));

                    String returnDate = rsBorrows.getString("returnDate");
                    if (!"null".equals(returnDate)) {
                        borrow.setReturnDate(LocalDate.parse(returnDate));
                    }
                    borrow.setApproved(rsBorrows.getInt("approved") == 1);

                    library.getBorrows().add(borrow);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return library;
    }
}
