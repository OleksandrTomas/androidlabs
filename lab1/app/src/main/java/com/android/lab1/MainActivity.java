package com.android.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements inputFragment.FragmentAListener {

    private inputFragment fragmentA;
    private outputFragment fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       fragmentA = new inputFragment();
       fragmentB = new outputFragment();

       getSupportFragmentManager().beginTransaction()
               .replace(R.id.fragmentContainerView, fragmentA)
               .replace(R.id.fragmentContainerView2, fragmentB)
               .commit();
    }

    @Override
    public void onInputOkButton(String input, String font_type) {
        fragmentB.updateText(input,font_type);
    }
    @Override
    public void onInputCancelButton() {
        fragmentB.clearText();
    }
}