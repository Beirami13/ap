package ap.exercises.FinalExam;

public class Pen extends Product {
    private Color color;
    public enum  Color {
        Red, Blue, Black,Green
    }
    public Pen(String name,int price,Color color){
        super(name, price);
        this.color=color;
    }

    public Color getColor(){
        return color;
    }
    public void setColor(Color color){
        this.color=color;
    }

    @Override
    public String toString() {
        return "Pens name is "+getName()+" price is "+getPrice()+" color is " + color;
    }

}
