package ap.exercises.ex7;

import ap.exercises.midtermProject.Library;

public interface Storage {
    void save(Library library);
    Library load();
}

