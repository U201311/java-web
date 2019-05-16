package project.example.demo.model;

import lombok.Data;

@Data
public class Family {
    private int id;
    private String name;
    private String phoneNumber;
    private String weChat;
    private  String eMail;
    public Family(int id,String numer,String phoneNumber,String weChat){
        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.weChat=weChat;
    }
}
