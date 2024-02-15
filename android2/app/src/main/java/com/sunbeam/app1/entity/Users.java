package com.sunbeam.app1.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Users implements Serializable
{
    /*
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    driving_license VARCHAR(20) UNIQUE,
    first_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    last_name VARCHAR(255) NOT NULL,
    contact VARCHAR(15) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(50) NOT NULL,
    aadhar_no VARCHAR(12) UNIQUE,
    pan_no VARCHAR(10) UNIQUE,
    dob DATE,
    gender VARCHAR(10),
    role VARCHAR(50) NOT NULL DEFAULT 'user',
    status BOOLEAN
    */

    private int id;
    private String drivingLicense, firstName, middleName, lastName, contact, email, password, aadharNo, panNo, gender, role;
    private Date dob;
    private  Boolean status;
    private Timestamp createdTimeStamp;

    public Users() {
    }

    public Users(String drivingLicense, String firstName, String middleName, String lastName, String contact, String email, String password, String aadharNo, String panNo, String gender, String role, Date dob, Boolean status, Timestamp createdTimeStamp) {
        this.drivingLicense = drivingLicense;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.aadharNo = aadharNo;
        this.panNo = panNo;
        this.gender = gender;
        this.role = role;
        this.dob = dob;
        this.status = status;
        this.createdTimeStamp = createdTimeStamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Timestamp getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(Timestamp createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }
}
