/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Model;



import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author DELL
 */
@Document(collection = "product")
public class Product {
    @Id
    private ObjectId _id;
    private String brandName;
    private String productName;
    private String modelId;
    private String indoorId;
    private String outdoorId;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getIndoorId() {
        return indoorId;
    }

    public void setIndoorId(String indoorId) {
        this.indoorId = indoorId;
    }

    public String getOutdoorId() {
        return outdoorId;
    }

    public void setOutdoorId(String outdoorId) {
        this.outdoorId = outdoorId;
    }
    

    public Product() {
    }



    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }




    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }




    
    
    
}
