/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Service;

import com.aircond.AirCondProject.Model.Account;
import com.aircond.AirCondProject.Repository.AccountRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account acc = accountRepository.findByUsername(username);
        if (acc == null) {
            throw new UsernameNotFoundException("User not found");
        }
        // Create and return a UserDetails object
        // You can use the org.springframework.security.core.userdetails.User class
        return org.springframework.security.core.userdetails.User
                .withUsername(acc.getUsername())
                .password(acc.getPassword())
                .roles(acc.getRoles().toArray(new String[0]))
                .build();
    }

    public void changePassword(String username, String newPassword) {
        accountService.changePassword(username, newPassword);
    }

    public void changeRoles(String username, List<String> newRoles) {
        accountService.changeRoles(username, newRoles);
    }

}
