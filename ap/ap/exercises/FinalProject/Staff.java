package ap.exercises.FinalProject;

public class Staff extends Person {
    private String staffId;

    public Staff(String name, String staffId, String username, String password) {
        super(name, username, password);
        this.staffId = staffId != null ? staffId.trim() : "";
    }

    public String getStaffId() { return staffId; }

    public void setStaffId(String staffId) {
        if (staffId != null && !staffId.trim().isEmpty()) {
            this.staffId = staffId.trim();
        }
    }

    @Override
    public String toString() {
        return "Name: " + getName() + " | Staff ID: " + staffId + " | Username: " + getUsername();
    }
}