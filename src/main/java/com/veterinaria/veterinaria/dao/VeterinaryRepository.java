package com.veterinaria.veterinaria.dao;

import org.bson.Document;
import com.veterinaria.veterinaria.models.Users.Veterinary;

import java.util.ArrayList;

public class VeterinaryRepository {
    public void InsertVeterinary(Veterinary veterinary){
        MongoDBCollectionHandler handler = new MongoDBCollectionHandler("Veterinaria", "Users");

        Document veterinary_document = new Document("name", veterinary.getName())
                .append("cedula", veterinary.getCedula())
                .append("age", veterinary.getAge())
                .append("gender", veterinary.getGender())
                .append("email", veterinary.getEmail())
                .append("phone", veterinary.getPhone())
                .append("role", "veterinary");

        handler.insertDocument(veterinary_document);
    }


    public ArrayList<Document> getVeterinaries() {
        MongoDBCollectionHandler handler = new MongoDBCollectionHandler("Veterinaria", "Users");
        ArrayList<Document> veterinaries =  handler.filterDocuments("role", "veterinary");
        return veterinaries;
    }
}
