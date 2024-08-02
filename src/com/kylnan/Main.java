package com.kylnan;
import com.kylnan.enigma.Enigma;
import javafx.application.Application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Application.launch(com.kylnan.GUI.class, args);

        /* Enigma Testing for encapsulation
        Enigma enigma = new Enigma("II", "IV", "V", "B", "bq cr di ej kw mt os px uz gh".toUpperCase());
        int[] positions = {1,17,12};
        int[] ringSettings = {0,0,0};
        enigma.setRotors(positions[0], positions[1], positions[2]);
        enigma.setRingSettings(ringSettings[0], ringSettings[1], ringSettings[2]);

        Scanner userInput = new Scanner(System.in);
        System.out.print("Plaintext: ");
        String message = userInput.nextLine().toUpperCase();
        StringBuilder encoded = new StringBuilder();

        for (char c : message.toCharArray()) {
            encoded.append(enigma.encodeDecode(c));
        }

        System.out.println("Encoded Message: " + encoded);

        enigma.setRotors(positions[0], positions[1], positions[2]);

        String encodedString = encoded.toString();
        StringBuilder decoded = new StringBuilder();

        for (char c : encodedString.toCharArray()) {
            decoded.append(enigma.encodeDecode(c));
        }
        System.out.println("Decoded Message: " + decoded);
         */
    }
}
