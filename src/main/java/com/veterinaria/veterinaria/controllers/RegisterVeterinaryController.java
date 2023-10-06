package com.veterinaria.veterinaria.controllers;

import com.veterinaria.veterinaria.dao.VeterinaryRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import com.veterinaria.veterinaria.models.Users.Veterinary;

import java.net.URL;
import java.util.ResourceBundle;




public class RegisterVeterinaryController implements Initializable {
    @FXML
    private TextField veterinaryName;
    @FXML
    private TextField  veterinaryCedula;
    @FXML
    private TextField veterinaryAge;
    @FXML
    private ComboBox veterinaryGender;
    @FXML
    private TextField veterinaryEmail;
    @FXML
    private TextField veterinaryPhone;
    @FXML
    private Button veterinaryRegisterBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        veterinaryGender.getItems().addAll("Masculino","Femenino");
        veterinaryGender.getSelectionModel().select("Masculino");

        veterinaryRegisterBtn.setOnMouseClicked(e -> {
            String name = veterinaryName.getText();
            String cedula = veterinaryCedula.getText();
            String age = veterinaryAge.getText();
            String gender = veterinaryGender.getValue().toString();
            String email = veterinaryEmail.getText();
            String phone = veterinaryPhone.getText();
            Veterinary veterinary = new Veterinary(name,cedula,age,gender,email,phone);

            VeterinaryRepository veterinaryRepository = new VeterinaryRepository();
            veterinaryRepository.InsertVeterinary(veterinary);
        });
    }
}
