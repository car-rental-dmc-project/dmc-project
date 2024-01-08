package com.sunbeam.CarApp.entity;

import java.io.Serializable;

public class User implements Serializable
{
    private int id;
    private String fname;
    private String mname;
    private String lname;
    private String phone;
    private String emailid;
    private String password;

    public User()
    {

    }

    public User(int id, String fname, String mname, String lname, String phone, String emailid, String password) {
        this.id = id;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.phone = phone;
        this.emailid = emailid;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", emailid='" + emailid + '\'' +
                '}';
    }
}
