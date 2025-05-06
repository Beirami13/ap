package shop;

public class Book {
    private int price;
    private String title;
    public Book(int price,String title){
        this.price=price;
        this.title=title;
    }
    public int getPrice(){
        return price;
    }
    public String getTitle(){
        return title;
    }
    @Override
    public String toString() {
        return "Book [price=" + price + ", title=" + title + "]";
    }
}
