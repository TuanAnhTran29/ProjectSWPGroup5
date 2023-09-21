/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuana
 */
public class User {
    private int userID;
    private String fullName;
    private String address;
    private String dob;
    private String phone;
    private String email;
    private int gender;
    private String avartar;
    private float salary;
    private int accountID;
    private int roleID;

    public User() {
    }

    public User(int userID, String fullName, String address, String dob, String phone, String email, int gender, String avartar, float salary, int accountID, int roleID) {
        this.userID = userID;
        this.fullName = fullName;
        this.address = address;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.avartar = avartar;
        this.salary = salary;
        this.accountID = accountID;
        this.roleID = roleID;
    }

    public User(String fullName, String address, String dob, String phone, String email, int gender, String avartar, float salary, int accountID, int roleID) {
        this.fullName = fullName;
        this.address = address;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.avartar = avartar;
        this.salary = salary;
        this.accountID = accountID;
        this.roleID = roleID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAvartar() {
        return avartar;
    }

    public void setAvartar(String avartar) {
        this.avartar = avartar;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
    
    
}
