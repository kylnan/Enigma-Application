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

    public int getPosition(){
        return this.position;
    }


    public char encodeForward(char c) {
        // Calculate shift amount, basically the offset for the mapping for given orientation of the rotor
        int shiftAmount = position - ringSetting;
        // Convert the mapping from int to a char i.e. shift input to rotor position
        char mapping = shift(c, shiftAmount);
        // Find the encoding for the given mapping calculated
        char encoded = wiring.charAt(mapping - 'A');
        // Revert the shift back
        // Each rotor needs to refer to the standard alphabet for encoding, this is why we shift back
        char output = shift(encoded, -shiftAmount);
        return output;
    }

    public char encodeBackward(char c) {
        // Same as encodeForward
        int shiftAmount = position - ringSetting;
        // Same as encodeForward
        char mapping = shift(c, shiftAmount);
        // Instead of finding mapped character in wiring, find the character in the original alphabet
        char encoded = (char)(wiring.indexOf(mapping) + 'A');
        // Same as encodeForward
        return shift(encoded, -shiftAmount);
    }

    private char shift(char c, int amount) {
        // Convert to original index and shift it by the amount, use % 26 to make sure it stays in range 1-26
        int shifted = (c - 'A' + amount) % 26;
        // Ensure non-negative result
        if (shifted < 0) {
            shifted += 26;
        }
        return (char) ('A' + shifted);
    }
}
