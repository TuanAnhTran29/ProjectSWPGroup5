/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuana
 */
public class ManagerOrder {
    private int managerOrderID;
    private int managerID;
    private String orderDate;
    private String requireDate;
    private String shipDate;
    private String shipAddress;
    private int contractID;

    public ManagerOrder() {
    }

    public ManagerOrder(int managerOrderID, int managerID, String orderDate, String requireDate, String shipDate, String shipAddress, int contractID) {
        this.managerOrderID = managerOrderID;
        this.managerID = managerID;
        this.orderDate = orderDate;
        this.requireDate = requireDate;
        this.shipDate = shipDate;
        this.shipAddress = shipAddress;
        this.contractID = contractID;
    }

    public ManagerOrder(int managerID, String orderDate, String requireDate, String shipDate, String shipAddress, int contractID) {
        this.managerID = managerID;
        this.orderDate = orderDate;
        this.requireDate = requireDate;
        this.shipDate = shipDate;
        this.shipAddress = shipAddress;
        this.contractID = contractID;
    }

    public int getManagerOrderID() {
        return managerOrderID;
    }

    public void setManagerOrderID(int managerOrderID) {
        this.managerOrderID = managerOrderID;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getRequireDate() {
        return requireDate;
    }

    public void setRequireDate(String requireDate) {
        this.requireDate = requireDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public int getContractID() {
        return contractID;
    }

    public void setContractID(int contractID) {
        this.contractID = contractID;
    }
    
    
}
