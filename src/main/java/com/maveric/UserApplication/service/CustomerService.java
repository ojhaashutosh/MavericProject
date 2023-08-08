package com.maveric.UserApplication.service;

import com.maveric.UserApplication.beans.CurrentAccount;
import com.maveric.UserApplication.beans.SavingsAccount;
import com.maveric.UserApplication.beans.User;
import com.maveric.UserApplication.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public User getById(int user_id)
    {
        Optional<User> byUserId = customerDao.findById(user_id);
        return byUserId.get();
    }

    public List<User> getAllUsers()
    {
        return customerDao.findAll();
    }
}
