package com.sunbeam.CarApp.entity;

import java.io.Serializable;

public class Car implements Serializable {
    private int id;
    private String modelname;
    private int purchaseyear;
    private double costperhour;
    private String fueltype;
    private String transmission;
    private double kmsdriven;
    private double mileage;
    private boolean insurance;


    public Car() {

    }

    public Car(int id, String modelname, int purchaseyear, double costperhour, String fueltype, String transmission, double kmsdriven, double mileage, boolean insurance) {
        this.id = id;
        this.modelname = modelname;
        this.purchaseyear = purchaseyear;
        this.costperhour = costperhour;
        this.fueltype = fueltype;
        this.transmission = transmission;
        this.kmsdriven = kmsdriven;
        this.mileage = mileage;
        this.insurance = insurance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public int getPurchaseyear() {
        return purchaseyear;
    }

    public void setPurchaseyear(int purchaseyear) {
        this.purchaseyear = purchaseyear;
    }

    public double getCostperhour() {
        return costperhour;
    }

    public void setCostperhour(double costperhour) {
        this.costperhour = costperhour;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public double getKmsdriven() {
        return kmsdriven;
    }

    public void setKmsdriven(double kmsdriven) {
        this.kmsdriven = kmsdriven;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public boolean getInsurance() {
        return insurance;
    }

    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "Model Name = " + modelname +
                "\nCost Per Hour = " + costperhour +
                "\nFuel Type = " + fueltype;
    }
}