/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Service;

import com.aircond.AirCondProject.Model.Account;
import com.aircond.AirCondProject.Repository.AccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void changePassword(String username, String newPassword) {
        Account acc = accountRepository.findByUsername(username);
        if (acc != null) {
            String hashedPassword = passwordEncoder.encode(newPassword);
            acc.setPassword(hashedPassword);
            accountRepository.save(acc);
        }
    }

    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public void changeRoles(String username, List<String> newRoles) {
        Account acc = accountRepository.findByUsername(username);
        if (acc != null) {
            acc.setRoles(newRoles);
            accountRepository.save(acc);
        }
    }

    //TODO Do register later
    public void registerUser(String username, String password, List<String> roles) {
        String hashedPassword = passwordEncoder.encode(password);
        // Create a new User object and set the hashed password
        // Save the user to the userRepository
    }
}
