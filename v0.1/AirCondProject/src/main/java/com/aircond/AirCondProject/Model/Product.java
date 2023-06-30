/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Model;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 *
 * @author DELL
 */
@org.springframework.data.mongodb.core.mapping.Document(collection = "product")
public class Product {

    @Id
    private String id;
    private Document data;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product() {
        this.data = new Document();
    }

    public Product(Document data) {
        this.data = data;
    }
    
    public Product(String id, Document data){
        this.id = id;
        this.data = data;
    }

    public void putData(String key, Object value) {
        this.data.put(key, value);
    }

    public Object get(String key) {
        return data.get(key);
    }

    public Document getData() {
        return data;
    }

    public void setData(Document data) {
        this.data = data;
    }

}
