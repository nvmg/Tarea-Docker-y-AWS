package edu.escuelaing.arem.MongoDB;

import edu.escuelaing.arem.Message.MessageStructure;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import java.util.ArrayList;
import org.bson.Document;

/**
 *
 * @author nicole.montana
 */
public class ConectionMongo {
    
    MongoClient mongoClient;

    public ConectionMongo() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://admin:<password>@arep-docker-taller.wiml5lb.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        this.mongoClient = MongoClients.create(settings);
    }

    public void insertMessage(MessageStructure mes) {
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> customers = database.getCollection("messages");
        Document documento = new Document();
        documento.put("content", mes.getContent());
        documento.put("date", mes.getDate());
        customers.insertOne(documento);
    }

    public ArrayList<MessageStructure> getMessages(){
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> customers = database.getCollection("messages");
        FindIterable<Document> iterable = customers.find();
        ArrayList<Document> documents = new ArrayList<>();
        ArrayList<MessageStructure> messages = new ArrayList<>();
        ArrayList<MessageStructure> nm = new ArrayList<>();
        iterable.into(documents);
        for(Document doc: documents){
            if(doc.get("content") != null && doc.get("date") != null){
                messages.add(new MessageStructure((String)doc.get("content"), (String)doc.get("date")));
            }
        }
        int end = messages.size() - 1;
        for(int i = 10; (i > 0) && (i <= 10) && (0 <= end) && (end < messages.size()); i--){
            nm.add(messages.get(end));
            end = end - 1;
        }
        for(MessageStructure men : nm){
            System.out.println("Mensaje:" + men.getDate() + men.getDate());
        }
        return nm;
    }

}
