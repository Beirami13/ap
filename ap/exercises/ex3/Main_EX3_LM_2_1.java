package ap.exercises.ex3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main_EX3_LM_2_1 {
    static class Borrow {
        public String studentId;
        public String bookTitle;
        public String borrowDate;

        public Borrow(String studentId, String bookTitle, String borrowDate) {
            this.studentId = studentId;
            this.bookTitle = bookTitle;
            this.borrowDate = borrowDate;
        }

        public String toString() {
            return studentId + "," + bookTitle + "," + borrowDate;
        }

        public static Borrow fromString(String line) {
            String[] parts = line.split(",");
            return new Borrow(parts[0], parts[1], parts[2]);
        }
    }

    public static void main(String[] args) {
        Borrow[] borrows = {
                new Borrow("1", "melat eshqh", "2025-04-09"),
                new Borrow("2", "midgard", "2025-04-08"),
                new Borrow("3", "divaneh", "2025-04-07")
        };

        saveBorrowsToFile(borrows);
        Borrow[] loaded = readBorrowsFromFile();

        for (int i = 0; i < loaded.length; i++) {
            if (loaded[i] != null)
                System.out.println(loaded[i]);
        }
    }

    public static void saveBorrowsToFile(Borrow[] borrows) {
        try (FileWriter writer = new FileWriter("borrows.txt")) {
            for (int i = 0; i < borrows.length; i++) {
                writer.write(borrows[i].toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static Borrow[] readBorrowsFromFile() {
        Borrow[] borrows = new Borrow[100];
        int count = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("borrows.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                borrows[count++] = Borrow.fromString(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error");
        }
        return borrows;
    }
}
