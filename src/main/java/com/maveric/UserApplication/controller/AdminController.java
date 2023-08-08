package com.maveric.UserApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @GetMapping("/getUser/{Accountid}")
    public void getDetails(){}

    @GetMapping("/getAllUsers")
    public void getAllUsers(){}

    @PatchMapping("/accStatus/{accountId}")
    public void accStatus(){}
}
