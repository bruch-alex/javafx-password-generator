package com.example.javafxpasswordgenerator.controllers;

import com.example.javafxpasswordgenerator.logic.PasswordGenerator;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;


public class PasswordGeneratorController {
    // UI elements
    @FXML
    private CheckBox upperCaseCheckBox;
    @FXML
    private CheckBox lowerCaseCheckBox;
    @FXML
    private CheckBox numbersCheckBox;
    @FXML
    private CheckBox specialsCheckBox;
    @FXML
    private CheckBox excludedChars;
    @FXML
    private Label passwordOutputLabel;
    @FXML
    private Spinner<Integer> passwordLengthSpinner;

    private final PasswordGenerator passwordGenerator = new PasswordGenerator();


    @FXML
    public void initialize() {
        passwordOutputLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        passwordLengthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 300, 10));
        bindCheckBoxes();
        setupListeners();

        passwordOutputLabel.setOnMouseClicked(event -> TabPaneController.copyPassword(passwordOutputLabel.getText()));
    }

    @FXML
    private void bindCheckBoxes() {
        // Bind checkBoxes
        upperCaseCheckBox.selectedProperty().bindBidirectional(passwordGenerator.upperCaseFlagProperty());
        lowerCaseCheckBox.selectedProperty().bindBidirectional(passwordGenerator.lowerCaseFlagProperty());
        numbersCheckBox.selectedProperty().bindBidirectional(passwordGenerator.numbersFlagProperty());
        specialsCheckBox.selectedProperty().bindBidirectional(passwordGenerator.specialFlagProperty());
        excludedChars.selectedProperty().bindBidirectional(passwordGenerator.removeSimilarFlagProperty());
    }

    @FXML
    private void setupListeners() {
        // Add listener for password length spinner
        passwordLengthSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            passwordGenerator.getPasswordLengthProperty().setValue(newValue);
        });
    }

    @FXML
    private void onGeneratePasswordButtonClick() {
        passwordOutputLabel.setText(passwordGenerator.generatePassword());
    }
}