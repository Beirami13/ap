package ap.exercises.ex3;

class Book {
    private String title;
    private String author;
    private int pages;
    private int year;
    public Book(String title, String author, int pages, int year) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getPages() {
        return pages;
    }
    public int getYear() {
        return year;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPages(int pages) {
        this.pages = pages;
    }
    public void setYear(int year) {
        this.year = year;
    }
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', pages=" + pages + ", year=" + year + '}';
    }
}

class Student {
    private String firstName;
    private String lastName;
    private String studentId;
    private String major;

    public Student(String firstName, String lastName, String studentId, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.major = major;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getStudentId() {
        return studentId;
    }
    public String getMajor() {
        return major;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    @Override
    public String toString() {
        return "Student{firstName='" + firstName + "', lastName='" + lastName + "', studentId='" + studentId + "', major='" + major + "'}";
    }
}

public class Main_EX3_LM_1_1 {
    public static void main(String[] args) {
        Book book1 = new Book("melat eshqh", "Elif", 500, 2010);
        Book book2 = new Book("midgard", "Ahmadreza Salegi", 350, 2013);
        Student student1 = new Student("Ahmad", "Rezayi", "1", "Computer");
        Student student2 = new Student("Tara", "Moradi", "2", "Art");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(student1);
        System.out.println(student2);
        book1.setPages(520);
        book2.setYear(1392);
        book1.setAuthor("Elif ashkoot");
        book2.setTitle("sheydayi");
        student1.setMajor("Mechanic");
        student2.setLastName("Rad");
        student1.setFirstName("Armin");
        student2.setStudentId("3");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(student1);
        System.out.println(student2);
    }
}