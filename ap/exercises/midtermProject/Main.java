package ap.exercises.midtermProject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Library library = FileManager.loadData();
            if (library == null) {
                Manager manager = new Manager("Ahoo", "Radmanesh", Manager.Level.master);
                library = new Library("My Library", manager);
            }
            Menu menu = new Menu(library);
            while (true) {
                menu.showRoll();
                System.out.println("Do you want to continue? (yes/no): ");
                String answer = new Scanner(System.in).nextLine();
                if (!answer.equalsIgnoreCase("yes")) break;
            }

            FileManager.saveData(library);
        } catch (Exception e) {
            System.err.println("ٍError: " + e.getMessage());
        }
    }
}
