package ap.exercises.FinalProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {

    private List<Student> students = new ArrayList<>();
    private static final String STUDENT_FILE = "students.txt";

    public StudentManager() {
        loadStudentsFromFile();
    }

    public void registerStudent(String name, String studentId, String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("This username already exists. Please choose a different username.");
            return;
        }

        Student student = new Student(name, studentId, username, password);
        students.add(student);
        saveStudent(student);

        System.out.println("Student registered successfully!");
    }

    private boolean isUsernameTaken(String username) {
        for (Student s : students) {
            if (s.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public void displayStudents() {
        System.out.println("\n--- List of Registered Students ---");
        if (students.isEmpty()) {
            System.out.println("No students have registered yet.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public int getStudentCount() {
        return students.size();
    }

    private void saveStudent(Student student) {
        try (FileWriter writer = new FileWriter(STUDENT_FILE, true)) {
            writer.write(student.getName() + "," +
                    student.getStudentId() + "," +
                    student.getUsername() + "," +
                    student.getPassword() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving student: " + e.getMessage());
        }
    }

    private void loadStudentsFromFile() {
        students.clear();
        File file = new File(STUDENT_FILE);
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 4) {
                    Student s = new Student(data[0], data[1], data[2], data[3]);
                    students.add(s);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading students file: " + e.getMessage());
        }
    }

    public Student authenticateStudent(String username, String password) {
        return students.stream()
                .filter(s -> s.getUsername().equals(username) && s.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
