/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author DELL
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        return "index";
    }
    
    @GetMapping("/cart")
    public String cart(Model model) {
        return "cart";
    }
    
    @GetMapping("/checkout")
    public String checkout(Model model) {
        return "checkout";
    }
    
    @GetMapping("/contact")
    public String contact(Model model) {
        return "contact";
    }
    
    @GetMapping("/detail")
    public String detail(Model model) {
        return "detail";
    }
    
    @GetMapping("/shop")
    public String shop(Model model) {
        return "shop";
    }

}
