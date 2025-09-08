package ap.exercises.FinalExam;

import ap.exercises.FinalExam.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductTools {

    public static void printSorted(List<Product> products){

        products.stream().distinct()
                .sorted(Comparator.comparing(Product::getName).thenComparingInt(Product::getPrice))
                .forEach(System.out::println);
    }

    public static Pair<Product, Product> printExpensive(List<Product> products) {
        Product product2 = products.stream()
                .filter(p -> p instanceof Book)
                .max(Comparator.comparingInt(Product::getPrice))
                .orElse(null);

        Product product3 = products.stream()
                .filter(p -> p instanceof Pen)
                .max(Comparator.comparingInt(Product::getPrice))
                .orElse(null);

        return new Pair<Product, Product>(product2, product3);
    }

    public static void ShoeColor(List<Product> products) {
        long blackPens = products.stream()
                .filter(p -> p instanceof Pen)
                .map(p -> (Pen) p)
                .filter(p -> p.getColor() == Pen.Color.Black)
                .count();

        long redPens = products.stream()
                .filter(p -> p instanceof Pen)
                .map(p -> (Pen) p)
                .filter(p -> p.getColor() == Pen.Color.Red)
                .count();

        long bluePens = products.stream()
                .filter(p -> p instanceof Pen)
                .map(p -> (Pen) p)
                .filter(p -> p.getColor() == Pen.Color.Blue)
                .count();

        long greenPens = products.stream()
                .filter(p -> p instanceof Pen)
                .map(p -> (Pen) p)
                .filter(p -> p.getColor() == Pen.Color.Green)
                .count();

        Map<Pen.Color, Long> colors = new HashMap<>();
        colors.put(Pen.Color.Red, redPens);
        colors.put(Pen.Color.Black, blackPens);
        colors.put(Pen.Color.Blue, bluePens);
        colors.put(Pen.Color.Green, greenPens);

        System.out.println(colors);
    }


}
