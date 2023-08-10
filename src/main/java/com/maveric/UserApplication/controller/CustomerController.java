package com.maveric.UserApplication.controller;

import com.maveric.UserApplication.Exception.InvalidCredentialsException;
import com.maveric.UserApplication.beans.User;
import com.maveric.UserApplication.dao.CustomerDao;
import com.maveric.UserApplication.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;

@RestController
public class CustomerController {
    private static final Logger logger= LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @PostMapping({"/registerNewCustomer"})
    public User registerNewCustomer(@RequestBody @Valid User user) {

        User userResponse= customerService.registerNewCustomer(user);
        logger.info("User added");
        return userResponse;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int user_id) {

        User user = customerService.getById(user_id);
        logger.info("fetched user by id");
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
//    @PostMapping("/users/login")
//    public ResponseEntity<Boolean> login(@RequestBody User user) throws InvalidCredentialsException {
//        logger.info("login successful");
//        return new ResponseEntity<Boolean>(customerService.getByUsername(user.getUsername(), user.getPassword()), HttpStatus.OK);
//    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) throws InvalidCredentialsException{
        return new ResponseEntity<String>(customerService.getByUsername(user.getUsername(), user.getPassword()), HttpStatus.OK);
    }


    @GetMapping(value = "/byUserName/{username}")
    public User getByUserName(@PathVariable String username)
    {
       return customerService.getByUserName(username);
    }


}