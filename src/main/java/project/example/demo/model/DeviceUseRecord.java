package project.example.demo.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class DeviceUseRecord {

    private int id;
    private int deviceId;
    private int oldersId;
    private int nurseId;
    private  String NurseName;
    private String DeviceType;
    private Date beginTime;
    private String OlderName ;
    private Date endTime;
    public DeviceUseRecord(){}
    public DeviceUseRecord(int  deviceId,int olderId,int nurseId,String olderName,String nurseName,String deviceType,Date beginTime,Date endTime){
        this.oldersId=olderId;
        this.deviceId= deviceId;
        this.nurseId=nurseId;
        this.OlderName=olderName;
        this.NurseName=nurseName;
        this.DeviceType=deviceType;
        this.beginTime=beginTime;
        this.endTime=endTime;
    }
}
