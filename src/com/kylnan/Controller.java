package com.kylnan;

import com.kylnan.enigma.Enigma;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private TextField inputField;

    @FXML
    private TextArea outputArea;

    @FXML
    private AnchorPane lampPane;

    @FXML
    private ChoiceBox<String> ringSetting1, ringSetting2, ringSetting3, rotorPosition1, rotorPosition2, rotorPosition3, rotorOption1, rotorOption2, rotorOption3, reflectorOption;

    @FXML
    private Label rotorDisplay1, rotorDisplay2, rotorDisplay3;

    private final String[] ringPositions = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"};
    private final String[] rotorOptions = {"I", "II", "III", "IV", "V"};
    private final String[] reflectorOptions = {"B", "C"};

    @FXML
    private Label lampQ, lampW, lampE, lampR, lampT, lampY, lampU, lampI, lampO, lampP,
            lampA, lampS, lampD, lampF, lampG, lampH, lampJ, lampK, lampL, lampZ,
            lampX, lampC, lampV, lampB, lampN, lampM;

    @FXML
    private ToggleButton plugA, plugB, plugC, plugD, plugE, plugF, plugG, plugH, plugI, plugJ,
            plugK, plugL, plugM, plugN, plugO, plugP, plugQ, plugR, plugS, plugT,
            plugU, plugV, plugW, plugX, plugY, plugZ;

    private List<ToggleButton> selectedPlugs = new ArrayList<>();

    private Enigma enigma;
    private boolean[] keyPressed = new boolean[256];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        enigma = new Enigma();

        // initial reset
        reset();
        // Key press handling
        inputField.setOnKeyTyped(event -> event.consume());

        inputField.addEventFilter(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode keyCode = event.getCode();
                String character = event.getText().toUpperCase();

                if (character.matches("[A-Z]") && !keyPressed[keyCode.getCode()]) {
                    keyPressed[keyCode.getCode()] = true;
                    processInput(character.charAt(0));
                    event.consume();
                } else if (keyCode == KeyCode.SPACE && !keyPressed[keyCode.getCode()]) {
                    keyPressed[keyCode.getCode()] = true;
                    outputArea.appendText(character);
                    event.consume();
                }
            }
        });

        inputField.addEventFilter(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode keyCode = event.getCode();
                String character = event.getText().toUpperCase();

                if (character.matches("[A-Z]") || keyCode == KeyCode.SPACE) {
                    keyPressed[keyCode.getCode()] = false;
                    displayRotors();
                    resetLampboard();
                    event.consume();
                }
            }
        });


        // ring settings
        ringSetting1.getItems().addAll(ringPositions);
        ringSetting1.setOnAction(this::ringSettings);

        ringSetting2.getItems().addAll(ringPositions);
        ringSetting2.setOnAction(this::ringSettings);

        ringSetting3.getItems().addAll(ringPositions);
        ringSetting3.setOnAction(this::ringSettings);

        rotorPosition1.getItems().addAll(ringPositions);
        rotorPosition1.setOnAction(this::rotorPositions);

        rotorPosition2.getItems().addAll(ringPositions);
        rotorPosition2.setOnAction(this::rotorPositions);

        rotorPosition3.getItems().addAll(ringPositions);
        rotorPosition3.setOnAction(this::rotorPositions);

        // change rotors
        rotorOption1.getItems().addAll(rotorOptions);
        rotorOption1.setOnAction(this::changeRotors);

        rotorOption2.getItems().addAll(rotorOptions);
        rotorOption2.setOnAction(this::changeRotors);

        rotorOption3.getItems().addAll(rotorOptions);
        rotorOption3.setOnAction(this::changeRotors);

        // change reflector
        reflectorOption.getItems().addAll(reflectorOptions);
        reflectorOption.setOnAction(this::changeReflector);


    }

    private void processInput(char character) {
        char encodedCharacter = enigma.encodeDecode(character);

        updateLampboard(encodedCharacter);
        appendToOutput(encodedCharacter);
    }

    private void updateLampboard(char character) {
        resetLampboard();
        switch (character) {
            case 'Q':
                lampQ.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'W':
                lampW.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'E':
                lampE.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'R':
                lampR.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'T':
                lampT.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'Y':
                lampY.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'U':
                lampU.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'I':
                lampI.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'O':
                lampO.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'P':
                lampP.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'A':
                lampA.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'S':
                lampS.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'D':
                lampD.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'F':
                lampF.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'G':
                lampG.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'H':
                lampH.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'J':
                lampJ.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'K':
                lampK.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'L':
                lampL.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'Z':
                lampZ.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'X':
                lampX.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'C':
                lampC.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'V':
                lampV.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'B':
                lampB.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'N':
                lampN.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
            case 'M':
                lampM.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                break;
        }
    }

    private void resetLampboard() {
        // Reset all lamps to default color (or transparent)
        String defaultColor = "-fx-background-color: transparent;";
        lampQ.setStyle(defaultColor);
        lampW.setStyle(defaultColor);
        lampE.setStyle(defaultColor);
        lampR.setStyle(defaultColor);
        lampT.setStyle(defaultColor);
        lampY.setStyle(defaultColor);
        lampU.setStyle(defaultColor);
        lampI.setStyle(defaultColor);
        lampO.setStyle(defaultColor);
        lampP.setStyle(defaultColor);
        lampA.setStyle(defaultColor);
        lampS.setStyle(defaultColor);
        lampD.setStyle(defaultColor);
        lampF.setStyle(defaultColor);
        lampG.setStyle(defaultColor);
        lampH.setStyle(defaultColor);
        lampJ.setStyle(defaultColor);
        lampK.setStyle(defaultColor);
        lampL.setStyle(defaultColor);
        lampZ.setStyle(defaultColor);
        lampX.setStyle(defaultColor);
        lampC.setStyle(defaultColor);
        lampV.setStyle(defaultColor);
        lampB.setStyle(defaultColor);
        lampN.setStyle(defaultColor);
        lampM.setStyle(defaultColor);
    }

    private void appendToOutput(char encodedCharacter) {
        outputArea.appendText(String.valueOf(encodedCharacter));
    }

    public void clearOutput(ActionEvent e){
        outputArea.clear();
        inputField.clear();
        resetLampboard();
    }

    public void reset(ActionEvent e){
        enigma.setRotors(0, 0 ,0);
        enigma.setRingSettings(0, 0, 0);

        ringSetting1.setValue("1");
        ringSetting2.setValue("1");
        ringSetting3.setValue("1");

        rotorPosition1.setValue("1");
        rotorPosition2.setValue("1");
        rotorPosition3.setValue("1");

        rotorDisplay1.setText("1");
        rotorDisplay2.setText("1");
        rotorDisplay3.setText("1");

        rotorOption1.setValue("I");
        rotorOption2.setValue("II");
        rotorOption3.setValue("III");

        reflectorOption.setValue("B");

    }

    public void reset(){
        enigma.setRotors(0, 0 ,0);
        enigma.setRingSettings(0, 0, 0);

        ringSetting1.setValue("1");
        ringSetting2.setValue("1");
        ringSetting3.setValue("1");

        rotorPosition1.setValue("1");
        rotorPosition2.setValue("1");
        rotorPosition3.setValue("1");

        rotorOption1.setValue("I");
        rotorOption2.setValue("II");
        rotorOption3.setValue("III");

        reflectorOption.setValue("B");

        rotorDisplay1.setText("1");
        rotorDisplay2.setText("1");
        rotorDisplay3.setText("1");
    }

    public void ringSettings(ActionEvent e){
        try{
            String leftString = ringSetting1.getValue();
            int left = Integer.parseInt(leftString) - 1;

            String midString = ringSetting2.getValue();
            int mid = Integer.parseInt(midString) - 1;

            String rightString = ringSetting3.getValue();
            int right = Integer.parseInt(rightString) - 1;

            enigma.setRingSettings(left, mid, right);
        } catch (Exception ex){
            System.out.println("Null String");
        }


    }

    public void rotorPositions(ActionEvent e){
        try{
            String leftString = rotorPosition1.getValue();
            int left = Integer.parseInt(leftString) - 1;

            String midString = rotorPosition2.getValue();
            int mid = Integer.parseInt(midString) - 1;

            String rightString = rotorPosition3.getValue();
            int right = Integer.parseInt(rightString) - 1;

            rotorDisplay1.setText(leftString);
            rotorDisplay2.setText(midString);
            rotorDisplay3.setText(rightString);
            enigma.setRotors(left, mid, right);
        } catch (Exception ex){
            System.out.println("Null String");
        }
    }

    public void changeRotors(ActionEvent e){
        String typeL = String.valueOf(rotorOption1.getValue());
        String typeM = String.valueOf(rotorOption2.getValue());
        String typeR = String.valueOf(rotorOption3.getValue());
        enigma.changeRotor("left", typeL);
        enigma.changeRotor("middle", typeM);
        enigma.changeRotor("right", typeR);
    }

    public void changeReflector(ActionEvent e){
        enigma.changeReflector(String.valueOf(reflectorOption.getValue()));
    }

    public void displayRotors(){
        String left = String.valueOf(enigma.left.getPosition() + 1);
        String right = String.valueOf(enigma.right.getPosition() + 1);
        String middle = String.valueOf(enigma.middle.getPosition() + 1);

        rotorDisplay1.setText(left);
        rotorDisplay2.setText(middle);
        rotorDisplay3.setText(right);
    }

}