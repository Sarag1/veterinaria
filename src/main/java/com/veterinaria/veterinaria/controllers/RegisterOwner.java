package com.veterinaria.veterinaria.controllers;

import com.veterinaria.veterinaria.dao.OwnerRepository;
import com.veterinaria.veterinaria.dao.PetRepository;
import com.veterinaria.veterinaria.models.Users.PetOwner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.bson.Document;

import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class RegisterOwner implements Initializable {
    @FXML
    private TextField OwnerName;
    @FXML
    private TextField OwnerCedula;
    @FXML
    private TextField OwnerAge;
    @FXML
    private ComboBox OwnerGender;
    @FXML
    private TextField OwnerEmail;
    @FXML
    private TextField OwnerPhone;
    @FXML
    private ComboBox OwnerPet;
    @FXML
    private Button OwnerRegisterBtn;

    private PetRepository petRepository = new PetRepository();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ArrayList<Document> pets = petRepository.GetPets();
        Map <String, String> pet_map = null;
        for (Document pet : pets) {
            String pet_name = pet.getString("name");
            String pet_id = pet.getObjectId("_id").toString();
            pet_map = Map.of(pet_id, pet_name);
        }

        for(Map.Entry<String, String> entry : pet_map.entrySet()) {
            OwnerPet.getItems().addAll(entry.getValue());
        }

        OwnerPet.getSelectionModel().select("Mascota");
        OwnerGender.getItems().addAll("Masculino","Femenino");
        OwnerGender.getSelectionModel().select("Masculino");
        Map<String, String> finalPet_map = pet_map;
        OwnerRegisterBtn.setOnMouseClicked(e -> {
            String name = OwnerName.getText();
            String cedula = OwnerCedula.getText();
            String age = OwnerAge.getText();
            String email = OwnerEmail.getText();
            String phone = OwnerPhone.getText();
            String gender = OwnerGender.getValue().toString();
            String pet = OwnerPet.getValue().toString();

            if(name.isEmpty() || cedula.isEmpty() || age.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                System.out.println("No se puede registrar el dueño");
                return;
            }

            if(pet.isEmpty() || pet.equals("Mascota")) {
                System.out.println("No se puede registrar el dueño");
                return;
            }

            for(Map.Entry<String, String> entry : finalPet_map.entrySet()) {
                if(entry.getValue().equals(pet)) {
                    pet = entry.getKey();
                }
            }

            PetOwner petOwner = new PetOwner(name, cedula, age, gender, email, phone, pet);
            OwnerRepository ownerRepository = new OwnerRepository();
            ownerRepository.registerOwner(petOwner);
        });
    }
}
