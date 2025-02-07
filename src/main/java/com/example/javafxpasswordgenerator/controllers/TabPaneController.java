package com.example.javafxpasswordgenerator.controllers;

import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class TabPaneController {
    public static final Clipboard clipboard = Clipboard.getSystemClipboard();
    public static final ClipboardContent content = new ClipboardContent();

    public static void copyPassword(String text) {
        content.putString(text);
        clipboard.setContent(TabPaneController.content);
    }
}
