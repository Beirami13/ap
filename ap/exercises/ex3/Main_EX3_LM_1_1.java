package ap.exercises.ex3;

//Book
class Book {
    String title;
    String author;
    int pages;
    int year;
    public Book(String title, String author, int pages, int year) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
    }
    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', pages=" + pages + ", year=" + year + '}';
    }
}

//Student
class Student {
    String firstName;
    String lastName;
    String studentId;
    String major;
    public Student(String firstName, String lastName, String studentId, String major) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
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
    }
}
