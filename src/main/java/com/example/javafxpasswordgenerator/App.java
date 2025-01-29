package com.example.javafxpasswordgenerator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
        Scene scene = new Scene(fxmlLoader.load(), 1000, 800);

        // apply saved theme
        stage.setScene(scene);
        stage.show();
    }

}