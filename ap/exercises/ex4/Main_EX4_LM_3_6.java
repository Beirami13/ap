package ap.exercises.ex4;

class Controller {
    private int firstSwitch;
    private int secondSwitch;

    public Controller() {
        firstSwitch = 0;
        secondSwitch = 0;
    }

    public int getSwitchState(int switchNum) {
        if (switchNum == 1) {
            return firstSwitch;
        } else if (switchNum == 2) {
            return secondSwitch;
        }
        return -1;
    }

    public int getLampState() {
        return (firstSwitch == secondSwitch) ? 0 : 1;
    }

    public void toggleSwitch(int switchNum) {
        if (switchNum == 1) {
            firstSwitch = 1 - firstSwitch;
        } else if (switchNum == 2) {
            secondSwitch = 1 - secondSwitch;
        }
    }
}

public class Main_EX4_LM_3_6 {
    public static void main(String[] args) {
        Controller controller = new Controller();

        System.out.println("Switch 1 State: " + controller.getSwitchState(1));
        System.out.println("Switch 2 State: " + controller.getSwitchState(2));
        System.out.println("Lamp State: " + controller.getLampState());

        // تغییر وضعیت سوئیچ‌ها
        controller.toggleSwitch(1);
        controller.toggleSwitch(2);

        // بررسی وضعیت بعد از تغییر سوئیچ‌ها
        System.out.println("After toggling:");
        System.out.println("Switch 1 State: " + controller.getSwitchState(1));
        System.out.println("Switch 2 State: " + controller.getSwitchState(2));
        System.out.println("Lamp State: " + controller.getLampState());
    }
}
