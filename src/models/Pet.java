/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Pet implements Serializable {

    public static final long serialVersionUID = -3040096452457271690L;
    private String description;
    private String date;
    private int unit;
    private Category category;

    public Pet() {
    }

    public Pet(String description, String date, int unit, Category category) {
        this.description = description;
        this.date = date;
        this.unit = unit;
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Pet{" + "description=" + description + ", date=" + date + ", unit=" + unit + ", category=" + category + '}';
    }

    public String toFile() {
        return description + ", " + date + ", " + unit + ", " + category;
    }

}
