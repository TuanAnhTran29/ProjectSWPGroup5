/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuana
 */
public class Customer {
    private int customerID;
    private int userID;
    private String region;
    private String country;

    public Customer() {
    }

    public Customer(int customerID, int userID, String region, String country) {
        this.customerID = customerID;
        this.userID = userID;
        this.region = region;
        this.country = country;
    }

    public Customer(int userID, String region, String country) {
        this.userID = userID;
        this.region = region;
        this.country = country;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}
