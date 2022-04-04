package com.example.calories;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MaleFragment extends Fragment{

    EditText etHeight,etWeight,etAge;
    Spinner spin ;
    Button mBtnCalc;
   // double BMR;
    TextView mResult;
    String[] country = { "نمط حياة خامل", "نمط حياة خفيف", "نمط حياة متوسط النشاط", "نمط حياة شديد النشاط"};
    double  calories ;
    ArrayAdapter aa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_male, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpViews(view);

        aa = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);

        mBtnCalc.setOnClickListener(view11 -> {

            if ((etWeight.getText().toString().isEmpty() ||
                    etHeight.getText().toString().isEmpty() ||
                    etAge.getText().toString().isEmpty() )){
                Toast.makeText(view.getContext(), "Enter Valid Details", Toast.LENGTH_LONG).show();

            }else{
                //Toast.makeText(view.getContext(), "Enter Valid Details", Toast.LENGTH_LONG).show();
                double weight = Double.parseDouble(etWeight.getText().toString());
                double height =  Double.parseDouble(etHeight.getText().toString());
                int age =  Integer.parseInt(etAge.getText().toString());
                //BMR = 10*weight + 6.25*height - 5*age +5;
                spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                        double BMR = 10*weight + 6.25*height - 5*age +5;
                        if (position==0){
                            calories= BMR*1.25;
                            mResult.setText(String.valueOf(calories));
                        }else if (position==1){
                            calories= BMR*1.375;
                            mResult.setText(String.valueOf(calories));
                        }else if (position==2){
                            calories= BMR*1.550;
                            mResult.setText(String.valueOf(calories));
                        }else if (position==3){
                            calories= BMR*1.725;
                            mResult.setText(String.valueOf(calories));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

        });


    }

    private void setUpViews(View view) {
        etHeight =view.findViewById(R.id.et_height);
        etWeight =view.findViewById(R.id.et_weight);
        etAge =view.findViewById(R.id.et_age);
        spin = view.findViewById(R.id.spinner);
        mResult= view.findViewById(R.id.text_result);
        mBtnCalc= view.findViewById(R.id.btn_claculate);
    }



}







