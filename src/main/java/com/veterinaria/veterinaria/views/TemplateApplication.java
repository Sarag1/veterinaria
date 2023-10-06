package com.veterinaria.veterinaria.views;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class TemplateApplication extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage stage) throws Exception {
       try {
           FXMLLoader fxml = new FXMLLoader(getClass().getResource("/vistas/Template.fxml"));
              Parent root = fxml.load();
              stage.setTitle("Veterinaria");
              stage.initStyle(javafx.stage.StageStyle.TRANSPARENT);
              Scene scene = new Scene(root);
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
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
}
