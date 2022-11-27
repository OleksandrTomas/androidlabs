package com.android.lab1;

import android.graphics.Typeface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class outputFragment extends Fragment {

    private TextView result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_output, container, false);
        result = v.findViewById(R.id.result);
        return v;
    }
    public void updateText(String newtext,int radio_id){
        result.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),findRadioButton(radio_id)));
        result.setText(newtext);
    }
    public String findRadioButton(int radio_id) {
        switch (radio_id){
            case R.id.f_font:
                return getString(getResources().getIdentifier("Adamina_path", "string", getActivity().getPackageName()));
            case R.id.s_font:
                return getString(getResources().getIdentifier("Aldrich_path", "string", getActivity().getPackageName()));
            case R.id.t_font:
                return getString(getResources().getIdentifier("Bahiana_path", "string", getActivity().getPackageName()));
            default:
                throw new IllegalStateException("Unexpected value: " + radio_id);
        }
    }
}