package com.maveric.UserApplication.beans;

import javax.persistence.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
public class CurrentAccount {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "currentAccount_seq")
    @SequenceGenerator(name = "currentAccount_seq", sequenceName = "currentAccount_sequence", initialValue = 1011200, allocationSize = 1)
    private int id;
    @Column(name = "balance")
    private double balance = 0.0;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int account_number;

    public CurrentAccount(){}

    public CurrentAccount(int id, double balance, int account_number) {
        this.id = id;
        this.balance = balance;
        this.account_number = account_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }
}
