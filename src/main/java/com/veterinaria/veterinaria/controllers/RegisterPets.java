package com.veterinaria.veterinaria.controllers;

import com.veterinaria.veterinaria.dao.PetRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import com.veterinaria.veterinaria.models.Pet;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterPets implements Initializable {
    @FXML
    private TextField petName;
    @FXML
    private TextField petAge;
    @FXML
    private ComboBox petGender;
    @FXML
    private TextField petEmergencyContact;
    @FXML
    private Button petRegisterBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        petGender.getItems().addAll("Masculino","Femenino");
        petGender.getSelectionModel().select("Masculino");

        petRegisterBtn.setOnMouseClicked(e -> {
            String name = petName.getText();
            String age = petAge.getText();
            String gender = petGender.getValue().toString();
            String emergencyContact = petEmergencyContact.getText();

            if(name.isEmpty() || age.isEmpty() || emergencyContact.isEmpty()) {
                System.out.println("No se puede registrar la mascota");
                return;
            }

            Pet registeredPet = new Pet(name, age, gender, emergencyContact);

            PetRepository petRepository = new PetRepository();
            petRepository.registerPet(registeredPet);
        });
    }
}
