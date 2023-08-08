package com.maveric.UserApplication.dao;

import com.maveric.UserApplication.beans.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingsAccountDao extends JpaRepository<SavingsAccount, Integer> {
}
