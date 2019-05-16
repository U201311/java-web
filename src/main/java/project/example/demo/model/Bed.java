package project.example.demo.model;

import lombok.Data;

@Data
public class Bed {
    private int id;
    private String buildingRow;
    private String buildingNumber;
    private  String roomNumber;
    private String number;
    private int bedState;
    public Bed(){}

    public Bed(int id,String buidlNumber,String buildingRow,String roomNumber,int bedState){
        this.id=id;
        this.buildingNumber=buidlNumber;
        this.buildingRow=buildingRow;
        this.roomNumber=roomNumber;
        this.bedState=bedState;
    }
}
