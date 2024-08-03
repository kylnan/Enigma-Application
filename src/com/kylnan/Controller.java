package com.kylnan;

import com.kylnan.enigma.Enigma;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    private TextField inputField;

    @FXML
    private TextArea outputArea;

    @FXML
    private AnchorPane lampPane;

    @FXML
    private ChoiceBox<String> ringSetting1;
    @FXML
    private ChoiceBox<String> ringSetting2;
    @FXML
    private ChoiceBox<String> ringSetting3;

    @FXML
    private ChoiceBox<String> rotorPosition1;
    @FXML
    private ChoiceBox<String> rotorPosition2;
    @FXML
    private ChoiceBox<String> rotorPosition3;

    private String[] ringPositions = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"};

    @FXML
    private Label lampQ;
    @FXML
    private Label lampW;
    @FXML
    private Label lampE;
    @FXML
    private Label lampR;
    @FXML
    private Label lampT;
    @FXML
    private Label lampY;
    @FXML
    private Label lampU;
    @FXML
    private Label lampI;
    @FXML
    private Label lampO;
    @FXML
    private Label lampP;
    @FXML
    private Label lampA;
    @FXML
    private Label lampS;
    @FXML
    private Label lampD;
    @FXML
    private Label lampF;
    @FXML
    private Label lampG;
    @FXML
    private Label lampH;
    @FXML
    private Label lampJ;
    @FXML
    private Label lampK;
    @FXML
    private Label lampL;
    @FXML
    private Label lampZ;
    @FXML
    private Label lampX;
    @FXML
    private Label lampC;
    @FXML
    private Label lampV;
    @FXML
    private Label lampB;
    @FXML
    private Label lampN;
    @FXML
    private Label lampM;

    private Enigma enigma;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        enigma = new Enigma();

        // Key press handling
        inputField.setOnKeyTyped(event -> {
            String character = event.getCharacter();
            if (character.matches("[a-zA-Z]")) {
                processInput(character.toUpperCase().charAt(0));
            }
            else{
                outputArea.appendText(character);
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

        // initial reset
        reset();
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

            enigma.setRotors(left, mid, right);
        } catch (Exception ex){
            System.out.println("Null String");
        }

    }
}