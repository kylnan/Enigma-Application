package com.kylnan;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import com.kylnan.enigma.Enigma;

public class GUI extends Application {

    private Enigma enigma;

    @Override
    public void start(Stage primaryStage) {
        // Initialize Enigma machine with rotors and reflector
        enigma = new Enigma("I", "II", "III", "B", "AZ BY CX");
        enigma.setRotors(0, 0, 0);

        // Create UI components
        Label inputLabel = new Label("Input:");
        TextField inputField = new TextField();
        Label outputLabel = new Label("Output:");
        TextField outputField = new TextField();
        outputField.setEditable(false);
        Button encodeButton = new Button("Encode");

        // Rotor position labels and ComboBoxes
        Label leftRotorLabel = new Label("Left Rotor Position:");
        ComboBox<Character> leftRotorComboBox = createRotorComboBox();
        Label middleRotorLabel = new Label("Middle Rotor Position:");
        ComboBox<Character> middleRotorComboBox = createRotorComboBox();
        Label rightRotorLabel = new Label("Right Rotor Position:");
        ComboBox<Character> rightRotorComboBox = createRotorComboBox();

        // Buttons to set rotor positions
        Button setRotorsButton = new Button("Set Rotors");

        // Set button action
        encodeButton.setOnAction(e -> {
            String inputText = inputField.getText().toUpperCase();
            StringBuilder encodedText = new StringBuilder();
            for (char c : inputText.toCharArray()) {
                encodedText.append(enigma.encodeDecode(c));
            }
            outputField.setText(encodedText.toString());
        });

        // Set rotors button action
        setRotorsButton.setOnAction(e -> {
            int leftPosition = leftRotorComboBox.getValue() - 'A';
            int middlePosition = middleRotorComboBox.getValue() - 'A';
            int rightPosition = rightRotorComboBox.getValue() - 'A';
            enigma.setRotors(leftPosition, middlePosition, rightPosition);
        });

        // Layout the UI components
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.add(inputLabel, 0, 0);
        grid.add(inputField, 1, 0);
        grid.add(encodeButton, 1, 1);
        grid.add(outputLabel, 0, 2);
        grid.add(outputField, 1, 2);
        grid.add(leftRotorLabel, 0, 3);
        grid.add(leftRotorComboBox, 1, 3);
        grid.add(middleRotorLabel, 0, 4);
        grid.add(middleRotorComboBox, 1, 4);
        grid.add(rightRotorLabel, 0, 5);
        grid.add(rightRotorComboBox, 1, 5);
        grid.add(setRotorsButton, 1, 6);

        // Create the scene and set the stage
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Enigma Machine");
        primaryStage.show();
    }

    private ComboBox<Character> createRotorComboBox() {
        ComboBox<Character> comboBox = new ComboBox<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            comboBox.getItems().add(c);
        }
        comboBox.setValue('A'); // Set default value
        return comboBox;
    }

}
