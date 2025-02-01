package com.example.javafxpasswordgenerator.controllers;

import com.example.javafxpasswordgenerator.logic.PasswordGenerator;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;


public class MainController {
    public CheckBox upperCaseCheckBox;
    public CheckBox lowerCaseCheckBox;
    public CheckBox numbersCheckBox;
    public CheckBox specialsCheckBox;
    public CheckBox excludedChars;
    public Label passwordOutputLabel;
    private PasswordGenerator passwordGenerator;
    @FXML
    public Button generatePasswordButton;
    @FXML
    public TextField passwordTextField;
    public Spinner<Integer> passwordLengthSpinner;
    public Clipboard clipboard;
    public ClipboardContent content;

    @FXML
    public void initialize() {
        passwordGenerator = new PasswordGenerator();
        passwordOutputLabel.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        passwordLengthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 10));
        setupBindings();

        clipboard = Clipboard.getSystemClipboard();
        content = new ClipboardContent();
        passwordTextField = new TextField();

        passwordOutputLabel.setOnMouseClicked(event -> {
            content.putString(passwordOutputLabel.getText());
            clipboard.setContent(content);
        });
    }

    @FXML
    private void setupBindings() {
        // Bind checkBoxes
        upperCaseCheckBox.selectedProperty().bindBidirectional(passwordGenerator.upperCaseFlagProperty());
        lowerCaseCheckBox.selectedProperty().bindBidirectional(passwordGenerator.lowerCaseFlagProperty());
        numbersCheckBox.selectedProperty().bindBidirectional(passwordGenerator.numbersFlagProperty());
        specialsCheckBox.selectedProperty().bindBidirectional(passwordGenerator.specialFlagProperty());
        excludedChars.selectedProperty().bindBidirectional(passwordGenerator.removeSimilarFlagProperty());

        // Add listener for password length spinner
        passwordLengthSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.equals(oldValue)) {
                passwordGenerator.getPasswordLengthProperty().setValue(newValue);
            }
        });


    }

    @FXML
    protected void onGeneratePasswordButtonClick() {
        passwordOutputLabel.setText(passwordGenerator.generate());
    }


}