package com.example.javafxpasswordgenerator.controllers;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;


public class PassphraseGeneratorController {
    @FXML
    private Spinner<Integer> passphraseLengthSpinner;
    @FXML
    private Label passphraseOutputLabel;
    @FXML
    private ChoiceBox<String> lettersChoiceBox = new ChoiceBox<>();
    @FXML
    private CheckBox numbersCheckBox;
    @FXML
    private CheckBox specialsCheckBox;

    @FXML
    public void initialize() {
        lettersChoiceBox.getItems().addAll("all lowercase", "Capitalized", "ALL UPPERCASE");
        lettersChoiceBox.getSelectionModel().selectFirst();

        passphraseOutputLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        passphraseLengthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 300, 10));
        bindCheckBoxes();
        setupListeners();
        passphraseOutputLabel.setOnMouseClicked(event -> TabPaneController.copyPassword(passphraseOutputLabel.getText()));
    }
    @FXML
    private void bindCheckBoxes() {

    }

    @FXML
    private void setupListeners() {

    }

}
