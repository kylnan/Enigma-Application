package com.kylnan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import com.kylnan.enigma.Enigma;

public class GUI extends Application {

    private Enigma enigma;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("layout.fxml"));
        Scene scene = new Scene(root, 1280, 720);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);

        // must always be at the end
        stage.setTitle("Enigma by Kylnan");
        stage.setScene(scene);
        stage.show();
    }

}
