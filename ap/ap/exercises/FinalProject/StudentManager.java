package ap.exercises.FinalProject;

import java.io.*;
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
        if (username == null) return false;
        for (Student s : students) {
            if (s.getUsername().equalsIgnoreCase(username.trim())) return true;
        }
        return false;
    }

    public int getStudentCount() {
        return students.size();
    }

    private void saveStudent(Student student) {
        try (FileWriter writer = new FileWriter(STUDENT_FILE, true)) {
            writer.write(escapeCsv(student.getName()) + "," +
                    escapeCsv(student.getStudentId()) + "," +
                    escapeCsv(student.getUsername()) + "," +
                    escapeCsv(student.getPassword()) + "\n");
        } catch (IOException e) {
            System.out.println("Error saving student: " + e.getMessage());
        }
    }

    private void loadStudentsFromFile() {
        students.clear();
        File file = new File(STUDENT_FILE);
        if (!file.exists()) return;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",", -1);
                if (parts.length >= 4) {
                    Student s = new Student(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3]);
                    students.add(s);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading students file: " + e.getMessage());
        }
    }

    public Student authenticateStudent(String username, String password) {
        if (username == null) return null;
        for (Student s : students) {
            if (s.getUsername().equals(username.trim()) && s.getPassword().equals(password)) {
                return s;
            }
        }
        return null;
    }

    private String escapeCsv(String value) {
        if (value == null) return "";
        return value.replace(",", " ");
    }

    public void updateStudent(Student student, String newName, String newPassword) {
        for (Student s : students) {
            if (s.getUsername().equals(student.getUsername())) {
                if (newName != null && !newName.trim().isEmpty()) {
                    s.setName(newName);
                }
                if (newPassword != null && !newPassword.trim().isEmpty()) {
                    s.setPassword(newPassword);
                }
                saveAllStudents();
                break;
            }
        }
    }

    private void saveAllStudents() {
        try (FileWriter writer = new FileWriter(STUDENT_FILE)) {
            for (Student s : students) {
                writer.write(escapeCsv(s.getName()) + "," +
                        escapeCsv(s.getStudentId()) + "," +
                        escapeCsv(s.getUsername()) + "," +
                        escapeCsv(s.getPassword()) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving students: " + e.getMessage());
        }
    }
}
