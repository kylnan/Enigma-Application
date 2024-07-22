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

    public static void rotate(Rotor left, Rotor middle, Rotor right){
        if (middle.atNotch()) {
            middle.step();
            left.step();
        } else if(right.atNotch()){
            middle.step();
        }
        right.step();
    }

    public static char encodeDecode(Rotor left, Rotor middle, Rotor right, Reflector reflector, Plugboard plugboard, char c){
        if (c == ' '){
            return ' ';
        }
        rotate(left, middle, right);

        //Plugboard in
        char signal = plugboard.encode(c);

        // Right to left encoding
        char s1 = right.encodeForward(signal);
        char s2 = middle.encodeForward(s1);
        char s3 = left.encodeForward(s2);

        // Through reflector
        char s4 = reflector.encode(s3);

        // Left to right encoding
        char s5 = left.encodeBackward(s4);
        char s6 = middle.encodeBackward(s5);
        char s7 = right.encodeBackward(s6);

        //Plugboard out
        s7 = plugboard.encode(s7);

        return s7;
    }

    public static void main(String[] args) {
        // Example usage with rotors I, II, III and reflector B
        Rotor right = new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'Q'); // Rotor I
        Rotor middle = new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'E'); // Rotor II
        Rotor left = new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'V'); // Rotor III
        Reflector reflector = new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT"); // Reflector B
        Plugboard plugboard = new Plugboard("AB CD EF GH");

        // Example encode/decode
        String message = "welcome to enigma".toUpperCase();
        StringBuilder encodedMessage = new StringBuilder();

        for (char c : message.toCharArray()) {
            encodedMessage.append(encodeDecode(left, middle, right, reflector, plugboard, c));
        }

        System.out.println("Encoded Message: " + encodedMessage);

        // Reset rotor positions to decode
        right.setPosition(0);
        middle.setPosition(0);
        left.setPosition(0);

        StringBuilder decodedMessage = new StringBuilder();

        for (char c : encodedMessage.toString().toCharArray()) {
            decodedMessage.append(encodeDecode(left, middle, right, reflector, plugboard, c));
        }

        System.out.println("Decoded Message: " + decodedMessage);
    }

}