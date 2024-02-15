package com.sunbeam.app1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sunbeam.app1.R;
import com.sunbeam.app1.api.RetrofitClient;
import com.sunbeam.app1.entity.Users;
import com.sunbeam.app1.utility.CarRentalConstants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    CheckBox check_remember;
    TextInputLayout email, password;
    Button login_signIn , login_signUp;
    TextView welcome, slogan;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        check_remember = findViewById(R.id.check_remember);
        check_remember.setChecked(true);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login_signIn = findViewById(R.id.login_signIn);
        login_signUp = findViewById(R.id.login_signUp);
        welcome = findViewById(R.id.welcome);
        slogan = findViewById(R.id.slogan);
    }

    public void login(View view){
        Log.e("LoginActivity",email.getEditText().getText().toString());
        Log.e("LoginActivity",password.getEditText().getText().toString());
        Users user = new Users();
        user.setEmail(email.getEditText().getText().toString());
        user.setPassword(password.getEditText().getText().toString());
        if (check_remember.isChecked()){
            getSharedPreferences(CarRentalConstants.SHARED_PREFERENCE_FILE_NAME,MODE_PRIVATE)
                    .edit()
                    .putBoolean(CarRentalConstants.LOGIN_STATUS,true)
                    .apply();
        }

        RetrofitClient.getInstance().getApi().loginUser(user).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.e("LoginActivity",response.body().getAsString());
                if (response.body().get("status").getAsString().equals("success")){
                    JsonArray array = response.body().get("data").getAsJsonArray();
                    Log.e("LoginActivity",array.getAsString());
                    if (array.size() != 0){
                        Log.e("LoginActivity",array.get(0).getAsJsonObject().getAsString());
                        int id = array.get(0).getAsJsonObject().get("user_id").getAsInt();
                        getSharedPreferences(CarRentalConstants.SHARED_PREFERENCE_FILE_NAME,MODE_PRIVATE)
                                .edit()
                                .putInt(CarRentalConstants.USER_ID,id)
                                .apply();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }
                    else {
                        Toast.makeText(LoginActivity.this,"Invalid Email and Password",Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(LoginActivity.this,"Something went wrong at the Login",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void register(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);

        Pair pairs[] = new Pair[6];
        pairs[0] = new Pair<View,String>(welcome,"logo_name");
        pairs[1] = new Pair<View,String>(slogan,"logo_sign");
        pairs[2] = new Pair<View,String>(email,"emailTrans");
        pairs[3] = new Pair<View,String>(password,"passwordTrans");
        pairs[4] = new Pair<View,String>(login_signIn,"btn_trans");
        pairs[5] = new Pair<View,String>(login_signUp,"login_signup_trans");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this,pairs);
        startActivity(intent,options.toBundle());

    }
}