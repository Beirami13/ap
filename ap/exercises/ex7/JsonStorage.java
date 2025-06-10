package ap.exercises.ex7;

import ap.exercises.midtermProject.*;

import java.io.*;
import java.util.*;

public class JsonStorage implements LibraryStorage {
    private final String filePath = "storage/library.json";

    @Override
    public void saveLibrary(Library library) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("{\n");

            // Books
            writer.write("\"books\":[\n");
            List<Book> books = library.getBooks();
            for (int i = 0; i < books.size(); i++) {
                Book b = books.get(i);
                writer.write(String.format(
                        "{\"title\":\"%s\",\"author\":\"%s\",\"year\":%d}%s\n",
                        escape(b.getTitle()), escape(b.getAuthor()), b.getYear(),
                        (i < books.size() - 1) ? "," : ""
                ));
            }
            writer.write("],\n");

            // Students
            writer.write("\"students\":[\n");
            List<Student> students = library.getStudents();
            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                writer.write(String.format(
                        "{\"id\":%d,\"first\":\"%s\",\"last\":\"%s\"}%s\n",
                        s.getStudentID(), escape(s.getFirstName()), escape(s.getLastName()),
                        (i < students.size() - 1) ? "," : ""
                ));
            }
            writer.write("],\n");

            // Manager
            Manager m = library.getManager();
            writer.write(String.format("\"manager\":{\"first\":\"%s\",\"last\":\"%s\"},\n", escape(m.getFirstName()), escape(m.getLastName())));

            // Librarians
            writer.write("\"librarians\":[\n");
            List<Librarian> librarians = library.getLibrarians();
            for (int i = 0; i < librarians.size(); i++) {
                Librarian l = librarians.get(i);
                writer.write(String.format(
                        "{\"id\":%d,\"first\":\"%s\",\"last\":\"%s\"}%s\n",
                        l.getLibrarianID(), escape(l.getFirstName()), escape(l.getLastName()),
                        (i < librarians.size() - 1) ? "," : ""
                ));
            }
            writer.write("]\n");

            writer.write("}\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Library loadLibrary() {
        System.out.println("loadLibrary() not implemented for JsonStorage (manual version).");
        return new Library("MyLib", new Manager("Admin", "Manager", Manager.Level.master));
    }

    private String escape(String s) {
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
