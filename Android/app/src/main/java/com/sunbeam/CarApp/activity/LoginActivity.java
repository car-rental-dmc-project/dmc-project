package com.sunbeam.CarApp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.sunbeam.CarApp.db.CarDbHelper;
import com.sunbeam.CarApp.entity.User;
import com.sunbeam.CarApp.utils.Constants;
import com.sunbeam.R;

public class LoginActivity extends AppCompatActivity {

    EditText al_editemailid, al_editpassword;
    CheckBox al_checkboxrememberme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean status = getSharedPreferences(Constants.CARAPP_PREFERENCE, MODE_PRIVATE)
                .getBoolean(Constants.LOGIN_STATUS, false);
        if(status)
        {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login);
        al_editemailid = findViewById(R.id.al_editemailid);
        al_editpassword = findViewById(R.id.al_editpassword);
        al_checkboxrememberme = findViewById(R.id.al_checkboxrememberme);
    }


    public void al_login(View view)
    {
        String emailid = al_editemailid.getText().toString();
        String password = al_editpassword.getText().toString();
        CarDbHelper carDbHelper = new CarDbHelper(this);
        User user = carDbHelper.getUser(emailid, password);
        if(user!=null)
        {
            if(al_checkboxrememberme.isChecked())
            {
                SharedPreferences preferences = getSharedPreferences(Constants.CARAPP_PREFERENCE, MODE_PRIVATE);
                preferences.edit().putBoolean(Constants.LOGIN_STATUS,true).apply();
            }
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
        else Toast.makeText(this, "email or password is incorrect", Toast.LENGTH_SHORT).show();

    }

    public void al_register(View view)
    {
        startActivity(new Intent(this,RegisterActivity.class));
    }
}