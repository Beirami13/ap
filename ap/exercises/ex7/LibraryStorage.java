package ap.exercises.ex7;

import ap.exercises.midtermProject.Library;

public interface LibraryStorage {
    void saveLibrary(Library library);
    Library loadLibrary();
}

