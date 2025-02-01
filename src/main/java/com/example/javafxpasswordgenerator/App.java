package com.example.javafxpasswordgenerator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static Stage primaryStage;

    public void run() {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        App.primaryStage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 400);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}