package com.example.cm.controller;

import com.example.cm.entity.User;
import com.example.cm.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/user")
    public void createUser(@RequestBody User user){
        adminService.createUser(user);
    }
}
