package com.sunbeam.app1.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Bookings implements Serializable
{
    /*
    --booking_id INT PRIMARY KEY AUTO_INCREMENT,
    --from_datetime DATETIME NOT NULL,
    --to_datetime DATETIME NOT NULL,
    --amount_per_hour DECIMAL(10, 2) NOT NULL,
    status BOOLEAN,
    --discount DECIMAL(5, 2),
    --deposit DECIMAL(10, 2) NOT NULL,
    --car_id INT NOT NULL,
    foreign key(car_id) references car_details(car_id)
    --user_id INT NOT NULL
     */
    private int id, carId, userId;
    private Double amountPerHour, discount, deposit;
    private LocalDateTime fromDateTime, toDateTime;
    private Boolean status;

    public Bookings() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Double getAmountPerHour() {
        return amountPerHour;
    }

    public void setAmountPerHour(Double amountPerHour) {
        this.amountPerHour = amountPerHour;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(LocalDateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public LocalDateTime getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(LocalDateTime toDateTime) {
        this.toDateTime = toDateTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
