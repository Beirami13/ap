package ap.exercises.FinalExam;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Book("Story", 550, "iii", "aaaa"));
        products.add(new Book("Story", 260, "o", "nnnn"));

        products.add(new Pen("Bik", 50, Pen.Color.Black));
        products.add(new Pen("Bik", 50, Pen.Color.Black));

//        ProductTools.printSorted(products);

//        Pair<Product, Product> result = ProductTools.printExpensive(products);
//        System.out.println(result.getKey());
//        System.out.println(result.getValue());

            ProductTools.ShoeColor(products);

    }
}
