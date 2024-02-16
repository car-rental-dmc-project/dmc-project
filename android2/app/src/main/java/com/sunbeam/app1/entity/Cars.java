package com.sunbeam.app1.entity;

import java.io.Serializable;

public class Cars implements Serializable
{
    /*
    --car_id INT PRIMARY KEY AUTO_INCREMENT,
    --model_name VARCHAR(255) NOT NULL,
    --purchase_year INT NOT NULL,
    --availability BOOLEAN NOT NULL,
    --location_id INT NOT NULL,
    --no_of_seats INT NOT NULL,
    --luggage_capacity INT,
    --cost_per_hour DECIMAL(10, 2) NOT NULL,
    --late_fee_per_hour DECIMAL(10, 2),
    --fuel_type VARCHAR(50) NOT NULL,
    --kms_driven INT NOT NULL,
    --transmission VARCHAR(20) NOT NULL,
    --mileage DECIMAL(5, 2) NOT NULL,
    --car_color VARCHAR(50),
    --user_id INT NOT NULL,
    --insurance BOOLEAN,
    --description VARCHAR(1000) NOT NULL,
     */

    private int id, year, locationId, seats, capacity, kmsDriven, userId;
    private String name, fuelType, transmission, carColor, description;
    private Boolean availability, insurance;
    private Double cost_perHour, lateFeePerHour, mileage;

    public Cars() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getKmsDriven() {
        return kmsDriven;
    }

    public void setKmsDriven(int kmsDriven) {
        this.kmsDriven = kmsDriven;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Boolean getInsurance() {
        return insurance;
    }

    public void setInsurance(Boolean insurance) {
        this.insurance = insurance;
    }

    public Double getCost_perHour() {
        return cost_perHour;
    }

    public void setCost_perHour(Double cost_perHour) {
        this.cost_perHour = cost_perHour;
    }

    public Double getLateFeePerHour() {
        return lateFeePerHour;
    }

    public void setLateFeePerHour(Double lateFeePerHour) {
        this.lateFeePerHour = lateFeePerHour;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }
}
