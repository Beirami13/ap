package ap.exercises.FinalProject;

public class Staff {
    private String name;
    private String staffId;
    private String username;
    private String password;

    public Staff(String name, String staffId, String username, String password) {
        this.name = name;
        this.staffId = staffId;
        this.username = username;
        this.password = password;
    }

    public String getName() { return name; }
    public String getStaffId() { return staffId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Staff ID: " + staffId + " | Username: " + username;
    }
}
