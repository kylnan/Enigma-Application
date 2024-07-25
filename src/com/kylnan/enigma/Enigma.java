package com.kylnan.enigma;

public class Enigma {
    private Rotor left;
    private Rotor middle;
    private Rotor right;
    private Reflector reflector;
    private Plugboard plugboard;

    public Enigma(String left, String middle, String right, String reflector, String plugboard) {
        this.left = createRotor(left);
        this.middle = createRotor(middle);
        this.right = createRotor(right);
        this.reflector = createReflector(reflector);
        this.plugboard = new Plugboard(plugboard);
    }

    private Rotor createRotor(String type) {
        return switch (type) {
            case "I" -> new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'R');
            case "II" -> new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'F');
            case "III" -> new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'W');
            case "IV" -> new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", 'K');
            case "V" -> new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", 'A');
            default -> throw new IllegalArgumentException("Invalid rotor type");
        };
    }

    private Reflector createReflector(String type) {
        return switch (type) {
            case "B" -> new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");
            case "C" -> new Reflector("FVPJIAOYEDRZXWGCTKUQSBNMHL");
            default -> throw new IllegalArgumentException("Invalid reflector type");
        };
    }

    public void setRotors(int left, int middle, int right) {
        this.left.setPosition(left);
        this.middle.setPosition(middle);
        this.right.setPosition(right);
    }

    public void setRingSettings(int left, int middle, int right) {
        this.left.setRingSetting(left);
        this.middle.setRingSetting(middle);
        this.right.setRingSetting(right);
    }

    public void rotate() {
        if (middle.atNotch()) {
            middle.step();
            left.step();
        } else if (right.atNotch()) {
            middle.step();
        }
        right.step();
    }

    public char encodeDecode(char c) {
        if (c < 'A' || c > 'Z') {
            return ' ';
        }
        rotate();

        //Plugboard in
        char signal = plugboard.encode(c);

        //Right to Left
        char s1 = right.encodeForward(signal);
        char s2 = middle.encodeForward(s1);
        char s3 = left.encodeForward(s2);

        //Reflector
        char s4 = reflector.encode(s3);

        //Left to Right
        char s5 = left.encodeBackward(s4);
        char s6 = middle.encodeBackward(s5);
        char s7 = right.encodeBackward(s6);

        //Plugboard out
        return plugboard.encode(s7);
    }
}
