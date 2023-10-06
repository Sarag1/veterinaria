package com.veterinaria.veterinaria.dao;

import org.bson.Document;
import com.veterinaria.veterinaria.models.Users.PetOwner;

public class OwnerRepository {
    public void registerOwner(PetOwner petOwner) {
        MongoDBCollectionHandler handler = new MongoDBCollectionHandler("Veterinaria", "Owners");

        Document owner_document = new Document("name", petOwner.getName())
                .append("age", petOwner.getAge())
                .append("gender", petOwner.getGender())
                .append("email", petOwner.getEmail())
                .append("phone", petOwner.getPhone())
                .append("pet", petOwner.getPetId());


        handler.insertDocument(owner_document);
    }
}
