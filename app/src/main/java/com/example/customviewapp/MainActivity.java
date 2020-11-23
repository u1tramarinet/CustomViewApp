package com.example.customviewapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.customviewapp.customattr.CustomAttrFragment;
import com.example.customviewapp.mergetag.MergeTagFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        addFragmentToActivity(BlankFragment.newInstance());
//        addFragmentToActivity(ButtonFragment.newInstance());
//        addFragmentToActivity(CustomAttrFragment.newInstance());
        addFragmentToActivity(MergeTagFragment.newInstance());
    }

    private void addFragmentToActivity(@NonNull Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.contentFrame, fragment);
        fragmentTransaction.commit();
    }
}
