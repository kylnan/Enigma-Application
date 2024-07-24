package com.kylnan;
import com.kylnan.enigma.Enigma;
import javafx.application.Application;

public class Main {
    public static void main(String[] args) {
        Application.launch(com.kylnan.GUI.class, args);

        // Enigma Testing for encapsulation
        Enigma enigma = new Enigma("I", "II", "III", "B", "");

        enigma.setRotors(0, 0, 0);

        String message = "HELLO world".toUpperCase();
        StringBuilder encoded = new StringBuilder();

        for (char c : message.toCharArray()) {
            encoded.append(enigma.encodeDecode(c));
        }

        System.out.println(STR."Encoded message: \{encoded.toString()}");

        enigma.setRotors(0, 0, 0);

        String encodedString = encoded.toString();
        StringBuilder decoded = new StringBuilder();

        for (char c : encodedString.toCharArray()) {
            decoded.append(enigma.encodeDecode(c));
        }
        System.out.println(STR."Decoded message: \{decoded.toString()}");
    }
}
