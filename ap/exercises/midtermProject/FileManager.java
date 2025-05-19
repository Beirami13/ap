package ap.exercises.midtermProject;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.*;

public class FileManager {
    private static final String DATA_DIR = "library_data/";

    static {
        new File(DATA_DIR).mkdirs();
    }

    public static void saveData(Library library) {
        try {
            saveBooks(library.getBooks());
            saveStudents(library.getStudents());
            saveLibrarians(library.getLibrarians());
            saveManager(library.getManager());
            saveBorrows(library.getBorrows());
            System.out.println("All data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static Library loadData() {
        try {
            Manager manager = loadManager();
            if (manager == null) {
                manager = new Manager("Default", "Manager", Manager.Level.master);
            }

            Library library = new Library("My Library", manager);
            loadBooks(library);
            loadStudents(library);
            loadLibrarians(library);
            loadBorrows(library);
            return library;
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return null;
        }
    }

    private static void saveBooks(List<Book> books) throws IOException {
        PrintWriter writer = new PrintWriter(DATA_DIR + "books.txt");
        for (Book book : books) {
            writer.println(book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getPages());
        }
        writer.close();
    }

    private static void loadBooks(Library library) throws IOException {
        File file = new File(DATA_DIR + "books.txt");
        if (!file.exists()) return;

        List<String> lines = Files.readAllLines(file.toPath());
        for (String line : lines) {
            String[] parts = line.split(",");
            library.addBook(new Book(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
        }
    }

    private static void saveStudents(List<Student> students) throws IOException {
        PrintWriter writer = new PrintWriter(DATA_DIR + "students.txt");
        for (Student student : students) {
            writer.println(student.getFirstName() + "," + student.getLastName() + "," + student.getStudentID()
                    + "," + student.getMajor() + "," + student.getJoinDate());
        }
        writer.close();
    }

    private static void loadStudents(Library library) throws IOException {
        File file = new File(DATA_DIR + "students.txt");
        if (!file.exists()) return;

        List<String> lines = Files.readAllLines(file.toPath());
        for (String line : lines) {
            String[] parts = line.split(",");
            library.addStu(new Student(parts[0],parts[1], Integer.parseInt(parts[2]),parts[3], LocalDate.parse(parts[4])));
        }
    }

    private static void saveLibrarians(List<Librarian> librarians) throws IOException {
        PrintWriter writer = new PrintWriter(DATA_DIR + "librarians.txt");
        for (Librarian librarian : librarians) {
            writer.println(librarian.getFirstName() + "," + librarian.getLastName() + "," + librarian.getLibrarianID());
        }
        writer.close();
    }

    private static void loadLibrarians(Library library) throws IOException {
        File file = new File(DATA_DIR + "librarians.txt");
        if (!file.exists()) return;

        List<String> lines = Files.readAllLines(file.toPath());
        for (String line : lines) {
            String[] parts = line.split(",");
            library.addLibrarian(new Librarian(parts[0], parts[1], Integer.parseInt(parts[2])));
        }
    }

    private static void saveManager(Manager manager) throws IOException {
        PrintWriter writer = new PrintWriter(DATA_DIR + "manager.txt");
        writer.println(manager.getFirstName() + "," + manager.getLastName() + "," + manager.getLevel());
        writer.close();
    }

    private static Manager loadManager() throws IOException {
        File file = new File(DATA_DIR + "manager.txt");
        if (!file.exists()) return null;

        String line = Files.readAllLines(file.toPath()).get(0);
        String[] parts = line.split(",");
        return new Manager(parts[0], parts[1], Manager.Level.valueOf(parts[2]));
    }

    private static void saveBorrows(List<Borrow> borrows) throws IOException {
        PrintWriter writer = new PrintWriter(DATA_DIR + "borrows.txt");
        for (Borrow borrow : borrows) {
            writer.println(borrow.getBook().getTitle() + "," + borrow.getStudent().getStudentID() + "," +
                    borrow.getLibrarian().getLibrarianID() + "," + borrow.getBorrowedDate() + "," + borrow.getEndDate() + "," +
                    (borrow.getReturnDate() != null ? borrow.getReturnDate() : "null") + "," +
                    borrow.isApproved() + "," + borrow.getDaysLate());
        }
        writer.close();
    }

    private static void loadBorrows(Library library) throws IOException {
        File file = new File(DATA_DIR + "borrows.txt");
        if (!file.exists()) return;

        List<String> lines = Files.readAllLines(file.toPath());
        for (String line : lines) {
            String[] parts = line.split(",");

            Book book = findBook(library, parts[0]);
            Student student = findStudent(library, Integer.parseInt(parts[1]));
            Librarian librarian = findLibrarian(library, Integer.parseInt(parts[2]));

            Borrow borrow = new Borrow(book, student, librarian, LocalDate.parse(parts[3])
            );

            borrow.setEndDate(LocalDate.parse(parts[4]));
            if (!parts[5].equals("null")) {
                borrow.setReturnDate(LocalDate.parse(parts[5]));
            }
            borrow.setApproved(Boolean.parseBoolean(parts[6]));
            library.getBorrows().add(borrow);
        }
    }

    private static Book findBook(Library library, String title) {
        for (Book book : library.getBooks()) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    private static Student findStudent(Library library, int studentID) {
        for (Student student : library.getStudents()) {
            if (student.getStudentID() == studentID) {
                return student;
            }
        }
        return null;
    }

    private static Librarian findLibrarian(Library library, int librarianID) {
        for (Librarian librarian : library.getLibrarians()) {
            if (librarian.getLibrarianID() == librarianID) {
                return librarian;
            }
        }
        return null;
    }
}