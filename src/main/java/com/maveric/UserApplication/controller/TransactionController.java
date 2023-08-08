package com.maveric.UserApplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransactionController {

    @PostMapping("/createTrans")
    public void createTransaction(){}

    @GetMapping("/viewTrans/{id}")
    public void viewTrans(){}

    @PatchMapping("/updateTrans/{id}")
    public void UpdateTrans(){}
}
