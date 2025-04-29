package ap.exercises.ex4;

public class Main_EX4_E3_5 {
    public static void main(String[] args) {
        LightController lightController = new LightController();

        testSwitchCombination(lightController, 0, 0);
        testSwitchCombination(lightController, 0, 1);
        testSwitchCombination(lightController, 1, 0);
        testSwitchCombination(lightController, 1, 1);
    }

    private static void testSwitchCombination(LightController lightController, int switch1, int switch2) {

        setSwitchState(lightController, 1, switch1);
        setSwitchState(lightController, 2, switch2);

        int actualState = lightController.getLampState();

        int expectedState = (switch1 == switch2) ? 0 : 1;

        System.out.println("Switch 1: " + switch1 + ", Switch 2: " + switch2 + " so Lamp: " + actualState + " (Expected: " + expectedState + ")");
    }

    private static void setSwitchState(LightController lightController, int switchNumber, int switchState) {
        if (switchNumber == 1) {
            while (lightController.getFirstSwitchState() != switchState) {
                lightController.toggleFirstSwitch();
            }
        } else if (switchNumber == 2) {
            while (lightController.getSecondSwitchState() != switchState) {
                lightController.toggleSecondSwitch();
            }
        }
    }
}
