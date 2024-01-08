package com.sunbeam.CarApp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;

import com.sunbeam.CarApp.db.CarDbHelper;
import com.sunbeam.CarApp.entity.Car;
import com.sunbeam.CarApp.utils.Constants;
import com.sunbeam.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Toolbar am_toolbar;
    ListView am_listview;
    List<Car> carList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am_toolbar= findViewById(R.id.am_toolbar);
        am_listview= findViewById(R.id.am_listview);
        setSupportActionBar(am_toolbar);
        carList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, carList);
        am_listview.setAdapter(arrayAdapter);

        am_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        am_listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
            {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
                popupMenu.getMenu().add("Edit");
                popupMenu.getMenu().add("Delete");
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        if(item.getTitle().equals("Edit"))
                        {
                            Intent intent = new Intent(MainActivity.this, EditCarActivity.class);
                            intent.putExtra("car", carList.get(position));
                            startActivity(intent);
                        }
                        if(item.getTitle().equals("Delete"))
                        {
                            new CarDbHelper(MainActivity.this).delete(carList.get(position).getId());
                            getAllCars();
                        }

                        return false;
                    }
                });

                return false;
            }
        });

    }

    @Override
    public void onStart()
    {
        super.onStart();
        getAllCars();
    }
    public void getAllCars()
    {
        CarDbHelper carDbHelper = new CarDbHelper(this);
        carDbHelper.getCars(carList);
        arrayAdapter.notifyDataSetChanged();
    }


    public boolean onCreateOptionsMenu(@NonNull Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId()==R.id.mm_add)
        {
            startActivity(new Intent(this, AddCarActivity.class));
        }
        if(item.getItemId()==R.id.mm_logout)
        {
            getSharedPreferences(Constants.CARAPP_PREFERENCE, MODE_PRIVATE).edit().putBoolean(Constants.LOGIN_STATUS, false).apply();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


}