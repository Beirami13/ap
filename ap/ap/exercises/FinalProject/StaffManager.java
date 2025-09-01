package ap.exercises.FinalProject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StaffManager {
    private List<Staff> staffList = new ArrayList<>();
    private static final String STAFF_FILE = "staff.txt";

    public StaffManager() {
        loadStaffFromFile();
        if (staffList.isEmpty()) {
            loadDefaultStaff();
            saveAllStaff();
        }
    }

    private void loadDefaultStaff() {
        staffList.add(new Staff("Abdi", "1", "staff1", "1234"));
        staffList.add(new Staff("Rad", "2", "staff2", "1383"));
    }

    public void registerStaff(String name, String staffId, String username, String password) {
        if (isUsernameTaken(username)) {
            System.out.println("Username already exists! Choose a different one.");
            return;
        }

        Staff staff = new Staff(name, staffId, username, password);
        staffList.add(staff);
        saveAllStaff();
        System.out.println("Staff registered successfully!");
    }

    private boolean isUsernameTaken(String username) {
        return staffList.stream().anyMatch(s -> s.getUsername().equalsIgnoreCase(username));
    }

    public Staff authenticateStaff(String username, String password) {
        return staffList.stream()
                .filter(s -> s.getUsername().equals(username) && s.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    public int getStaffCount() {
        return staffList.size();
    }

    public void changePassword(Staff staff, String newPassword) {
        staffList.stream()
                .filter(s -> s.getUsername().equals(staff.getUsername()))
                .findFirst()
                .ifPresent(s -> s.setPassword(newPassword));

        saveAllStaff();
        System.out.println("Password changed successfully!");
    }

    private void loadStaffFromFile() {
        staffList.clear();
        File file = new File(STAFF_FILE);
        if (!file.exists()) return;

        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                if (data.length == 4) {
                    Staff s = new Staff(data[0], data[1], data[2], data[3]);
                    staffList.add(s);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading staff file: " + e.getMessage());
        }
    }

    private void saveAllStaff() {
        try (FileWriter writer = new FileWriter(STAFF_FILE)) {
            for (Staff s : staffList) {
                writer.write(s.getName() + "," + s.getStaffId() + "," + s.getUsername() + "," + s.getPassword() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving staff: " + e.getMessage());
        }
    }
}
