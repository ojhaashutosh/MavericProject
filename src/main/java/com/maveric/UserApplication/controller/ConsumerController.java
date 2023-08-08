package com.maveric.UserApplication.controller;

import com.maveric.UserApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ConsumerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/signUp")
    public void signUp() {}
    @PostMapping("/login")
    public void login(){}

    @PatchMapping("/updateUserDetails")
    public void updateDetails(){}

    @GetMapping("/signout")
    public void singOut(){}



}
