package ap.exercises.FinalProject;

import java.io.*;
import java.time.LocalDate;
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

    public void borrowBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine().toLowerCase();

        Book book = books.stream()
                .filter(b -> b.getTitle().toLowerCase().equals(title))
                .findFirst()
                .orElse(null);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isBorrowed()) {
            System.out.println("Sorry, this book is already borrowed.");
            return;
        }

        try {
            System.out.print("Enter start date (yyyy-MM-dd): ");
            LocalDate startDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Enter end date (yyyy-MM-dd): ");
            LocalDate endDate = LocalDate.parse(scanner.nextLine());

            if (endDate.isBefore(startDate)) {
                System.out.println("End date cannot be before start date.");
                return;
            }

            book.setBorrowed(true);
            book.setStartDate(startDate);
            book.setEndDate(endDate);

            saveAllBooks();

            System.out.println("Book borrowed successfully from " + startDate + " to " + endDate);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }
    }

    private void saveAllBooks() {
        try (FileWriter writer = new FileWriter(BOOK_FILE)) {
            for (Book b : books) {
                writer.write(b.getTitle() + "," +
                        b.getAuthor() + "," +
                        b.getYear() + "," +
                        b.isBorrowed() + "," +
                        (b.getStartDate() != null ? b.getStartDate() : "") + "," +
                        (b.getEndDate() != null ? b.getEndDate() : "") + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving books: " + e.getMessage());
        }
    }

    private void loadBooksFromFile() {
        books.clear();
        File file = new File(BOOK_FILE);
        if (!file.exists()) return;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                if (data.length >= 4) {
                    Book b = new Book(data[0], data[1], Integer.parseInt(data[2]));
                    b.setBorrowed(Boolean.parseBoolean(data[3]));

                    if (data.length >= 6) {
                        if (!data[4].isEmpty()) b.setStartDate(LocalDate.parse(data[4]));
                        if (!data[5].isEmpty()) b.setEndDate(LocalDate.parse(data[5]));
                    }

                    books.add(b);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading books file: " + e.getMessage());
        }
    }
}
