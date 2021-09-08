package com.github.markahenrich.guitarinventory.models;

public class Guitar {
    private int manufacturerId;
    private String modelName;
    private int modelYear;
    private String color;
    private float price;

    public Guitar(int manufacturerId, String modelName, int modelYear, String color, float price) {
        this.manufacturerId = manufacturerId;
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.color = color;
        this.price = price;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
