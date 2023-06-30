/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Repository;

import com.aircond.AirCondProject.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author DELL
 */
public interface ProductRepository extends MongoRepository<Product, String> {
}
