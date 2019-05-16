package project.example.demo.model;

import lombok.Data;

@Data
public class OlderAndFamily {

    private int id;
    private int oldersId;
    private int familyId;
    private String relationship;

    public OlderAndFamily(int oldersId, int familyId,String relationship){
        this.familyId=familyId;
        this.oldersId=oldersId;
        this.relationship=relationship;
    }
}
