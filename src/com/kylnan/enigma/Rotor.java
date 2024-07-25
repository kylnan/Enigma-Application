package com.kylnan.enigma;

public class Rotor {
    private final String wiring;
    private int position;
    private int ringSetting;
    private final char notch;

    public Rotor(String wiring, char notch) {
        this.wiring = wiring;
        this.notch = notch;
        this.position = 0;
        this.ringSetting = 0;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setRingSetting(int ringSetting) {
        this.ringSetting = ringSetting;
    }

    public boolean atNotch() {
        return (wiring.charAt(position) == notch);
    }

    public void step() {
        position = (position + 1) % 26;
    }


    public char encodeForward(char c) {
        int shiftAmount = position - ringSetting;
        char shiftedIn = shift(c, shiftAmount);
        char encoded = wiring.charAt(shiftedIn - 'A');
        return shift(encoded, -shiftAmount);
    }

    public char encodeBackward(char c) {
        int shiftAmount = position - ringSetting;
        char shiftedIn = shift(c, shiftAmount);
        char encoded = (char)(wiring.indexOf(shiftedIn) + 'A');
        return shift(encoded, -shiftAmount);
    }

    private char shift(char c, int amount) {
        int shifted = (c - 'A' + amount) % 26;
        if (shifted < 0) {
            shifted += 26;
        }
        return (char) ('A' + shifted);
    }
}
