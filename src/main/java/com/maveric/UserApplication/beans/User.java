package com.maveric.UserApplication.beans;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    @Column(unique = true, nullable = false)
    private String aadhar_id;

    private byte enabled;
    @NotBlank(message = "First Name cannot be empty")
    @Column(name = "first_name")
    private String first_Name;

    @NotBlank(message = "First Name cannot be empty")
    @Column(name = "last_name")
    private String last_Name;

    @NotBlank(message = "Password cannot be empty")
    @Length(min = 7, message = "Password should be atleast 7 characters long")
    @Column(name = "password")
    private String password;



    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Please enter a valid email address")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "mobile", unique = true)
    @Length(min = 10, message = "Phone number should be atleast 10 number long")
    private String phone;
    @Column(unique = true,nullable = false)
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "savings_account_id", referencedColumnName = "id")
    private SavingsAccount savingsAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="current_account_id", referencedColumnName = "id")
    private CurrentAccount currentAccount;

    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(
            name="UserRole",
            joinColumns={@JoinColumn(name="User_Id", referencedColumnName="user_id")},
            inverseJoinColumns={@JoinColumn(name="Role_Id", referencedColumnName="role_id")})
    private List<Role> roles = new ArrayList<>();

    public User(List<Role> roles) {
        this.roles = roles;
    }

    public User(){
    }

    public User( String aadhar_id, byte enabled, String first_Name, String last_Name, String password, String email, String phone, String username) {
        this.aadhar_id = aadhar_id;
        this.enabled = enabled;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.password = password;
        this.phone = phone;
        this.username = username;
        this.email=email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
