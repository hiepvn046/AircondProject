/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Controller;

import com.aircond.AirCondProject.Model.Product;
import com.aircond.AirCondProject.Model.ResponseObject;
import com.aircond.AirCondProject.Repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Product> foundProduct = reposiroty.findById(id);
        return foundProduct.isPresent() ? ResponseEntity.status(HttpStatus.FOUND).body(
                new ResponseObject("Found", "Found product", foundProduct)
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Not Found", "Cannot found product with id: " + id, "")
        );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct) {
        return reposiroty.findByProductName(newProduct.getProductName()).isEmpty() ? ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new ResponseObject("ACCEPTED", "The data has been inserted", reposiroty.save(newProduct))
        ) : ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
                new ResponseObject("NOT_ACCEPTABLE", "This product has already in database", "")
        );
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "This product has been updated", reposiroty.findById(id).map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setPrice(newProduct.getPrice());
                    return reposiroty.save(product);
                }).orElseGet(() -> {
                    newProduct.setId(id);
                    return reposiroty.save(newProduct);
                }))
        );
    }

    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id) {
        if (reposiroty.existsById(id)) {
            reposiroty.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("OK", "Product " + id + " has been deleted", ""));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("NOT FOUND", "Cannot find the data", "")
            );
        }
    }

}
