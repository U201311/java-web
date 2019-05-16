package project.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class Older {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String healthyState;
    private String idNumber;
    private Date inDate;
    private Date outDate;
    private String nation;
    private String remark;
    public Older(){}
    public Older(int id, String name,int age,String sex,String healthyState){
        this.id=id;
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.healthyState=healthyState;
    }
    public Older(int id ,String name,int age,String sex,String healthyState,String idNumber,Date inDate,String nation,String remark){
        this.id=id;
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.healthyState=healthyState;
        this.idNumber=idNumber;
        this.inDate=inDate;
        this.nation=nation;
        this.remark=remark;
    }
}
