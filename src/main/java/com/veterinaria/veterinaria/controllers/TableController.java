package com.veterinaria.veterinaria.controllers;

import com.veterinaria.veterinaria.ButtonHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import org.bson.Document;

import java.net.URL;
import java.util.ResourceBundle;


public class TableController implements Initializable {
    @FXML
    private ListView<String> list_frame;

    private String[] list = {"1","2","3","4","5","6","7","8","9","10"};



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list_frame.getItems().addAll(list);
    }
}
