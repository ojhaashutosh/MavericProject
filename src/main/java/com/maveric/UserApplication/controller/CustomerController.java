package com.maveric.UserApplication.controller;

import com.maveric.UserApplication.beans.User;
import com.maveric.UserApplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping({"/registerNewCustomer"})
    public User registerNewCustomer(@RequestBody User user) {
        return customerService.registerNewCustomer(user);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int user_id) {

        User user = customerService.getById(user_id);
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
    @GetMapping("/users/getAllUsers")
    public ResponseEntity<User> getAllUsers() {

        List<User> user = customerService.getAllUsers();
        return new ResponseEntity<>(new User(),HttpStatus.OK);

    }

}