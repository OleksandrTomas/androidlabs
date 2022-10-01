package com.android.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text_field;
    private TextView result;
    private RadioGroup radio_group;
    private Typeface tf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_field = findViewById(R.id.text_field);
        Button button_ok = findViewById(R.id.button_ok);
        result = findViewById(R.id.result);
        Button button_cancel = findViewById(R.id.button_cancel);
        radio_group = findViewById(R.id.radio_group);


        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text_field.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, R.string.no_input, Toast.LENGTH_LONG).show();
                }
                else{
                    int radio_id=radio_group.getCheckedRadioButtonId();
                    findRadioButton(radio_id);
                    result.setTypeface(tf);
                    String text= text_field.getText().toString();
                    result.setText(text);
                }
            }
        });
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_field.setText("");
                result.setText("");
            }
        });

    }

    private void findRadioButton(int radio_id) {
        switch (radio_id){
            case R.id.f_font:
                tf= Typeface.createFromAsset(getAssets(), "fonts/Adamina-Regular.ttf");
                break;
            case R.id.s_font:
                tf= Typeface.createFromAsset(getAssets(), "fonts/Aldrich-Regular.ttf");
                break;
            case R.id.t_font:
                tf= Typeface.createFromAsset(getAssets(), "fonts/Bahiana-Regular.ttf");
                break;
        }
    }

}