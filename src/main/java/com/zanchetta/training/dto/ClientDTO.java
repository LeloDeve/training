package com.zanchetta.training.dto;

import com.zanchetta.training.domain.Client;

import java.io.Serializable;

public class ClientDTO implements Serializable {

    private String id;
    private String name;
    private String email;
    private String phone;


    public ClientDTO(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.phone = client.getPhone();
    }

    public ClientDTO(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
