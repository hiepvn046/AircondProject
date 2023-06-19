/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Database;

import com.aircond.AirCondProject.Model.Product;
import com.aircond.AirCondProject.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author DELL
 */

@Configuration
public class Database {
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    
    @Bean
    CommandLineRunner initDatabase(ProductRepository productRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product product = new Product("Air 1",20.0);
                logger.info("insert : "+ productRepository.save(product));
            };
        };
    }
}
