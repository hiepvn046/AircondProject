/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Service;

import com.aircond.AirCondProject.Model.Product;
import com.aircond.AirCondProject.Repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.bson.Document;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class ProductService {
    //This class is bug, I will find the way to let it run
    //Just ignore it now

    @Autowired
    private ProductRepository reposiroty;

    public Optional<Product> getProductById(String id) {
        return reposiroty.findById(id);
    }

    public List<Product> getAll() {
        return reposiroty.findAll();
    }

    public void updateAndInsertProduct(Document data) {
        reposiroty.save(new Product(data));
    }

    public void updateAndInsertProduct(String id, Document data) {
        reposiroty.save(new Product(id, data));
    }

    public void deleteProduct(String id) {
        reposiroty.deleteById(id);
    }
}
