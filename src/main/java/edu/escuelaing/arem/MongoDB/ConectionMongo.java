package edu.escuelaing.arem.MongoDB;

import com.mongodb.ConnectionString;
import com.mongodb.client.*;

import java.util.ArrayList;

/**
 *
 * @author nicole.montana
 */
public class ConectionMongo {
    public String uri;
    public MongoClient mongo;
    
    public ConectionMongo(){
        uri = "";
        ConnectionString connection = new ConnectionString(uri);
        this.mongo = MongoClients.create(connection);
    }
    
    public void insertMessage(Message message){
        
    }
    
    public ArrayList<Message> getMessages(){
        
        
    }
    
}
