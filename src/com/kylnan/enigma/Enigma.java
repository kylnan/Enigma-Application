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

    public Enigma() {
        this.left = createRotor("I");
        this.middle = createRotor("II");
        this.right = createRotor("III");
        this.reflector = createReflector("B");
        this.plugboard = new Plugboard("");
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
    public void setPlugboard(String wiring) {
        this.plugboard = new Plugboard(wiring);
    }
    public void setReflector(Reflector reflector) {
        this.reflector = reflector;
    }
    public void changeReflector(String type){
        this.reflector = createReflector(type);
    }
    public void setRotors(int left, int middle, int right) {
        this.left.setPosition(left);
        this.middle.setPosition(middle);
        this.right.setPosition(right);
    }
    public void changeRotor(String wheel, String type){
        switch (wheel){
            case "left" -> this.left = createRotor(type);
            case "middle" -> this.middle = createRotor(type);
            case "right" -> this.right = createRotor(type);
        }
    }
    public void setRingSettings(int left, int middle, int right) {
        this.left.setRingSetting(left);
        this.middle.setRingSetting(middle);
        this.right.setRingSetting(right);
    }

    public void rotate() {
        // Double stepping
        if (middle.atNotch()) {
            middle.step();
            left.step();
        } else if (right.atNotch()) {
            middle.step();
        }

        // Stepping regardless
        right.step();
    }

    public Plugboard getPlugboard(){
        return this.plugboard;
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
