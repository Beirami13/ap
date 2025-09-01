package ap.exercises.FinalProject;

public class Staff {
    private String name;
    private String staffId;
    private String username;
    private String password;

    public Staff(String name, String staffId, String username, String password) {
        this.name = name != null ? name.trim() : "";
        this.staffId = staffId != null ? staffId.trim() : "";
        this.username = username != null ? username.trim() : "";
        this.password = password != null ? password : "";
    }

    public String getName() {
        return name;
    }
    public String getStaffId() {
        return staffId;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password != null ? password : "";
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Staff ID: " + staffId + " | Username: " + username;
    }
}
