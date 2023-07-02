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
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public Optional<Product> getProductById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public void updateAndInsertProduct(Document data) {
        repository.save(new Product(data));
    }

    @Override
    public void updateAndInsertProduct(String id, Document data) {
        repository.save(new Product(id, data));
    }

    @Override
    public void deleteProduct(String id) {
        repository.deleteById(id);
    }

}
