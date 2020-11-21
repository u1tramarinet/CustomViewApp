package com.example.customviewapp.customattr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;

import com.example.customviewapp.R;

public class CustomTextView extends android.support.v7.widget.AppCompatTextView {

    public CustomTextView(Context context) {
        this(context, null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.textViewStyle);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyAttributes(context, attrs);
    }

    private void applyAttributes(Context context, AttributeSet attributeSet) {
        StyleableUtils.DefaultAttributes defaultAttributes = StyleableUtils.getDefaultAttributes(context, attributeSet);
        applyCustomAttributes(context, attributeSet, defaultAttributes);
    }

    private void applyCustomAttributes(Context context, AttributeSet attributeSet, StyleableUtils.DefaultAttributes defaultAttributes) {
//        TypedArray ta = context.obtainStyledAttributes(attributeSet, R.styleable.CustomTextView);
        TypedArray ta = StyleableUtils.obtainStyledAttributes(context, attributeSet, R.styleable.CustomTextView);

        int test;
        try {
            int indexCount = ta.getIndexCount();
            int length = ta.length();
            test = ta.getInt(R.styleable.CustomTextView_test, 0);
            Log.d(CustomTextView.class.getSimpleName(),
                    "[CUSTOM_ATTR_TEST]length=" + length
                            + ", indexCount=" + indexCount
                            + ", test=" + test);
        } finally {
            ta.recycle();
        }
        setTestFromAttr(Test.valueOf(test), defaultAttributes);
    }

    public void setTest(@NonNull Test test) {
        setText(test.text);
        setBackgroundResource(test.color);
    }

    private void setTestFromAttr(@NonNull Test test, @NonNull StyleableUtils.DefaultAttributes defaultAttributes) {
        StyleableUtils.setText(this, test.text, defaultAttributes);
        StyleableUtils.setBackground(this, test.color, defaultAttributes);
    }

    @SuppressLint("CustomViewStyleable")
    private void loadDefaultAttributes(Context context, AttributeSet attributeSet) {
        TypedArray ta = context.obtainStyledAttributes(attributeSet, R.styleable.DefaultStyleable);
        
        try {
            int indexCount = ta.getIndexCount();
            int length = ta.length();
            Log.d(CustomTextView.class.getSimpleName(),
                    "[CUSTOM_ATTR_TEST]length=" + length
                            + ", indexCount=" + indexCount);
        } finally {
            ta.recycle();
        }
    }

    enum Test {
        A(android.R.color.holo_blue_bright, "A"),
        B(android.R.color.holo_green_light, "B"),
        C(android.R.color.holo_red_light, "C");
        @ColorRes
        private final int color;
        private final String text;
        Test(@ColorRes int color, @NonNull String text) {
            this.color = color;
            this.text = text;
        }

        @NonNull
        private static Test valueOf(int index) {
            for (Test test : Test.values()) {
                if (index == test.ordinal()) {
                    return test;
                }
            }
            return Test.A;
        }
    }
}
