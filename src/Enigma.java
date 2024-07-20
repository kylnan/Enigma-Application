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
        Rotor middle = new Rotor(II, 'F');
        Rotor left = new Rotor(III, 'W');

        // Example Reflector
        Reflector reflector = new Reflector(reflectorB);

        /* Test setting positions
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
        for (int i = 0; i < 26; i++){
            right.setPosition(i);
            System.out.print(right.encodeForward((char)(i + 'A')) + " ");
        }
        System.out.println();
        for (int i = 0; i < 26; i++){
            right.setPosition(i);
            System.out.print(middle.encodeForward((char)(i + 'A')) + " ");
        }
        System.out.println();
        for (int i = 0; i < 26; i++){
            right.setPosition(i);
            System.out.print(left.encodeForward((char)(i + 'A')) + " ");
        }
        System.out.println();
        if (right.encodeForward('A') == 'M') {
            System.out.println("Right Rotor encodes forward correctly.");
        } else {

            System.out.println("Error in Right Rotor forward encoding.");
        }

        // Test encoding backward
        for (int i = 0; i < 26; i++){
            right.setPosition(0);
            System.out.print(right.encodeBackward(I.charAt(i)) + " ");
        }
        System.out.println();
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
        for (int i = 0; i < 26; i++){
            System.out.print(reflector.encodeForward((char)(i+'A')) + " ");
        }
        System.out.println();
        */
        // Test all 3 rotors
        right.setPosition(0);
        middle.setPosition(0);
        left.setPosition(0);
        String message = "hello world";
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < message.length(); i++){
            cipher.append(encode(left,middle, right, reflector, message.charAt(i)));
        }
        System.out.println("Cipher is: " + cipher);
    }

    public static char encode(Rotor left, Rotor middle, Rotor right, Reflector reflector, char c){
        if(middle.atNotch()) {
            middle.step();
            left.step();
        }
        else if(right.atNotch()){
            middle.step();
        }
        right.step();

        char signal = right.encodeForward(c);
        char s1 = middle.encodeForward(signal);
        char s2 = left.encodeForward(s1);

        char s3 = reflector.encodeForward(s2);

        char s4 = left.encodeBackward(s3);
        char s5 = middle.encodeBackward(s4);

        return right.encodeBackward(s5);
    }
}