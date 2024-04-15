package org.example.nosqlclassassignment;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBExample {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
            MongoDatabase database = mongoClient.getDatabase("assignment");
            MongoCollection<Document> collection = database.getCollection("class");
            Document document = new Document()
                    .append("_id", 1)
                    .append("name", "Sample Product")
                    .append("price", 19.99)
                    .append("description", "This is a sample product description.")
                    .append("descriptionFarsi", "این یک توضیح محصول نمونه است.")
                    .append("descriptionJapanese","これはサンプル製品の説明です);");

            collection.insertOne(document);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e);      }   }

}
