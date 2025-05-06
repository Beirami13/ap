package shop;

import java.util.ArrayList;

public class Store {
    public static void main(String[] args) {
        Pen p1 = new Pen(100,"pinck","bick");
        Pen p2 = new Pen(200,"blue","bick");
        Book b1 = new Book(100,"melat");
        ArrayList<Pen> p = new ArrayList<>();
        ArrayList<Book> b = new ArrayList<>();
        p.add(p1);
        p.add(p2);
        b.add(b1);
        for (Pen pen : p) {
            System.out.println(pen);
        }
        for (Book book : b) {
            System.out.println(book);
        }
    }
}
