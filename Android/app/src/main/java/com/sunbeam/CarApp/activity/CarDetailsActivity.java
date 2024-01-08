package com.sunbeam.CarApp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.sunbeam.CarApp.entity.Car;
import com.sunbeam.R;

public class CarDetailsActivity extends AppCompatActivity {

    TextView acd_modelname, acd_purchaseyear, acd_costperhour;
    TextView acd_fueltype, acd_transmission, acd_kmsdriven;
    TextView acd_mileage, acd_insurance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        acd_modelname = findViewById(R.id.acd_modelname);
        acd_purchaseyear = findViewById(R.id.acd_purchaseyear);
        acd_costperhour = findViewById(R.id.acd_costperhour);
        acd_fueltype = findViewById(R.id.acd_fueltype);
        acd_transmission = findViewById(R.id.acd_transmission);
        acd_kmsdriven = findViewById(R.id.acd_kmsdriven);
        acd_mileage = findViewById(R.id.acd_mileage);
        acd_insurance = findViewById(R.id.acd_insurance);

        Car car = (Car) getIntent().getSerializableExtra("car");

        acd_modelname.setText("Model Name : "+ car.getModelname());
        acd_purchaseyear.setText("Purchase Year : "+ car.getPurchaseyear());
        acd_costperhour.setText("Cost Per Hour : "+ car.getCostperhour());
        acd_fueltype.setText("Fuel Type : "+ car.getFueltype());
        acd_transmission.setText("Transmission : "+ car.getTransmission());
        acd_kmsdriven.setText("Kms Driven : "+ car.getKmsdriven());
        acd_mileage.setText("Mileage : "+ car.getMileage());
        acd_insurance.setText("Insurance : "+ car.getInsurance());

    }
}