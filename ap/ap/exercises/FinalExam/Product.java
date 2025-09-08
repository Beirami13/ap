package ap.exercises.FinalExam;

public class Product {
    private int price;
    private String name;

    public Product(String name,int price){
        this.price=price;
        this.name=name;
    }

    public int getPrice(){
        return price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return price == product.price &&
                name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, price);
    }


    @Override
    public String toString() {
        return "name is" + name + "price is" + price;
    }
}
