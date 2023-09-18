/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuana
 */
public class StorageStaff {
    private int storageStaffID;
    private int userID;
    private String storageAddress;

    public StorageStaff() {
    }

    public StorageStaff(int storageStaffID, int userID, String storageAddress) {
        this.storageStaffID = storageStaffID;
        this.userID = userID;
        this.storageAddress = storageAddress;
    }

    public StorageStaff(int userID, String storageAddress) {
        this.userID = userID;
        this.storageAddress = storageAddress;
    }

    public int getStorageStaffID() {
        return storageStaffID;
    }

    public void setStorageStaffID(int storageStaffID) {
        this.storageStaffID = storageStaffID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getStorageAddress() {
        return storageAddress;
    }

    public void setStorageAddress(String storageAddress) {
        this.storageAddress = storageAddress;
    }
    
    
}
