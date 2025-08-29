package ap.exercises.FinalProject;

public class LibrarySystem {
    private StudentManager studentManager;
    private BookManager bookManager;
    private MenuHandler menuHandler;
    private StaffManager staffManager;

    public LibrarySystem() {
        this.studentManager = new StudentManager();
        this.menuHandler = new MenuHandler(this);
        this.bookManager = new BookManager();
        this.staffManager = new StaffManager();
    }

    public int getStudentCount() {
        return this.studentManager.getStudentCount();
    }

    public void registerStudent(String name, String studentId, String username, String password) {
        studentManager.registerStudent(name, studentId, username, password);
    }

    public Student authenticateStudent(String username, String password) {
        return studentManager.authenticateStudent(username, password);
    }

    public void SearchBooks() {
        bookManager.searchBooks();
    }

    public void searchBookByTitle() {
        bookManager.searchBookByTitleForGuest();
    }

    public void editStudentInformation(Student student) {
        System.out.println("Not implemented.");
    }

    public void borrowBook(Student student) {
        bookManager.borrowBook(student);
    }

    public void returnBook(Student student) {
        System.out.println("Not implemented.");
    }

    public void displayAvailableBooks() {
        System.out.println("Not implemented.");
    }

    public void start() {
        menuHandler.displayMainMenu();
    }

    public int getBookCount() {
        return bookManager.getBookCount();
    }

    public int getTotalBorrows() {
        return bookManager.getTotalBorrows();
    }

    public int getCurrentlyBorrowedCount() {
        return bookManager.getCurrentlyBorrowedCount();
    }

    public void displayLibraryStats() {
        System.out.println("\n--- Library Simple Statistics ---");
        System.out.println("Total registered students: " + getStudentCount());
        System.out.println("Total books: " + getBookCount());
        System.out.println("Total borrow requests (historical): " + getTotalBorrows());
        System.out.println("Currently borrowed books: " + getCurrentlyBorrowedCount());
    }

    public Staff authenticateStaff(String username, String password) {
        return staffManager.authenticateStaff(username, password);
    }

    public void changeStaffPassword(Staff staff, String newPassword) {
        staffManager.changePassword(staff, newPassword);
    }

    public void registerBook() {
        bookManager.registerBook();
    }


    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.start();
    }
}