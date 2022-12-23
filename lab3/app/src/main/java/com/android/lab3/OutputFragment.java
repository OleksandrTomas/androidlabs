package com.android.lab3;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class OutputFragment extends Fragment {

    private TextView result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_output, container, false);
        result = v.findViewById(R.id.result);
        return v;
    }

    public void updateText(String newtext, String font_id) {
        result.setTypeface(Typeface.createFromAsset(getActivity().getAssets(), font_id));
        result.setText(newtext);
    }
    public void clearText() {
        result.setText("");
    }
}
