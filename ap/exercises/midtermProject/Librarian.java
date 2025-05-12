package ap.exercises.midtermProject;

public class Librarian {
    private String firstName;
    private String lastName;
    private int librarianID;

    public Librarian(String firstName, String lastName, int librarianID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.librarianID = librarianID;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getLibrarianID() {
        return librarianID;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setLibrarianID(int librarianID) {
        this.librarianID = librarianID;
    }
    @Override
    public String toString() {
        return "Full name: " + firstName + " " + lastName + " ID is " + librarianID;
    }
}
