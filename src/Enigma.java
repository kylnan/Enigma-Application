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
        Rotor left = new Rotor(I, 'Q');
        Rotor middle = new Rotor(II, 'E');
        Rotor right = new Rotor(III, 'V');

        // Example Reflector
        Reflector reflector = new Reflector(reflectorB);

        // Test all 3 rotors + reflector
        right.setPosition(0);
        middle.setPosition(0);
        left.setPosition(0);
        String message = "hello world";
        StringBuilder cipher = new StringBuilder();
        for (int i = 0; i < message.length(); i++){
            cipher.append(encode(left ,middle, right, reflector, message.charAt(i)));
        }
        System.out.println("Cipher is: " + cipher);
    }

    public static char encode(Rotor left, Rotor middle, Rotor right, Reflector reflector, char c){
        if (c == ' '){
            return ' ';
        }

        if (middle.atNotch()) {
            middle.step();
            left.step();
        } else if(right.atNotch()){
            middle.step();
        }
        right.step();

        // Right to left encoding
        char signal = right.encodeForward(c);
        char s1 = middle.encodeForward(signal);
        char s2 = left.encodeForward(s1);

        // Through reflector
        char s3 = reflector.encodeForward(s2);

        // Left to right encoding
        char s4 = left.encodeBackward(s3);
        char s5 = middle.encodeBackward(s4);
        char s6 = right.encodeBackward(s5);

        //Plugboard should go here

        return s6;
    }
}