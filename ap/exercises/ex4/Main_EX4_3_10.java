package ap.exercises.ex4;

public class Main_EX4_3_10 {
    private double total;
    private String items;

    public Main_EX4_3_10() {
        total = 0;
        items = "";
    }

    public void addItem(double price) {
        total += price;
        items = items + String.valueOf(price) + "\n";
    }

    public void printReceipt() {
        System.out.print(items);
        System.out.println("Total: " + total);
    }

    public static void main(String[] args) {
        Main_EX4_3_10 T = new Main_EX4_3_10();
        T.addItem(21);
        T.addItem(20.8);
        T.addItem(9.1);

        T.printReceipt();
    }
}

