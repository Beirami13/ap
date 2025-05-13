package ap.exercises.midtermProject;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager("Ahoo", "ريالشی", Manager.Level.master);
        Library library = new Library("My Library", manager);
        Menu menu = new Menu(library);
        menu.showRoll();
    }
}
