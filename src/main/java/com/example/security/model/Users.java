package com.example.security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
    @Id
    private int id;
    private String username;
    private String password;

    public Users(){}
    public Users(int id,String username,String password){
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public String getusername() {
        return username;
    }
    public String getpassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setusername(String username) {
        this.username = username;
    }
    public void setpassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Users{" +
                "id : " + id + 
                ",username : " + username + "\'"  + 
                ",password : " + password + 
                "}";
    }
}
