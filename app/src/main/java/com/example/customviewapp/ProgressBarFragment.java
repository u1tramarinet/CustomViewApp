package com.example.customviewapp;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class ProgressBarFragment extends Fragment {

    private CustomView customView;
    private ProgressBar progressBar1;
    private ProgressBar progressBar2;
    private ProgressBar progressBar3;
    private ProgressBar progressBar4;
    private SeekBar seekBar;

    MutableLiveData<Integer> progressData = new MutableLiveData<>();

    public ProgressBarFragment() {
        // Required empty public constructor
    }
    public static ProgressBarFragment newInstance() {
        return new ProgressBarFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_progress_bar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        customView = view.findViewById(R.id.customView);
        progressBar1 = view.findViewById(R.id.progressBar1);
        progressBar2 = view.findViewById(R.id.progressBar2);
        progressBar3 = view.findViewById(R.id.progressBar3);
        progressBar4 = view.findViewById(R.id.progressBar4);
        seekBar = view.findViewById(R.id.seekbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressData.postValue(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        progressData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer progress) {
                if (progress == null) return;
                progressBar2.setProgress(progress, true);
                progressBar3.setProgress(progress, true);
                progressBar4.setProgress(progress, true);
                if (progress <= 95) {
                    progressBar3.setSecondaryProgress(progress + 5);
                }
            }
        });

        test();
    }

    private void test() {
//        progressBar2.setProgress(50, true);
//        progressBar3.setProgress(50, true);
//        progressBar3.setSecondaryProgress(52);
    }
}
