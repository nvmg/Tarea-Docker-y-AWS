package edu.escuelaing.arem.Message;

import java.util.Date;

/**
 *
 * @author nicole.montana
 */
public class Message {
    
    private String content;
    private String date;
    
    public Message(String content){
        this.content = content;
        this.date = java.time.LocalDate.now().toString();
    }
    
    
}
