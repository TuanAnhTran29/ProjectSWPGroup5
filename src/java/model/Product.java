/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuana
 */
public class Product {
    private int productID;
    private String productName;
    private String expiry;
    private String maniDate;
    private float price;
    private int quantity;
    private boolean active;
    private int discountID;
    private int providerID;
    private int categoryID;

    public Product() {
    }

    public Product(int productID, String productName, String expiry, String maniDate, float price, int quantity, boolean active, int discountID, int providerID, int categoryID) {
        this.productID = productID;
        this.productName = productName;
        this.expiry = expiry;
        this.maniDate = maniDate;
        this.price = price;
        this.quantity = quantity;
        this.active = active;
        this.discountID = discountID;
        this.providerID = providerID;
        this.categoryID = categoryID;
    }

    public Product(String productName, String expiry, String maniDate, float price, int quantity, boolean active, int discountID, int providerID, int categoryID) {
        this.productName = productName;
        this.expiry = expiry;
        this.maniDate = maniDate;
        this.price = price;
        this.quantity = quantity;
        this.active = active;
        this.discountID = discountID;
        this.providerID = providerID;
        this.categoryID = categoryID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getManiDate() {
        return maniDate;
    }

    public void setManiDate(String maniDate) {
        this.maniDate = maniDate;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public int getProviderID() {
        return providerID;
    }

    public void setProviderID(int providerID) {
        this.providerID = providerID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
    
    
}
