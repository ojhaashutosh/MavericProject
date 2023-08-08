package com.maveric.UserApplication.service;

import com.maveric.UserApplication.beans.CurrentAccount;
import com.maveric.UserApplication.dao.CurrentAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CurrentAccountService {
    @Autowired
    private CurrentAccountDao currentAccountDao;
    public CurrentAccount createCurrentAccount(){
        return currentAccountDao.save(new CurrentAccount());
    }
}
