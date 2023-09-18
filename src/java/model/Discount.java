/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tuana
 */
public class Discount {
    private int discountID;
    private float discountValue;
    private String startDate;
    private String endDate;
    private int limit;
    private boolean active;

    public Discount() {
    }

    public Discount(int discountID, float discountValue, String startDate, String endDate, int limit, boolean active) {
        this.discountID = discountID;
        this.discountValue = discountValue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.limit = limit;
        this.active = active;
    }

    public Discount(float discountValue, String startDate, String endDate, int limit, boolean active) {
        this.discountValue = discountValue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.limit = limit;
        this.active = active;
    }

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public float getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(float discountValue) {
        this.discountValue = discountValue;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
}
