package project.example.demo.model;

import lombok.Data;

import java.util.Date;
@Data
public class EmotionUse {

    private int id;
    private int deviceId;
    private int oldersId;
    private String olderName;
    private Date beginTime;
    private Date endTime;

    public EmotionUse(int deviceId,int oldersId,String olderName){
        this.deviceId=deviceId;
        this.oldersId=oldersId;
        this.olderName=olderName;
    }
}
