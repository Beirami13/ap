package ap.exercises.midtermExam;

public class Case {
    private String color;
    private String model;
    private String cpu;
    private int speaker;
    public Case(String color, String model, String cpu, int speaker){
        this.color=color;
        this.model=model;
        this.cpu=cpu;
        this.speaker=speaker;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public String getCpu() {
        return cpu;
    }

    public int getSpeaker(){
        return speaker;
    }

    @Override
    public String toString() {
        return "Case -> " + "color: " + color + " " + " model: " + model + " " + " cpu: " + cpu + " " + "speaker: " + speaker ;
    }
}
