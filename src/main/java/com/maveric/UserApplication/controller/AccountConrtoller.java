package com.maveric.UserApplication.controller;

import com.maveric.UserApplication.beans.CurrentAccount;
import com.maveric.UserApplication.beans.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountConrtoller {
    @PostMapping({"/createAcc"})
    public CurrentAccount createAcc(){
        return new CurrentAccount();
    }

    @GetMapping("/viewAccDetails/{id}")
    public User viewAcc(){
        return new User();
    }

    @PatchMapping("/updateAccDetails/{id}")
    public User updateAcc(){
        return new User();
    }
}
