/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuana
 */
public class Provider {
    private int providerID;
    private int userID;
    private String companyName;

    public Provider() {
    }

    public Provider(int providerID, int userID, String companyName) {
        this.providerID = providerID;
        this.userID = userID;
        this.companyName = companyName;
    }

    public Provider(int userID, String companyName) {
        this.userID = userID;
        this.companyName = companyName;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    
}
