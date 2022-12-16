package com.android.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    private TextView text_data;
    DatabaseHelper DataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text_data = findViewById(R.id.text_info);
        Button clear_tablet = findViewById(R.id.clear_tablet);

        DataBase = new DatabaseHelper(this);

        text_data.append(DataBase.getDataStrings());

        clear_tablet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase.deleteData();
                text_data.setText("");
            }
        });
    }

}
