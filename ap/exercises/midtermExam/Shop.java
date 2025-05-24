package ap.exercises.midtermExam;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private ArrayList<Laptop> laptops;
    private ArrayList<Case> cases;

    public Shop(ArrayList<Laptop> laptops,ArrayList<Case> cases){
        this.laptops=new ArrayList<>();
        this.cases=new ArrayList<>();
    }
    public List<Laptop> getLaptop(){
        return laptops;
    }
    public List<Case> getCase(){
        return cases;
    }
    public void printLaptop(){
        for (Laptop laptop : laptops){
            System.out.println(laptop);
        }
    }
    public void printCase(){
        for (Case Case : cases){
            System.out.println(Case);
        }
    }
    public void addLap(Laptop laptop){
        laptops.add(laptop);
    }
    public void addCase(Case Case){
        cases.add(Case);
    }
}
