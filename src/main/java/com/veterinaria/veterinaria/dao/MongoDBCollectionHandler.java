package com.veterinaria.veterinaria.dao;


import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.*;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MongoDBCollectionHandler {
    private final MongoCollection<Document> collection;

    public MongoDBCollectionHandler(String databaseName, String collectionName) {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        String connectionString = "mongodb+srv://diegoandresm200:8GyrmmTi1YETgGgI@cluster0.3tcbl8i.mongodb.net/?retryWrites=true&w=majority";
        MongoClient mongoClient = MongoClients.create(connectionString);

        MongoDatabase database = mongoClient.getDatabase(databaseName);
        this.collection = database.getCollection(collectionName);
    }

    public void insertDocument(Document document) {
        collection.insertOne(document);
    }

    public ArrayList<Document> getDocuments() {
        FindIterable<Document> documents = collection.find();
        return documents.into(new ArrayList<>());
    }

    public ArrayList<Document> filterDocuments(String key, String value) {
        Document query = new Document(key, value);
        FindIterable<Document> documents = collection.find(query);
        return documents.into(new ArrayList<>());
    }

    public ArrayList<Document> executeQuery(String query) {
        Bson bson = BasicDBObject.parse(query);
        FindIterable<Document> documents = collection.find().projection(bson);
        return documents.into(new ArrayList<>());
    }
}