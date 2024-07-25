package com.kylnan.enigma;

import java.util.HashMap;

public class Plugboard {
    // Using hashmap because pairings are unique
    private final HashMap<Character, Character> settings = new HashMap<>();

    public Plugboard(String wires) {
        // Split up the string by spaces, gives the pairs
        String[] pairs = wires.split(" ");
        for (String pair : pairs) {
            if (pair.isEmpty()) {
                break;
            }
            char a = pair.charAt(0);
            char b = pair.charAt(1);
            // Used for encoding forward
            settings.put(a, b);
            // Used for encoding backward
            settings.put(b, a);
        }
    }

    // Check if there is a key with a value, if there is no key then return input itself
    public char encode(char input) {
        return settings.getOrDefault(input, input);
    }
}
