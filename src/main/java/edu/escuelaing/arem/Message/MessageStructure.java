package edu.escuelaing.arem.Message;

/**
 *
 * @author nicole.montana
 */
public class MessageStructure{
    
    private String content;
    private String date;
    
    public MessageStructure(String content){
        this.content = content;
        this.date = java.time.LocalDate.now().toString();
    }
    
    public MessageStructure(String content, String date){
        this.content = content;
        this.date = date;
    }
    
    public String getContent(){
        return content;
    }
    
    public void setContent(String content){
        this.content = content;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setDate(String date){
        this.date = date;
    }
}
