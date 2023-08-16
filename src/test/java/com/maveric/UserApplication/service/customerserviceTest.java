package com.maveric.UserApplication.service;

import com.maveric.UserApplication.Exception.InvalidCredentialsException;
import com.maveric.UserApplication.Exception.UserNotFoundExpception;
import com.maveric.UserApplication.beans.CurrentAccount;
import com.maveric.UserApplication.beans.SavingsAccount;
import com.maveric.UserApplication.beans.User;
import com.maveric.UserApplication.dao.CustomerDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import java.util.Optional;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



class CustomerServiceTest {



    @Mock
    private CustomerDao customerDao;
    @Mock
    private CurrentAccountService currentAccountService;
    @Mock
    private SavingsAccountService savingsAccountService;
    @InjectMocks
    private CustomerService customerService;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterNewCustomer() {
        User user = new User();
        when(savingsAccountService.createSavingsAccount()).thenReturn(new SavingsAccount());
        when(currentAccountService.createCurrentAccount()).thenReturn(new CurrentAccount());
        when(customerDao.save(any())).thenReturn(user);

        User savedUser = customerService.registerNewCustomer(user);

        verify(savingsAccountService, times(1)).createSavingsAccount();
        verify(currentAccountService, times(1)).createCurrentAccount();
        verify(customerDao, times(1)).save(any());
    }



    @Test
    void testGetById() {
        int userId = 1;
        User user = new User();
        when(customerDao.findById(userId)).thenReturn(Optional.of(user));
        User retrievedUser = customerService.getById(userId);
        assertNotNull(retrievedUser);
        assertSame(user, retrievedUser);
        verify(customerDao, times(1)).findById(userId);
    }



    @Test
    void testGetByIdUserNotFound() {
        int userId = 1;
        when(customerDao.findById(userId)).thenReturn(Optional.empty());
        assertThrows(UserNotFoundExpception.class, () -> customerService.getById(userId));
        verify(customerDao, times(1)).findById(userId);
    }

    @Test
    void testGetByUsernameAndPasswordValid() {
        String username = "username";
        String password = "password";
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        when(customerDao.findByUsername(username)).thenReturn(user);
        String result = customerService.getByUsername(username, password);
        assertEquals("login successful", result);
    }

    @Test
    void testGetByUsernameAndPasswordInvalidPassword() {
        String username = "username";
        String password = "password";
        User user = new User();
        user.setUsername(username);
        user.setPassword("incorrectPassword");
        when(customerDao.findByUsername(username)).thenReturn(user);

        assertThrows(InvalidCredentialsException.class, () -> customerService.getByUsername(username, password));
    }

    @Test
    void testGetByUsernameAndInvalidUsername() {
        String username = "username";
        String password = "password";
        when(customerDao.findByUsername(username)).thenReturn(null);

        String result = customerService.getByUsername(username, password);

        assertEquals("User with " + username + " does not exists", result);
    }

    @Test
    void testGetByUserName() {
        String username = "username";
        User user = new User();
        when(customerDao.findByUsername(username)).thenReturn(user);

        User retrievedUser = customerService.getByUserName(username);

        assertNotNull(retrievedUser);
        assertSame(user, retrievedUser);



        verify(customerDao, times(1)).findByUsername(username);
    }

    @Test
    void testGetByUserNameNotFound() {
        String username = "nonexistentUsername";
        when(customerDao.findByUsername(username)).thenReturn(null);

        User retrievedUser = customerService.getByUserName(username);

        assertNull(retrievedUser);



        verify(customerDao, times(1)).findByUsername(username);
    }


}



