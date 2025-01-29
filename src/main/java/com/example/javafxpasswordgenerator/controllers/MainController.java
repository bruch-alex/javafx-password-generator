package com.example.javafxpasswordgenerator.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class MainController {
    public Button generatePasswordButton;
    @FXML
    private Label welcomeText;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Slider passwordLengthSlider;

    @FXML
    protected void onGeneratePasswordButtonClick() {
        passwordLengthSlider.setMin(4);
        passwordLengthSlider.setMax(100);
        passwordLengthSlider.setShowTickLabels(true);
        passwordTextField.setText(String.valueOf(passwordLengthSlider.getValue()));
    }


}