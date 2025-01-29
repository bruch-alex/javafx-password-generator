module com.example.javafxpasswordgenerator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxpasswordgenerator to javafx.fxml;
    exports com.example.javafxpasswordgenerator;
    exports com.example.javafxpasswordgenerator.controllers;
    opens com.example.javafxpasswordgenerator.controllers to javafx.fxml;
}