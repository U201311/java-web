package project.example.demo.model;

import lombok.Data;

@Data
public class OlderAndBed {
    private int id;
    private int olderId;
    private int bedId;
    public OlderAndBed(){}

    public OlderAndBed(int id,int olderId,int bedId){
        this.id=id;
        this.olderId=olderId;
        this.bedId=bedId;
    }
}
