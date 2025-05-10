package ap.exercises.midtermProject;

import java.time.LocalDate;

public class Librarian {
    private String firstName;
    private String lastName;
    private int librarianID;
    public Librarian(String firstName,String lastName,  int librarianID){
        this.firstName=firstName;
        this.lastName=lastName;
        this.librarianID=librarianID;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getLibrarianID(){
        return librarianID;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setLibrarianIDID(int librarianID){
        this.librarianID=librarianID;
    }
}
