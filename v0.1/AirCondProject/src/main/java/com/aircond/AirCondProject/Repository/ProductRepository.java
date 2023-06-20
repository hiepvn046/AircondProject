/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Repository;

import com.aircond.AirCondProject.Model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author DELL
 */


public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findByProductName (String productName);
}
