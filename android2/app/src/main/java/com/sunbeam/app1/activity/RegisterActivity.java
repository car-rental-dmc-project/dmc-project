package com.sunbeam.app1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.JsonObject;
import com.sunbeam.app1.R;
import com.sunbeam.app1.api.RetrofitClient;
import com.sunbeam.app1.entity.Users;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    TextInputLayout email , password , first_name, middle_name, last_name, phone, confirm_password;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        first_name = findViewById(R.id.first_name);
        middle_name = findViewById(R.id.middle_name);
        last_name = findViewById(R.id.last_name);
        phone = findViewById(R.id.phone);
        confirm_password = findViewById(R.id.confirm_password);
    }

    private  Boolean validateFirstName(){
        String valFName = first_name.getEditText().getText().toString();
        if (valFName.isEmpty()){
            first_name.setError("Fields cannot be empty");
            return false;
        }
        else {
            first_name.setError(null);
            first_name.setErrorEnabled(false);
            return true;
        }
    }
    private  Boolean validateLastName(){
        String valLName = last_name.getEditText().getText().toString();
        if (valLName.isEmpty()){
            last_name.setError("Fields cannot be empty");
            return false;
        }
        else {
            last_name.setError(null);
            last_name.setErrorEnabled(false);
            return true;
        }
    }
    private  Boolean validateEmail(){
        String valEmail = email.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._]+@[a-z]+\\.+[a-z]+";
        if (valEmail.isEmpty()){
            email.setError("Fields cannot be empty");
            return false;
        } else if (!valEmail.matches(emailPattern)) {
            email.setError("Invalid Email Address");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }
    private  Boolean validatePhone(){
        String valPhone = phone.getEditText().getText().toString();
        if (valPhone.isEmpty()){
            phone.setError("Fields cannot be empty");
            return false;
        } else if (valPhone.length() != 10) {
            phone.setError("Phone no. should be 10 digit");
            return false;
        } else {
            phone.setError(null);
            phone.setErrorEnabled(false);
            return true;
        }
    }
    private  Boolean validatePassword(){
        String valPass = password.getEditText().getText().toString();
        String passPattern = "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 8 characters
                "$";
        if (valPass.isEmpty()){
            password.setError("Fields cannot be empty");
            return false;
        } else if (!valPass.matches(passPattern)) {
            password.setError("Password must contain 8 character, 1 lower case, 1 upper case, 1 special character");
            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
    private  Boolean validateConfirmPassword(){
        String valCPass = confirm_password.getEditText().getText().toString();
        String valPass = password.getEditText().getText().toString();
        if (valCPass.isEmpty()){
            confirm_password.setError("Fields cannot be empty");
            return false;
        } else if (!valCPass.equals(valPass)) {
            confirm_password.setError("Password doesn't matches");
            return false;
        } else {
            confirm_password.setError(null);
            confirm_password.setErrorEnabled(false);
            return true;
        }
    }
    public void al_login(View view){
        finishAfterTransition();
    }
    public void sign_up(View view){
        if (!validateFirstName() | !validateLastName() | !validateEmail() |
                !validatePhone() | !validatePassword() | !validateConfirmPassword()){
              return;
        }
        Users users = new Users();
        users.setFirstName(first_name.getEditText().getText().toString());
        String mName = middle_name.getEditText().getText().toString();
        if (!mName.isEmpty())
            users.setMiddleName(mName);
        else users.setMiddleName(null);
        users.setLastName(last_name.getEditText().getText().toString());
        users.setEmail(email.getEditText().getText().toString());
        users.setContact(phone.getEditText().getText().toString());
        users.setPassword(password.getEditText().getText().toString());

        RetrofitClient.getInstance().getApi().registerUser(users).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.body().get("status").getAsString().equals("success"))
                    finishAfterTransition();
                else {
                    if (response.body().get("error").getAsJsonObject().get("errno").getAsInt() == 1062){
                        Toast.makeText(RegisterActivity.this, "Something went wrong while registration", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Something went wrong while registration", Toast.LENGTH_SHORT).show();
            }
        });
    }
}