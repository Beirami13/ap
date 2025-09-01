package ap.exercises.FinalProject;

public class Student {
    private String name;
    private String studentId;
    private String username;
    private String password;

    public Student(String name, String studentId, String username, String password) {
        this.name = name != null ? name.trim() : "";
        this.studentId = studentId != null ? studentId.trim() : "";
        this.username = username != null ? username.trim() : "";
        this.password = password != null ? password : "";
    }

    public String getName() {
        return name;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name != null ? name.trim() : this.name;
    }

    public void setPassword(String password) {
        this.password = password != null ? password : this.password;
    }


    @Override
    public String toString() {
        return "Name: " + name + " | Student ID: " + studentId + " | Username: " + username;
    }
}
