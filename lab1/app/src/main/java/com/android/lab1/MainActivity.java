package com.android.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements MainInputFragment.FragmentAListener {

    private MainInputFragment fragmentA;
    private MainOutputFragment fragmentB;
    Button button_storage;
    Button button_media;
    DatabaseHelper DataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentA = new MainInputFragment();
        fragmentB = new MainOutputFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainerView, fragmentA)
                .replace(R.id.fragmentContainerView2, fragmentB)
                .commit();

        button_storage = findViewById(R.id.open_Storage);
        button_media = findViewById(R.id.open_Media);
        DataBase = new DatabaseHelper(this);

        button_media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MediaActivity.class);
                startActivity(intent);
            }
        });
        button_storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onInputOkButton(String input, String font_type) {
        fragmentB.updateText(input, font_type);
        boolean checkinsert = DataBase.insertData(font_type,input);
        if (checkinsert){
            Toast.makeText(this, R.string.success, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onInputCancelButton() {
        fragmentB.clearText();
    }
}