package project.example.demo.model;

import lombok.Data;

@Data
public class Robot {
    private int id;
    private String robotName;
    private String netState;
    private String serviceState;

    public Robot(int id ,String robotName,String netState,String serviceState){
        this.id=id;
        this.robotName=robotName;
        this.netState=netState;
        this.serviceState=serviceState;
    }

    public Robot(int id,String robotName){
        this.id=id;
        this.robotName=robotName;
    }
}
