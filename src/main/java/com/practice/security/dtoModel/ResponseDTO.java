package com.practice.security.dtoModel;

public class ResponseDTO {
    private int id;
    private String username;

    public ResponseDTO(){}

    public ResponseDTO(int id,String username){
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }

}
