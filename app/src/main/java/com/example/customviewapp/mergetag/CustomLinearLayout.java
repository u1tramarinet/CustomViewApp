package com.example.customviewapp.mergetag;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.customviewapp.R;

public class CustomLinearLayout extends LinearLayout {
    private static final String TAG = "[MERGE_TAG_TEST]";
    public CustomLinearLayout(Context context) {
        this(context, null);
        // Not called.
        Log.d(TAG, "constructor context=" + context);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        // Called at first.
        Log.d(TAG, "constructor context=" + context + ", attrs=" + attrs);
    }

    public CustomLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, R.style.CustomLinearLayout);
        Log.d(TAG, "constructor context=" + context + ", attrs=" + attrs + ", defStyleAttr=" + defStyleAttr);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Log.d(TAG, "constructor context=" + context + ", attrs=" + attrs + ", defStyleAttr=" + defStyleAttr + ", defStyleRes=" + defStyleRes);
        inflate(context, R.layout.layout_custom_linear_layout, this);
        loadAttributeSet(attrs);
        applyAttributes(context, attrs);
    }

    private void applyAttributes(Context context, AttributeSet attributeSet) {
        StyleableUtils.DefaultAttributes defaultAttributes = StyleableUtils.getDefaultAttributes(context, attributeSet);
        applyBaseSetting(defaultAttributes);
    }

    private void applyBaseSetting(StyleableUtils.DefaultAttributes defaultAttributes) {
//        StyleableUtils.setBackground(this, android.R.color.holo_blue_bright, defaultAttributes);
    }

    private void loadAttributeSet(@Nullable AttributeSet attributeSet) {
        if (attributeSet == null) {
            Log.d(TAG, "attributeSet=null");
            return;
        }
        int count = attributeSet.getAttributeCount();
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < count; i++) {
            buffer.append(attributeSet.getAttributeName(i)).append(":").append(attributeSet.getAttributeValue(i)).append(" ");
        }
        Log.d(TAG, "attributeCount=" + count + ", names=[" + buffer.toString() + "]");

    }
}
