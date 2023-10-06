package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.models.Users.Admin;
import org.bson.Document;

public class AdminRepository {
    public void registerAdmin(Admin admin) {
        MongoDBCollectionHandler handler = new MongoDBCollectionHandler("Veterinaria", "Users");
        Document admin_document = new Document("name", admin.getName())
                .append("role", "admin")
                .append("cedula", admin.getCedula())
                .append("password", admin.getPassword());

        handler.insertDocument(admin_document);
    }

    public Document getAdmin(String cedula) {
        MongoDBCollectionHandler handler = new MongoDBCollectionHandler("Veterinaria", "Users");
        Document admin = handler.filterDocuments("cedula", cedula).get(0);
        return admin;
    }
}
