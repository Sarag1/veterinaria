package com.veterinaria.veterinaria.controllers;

import com.veterinaria.veterinaria.dao.AdminRepository;
import com.veterinaria.veterinaria.dao.VeterinaryRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.bson.Document;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private TextField LoginDocument;
    @FXML
    private PasswordField LoginPassword;
    @FXML
    private Button btnLogin;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        VeterinaryRepository veterinaryRepository = new VeterinaryRepository();
        ArrayList<Document> veterinaries = veterinaryRepository.getVeterinaries();

        btnLogin.setOnAction(e -> {
            AdminRepository adminRepository = new AdminRepository();
            Document admin = adminRepository.getAdmin(LoginDocument.getText());
            Dialog dialog = new Dialog();
            if (admin != null) {
                if (admin.get("password").toString().equals(LoginPassword.getText())) {
                    dialog.setContentText("Login successful");
                } else {
                    dialog.setContentText("Login failed");
                }
            } else {
                dialog.setContentText("Login failed");
            }
            dialog.show();
        });
    }
}
