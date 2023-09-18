/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuana
 */
public class CustomerOrderDetail {
    private int id;
    private int orderID;
    private int productID;
    private int voucherID;
    private float price;
    private int quantity;

    public CustomerOrderDetail() {
    }

    public CustomerOrderDetail(int id, int orderID, int productID, int voucherID, float price, int quantity) {
        this.id = id;
        this.orderID = orderID;
        this.productID = productID;
        this.voucherID = voucherID;
        this.price = price;
        this.quantity = quantity;
    }

    public CustomerOrderDetail(int orderID, int productID, int voucherID, float price, int quantity) {
        this.orderID = orderID;
        this.productID = productID;
        this.voucherID = voucherID;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(int voucherID) {
        this.voucherID = voucherID;
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
