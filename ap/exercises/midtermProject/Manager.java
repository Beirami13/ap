package ap.exercises.midtermProject;

public class Manager {
    public enum Level{
        diploma,bachelor,master,phd
    }
    private String firstName;
    private String lastName;
    private Level level;
    public Manager(String firstName,String lastName,  Level level){
        this.firstName=firstName;
        this.lastName=lastName;
        this.level=level;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public Level getLevel(){
        return level;
    }
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setLevel(Level level){
        this.level=level;
    }
}
