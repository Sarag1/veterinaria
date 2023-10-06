package com.veterinaria.veterinaria.dao;

import com.veterinaria.veterinaria.models.Pet;
import org.bson.Document;

import java.util.ArrayList;

public class PetRepository {
    public void registerPet(Pet pet) {
        MongoDBCollectionHandler handler = new MongoDBCollectionHandler("Veterinaria", "Pets");

        Document pet_document = new Document("name", pet.getName())
                .append("age", pet.getAge())
                .append("gender", pet.getGender())
                .append("emergency_contact", pet.getEmergencyContact());

        handler.insertDocument(pet_document);
    }

    public ArrayList<Document> GetPets() {
        MongoDBCollectionHandler handler = new MongoDBCollectionHandler("Veterinaria", "Pets");
        String query = "{_id:1,name:1}";
        ArrayList<Document> documents = handler.executeQuery(query);
        return documents;
    }
}
