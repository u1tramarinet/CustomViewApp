package com.example.customviewapp.customattr;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.example.customviewapp.R;

public class CustomTextViewLayout extends LinearLayout {
    @NonNull
    public final CustomTextView textViewTop;
    @NonNull
    public final CustomTextView textViewBottom;
    public CustomTextViewLayout(Context context) {
        this(context, null);
    }

    public CustomTextViewLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTextViewLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CustomTextViewLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context, R.layout.layout_custom_textview, this);
        textViewTop = findViewById(R.id.textView01);
        textViewBottom = findViewById(R.id.textView02);
        applyAttributes(context, attrs);
    }

    private void applyAttributes(Context context, AttributeSet attributeSet) {
        StyleableUtils.DefaultAttributes defaultAttributes = StyleableUtils.getDefaultAttributes(context, attributeSet);
        applyCustomAttributes(context, attributeSet, defaultAttributes);
    }

    private void applyCustomAttributes(Context context, AttributeSet attributeSet, StyleableUtils.DefaultAttributes defaultAttributes) {
        TypedArray ta = StyleableUtils.obtainStyledAttributes(context, attributeSet, R.styleable.CustomTextViewLayout);

        int test2;
        boolean textTopObtained;
        String textTop;
        boolean textBottomObtained;
        String textBottom;
        try {
            test2 = ta.getInt(R.styleable.CustomTextViewLayout_test2, Test2.D.ordinal());
            textTopObtained = ta.hasValueOrEmpty(R.styleable.CustomTextViewLayout_textTop);
            textTop = ta.getString(R.styleable.CustomTextViewLayout_textTop);
            textBottomObtained = ta.hasValueOrEmpty(R.styleable.CustomTextViewLayout_textBottom);
            textBottom = ta.getString(R.styleable.CustomTextViewLayout_textBottom);
        } finally {
            ta.recycle();
        }
        setTest2FromAttr(Test2.valueOf(test2), defaultAttributes);
        if (textTopObtained) {
            textViewTop.setText(textTop);
        }
        if (textBottomObtained) {
            textViewBottom.setText(textBottom);
        }
    }

    private void setTest2FromAttr(@NonNull Test2 test2, @NonNull StyleableUtils.DefaultAttributes defaultAttributes) {
        textViewTop.setTest(test2.testTop);
        textViewTop.setText(test2.text);
        textViewBottom.setTest(test2.testBottom);
        textViewBottom.setText(test2.text);
    }

    private enum Test2 {
        D(CustomTextView.Test.B, CustomTextView.Test.C,"ai"),
        E(CustomTextView.Test.C, CustomTextView.Test.B,"mai"),
        F(CustomTextView.Test.C, CustomTextView.Test.A, null);
        @NonNull
        final CustomTextView.Test testTop;
        @NonNull
        final CustomTextView.Test testBottom;
        @Nullable
        final String text;
        Test2(@NonNull CustomTextView.Test testTop, @NonNull CustomTextView.Test testBottom, @Nullable String text) {
            this.testTop = testTop;
            this.testBottom = testBottom;
            this.text = text;
        }

        private static Test2 valueOf(int index) {
            for (Test2 test2 : Test2.values()) {
                if (index == test2.ordinal()) {
                    return test2;
                }
            }
            return Test2.D;
        }
    }
}
