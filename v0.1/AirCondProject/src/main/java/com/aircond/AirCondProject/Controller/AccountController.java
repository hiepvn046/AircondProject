/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Controller;

import com.aircond.AirCondProject.Model.Account;
import com.aircond.AirCondProject.Model.ResponseObject;
import com.aircond.AirCondProject.Repository.AccountRepository;
import com.aircond.AirCondProject.Service.UserDetailsServiceImpl;
import java.util.List;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private AccountRepository accountRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/change-password")
    ResponseEntity<ResponseObject> changePassword(@RequestBody Document account) {
        String username = (String) account.get("username");
        String password = (String) account.get("password");
        userDetailsService.changePassword(username, password);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "The password of account with username {" + username + "} has been changed", ""));
    }

    @PostMapping("/register")
    ResponseEntity<ResponseObject> register(@RequestBody Document account) {
        String username = (String) account.get("username");
        String password = (String) account.get("password");
        List<String> roles = (List<String>) account.get("roles");

        if (accountRepository.findByUsername(username) != null) {
            throw new RuntimeException("Username already exists");
        }

        String hashedPassword = passwordEncoder.encode(password);

        accountRepository.save(new Account(username, hashedPassword, roles));

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("OK", "The account with username {" + username + "} has been registered successfully", ""));
    }
}
