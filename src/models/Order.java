/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class Order {

    private String date;
    private String customerName;
    private String petId;
    private int quantity;
    private int cost;

    public Order() {
    }

    public Order(String date, String customerName, String petId, int quantity, int cost) {
        this.date = date;
        this.customerName = customerName;
        this.petId = petId;
        this.quantity = quantity;
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int quantity, int price) {
        this.cost = quantity * price;
    }

    @Override
    public String toString() {
        return "Order{" + "date=" + date + ", customerName=" + customerName + ", petId=" + petId + ", quantity=" + quantity + ", cost=" + cost + '}';
    }

    public String toFile() {
        return date + ", " + customerName + ", " + petId + ", " + quantity + ", " + cost;

    }

}
