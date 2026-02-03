package com.espe.persistence;

import com.espe.model.Vehiculo;
import com.espe.repository.IVehiculoRepository;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoVehiculoRepository implements IVehiculoRepository {
    private final MongoCollection<Document> collection;

    public MongoVehiculoRepository() {
        MongoClient mongoClient = MongoClients.create("mongodb+srv://albastidas2_db_user:alexi$_2006@cluster0.qletf6c.mongodb.net/?appName=Cluster0");
        MongoDatabase database = mongoClient.getDatabase("DevRentalDB");
        this.collection = database.getCollection("vehiculos");
    }

    @Override
    public void guardar(Vehiculo v) {
        Document doc = new Document("placa", v.getPlaca())
                .append("marca", v.getMarca())
                .append("modelo", v.getModelo())
                .append("precioDia", v.getPrecioDia());
        collection.insertOne(doc);
    }
}