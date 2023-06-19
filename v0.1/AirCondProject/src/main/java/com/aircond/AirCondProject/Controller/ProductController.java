/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Controller;

import com.aircond.AirCondProject.Model.Product;
import com.aircond.AirCondProject.Repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */

@RestController
@RequestMapping(path = "/api/v1/Products")
public class ProductController {
    @Autowired
    private ProductRepository reposiroty;
    
    @GetMapping("")
    List<Product> getAllProducts(){
        return reposiroty.findAll();
    }
}
