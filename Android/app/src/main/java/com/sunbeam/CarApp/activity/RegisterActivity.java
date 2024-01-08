package com.sunbeam.CarApp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sunbeam.CarApp.db.CarDbHelper;
import com.sunbeam.CarApp.entity.User;
import com.sunbeam.R;

public class RegisterActivity extends AppCompatActivity {


    EditText ar_editfname, ar_editmname, ar_editlname, ar_editphone, ar_editemailid, ar_editpassword, ar_editconfirmpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ar_editfname = findViewById(R.id.ar_editfname);
        ar_editmname = findViewById(R.id.ar_editmname);
        ar_editlname = findViewById(R.id.ar_editlname);
        ar_editphone = findViewById(R.id.ar_editphone);
        ar_editemailid = findViewById(R.id.ar_editemailid);
        ar_editpassword = findViewById(R.id.ar_editpassword);
        ar_editconfirmpassword = findViewById(R.id.ar_editconfirmpassword);
    }

    private User validateUser()
    {
        User user = new User();
        user.setFname(ar_editfname.getText().toString());
        user.setMname(ar_editmname.getText().toString());
        user.setLname(ar_editlname.getText().toString());
        user.setPhone(ar_editphone.getText().toString());
        user.setEmailid(ar_editemailid.getText().toString());
        user.setPassword(ar_editpassword.getText().toString());

        if(user.getFname().equals(""))
            Toast.makeText(this, "First Name cannot be empty", Toast.LENGTH_SHORT).show();
        else if(user.getMname().equals(""))
            Toast.makeText(this, "Middle Name cannot be empty", Toast.LENGTH_SHORT).show();
        else if(user.getLname().equals(""))
            Toast.makeText(this, "Last Name cannot be empty", Toast.LENGTH_SHORT).show();
        else if(user.getPhone().equals(""))
            Toast.makeText(this, "Phone cannot be empty", Toast.LENGTH_SHORT).show();
        else if(user.getEmailid().equals(""))
            Toast.makeText(this, "Emailid cannot be empty", Toast.LENGTH_SHORT).show();
        else if(user.getPassword().equals(""))
            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show();
        else
        {
            if(user.getPassword().equals(ar_editconfirmpassword.getText().toString()))
                return user;
            else
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        }
        return null;
    }
    public void ar_register(View view)
    {
        User user= validateUser();
        if(user!=null)
        {
            CarDbHelper carDbHelper = new CarDbHelper(this);
            carDbHelper.insertUser(user);
            finish();
        }
    }

    public void ar_cancel(View view)
    {
        finish();
    }
}