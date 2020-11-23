package com.example.customviewapp.mergetag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.customviewapp.R;

public class MergeTagFragment extends Fragment {

    public MergeTagFragment() {
        // Required empty public constructor
    }

    public static MergeTagFragment newInstance() {
        return new MergeTagFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_merge_tag, container, false);
    }
}