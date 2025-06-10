package com.uniclinica.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Ponto de entrada da interface gráfica JavaFX.
 */
public class JavaFXApp extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("UniClinicaVet - JavaFX");
        Scene scene = new Scene(label, 400, 200);
        stage.setTitle("UniClinicaVet");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
