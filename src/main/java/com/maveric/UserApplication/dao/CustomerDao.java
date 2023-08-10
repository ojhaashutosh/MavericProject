package com.maveric.UserApplication.dao;

import com.maveric.UserApplication.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
    public interface CustomerDao extends JpaRepository<User, Integer> {

    public  User findByUsername (String username);
}
