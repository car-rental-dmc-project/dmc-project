package com.sunbeam.CarApp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.sunbeam.CarApp.db.CarDbHelper;
import com.sunbeam.CarApp.entity.Car;
import com.sunbeam.R;

public class AddCarActivity extends AppCompatActivity {

    EditText aac_editmodelname, aac_editpurchaseyear, aac_editcostperhour;
    EditText aac_editfueltype, aac_edittransmission, aac_editkmsdriven, aac_editmileage;
    RadioButton acc_radiobtnyes, acc_radiobtnno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);
        aac_editmodelname= findViewById(R.id.aac_editmodelname);
        aac_editpurchaseyear= findViewById(R.id.aac_editpurchaseyear);
        aac_editcostperhour= findViewById(R.id.aac_editcostperhour);
        aac_editfueltype= findViewById(R.id.aac_editfueltype);
        aac_edittransmission= findViewById(R.id.aac_edittransmission);
        aac_editkmsdriven= findViewById(R.id.aac_editkmsdriven);
        aac_editmileage= findViewById(R.id.aac_editmileage);
        acc_radiobtnyes= findViewById(R.id.acc_radiobtnyes);
        acc_radiobtnno= findViewById(R.id.acc_radiobtnno);
    }

    public void aac_add(View view)
    {
        Car car = new Car();
        car.setModelname(aac_editmodelname.getText().toString());
        car.setPurchaseyear(Integer.parseInt(aac_editpurchaseyear.getText().toString()));
        car.setCostperhour(Double.parseDouble(aac_editcostperhour.getText().toString()));
        car.setFueltype(aac_editfueltype.getText().toString());
        car.setTransmission(aac_edittransmission.getText().toString());
        car.setKmsdriven(Double.parseDouble(aac_editkmsdriven.getText().toString()));
        car.setMileage(Double.parseDouble(aac_editmileage.getText().toString()));

        if (acc_radiobtnyes.isChecked())
        {
            car.setInsurance(true);
        }
        else
        {
            car.setInsurance(false);
        }

        CarDbHelper carDbHelper= new CarDbHelper(this);
        carDbHelper.insertCar(car);
        finish();
    }
}