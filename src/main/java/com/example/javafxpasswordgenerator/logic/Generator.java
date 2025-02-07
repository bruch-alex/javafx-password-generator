package com.example.javafxpasswordgenerator.logic;

import javafx.beans.property.BooleanProperty;

import java.util.Set;

public abstract class Generator {
    protected final Set<Integer> numbersDecimal = Set.of(48, 49, 50, 51, 52, 53, 54, 55, 56, 57);
    protected final Set<Integer> specialsDecimal = Set.of(33, 34, 35, 36, 37, 38, 39);
    protected final Set<Integer> similarCharsDecimal = Set.of(48, 49, 73, 74, 76, 79, 105, 106, 108, 111);

    protected BooleanProperty numbersFlagProperty;
    protected BooleanProperty specialFlagProperty;
    protected BooleanProperty removeSimilarFlagProperty;

}
