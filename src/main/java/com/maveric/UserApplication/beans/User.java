package com.maveric.UserApplication.beans;

import javax.persistence.*;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String aadhar_id;
    private byte enabled;
    private String first_Name;
    private String last_Name;
    private String password;
    private String phone;
    private String username;
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private int current_account_id;
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private int savings_account_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "savings_account_id", referencedColumnName = "id")
    private SavingsAccount savingsAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="current_account_id", referencedColumnName = "id")
    private CurrentAccount currentAccount;

    public User(){
    }

    public User( String aadhar_id, byte enabled, String first_Name, String last_Name, String password, String phone, String username) {
        this.aadhar_id = aadhar_id;
        this.enabled = enabled;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.password = password;
        this.phone = phone;
        this.username = username;
//        this.current_account_id = current_account_id;
//        this.savings_account_id = savings_account_id;
//        this.savingsAccount = savingsAccount;
//        this.currentAccount = currentAccount;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getAadhar_id() {
        return aadhar_id;
    }

    public void setAadhar_id(String aadhar_id) {
        this.aadhar_id = aadhar_id;
    }

    public byte getEnabled() {
        return enabled;
    }

    public void setEnabled(byte enabled) {
        this.enabled = enabled;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCurrentAccountId(){return  currentAccount.getAccount_number();}
    public int getSavingsAccountId(){return savingsAccount.getAccount_number();}
    public void setSavingsAccount(SavingsAccount account){this.savingsAccount=account;}
    public void setCurrentAccount(CurrentAccount account){this.currentAccount=account;}
//    public SavingsAccount getSavingsAccount() {
//        return savingsAccount;
//    }
//
//    public void setSavingsAccount(SavingsAccount savingsAccount) {
//        this.savingsAccount = savingsAccount;
//    }

//    public CurrentAccount getCurrentAccount() {
//        return currentAccount;
//    }
//
//    public void setCurrentAccount(CurrentAccount currentAccount) {
//        this.currentAccount = currentAccount;
//    }
}
