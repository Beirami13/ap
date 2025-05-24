package ap.exercises.midtermExam;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Case> cases = new ArrayList<>();
        ArrayList<Laptop> laptops = new ArrayList<>();
        Shop shop = new Shop(laptops,cases);
        Laptop laptop1 = new Laptop("black","asus",2,16);
        Case case1 = new Case("white","dell","i 7",2);
        shop.addLap(laptop1);
        shop.addCase(case1);
        shop.printLaptop();
        shop.printCase();
    }
}
