module com.veterinaria.veterinaria {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires org.mongodb.driver.core;
    requires java.logging;

    opens com.veterinaria.veterinaria to javafx.fxml;
    exports com.veterinaria.veterinaria;
    exports com.veterinaria.veterinaria.views;
    opens com.veterinaria.veterinaria.views to javafx.fxml;
    exports com.veterinaria.veterinaria.controllers;
    opens com.veterinaria.veterinaria.controllers to javafx.fxml;
}