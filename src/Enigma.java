//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Enigma{
    public static void main(String[] args) {
        // Example rotor wirings and notch positions
        Rotor rotor1 = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'R');
        Rotor rotor2 = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'F');
        Rotor rotor3 = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'W');

        // Test setting positions
        rotor1.setPosition(5);
        if (rotor1.getPosition() == 5) {
            System.out.println("Rotor 1 position set correctly.");
        } else {
            System.out.println("Error in setting Rotor 1 position.");
        }

        // Test advancing rotors
        rotor1.setPosition(0);
        rotor1.step();
        if (rotor1.getPosition() == 1) {
            System.out.println("Rotor 1 advanced correctly.");
        } else {
            System.out.println("Error in advancing Rotor 1.");
        }

        rotor1.setPosition(25);
        rotor1.step();
        if (rotor1.getPosition() == 0) {
            System.out.println("Rotor 1 wrapped around correctly.");
        } else {
            System.out.println("Error in Rotor 1 wrapping around.");
        }

        // Test encoding forward
        rotor1.setPosition(3);
        if (rotor1.encodeForward('A') == 'C') {
            System.out.println("Rotor 1 encodes forward correctly.");
        } else {
            System.out.println("Error in Rotor 1 forward encoding.");
        }

        // Test encoding backward
        rotor1.setPosition(0);
        if (rotor1.encodeBackward('E') == 'A' && rotor1.encodeBackward('K') == 'B') {
            System.out.println("Rotor 1 encodes backward correctly.");
        } else {
            System.out.println("Error in Rotor 1 backward encoding.");
        }

        // Test notch detection
        rotor1.setPosition(17);
        if (rotor1.atNotch()) {
            System.out.println("Rotor 1 correctly detects notch.");
        } else {
            System.out.println("Error in Rotor 1 notch detection.");
        }

        rotor1.setPosition(16);
        if (!rotor1.atNotch()) {
            System.out.println("Rotor 1 correctly does not detect notch.");
        } else {
            System.out.println("Error in Rotor 1 notch detection.");
        }

        System.out.println("All tests completed.");
    }
}