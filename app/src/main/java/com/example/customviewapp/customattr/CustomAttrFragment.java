package com.example.customviewapp.customattr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.customviewapp.R;

public class CustomAttrFragment extends Fragment {

    public CustomAttrFragment() {
    }

    public static CustomAttrFragment newInstance() {
        return new CustomAttrFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_custom_attr, container, false);
    }
}