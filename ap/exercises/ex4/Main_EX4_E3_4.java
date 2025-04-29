package ap.exercises.ex4;

class LightController {
    private int firstSwitch;
    private int secondSwitch;

    public LightController() {
        this.firstSwitch = 0;
        this.secondSwitch = 0;
    }

    public int getFirstSwitchState() {
        return firstSwitch;
    }

    public int getSecondSwitchState() {
        return secondSwitch;
    }

    public int getLampState() {
        if (firstSwitch == secondSwitch) {
            return 0;
        } else {
            return 1;
        }
    }

    public void toggleFirstSwitch() {
        firstSwitch = 1 - firstSwitch;
    }

    public void toggleSecondSwitch() {
        secondSwitch = 1 - secondSwitch;
    }
}


public class Main_EX4_E3_4 {
    public static void main(String[] args) {
        LightController control = new LightController();
        System.out.println("Lamp State is: " + control.getLampState());
        control.toggleFirstSwitch();
        System.out.println("After first switch Lamp State is: " + control.getLampState());
        control.toggleSecondSwitch();
        System.out.println("After second switch Lamp State is: " + control.getLampState());
    }
}
