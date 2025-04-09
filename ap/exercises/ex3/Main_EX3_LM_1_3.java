package ap.exercises.ex3;

public class Main_EX3_LM_1_3 {
    static class Student {
        public String firstName;
        public String lastName;
        public String studentId;
        public String major;
        public Student(String firstName, String lastName, String studentId, String major) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.studentId = studentId;
            this.major = major;
        }
        public String toString() {
            return "Student{firstName='" + firstName + "', lastName='" + lastName + "', studentId='" + studentId + "', major='" + major + "'}";
        }
    }
    public static void main(String[] args){
        Main_EX3_LM_1_3.Student[] students = {
                new Main_EX3_LM_1_3.Student("Ahoo", "Rezayi", "1", "Computer"),
                new Main_EX3_LM_1_3.Student("Tara", "Moradi", "2", "Art"),
                new Main_EX3_LM_1_3.Student("Amir", "Karimi", "3", "Physics")
        };
        System.out.println(findStuByName(students, "Ahoo", "Rezayi"));
    }
    public static Student findStuByName(Student[] students, String first, String last){
        for (int i=0; i<students.length; i++){
            if((students[i].firstName).equalsIgnoreCase(first) && (students[i].lastName).equalsIgnoreCase(last)){
                return students[i];
            }
        }
        return null;
    }
}