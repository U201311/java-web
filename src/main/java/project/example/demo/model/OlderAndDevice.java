package project.example.demo.model;

import lombok.Data;

@Data
public class OlderAndDevice {
    private int id;
    private int oldersId;
    private int deviceId;
    public OlderAndDevice(){}

    public OlderAndDevice(int oldersId,int deviceId){
        this.oldersId=oldersId;
        this.deviceId=deviceId;
    }
}
