package com.veterinaria.veterinaria.controllers;

import com.veterinaria.veterinaria.ButtonHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.veterinaria.veterinaria.dao.VeterinaryRepository;

public class TemplateController implements Initializable {
    @FXML
    private Button rVeterinary;
    @FXML
    private Button rPet;
    @FXML
    private Button rPetOwner;
    @FXML
    private Button rSeller;
    @FXML
    private Button rClinicHistory;
    @FXML
    private Button rReceipt;
    @FXML
    private Button cClinicHistory;
    @FXML
    private Button cOrders;
    @FXML
    private StackPane contentPane;
    @FXML
    private Button closeButton;
    @FXML
    private Button minimizeButton;
    @FXML
    private Button maximizeButton;

    private Map<Button, Pane> contentMap = new HashMap<>(); // <Boton, Contenido de el panel>, usamos un hashmap envez de un map normal para poder acceder tener acceso a los metodos de hashmap como el containskey
    private ArrayList<Button> buttonsList = new ArrayList<>(); // Lista de botones, usamos arraylist para poder iterar sobre ellos de forma mas facil y eficiente

    private ButtonHandler buttonHandler;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonHandler = new ButtonHandler(contentPane);
        setButtonAction(rVeterinary, "/vistas/MenuViews/RegisterVerterinary.fxml");
        setButtonAction(rPet, "/vistas/MenuViews/RegisterPets.fxml");
        setButtonAction(rPetOwner, "/vistas/MenuViews/RegisterOwners.fxml");
        setButtonAction(rSeller, "/vistas/MenuViews/RegisterSellers.fxml");
        setButtonAction(rClinicHistory, "/vistas/MenuViews/RegisterClinicHistory.fxml");
        setButtonAction(rReceipt, "/vistas/MenuViews/RegisterRecipt.fxml");
        setButtonAction(cClinicHistory, "/vistas/TableView.fxml");
        setButtonAction(cOrders, "/vistas/TableView.fxml");

        buttonsList.add(rVeterinary);
        buttonsList.add(rPet);
        buttonsList.add(rPetOwner);
        buttonsList.add(rSeller);
        buttonsList.add(rClinicHistory);
        buttonsList.add(rReceipt);
        buttonsList.add(cClinicHistory);
        buttonsList.add(cOrders);

        closeButton.setOnMouseClicked(e -> {
            System.exit(0);
        });

        maximizeButton.setOnMouseClicked(e -> {
            Stage stage = (Stage) maximizeButton.getScene().getWindow();
            Screen screen = Screen.getPrimary();
            if(stage.getWidth() != screen.getVisualBounds().getWidth() || stage.getHeight() != screen.getVisualBounds().getHeight()) {
                stage.setWidth(screen.getVisualBounds().getWidth());
                stage.setHeight(screen.getVisualBounds().getHeight());
                stage.setX(screen.getVisualBounds().getMinX());
                stage.setY(screen.getVisualBounds().getMinY());
            } else {
                stage.setWidth(800);
                stage.setHeight(600);
                stage.centerOnScreen();
            }
        });

        minimizeButton.setOnMouseClicked(e -> {
            Stage stage = (Stage) minimizeButton.getScene().getWindow();
            stage.setIconified(true);
        });
    }

    public void setButtonAction(Button button, String fxmlPath) {
        buttonHandler.setButtonAction(button, fxmlPath);
    }
}
