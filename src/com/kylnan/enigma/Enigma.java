package com.kylnan.enigma;

public class Enigma {
    private Rotor left;
    private Rotor middle;
    private Rotor right;
    private final Reflector reflector;
    private final Plugboard plugboard;

    public Enigma(String left, String middle, String right, String reflector, String plugboard) {
        this.left = createRotor(left);
        this.middle = createRotor(middle);
        this.right = createRotor(right);
        this.reflector = createReflector(reflector);
        this.plugboard = new Plugboard(plugboard);
    }

    private Rotor createRotor(String type) {
        switch(type) {
            case "I": return new Rotor("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 'R');
            case "II": return new Rotor("AJDKSIRUXBLHWTMCQGZNPYFVOE", 'F');
            case "III": return new Rotor("BDFHJLCPRTXVZNYEIWGAKMUSQO", 'W');
            case "IV": return new Rotor("ESOVPZJAYQUIRHXLNFTGKDCMWB", 'K');
            case "V": return new Rotor("VZBRGITYUPSDNHLXAWMJQOFECK", 'A');
            default: throw new IllegalArgumentException("Invalid rotor type: " + type);
        }
    }

    private Reflector createReflector(String type) {
        switch(type) {
            case "B": return new Reflector("YRUHQSLDPXNGOKMIEBFZCWVJAT");
            case "C": return new Reflector("FVPJIAOYEDRZXWGCTKUQSBNMHL");
            default: throw new IllegalArgumentException("Invalid reflector type: " + type);
        }
    }

    public void setRotors(int left, int middle, int right) {
        this.left.setPosition(left);
        this.middle.setPosition(middle);
        this.right.setPosition(right);
    }

    private void rotate() {
        if (this.middle.atNotch()) {
            this.middle.step();
            this.left.step();
        } else if (this.right.atNotch()) {
            this.middle.step();
        }
        this.right.step();
    }

    public char encodeDecode(char c) {
        if (c < 'A' || c > 'Z') {
            return ' ';
        }
        rotate();

        // Plugboard in
        char signal = this.plugboard.encode(c);

        // Right to left encoding
        char s1 = this.right.encodeForward(signal);
        char s2 = this.middle.encodeForward(s1);
        char s3 = this.left.encodeForward(s2);

        // Through reflector
        char s4 = this.reflector.encode(s3);

        // Left to right encoding
        char s5 = this.left.encodeBackward(s4);
        char s6 = this.middle.encodeBackward(s5);
        char s7 = this.right.encodeBackward(s6);

        // Plugboard out
        return this.plugboard.encode(s7);
    }
}
