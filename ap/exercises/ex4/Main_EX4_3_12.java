package ap.exercises.ex4;

public class Main_EX4_3_12 {
    public static void main(String[] args) {
        Employee H = new Employee("Hirad", 50000);

        System.out.println("Name: " + H.getName());
        System.out.println("Salary: " + H.getSalary());

        H.raiseSalary(10); // Harry gets a 10% raise

        System.out.println("After Raise: " + H.getSalary());
    }
}

class Employee {
    private String Name;
    private double Salary;

    public Employee(String Name, double Salary) {
        this.Name = Name;
        this.Salary = Salary;
    }

    public String getName() {
        return Name;
    }

    public double getSalary() {
        return Salary;
    }

    public void raiseSalary(double Percent) {
        Salary = Salary * (1 + Percent / 100);
    }
}


