package edu.escuelaing.arem;

import static spark.Spark.*;
import com.google.gson.Gson;
import edu.escuelaing.arem.MongoDB.ConectionMongo;

/**
 *
 * @author nicole.montana
 */
public class DockerAWS {

    public static void main(String[] args) {
        port(getPort());
        ConectionMongo conect = new ConectionMongo();
        get("/message", (req,res) -> {
            res.status(200);
            res.type("application/json");
            return new Gson().toJson(conect.getMessages())
        });
        
       
    }
    
    public static int getPort(){
         if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
