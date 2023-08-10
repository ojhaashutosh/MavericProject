package com.maveric.UserApplication.service;

import com.maveric.UserApplication.Exception.InvalidCredentialsException;
import com.maveric.UserApplication.Exception.UserNotFoundExpception;
import com.maveric.UserApplication.beans.User;
import com.maveric.UserApplication.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

import static java.util.Objects.nonNull;

@Service
public class CustomerService {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CurrentAccountService currentAccountService;
    @Autowired
    private SavingsAccountService savingsAccountService;

    public User registerNewCustomer(User user)
    {
        user.setSavingsAccount(savingsAccountService.createSavingsAccount());
        user.setCurrentAccount(currentAccountService.createCurrentAccount());
        return customerDao.save(user);
    }

    public User getById(int user_id) throws UserNotFoundExpception
    {
        Optional<User> byUserId = customerDao.findById(user_id);
        if(byUserId.isPresent()) {
            return byUserId.get();
        }
        throw new UserNotFoundExpception("User Not Found");
    }


//    public boolean getByUsername(String username, String password) throws InvalidCredentialsException {
//        User byUsername = customerDao.findByUsername(username);
//        if (nonNull(byUsername)) {
//            return byUsername.getPassword().equalsIgnoreCase(password);
//        }
//            throw new InvalidCredentialsException("Invalid Credentials");
//    }

    public String getByUsername(String username, String password) throws InvalidCredentialsException{
        User byUsername= customerDao.findByUsername(username);
        if(byUsername!=null) {
            if (byUsername.getPassword().equalsIgnoreCase(password))
                return "login successful";
            else throw new InvalidCredentialsException("Invalid Credentials");
        }
        return "User with " + username + " does not exists";

    }


    public User getByUserName(String username)
    {
        return customerDao.findByUsername(username);
    }
}
