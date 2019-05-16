package project.example.demo.model;

import lombok.Data;

@Data
public class Nurse {

    private int id;

    private String name;

    private String sex;

    private String phoneNumber;

    public Nurse(){}

    public Nurse(int id,String name,String sex,String phoneNumber){
        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.sex=sex;
    }
}
