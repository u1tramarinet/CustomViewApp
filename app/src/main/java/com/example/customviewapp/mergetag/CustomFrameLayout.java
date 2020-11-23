package com.example.customviewapp.mergetag;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.GridLayout;

import com.example.customviewapp.R;

public class CustomFrameLayout extends FrameLayout {
    private static final String TAG = "[MERGE_TAG_TEST]";
    public CustomFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public CustomFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CustomFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context, R.layout.layout_custom_frame_layout, this);
        applyAttributes(context, attrs);
    }

    private void applyAttributes(Context context, AttributeSet attributeSet) {
        StyleableUtils.DefaultAttributes defaultAttributes = StyleableUtils.getDefaultAttributes(context, attributeSet);
        applyBaseSetting(defaultAttributes);
    }

    private void applyBaseSetting(StyleableUtils.DefaultAttributes defaultAttributes) {
        StyleableUtils.setBackground(this, android.R.color.holo_blue_bright, defaultAttributes);
        setForegroundGravity(Gravity.CENTER);
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

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        confirmRealSize();
    }

    private void confirmRealSize() {
        int width = getWidth();
        int measuredWidth = getMeasuredWidth();
        int minimumWidth = getMinimumWidth();
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        Log.d(TAG, "width=" + width + ", measuredWidth=" + measuredWidth + ", minimumWidth=" + minimumWidth + ", suggestedMinimumWidth=" + suggestedMinimumWidth);
        int height = getHeight();
        int measuredHeight = getMeasuredHeight();
        int minimumHeight = getMinimumHeight();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        Log.d(TAG, "height=" + height + ", measuredHeight=" + measuredHeight + ", minimumHeight=" + minimumHeight + ", suggestedMinimumHeight=" + suggestedMinimumHeight);
    }
}
