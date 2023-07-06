/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Model;

import com.aircond.AirCondProject.Security.Roles;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 *
 * @author DELL
 */
@org.springframework.data.mongodb.core.mapping.Document(collection = "account")
public class Account {

    @Id
    private ObjectId id;
    private String username;
    private String password;
    private List<String> roles;

    public Account() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(String username, String password, List<String> roles) {
        this.id = new ObjectId();
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
    
    

}
