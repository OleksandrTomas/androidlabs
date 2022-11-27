package com.android.lab1;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class inputFragment extends Fragment {

    private EditText text_field;
    private RadioGroup radio_group;

    private FragmentAListener listener;

    public interface FragmentAListener {
        void  onInputInpFrag(String input,int radio);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input, container, false);

        text_field = v.findViewById(R.id.text_field);
        Button button_ok = v.findViewById(R.id.button_ok);
        Button button_cancel = v.findViewById(R.id.button_cancel);
        radio_group = v.findViewById(R.id.radio_group);

        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(text_field.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), R.string.no_input, Toast.LENGTH_LONG).show();
                }
                else{
                    int radio_id=radio_group.getCheckedRadioButtonId();
                    String text= text_field.getText().toString();
                    listener.onInputInpFrag(text,radio_id);
                }
            }
        });

        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_field.setText("");
                listener.onInputInpFrag("",R.id.f_font);
            }
        });
        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {listener = (FragmentAListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + " must implement FragmentBListener");
        }
    }


}