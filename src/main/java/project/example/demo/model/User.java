package project.example.demo.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String password;

    public User(){}
    public User(String username,String password){
        this.username=username;
        this.password=password;
    }
}
