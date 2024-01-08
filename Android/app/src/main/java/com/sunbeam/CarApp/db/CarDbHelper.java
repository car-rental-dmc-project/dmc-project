package com.sunbeam.CarApp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.sunbeam.CarApp.entity.Car;
import com.sunbeam.CarApp.entity.User;
import com.sunbeam.CarApp.utils.Constants;

import java.util.List;

public class CarDbHelper extends SQLiteOpenHelper {
    public CarDbHelper(@Nullable Context context) {
        super(context, "carapp_db" , null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sqlCar = "create table "+ Constants.CAR_TABLE+
                "("+Constants.ID+" integer primary key autoincrement,"+
                Constants.CAR_MODELNAME+" text,"+Constants.CAR_PURCHASEYEAR+" text,"+
                Constants.CAR_COSTPERHOUR+" text,"+Constants.CAR_FUELTYPE+" text,"+
                Constants.CAR_TRANSMISSION+" text,"+Constants.CAR_KMSDRIVEN+" text,"+
                Constants.CAR_MILEAGE+" text,"+Constants.CAR_INSURANCE+" boolean)";

        String sqlUser = "create table "+Constants.USER_TABLE+
                "("+Constants.ID+" integer primary key autoincrement,"+
                Constants.USER_FNAME+" text,"+Constants.USER_MNAME+" text,"+
                Constants.USER_LNAME+" text,"+Constants.USER_PHONE+" text,"+
                Constants.USER_EMAILID+" text,"+Constants.USER_PASSWORD+" text)";

        db.execSQL(sqlCar);
        db.execSQL(sqlUser);
    }

    public void insertUser(User user)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.USER_FNAME, user.getFname());
        values.put(Constants.USER_MNAME, user.getMname());
        values.put(Constants.USER_LNAME, user.getLname());
        values.put(Constants.USER_PHONE, user.getPhone());
        values.put(Constants.USER_EMAILID, user.getEmailid());
        values.put(Constants.USER_PASSWORD, user.getPassword());

        db.insert(Constants.USER_TABLE, null, values);
    }

    public User getUser(String emailid, String password)
    {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(Constants.USER_TABLE,null, "emailid=? and password=?", new String[]{emailid, password}, null, null, null);
        if(cursor.moveToNext())
        {
            User user = new User();
            user.setId(cursor.getInt(0));
            user.setEmailid(emailid);
            user.setPassword(password);
            user.setFname(cursor.getString(1));
            user.setMname(cursor.getString(2));
            user.setLname(cursor.getString(3));
            user.setPhone(cursor.getString(4));
            return user;
        }
        return null;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }

    public void insertCar(Car car)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.CAR_MODELNAME, car.getModelname());
        values.put(Constants.CAR_PURCHASEYEAR, car.getPurchaseyear());
        values.put(Constants.CAR_COSTPERHOUR, car.getCostperhour());
        values.put(Constants.CAR_FUELTYPE, car.getFueltype());
        values.put(Constants.CAR_TRANSMISSION, car.getTransmission());
        values.put(Constants.CAR_KMSDRIVEN, car.getKmsdriven());
        values.put(Constants.CAR_MILEAGE, car.getMileage());
        values.put(Constants.CAR_INSURANCE, car.getInsurance());

        db.insert(Constants.CAR_TABLE, null, values);
    }

    public void getCars(List<Car> carList)
    {
        carList.clear();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(Constants.CAR_TABLE, null,null,null,null,null,null);
        while(cursor.moveToNext())
        {
            Car car= new Car();
            car.setId(cursor.getInt(0));
            car.setModelname(cursor.getString(1));
            car.setPurchaseyear(cursor.getInt(2));
            car.setCostperhour(cursor.getDouble(3));
            car.setFueltype(cursor.getString(4));
            car.setTransmission(cursor.getString(5));
            car.setKmsdriven(cursor.getDouble(6));
            car.setMileage(cursor.getDouble(7));
            car.setInsurance(cursor.getInt(8) == 1);
            carList.add(car);
        }
    }


    public void updateCar(int id, double costperhour, double kmsdriven, double mileage, boolean insurance)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Constants.CAR_COSTPERHOUR, costperhour);
        values.put(Constants.CAR_KMSDRIVEN, kmsdriven);
        values.put(Constants.CAR_MILEAGE, mileage);
        values.put(Constants.CAR_INSURANCE,insurance ? 1:0);
        Log.e("values", ""+values);
        db.update(Constants.CAR_TABLE,values,"id=?",new String[]{""+id});
    }

    public void delete(int id)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Constants.CAR_TABLE, "id=?", new String[]{""+id});
    }
}
