package com.veterinaria.veterinaria.views;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginApplication extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginApplication.class.getResource("/vistas/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.initStyle(javafx.stage.StageStyle.TRANSPARENT);
        stage.setTitle("Login");
        stage.setScene(scene);

        // Make the stage draggable
        stage.getScene().setOnMousePressed(new EventHandler<MouseEvent>() {
                                               @Override
                                               public void handle(MouseEvent mouseEvent) {
                                                   xOffset = mouseEvent.getSceneX();
                                                   yOffset = mouseEvent.getSceneY();
                                               }
                                           });
                // Move around here
                stage.getScene().setOnMouseDragged(new EventHandler<MouseEvent>() {
                                               @Override
                                               public void handle(MouseEvent mouseEvent) {
                                                   stage.setX(mouseEvent.getScreenX() - xOffset);
                                                   stage.setY(mouseEvent.getScreenY() - yOffset);
                                               }
                                           });
                stage.show();
    }

}
