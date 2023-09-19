/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuana
 */
public class CustomerOrder {
    private int orderID;
    private int customerID;
    private int sellerID;
    private String shipDate;
    private String requireDate;
    private String orderDate;
    private String shipAddress;
    private String status;

    public CustomerOrder() {
    }

    public CustomerOrder(int orderID, int customerID, int sellerID, String shipDate, String requireDate, String orderDate, String shipAddress, String status) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.sellerID = sellerID;
        this.shipDate = shipDate;
        this.requireDate = requireDate;
        this.orderDate = orderDate;
        this.shipAddress = shipAddress;
        this.status= status;
    }

    public CustomerOrder(int customerID, int sellerID, String shipDate, String requireDate, String orderDate, String shipAddress, String status) {
        this.customerID = customerID;
        this.sellerID = sellerID;
        this.shipDate = shipDate;
        this.requireDate = requireDate;
        this.orderDate = orderDate;
        this.shipAddress = shipAddress;
        this.status= status;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getSellerID() {
        return sellerID;
    }

    public void setSellerID(int sellerID) {
        this.sellerID = sellerID;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getRequireDate() {
        return requireDate;
    }

    public void setRequireDate(String requireDate) {
        this.requireDate = requireDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
