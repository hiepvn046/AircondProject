/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Controller;

import com.aircond.AirCondProject.Model.Product;
import com.aircond.AirCondProject.Model.ResponseObject;
import com.aircond.AirCondProject.Repository.ProductRepository;
import com.aircond.AirCondProject.Service.ProductService;
import java.util.List;
import java.util.Optional;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

    @Autowired
    private ProductRepository reposiroty;
    private ProductService productService;

    @GetMapping("")
    ResponseEntity<ResponseObject> getAllProducts() {
        List<Product> foundProduct = reposiroty.findAll();
        return !foundProduct.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Get all products", foundProduct)
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Not Found", "Cannot get products", "")
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getProductById(@PathVariable("id") String id) {
        Optional<Product> product = reposiroty.findById(id);

        return product.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("Not Found", "Cannot found product with id: " + id, ""))
                : ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "Product with id: " + id, product));
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Document data) {
        reposiroty.save(new Product(data));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "The new product has been inserted", ""));
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Document data, @PathVariable String id) {
        reposiroty.save(new Product(id, data));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("OK", "The product with id{" + id + "} has been updated", ""));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable String id) {
        reposiroty.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "Product with id{" + id + "} has been deleted", ""));
    }

}
