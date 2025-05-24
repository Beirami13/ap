package ap.exercises.midtermExam;

public class Laptop {
    private String color;
    private String model;
    private int vazn;
    private int ram;
    public Laptop(String color, String model, int vazn, int ram){
        this.color=color;
        this.model=model;
        this.vazn=vazn;
        this.ram=ram;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public int getVazn() {
        return vazn;
    }

    public int getRam(){
        return ram;
    }

    @Override
    public String toString() {
        return "Laptop -> " + "color: " + color + " " + "model: " + model + " " + "vazn: " + vazn + ", ram: " + ram;
    }
}
