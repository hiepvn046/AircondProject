/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Service;

import com.aircond.AirCondProject.Model.Product;
import java.util.List;
import java.util.Optional;
import org.bson.Document;

import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public interface ProductService {

    Optional<Product> getProductById(String id);

    List<Product> getAll();

    void updateAndInsertProduct(Document data);

    void updateAndInsertProduct(String id, Document data);

    void deleteProduct(String id);

}
