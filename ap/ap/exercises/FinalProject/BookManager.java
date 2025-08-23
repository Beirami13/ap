package ap.exercises.FinalProject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookManager {
    private List<Book> books = new ArrayList<>();
    private static final String BOOK_FILE = "books.txt";

    public BookManager() {
        loadBooksFromFile();
    }

    public void addBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        books.add(book);
        saveBook(book);
        System.out.println("Book added successfully!");
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\n--- Library Books ---");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void searchBooks() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- Search Book ---");
        System.out.println("1. By Title");
        System.out.println("2. By Author");
        System.out.println("3. By Year");
        System.out.print("Choose search type: ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        List<Book> results = new ArrayList<>();

        switch (choice) {
            case 1:
                System.out.print("Enter book title: ");
                String title = scanner.nextLine().toLowerCase();
                results = books.stream()
                        .filter(b -> b.getTitle().toLowerCase().contains(title))
                        .collect(Collectors.toList());
                break;
            case 2:
                System.out.print("Enter author name: ");
                String author = scanner.nextLine().toLowerCase();
                results = books.stream()
                        .filter(b -> b.getAuthor().toLowerCase().contains(author))
                        .collect(Collectors.toList());
                break;
            case 3:
                System.out.print("Enter publication year: ");
                try {
                    int year = Integer.parseInt(scanner.nextLine());
                    results = books.stream()
                            .filter(b -> b.getYear() == year)
                            .collect(Collectors.toList());
                } catch (NumberFormatException e) {
                    System.out.println("Year must be a number.");
                    return;
                }
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("\nSearch Results:");
            for (Book b : results) {
                System.out.println(b);
            }
        }
    }

    private void saveBook(Book book) {
        try (FileWriter writer = new FileWriter(BOOK_FILE, true)) {
            writer.write(book.getTitle() + "," +
                    book.getAuthor() + "," +
                    book.getYear() + "," +
                    book.isBorrowed() + "\n");
        } catch (IOException e) {
            System.out.println("Error saving book: " + e.getMessage());
        }
    }

    private void loadBooksFromFile() {
        books.clear();
        File file = new File(BOOK_FILE);
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length == 4) {
                    Book b = new Book(data[0], data[1], Integer.parseInt(data[2]));
                    b.setBorrowed(Boolean.parseBoolean(data[3]));
                    books.add(b);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading books file: " + e.getMessage());
        }
    }
}
