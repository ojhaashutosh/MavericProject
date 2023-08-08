package com.maveric.UserApplication.service;

import com.maveric.UserApplication.beans.SavingsAccount;
import com.maveric.UserApplication.dao.SavingsAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavingsAccountService {
    @Autowired
    SavingsAccountDao savingsAccountDao;
    public SavingsAccount createSavingsAccount(){
        return savingsAccountDao.save(new SavingsAccount());
    }
}
