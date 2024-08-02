package com.kylnan;

import com.kylnan.enigma.Enigma;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;



public class Controller {
    @FXML
    private TextField inputField;

    @FXML
    private TextArea outputArea;

    @FXML
    private AnchorPane lampPane;

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

    @FXML
    public void initialize() {
        enigma = new Enigma();

        inputField.setOnKeyTyped(event -> {
            String character = event.getCharacter();
            if (character.matches("[a-zA-Z]")) {
                processInput(character.toUpperCase().charAt(0));
            }
        });
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
                lampQ.setStyle("-fx-background-color: yellow;");
                break;
            case 'W':
                lampW.setStyle("-fx-background-color: yellow;");
                break;
            case 'E':
                lampE.setStyle("-fx-background-color: yellow;");
                break;
            case 'R':
                lampR.setStyle("-fx-background-color: yellow;");
                break;
            case 'T':
                lampT.setStyle("-fx-background-color: yellow;");
                break;
            case 'Y':
                lampY.setStyle("-fx-background-color: yellow;");
                break;
            case 'U':
                lampU.setStyle("-fx-background-color: yellow;");
                break;
            case 'I':
                lampI.setStyle("-fx-background-color: yellow;");
                break;
            case 'O':
                lampO.setStyle("-fx-background-color: yellow;");
                break;
            case 'P':
                lampP.setStyle("-fx-background-color: yellow;");
                break;
            case 'A':
                lampA.setStyle("-fx-background-color: yellow;");
                break;
            case 'S':
                lampS.setStyle("-fx-background-color: yellow;");
                break;
            case 'D':
                lampD.setStyle("-fx-background-color: yellow;");
                break;
            case 'F':
                lampF.setStyle("-fx-background-color: yellow;");
                break;
            case 'G':
                lampG.setStyle("-fx-background-color: yellow;");
                break;
            case 'H':
                lampH.setStyle("-fx-background-color: yellow;");
                break;
            case 'J':
                lampJ.setStyle("-fx-background-color: yellow;");
                break;
            case 'K':
                lampK.setStyle("-fx-background-color: yellow;");
                break;
            case 'L':
                lampL.setStyle("-fx-background-color: yellow;");
                break;
            case 'Z':
                lampZ.setStyle("-fx-background-color: yellow;");
                break;
            case 'X':
                lampX.setStyle("-fx-background-color: yellow;");
                break;
            case 'C':
                lampC.setStyle("-fx-background-color: yellow;");
                break;
            case 'V':
                lampV.setStyle("-fx-background-color: yellow;");
                break;
            case 'B':
                lampB.setStyle("-fx-background-color: yellow;");
                break;
            case 'N':
                lampN.setStyle("-fx-background-color: yellow;");
                break;
            case 'M':
                lampM.setStyle("-fx-background-color: yellow;");
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
    }

    public void reset(ActionEvent e){
        enigma.setRotors(0, 0 ,0);
        enigma.setRingSettings(0, 0, 0);
    }
}