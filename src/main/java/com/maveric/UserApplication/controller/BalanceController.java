package com.maveric.UserApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {

    @PostMapping("/createBalance/{id}")
    public void createBalance(){}

    @GetMapping("/viewBalanceby/{id}")
    public void viewBalance(){}

    @PatchMapping("/updateBalance/{id}")
    public void UpdateBalance(){}
}
