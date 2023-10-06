package com.veterinaria.veterinaria;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ButtonHandler {
    private static Map<Button, Pane> contentMap = new HashMap<>();
    private static Map<Button, String> buttonStyleMap = new HashMap<>();
    private static StackPane contentPane;

    public ButtonHandler(StackPane contentPane) {
        this.contentPane = contentPane;
    }

    public ButtonHandler() {
    }

    public static void setButtonAction(Button button, String fxmlPath) {
        if(button == null ) {
            throw new IllegalArgumentException("Button must not be null");
        }
        if(fxmlPath == null || fxmlPath.isEmpty()) {
            throw new IllegalArgumentException("fxmlPath must not be null or empty");
        }
        button.setOnMouseClicked(e -> {
            try {
                if (contentMap.containsKey(button)) {
                    contentPane.getChildren().clear();
                    contentPane.getChildren().add(contentMap.get(button));
                    for (Map.Entry<Button, String> entry : buttonStyleMap.entrySet()) {
                        if (entry.getKey() != button) {
                            entry.getKey().setStyle("-fx-background-color: #2d3436");
                        } else {
                            entry.getKey().setStyle("-fx-background-color: #636e72");
                        }
                    }
                } else {
                    FXMLLoader loader = new FXMLLoader(ButtonHandler.class.getResource(fxmlPath));
                    Pane loadedContent = loader.load();
                    contentMap.put(button, loadedContent);
                    buttonStyleMap.put(button, "false");

                    contentPane.getChildren().clear();
                    contentPane.getChildren().add(loadedContent);
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    public static void print(){
        for (Map.Entry<Button, Pane> entry : contentMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
