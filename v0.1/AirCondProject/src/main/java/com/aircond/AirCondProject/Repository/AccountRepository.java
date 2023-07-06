/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Repository;

import com.aircond.AirCondProject.Model.Account;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author DELL
 */
public interface AccountRepository extends MongoRepository<Account, ObjectId> {
    Account findByUsername(String username);
}
