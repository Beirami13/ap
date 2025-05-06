package shop;

public class Pen {
    private int price;
    private String color;
    private String brand;
    public Pen(int price,String color,String brand){
        this.price=price;
        this.color=color;
        this.brand=brand;
    }
    public int getPrice(){
        return price;
    }
    public String getColor(){
        return color;
    }
    public String getBrand(){
        return brand;
    }
}
