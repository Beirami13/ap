package ap.exercises.midtermProject;

import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    private List<Borrow> borrows;

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }

    public void saveBorrowsToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (Borrow b : borrows) {
                writer.println(b.toString());
            }
            System.out.println("Saved");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void loadBorrowsFromFileSimple(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            System.out.println("Loaded.");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
