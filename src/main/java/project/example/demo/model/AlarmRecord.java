package project.example.demo.model;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
@Data
public  class  AlarmRecord {
    private int id;
    private int deviceId;
    private int oldersId;
    private String oldersName;
    private String alarmType;
    private Timestamp alarmTime;
    private Timestamp alarmReplyTime;
    private String alarmName;
    private int nurseId;
    private String nurseName;
    private double X;
    private  double Y;
    public AlarmRecord(){}
}
