package com.example.javafxpasswordgenerator.controllers;

import com.example.javafxpasswordgenerator.logic.Generator;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class MainController {
    public CheckBox upperCaseCheckBox;
    public CheckBox lowerCaseCheckBox;
    public CheckBox numbersCheckBox;
    public CheckBox specialsCheckBox;
    public CheckBox excludedChars;
    private Generator generator;
    @FXML
    public Button generatePasswordButton;
    @FXML
    public TextField passwordTextField;
    public Spinner<Integer> passwordLengthSpinner;
    public Button copyButton;

    @FXML
    public void initialize() {
        generator = new Generator();
        //passwordLengthSpinner = new Spinner<>();
        passwordLengthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 10));
        setupBindings();
    }

    @FXML
    private void setupBindings() {
        upperCaseCheckBox.selectedProperty().bindBidirectional(generator.upperCaseFlagProperty());
        lowerCaseCheckBox.selectedProperty().bindBidirectional(generator.lowerCaseFlagProperty());
        numbersCheckBox.selectedProperty().bindBidirectional(generator.numbersFlagProperty());
        specialsCheckBox.selectedProperty().bindBidirectional(generator.specialFlagProperty());
        excludedChars.selectedProperty().bindBidirectional(generator.removeSimilarFlagProperty());
        passwordLengthSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.equals(oldValue)) {
                generator.getPasswordLengthProperty().setValue(newValue);
            }
        });
    }

    @FXML
    protected void onGeneratePasswordButtonClick() {
        passwordTextField.setText(generator.generatePassword());
    }

}