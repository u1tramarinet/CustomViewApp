package com.example.customviewapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * http://y-anz-m.blogspot.com/2011/07/androidandroidduplicateparentstate.html
 * https://qiita.com/tkt989/items/6a0608d747c45ae42d77
 */
public class TextAndImageButton extends RelativeLayout {
    private static final String TAG = TextAndImageButton.class.getSimpleName();
    private ImageButton imageButton;
    private TextView textView;
    private OnClickListener listener;

    public TextAndImageButton(@NonNull Context context) {
        this(context, null);
    }

    public TextAndImageButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextAndImageButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public TextAndImageButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        View rootView = LayoutInflater.from(context).inflate(R.layout.text_and_image_button, this);
        imageButton = rootView.findViewById(R.id.imageButton);
        textView = rootView.findViewById(R.id.textView);
    }

    @Override
    public void setOnClickListener(@Nullable View.OnClickListener l) {
        this.listener = l;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (MotionEvent.ACTION_UP == ev.getAction()) {
            if ((null != listener) && isPositionInside(ev)) {
                post(new Runnable() {
                    @Override
                    public void run() {
                        listener.onClick(TextAndImageButton.this);
                    }
                });
            }
        }

        return super.dispatchTouchEvent(ev);
    }

    private boolean isPositionInside(@NonNull MotionEvent ev) {
        int[] point = new int[2];

        getLocationOnScreen(point);

        int x = point[0];
        int y = point[1];

        return (ev.getRawX() >= x && ev.getRawX() <= x + getWidth()) &&
                (ev.getRawY() >= y && ev.getRawY() <= y + getHeight());
    }
}