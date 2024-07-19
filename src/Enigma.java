/* Rotor and Reflector Strings

    -------------Rotors---------------
    I     = EKMFLGDQVZNTOWYHXUSPAIBRCJ
    II    = AJDKSIRUXBLHWTMCQGZNPYFVOE
    III   = BDFHJLCPRTXVZNYEIWGAKMUSQO
    IV    = ESOVPZJAYQUIRHXLNFTGKDCMWB
    V     = VZBRGITYUPSDNHLXAWMJQOFECK

    --------------Reflectors----------------
    Reflector B = YRUHQSLDPXNGOKMIEBFZCWVJAT
    Reflector C = FVPJIAOYEDRZXWGCTKUQSBNMHL
 */
public class Enigma{
    public static void main(String[] args) {
        String I = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
        String II = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
        String III = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
        String IV = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
        String V = "VZBRGITYUPSDNHLXAWMJQOFECK";

        String reflectorB = "YRUHQSLDPXNGOKMIEBFZCWVJAT";
        String reflectorC = "FVPJIAOYEDRZXWGCTKUQSBNMHL";

        // Example rotor wirings and notch positions
        Rotor right = new Rotor(I, 'R');
        Rotor rotor2 = new Rotor(II, 'F');
        Rotor rotor3 = new Rotor(III, 'W');

        // Test setting positions
        right.setPosition(5);
        if (right.getPosition() == 5) {
            System.out.println("Right Rotor position set correctly.");
        } else {
            System.out.println("Error in setting Right Rotor position.");
        }

        // Test advancing rotors
        right.setPosition(0);
        right.step();
        if (right.getPosition() == 1) {
            System.out.println("Right Rotor advanced correctly.");
        } else {
            System.out.println("Error in advancing Right Rotor.");
        }

        right.setPosition(25);
        right.step();
        if (right.getPosition() == 0) {
            System.out.println("Right Rotor wrapped around correctly.");
        } else {
            System.out.println("Error in Right Rotor wrapping around.");
        }

        // Test encoding forward
        right.setPosition(3);
        if (right.encodeForward('A') == 'C') {
            System.out.println("Right Rotor encodes forward correctly.");
        } else {
            System.out.println("Error in Right Rotor forward encoding.");
        }

        // Test encoding backward
        right.setPosition(0);
        if (right.encodeBackward('E') == 'A' && right.encodeBackward('K') == 'B') {
            System.out.println("Right Rotor encodes backward correctly.");
        } else {
            System.out.println("Error in Right Rotor backward encoding.");
        }

        // Test notch detection
        right.setPosition(17);
        if (right.atNotch()) {
            System.out.println("Right Rotor correctly detects notch.");
        } else {
            System.out.println("Error in Right Rotor notch detection.");
        }

        right.setPosition(16);
        if (!right.atNotch()) {
            System.out.println("Right Rotor correctly does not detect notch.");
        } else {
            System.out.println("Error in Right Rotor notch detection.");
        }

        // Test Reflector encoding
        Reflector reflector = new Reflector(reflectorB);
        if (reflector.encodeForward('B') == 'R' && reflector.encodeBackward('R') == 'B'){
            System.out.println("Reflector Works!");
        }
        System.out.println("All tests completed.");
    }
}