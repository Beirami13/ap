package ap.exercises.ex3;

import java.io.*;

public class Main_EX3_LM_1_2_C{
    static String[] booksFromFile = new String[100];
    static int bookCount = 0;
    static String[] studentsFromFile = new String[100];
    static int studentCount = 0;

    static class Book {
        private String title;
        private String author;
        private int pages;
        private int year;
        public Book(String title, String author, int pages, int year) {
            this.title = title;
            this.author = author;
            this.pages = pages;
            this.year = year;
        }
        public String toString() {
            return "Book{title='" + title + "', author='" + author + "', pages=" + pages + ", year=" + year + '}';
        }
    }

    static class Student {
        private String firstName;
        private String lastName;
        private String studentId;
        private String major;
        public Student(String firstName, String lastName, String studentId, String major) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.studentId = studentId;
            this.major = major;
        }
        public String toString() {
            return "Student{firstName='" + firstName + "', lastName='" + lastName + "', studentId='" + studentId + "', major='" + major + "'}";
        }
    }

    public static void main(String[] args) {
        writeToFile();
        readFromFile();
    }

    public static void writeToFile() {
        Book[] books = {
                new Book("melat eshqh", "Elif", 500, 2010),
                new Book("midgard", "Ahmadreza Salegi", 350, 2014),
                new Book("divaneh", "Sohrab", 250, 1386),
                new Book("nakh nama", "Mina", 300, 2017)
        };

        Student[] students = {
                new Student("Ahoo", "Rezayi", "1", "Computer"),
                new Student("Tara", "Moradi", "2", "Art"),
                new Student("Amir", "Karimi", "3", "Physics")
        };

        try (FileWriter bookWriter = new FileWriter("books.txt")) {
            for (Book book : books) {
                bookWriter.write(book.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error");
        }

        try (FileWriter studentWriter = new FileWriter("students.txt")) {
            for (Student student : students) {
                studentWriter.write(student.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void readFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("books.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                booksFromFile[bookCount++] = line;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error");
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("students.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                studentsFromFile[studentCount++] = line;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}