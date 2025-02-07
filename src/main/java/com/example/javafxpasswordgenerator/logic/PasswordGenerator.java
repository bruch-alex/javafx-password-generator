package com.example.javafxpasswordgenerator.logic;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

public class PasswordGenerator extends Generator{
    //CharSets
    private final Set<Integer> lowerCaseDecimal = Set.of(97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122);
    private final Set<Integer> upperCaseDecimal = Set.of(65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90);

    // Flags for charSets
    private final BooleanProperty lowerCaseFlagProperty;
    private final BooleanProperty upperCaseFlagProperty;

    // Generator properties
    private final IntegerProperty passwordLengthProperty;
    private final ArrayList<Integer> finalSet;
    private final Random random = new Random();

    public PasswordGenerator() {
        this.lowerCaseFlagProperty = new SimpleBooleanProperty(true);
        this.upperCaseFlagProperty = new SimpleBooleanProperty(true);
        this.numbersFlagProperty = new SimpleBooleanProperty(true);
        this.specialFlagProperty = new SimpleBooleanProperty(false);
        this.removeSimilarFlagProperty = new SimpleBooleanProperty(false);
        this.passwordLengthProperty = new SimpleIntegerProperty(10);
        this.finalSet = new ArrayList<>();
    }

    private void updateFinalCharSet() {
        if (lowerCaseFlagProperty.get()) finalSet.addAll(lowerCaseDecimal);
        else finalSet.removeAll(lowerCaseDecimal);

        if (upperCaseFlagProperty.get()) finalSet.addAll(upperCaseDecimal);
        else finalSet.removeAll(upperCaseDecimal);

        if (numbersFlagProperty.get()) finalSet.addAll(this.numbersDecimal);
        else finalSet.removeAll(numbersDecimal);

        if (specialFlagProperty.get()) finalSet.addAll(specialsDecimal);
        else finalSet.removeAll(specialsDecimal);

        if (removeSimilarFlagProperty.get()) finalSet.removeAll(similarCharsDecimal);
    }

    public IntegerProperty getPasswordLengthProperty() {
        return passwordLengthProperty;
    }

    public BooleanProperty lowerCaseFlagProperty() {
        return lowerCaseFlagProperty;
    }

    public BooleanProperty upperCaseFlagProperty() {
        return upperCaseFlagProperty;
    }

    public BooleanProperty numbersFlagProperty() {
        return numbersFlagProperty;
    }

    public BooleanProperty specialFlagProperty() {
        return specialFlagProperty;
    }

    public BooleanProperty removeSimilarFlagProperty() {
        return removeSimilarFlagProperty;
    }

    public String generatePassword() {
        updateFinalCharSet();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLengthProperty.get(); i++) {
            password.append((char) (int) finalSet.get(random.nextInt(1, finalSet.size())));
        }
        return password.toString();
    }
}
