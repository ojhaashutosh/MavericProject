package com.maveric.UserApplication.dao;

import com.maveric.UserApplication.beans.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentAccountDao extends JpaRepository<CurrentAccount, Integer> {
}
