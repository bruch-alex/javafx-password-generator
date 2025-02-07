package com.example.javafxpasswordgenerator;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static Stage primaryStage;

    public void run() {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        App.primaryStage = stage;
        App.primaryStage.setTitle("Tiny Generator");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),300,420);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}