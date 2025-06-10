package ap.exercises.ex7;

import ap.exercises.midtermProject.*;

public class Main {
    public static void main(String[] args) {
        String storageType = ConfigReader.readStorageType("config.txt");
        LibraryStorage storage;

        switch (storageType.toLowerCase()) {
            case "json":
                storage = new JsonStorage();
                break;
            case "sqlite":
                storage = new SQLiteStorage();
                break;
            case "tabsplit":
            default:
                storage = new TabSplitStorage();
                break;
        }

        Library library = storage.loadLibrary();
        System.out.println("Loaded library with:");
        System.out.println(library.getBooks().size() + " books");
        System.out.println(library.getStudents().size() + " students");

        storage.saveLibrary(library);
    }
}
