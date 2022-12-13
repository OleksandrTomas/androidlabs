package com.android.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    private TextView text_data;
    private Button clear_tablet;
    DatabaseHelper DataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        text_data = findViewById(R.id.text_info);
        clear_tablet = findViewById(R.id.clear_tablet);

        DataBase = new DatabaseHelper(this);

        Cursor res = DataBase.getData();
        while (res.moveToNext()) {
            String font = res.getString(0);
            String text = res.getString(1);
            text_data.append("* Font path: " + font + " | Text: " + text + "\n");
        }
        clear_tablet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataBase.deleteData();
                text_data.setText("");
            }
        });
    }

}
