/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aircond.AirCondProject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @GetMapping("/")
    public String admin(Model model) {
        return "redirect:/admin/authentication-login";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "/admin/dashboard";
    }
    
    @GetMapping("/authentication-login")
    public String login(Model model) {
        return "/admin/authentication-login";
    }
    
    @GetMapping("/authentication-register")
    public String register(Model model) {
        return "/admin/authentication-register";
    }
    
    @GetMapping("/icon-tabler")
    public String iconTabler(Model model) {
        return "/admin/icon-tabler";
    }
    
    @GetMapping("/sample-page")
    public String samplePage(Model model) {
        return "/admin/sample-page";
    }
    
    @GetMapping("/ui-alerts")
    public String alerts(Model model) {
        return "/admin/ui-alerts";
    }
    
    @GetMapping("/ui-buttons")
    public String buttons(Model model) {
        return "/admin/ui-buttons";
    }
    
    @GetMapping("/ui-card")
    public String card(Model model) {
        return "/admin/ui-card";
    }
    
    @GetMapping("/ui-forms")
    public String forms(Model model) {
        return "/admin/ui-forms";
    }
    
    @GetMapping("/ui-typography")
    public String typography(Model model) {
        return "/admin/ui-typography";
    }
}
