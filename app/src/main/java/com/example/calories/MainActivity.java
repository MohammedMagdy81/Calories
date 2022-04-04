package com.example.calories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mMale,mFamale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MaleFragment maleFragment= new MaleFragment();
        FamaleFragment famaleFragment= new FamaleFragment();
        mMale= findViewById(R.id.btn_male);
        mFamale= findViewById(R.id.btn_famale);

        mMale.setOnClickListener(view -> setFragment(maleFragment));
        mFamale.setOnClickListener(view -> setFragment(famaleFragment));



    }

    private void setFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.fragment_contianer,fragment).commit();
    }
}