package ap.exercises.midtermProject;

import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private int studentID;
    private String major;
    private LocalDate joinDate;
    public Student(String firstName,String lastName,  int studentID,String major, LocalDate joinDate){
        this.firstName=firstName;
        this.lastName=lastName;
        this.studentID=studentID;
        this.major=major;
        this.joinDate=joinDate;
    }
    public String getFirstName(){

        return firstName;
    }
    public String getLastName(){

        return lastName;
    }
    public int getStudentID(){

        return studentID;
    }
    public String getMajor(){

        return major;
    }
    public LocalDate getJoinDate(){

        return joinDate;
    }
    public void setFirstName(String firstName){

        this.firstName=firstName;
    }
    public void setLastName(String lastName){

        this.lastName=lastName;
    }
    public void setMajor(String major){

        this.major=major;
    }
    public void setJoinDate(LocalDate joinDate){

        this.joinDate=joinDate;
    }
    @Override
    public String toString(){
        return "Full name "+firstName+" "+lastName+" ID "+studentID+" major is "+major+" joined in "+joinDate;
    }
}
