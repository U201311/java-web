package project.example.demo.model;

import lombok.Data;

@Data
public class Device {
    private int deviceId;
    private String deviceName;
    private int netState;
    private int serviceState;
    private int linkedDevice;
    public Device(){

    }
    public Device(int deviceId,String deviceName){
        this.deviceId=deviceId;
        this.deviceName=deviceName;
    }

    public Device(int deviceId,String deviceName,int netState,int serviceState,int linkedDevice){
        this.deviceId=deviceId;
        this.deviceName=deviceName;
        this.netState=netState;
        this.serviceState=serviceState;
        this.linkedDevice=linkedDevice;
    }
}
