/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author DELL
 */
@Document(collection = "product")
public class Product {

    @Id
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

}
