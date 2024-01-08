package com.sunbeam.CarApp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.sunbeam.CarApp.db.CarDbHelper;
import com.sunbeam.CarApp.entity.Car;
import com.sunbeam.R;

public class EditCarActivity extends AppCompatActivity {

    Car car;
    TextView aec_textmodelname, aec_textpurchaseyear, aec_textcostperhour;
    TextView aec_textfueltype,aec_texttransmission, aec_textkmsdriven;
    TextView aec_textmileage,aec_textinsurance;
    EditText aec_editcostperhour, aec_editkmsdriven, aec_editmileage;
    RadioButton aec_radiobtnyes, aec_radiobtnno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_car);
        aec_textmodelname= findViewById(R.id.aec_textmodelname);
        aec_textpurchaseyear= findViewById(R.id.aec_textpurchaseyear);
        aec_textcostperhour= findViewById(R.id.aec_textcostperhour);
        aec_textfueltype= findViewById(R.id.aec_textfueltype);
        aec_texttransmission= findViewById(R.id.aec_texttransmission);
        aec_textkmsdriven= findViewById(R.id.aec_textkmsdriven);
        aec_textmileage= findViewById(R.id.aec_textmileage);
        aec_textinsurance= findViewById(R.id.aec_textinsurance);
        aec_editcostperhour= findViewById(R.id.aec_editcostperhour);
        aec_editkmsdriven= findViewById(R.id.aec_editkmsdriven);
        aec_editmileage= findViewById(R.id.aec_editmileage);
        aec_radiobtnyes= findViewById(R.id.aec_radiobtnyes);
        aec_radiobtnno= findViewById(R.id.aec_radiobtnno);

        car = (Car) getIntent().getSerializableExtra("car");
        aec_textmodelname.setText("Model Name : "+car.getModelname());
        aec_textpurchaseyear.setText("Purchase Year : "+ car.getPurchaseyear());
        aec_textcostperhour.setText("Cost Per Hour");
        aec_textfueltype.setText("Fuel Type : "+ car.getFueltype());
        aec_texttransmission.setText("Transmission : "+ car.getTransmission());
        aec_textkmsdriven.setText("Kms Driven : ");
        aec_textmileage.setText("Mileage : ");
        aec_textinsurance.setText("Insurance");

        aec_editcostperhour.setText(""+ car.getCostperhour());
        aec_editkmsdriven.setText(""+ car.getKmsdriven());
        aec_editmileage.setText(""+ car.getMileage());
        if (car.getInsurance()) {
            aec_textinsurance.setText("Insurance : Yes");
            aec_radiobtnyes.setChecked(true);
            aec_radiobtnno.setChecked(false);
        } else {
            aec_textinsurance.setText("Insurance : No");
            aec_radiobtnyes.setChecked(false);
            aec_radiobtnno.setChecked(true);
        }
    }

    public void aec_update(View view)
    {

        double costperhour = Double.parseDouble(aec_editcostperhour.getText().toString());
        double kmsdriven = Double.parseDouble(aec_editkmsdriven.getText().toString());
        double mileage = Double.parseDouble(aec_editmileage.getText().toString());
        boolean insurance = aec_radiobtnyes.isChecked();

        car.setCostperhour(costperhour);
        car.setKmsdriven(kmsdriven);
        car.setMileage(mileage);
        car.setInsurance(insurance);


        CarDbHelper carDbHelper= new CarDbHelper(this);
        carDbHelper.updateCar(car.getId(),costperhour, kmsdriven, mileage, insurance);
        finish();
    }
}