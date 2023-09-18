/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuana
 */
public class ManagerOrderDetail {
    private int detailID;
    private int productID;
    private int managerOrderID;
    private float price;
    private int quantity;

    public ManagerOrderDetail() {
    }

    public ManagerOrderDetail(int detailID, int productID, int managerOrderID, float price, int quantity) {
        this.detailID = detailID;
        this.productID = productID;
        this.managerOrderID = managerOrderID;
        this.price = price;
        this.quantity = quantity;
    }

    public ManagerOrderDetail(int productID, int managerOrderID, float price, int quantity) {
        this.productID = productID;
        this.managerOrderID = managerOrderID;
        this.price = price;
        this.quantity = quantity;
    }

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getManagerOrderID() {
        return managerOrderID;
    }

    public void setManagerOrderID(int managerOrderID) {
        this.managerOrderID = managerOrderID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
